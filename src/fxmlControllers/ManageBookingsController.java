package fxmlControllers;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManageBookingsController implements Initializable {

    @FXML
    private TableView<Booking> table;

    @FXML
    private TableColumn<Booking, String> bookingIdColumn;

    @FXML
    private TableColumn<Booking, ArrayList<Ticket>> ticketColumn;

    @FXML
    private TableColumn<Booking, ArrayList<Refreshment>> refreshmentColumn;

    @FXML
    private TableColumn<Booking, String> priceColumn;

    @FXML
    private JFXButton homeButton;

    @FXML
    private JFXButton searchByID;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXTextField idTextField;

    @FXML
    private JFXTextField filmTextField;

    @FXML
    void openHomePage(ActionEvent event) throws IOException {
        SceneCreator.openScene("../fxml/homePage.fxml");
    }

    @FXML
    void searchByID(ActionEvent event) {
        if (!idTextField.getText().isEmpty()) {
            table.getItems().clear();
            for (Booking booking:Main.getBookings().getBookingsByID(idTextField.getText())) {
                table.getItems().add(booking);
            }
        }
    }

    @FXML
    void searchByDate(ActionEvent event) {
            table.getItems().clear();
        for (Booking booking:Main.getBookings().getBookingsByID(datePicker.getValue().toString())) {
            table.getItems().add(booking);
        }
    }

    //Had to implement it this way due to Serialisation creating separate copies of the Seat objects
    @FXML
    void deleteBooking(ActionEvent event) throws IOException, ClassNotFoundException {
        Booking selectedBooking = table.getSelectionModel().getSelectedItem();
        if (selectedBooking != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete booking");
            alert.setHeaderText("This will delete the booking permanently");
            alert.setContentText("Are you sure you want to do this?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                for (Ticket ticket:selectedBooking.getTickets()) {
                    for (Showing showing:Main.getShowings().getShowings()) {
                        if (showing.getFilm().getTitle().equals(ticket.getShowing().getFilm().getTitle())&&showing.getShowingTimeFormatted().equals(ticket.getShowing().getShowingTimeFormatted())&&showing.getShowingDateFormatted(false).equals(showing.getShowingDateFormatted(false))) {
                            String row = ticket.getSeat().getRowLetter();
                            int number = ticket.getSeat().getSeatNumber();
                            showing.getSeat(row, number).setBookingStatus(false);
                        }
                    }
                }
                Main.getBookings().removeBooking(selectedBooking);
                populateTableView();
                Main.getBookings().saveBookings();
                Main.getShowings().saveShowings();
            }
        }
    }

    @FXML
    private void populateTableView() {
        table.getItems().clear();
        for (Booking booking : Main.getBookings().getBookings()) {
            table.getItems().add(booking);
        }
    }

    @FXML
    private void searchByFilm(ActionEvent event) {
        if (!filmTextField.getText().isEmpty()){
            table.getItems().clear();
            String selectedFilm=filmTextField.getText();
            for (Booking booking : Main.getBookings().getBookings()) {
                for (Ticket ticket: booking.getTickets()) {
                    if(ticket.getShowing().getFilm().getTitle().toLowerCase().contains(selectedFilm.toLowerCase())){
                        table.getItems().add(booking);
                    }
                }
            }
        }
        else{
            populateTableView();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Booking> bookingList = FXCollections.observableArrayList(Main.getBookings().getBookings());
        table.setItems(bookingList);
        bookingIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        ticketColumn.setCellValueFactory(new PropertyValueFactory<>("tickets"));
        refreshmentColumn.setCellValueFactory(new PropertyValueFactory<>("refreshments"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        }
    }

