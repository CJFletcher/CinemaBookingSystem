package fxmlControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Booking;
import model.Main;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManageBookingsController implements Initializable {

    @FXML
    private JFXButton homeButton;

    @FXML
    private JFXButton searchByID;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXListView<Booking> bookingListView;

    @FXML
    private JFXTextField idTextField;

    @FXML
    void openHomePage(ActionEvent event) throws IOException {
        SceneCreator.openScene("../fxml/homePage.fxml");
    }

    @FXML
    void searchByID(ActionEvent event) {
        if (!idTextField.getText().isEmpty()) {
            bookingListView.getItems().clear();
            for (Booking booking:Main.getBookings().getBookingsByID(idTextField.getText())) {
                bookingListView.getItems().add(booking);
            }
        }
    }

    @FXML
    void searchByDate(ActionEvent event) {
            bookingListView.getItems().clear();
        for (Booking booking:Main.getBookings().getBookingsByID(datePicker.getValue().toString())) {
            bookingListView.getItems().add(booking);
        }
    }

    @FXML
    void deleteBooking(ActionEvent event) throws IOException, ClassNotFoundException {
        Booking selectedBooking = bookingListView.getSelectionModel().getSelectedItem();
        if (selectedBooking != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete booking");
            alert.setHeaderText("This delete the booking permanently");
            alert.setContentText("Are you sure you want to do this?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                selectedBooking.setSeatsAsUnBooked();
                Main.getBookings().removeBooking(selectedBooking);
                populateListView();
                Main.getBookings().saveBookings();
                Main.getShowings().saveShowings();
            }
        }
    }

    private void populateListView() {
        bookingListView.getItems().clear();
        for (Booking booking : Main.getBookings().getBookings()) {
            bookingListView.getItems().add(booking);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            populateListView();
        }
    }

