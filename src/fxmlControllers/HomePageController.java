package fxmlControllers;

import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import static fxmlControllers.SceneCreator.openScene;

public class HomePageController implements Initializable {

    @FXML
    private JFXButton manageBookingsButton;

    @FXML
    private JFXButton adminPageButton;

    @FXML
    private JFXButton createNewBookingButton;

    @FXML
    private JFXButton basketButton;

    @FXML
    private JFXButton exitButton;

    @FXML
    private GridPane snackGridPane;

    @FXML
    private JFXButton viewAllSnacksButton;

    @FXML
    private JFXListView<BorderPane> showingsListView;

    @FXML
    void openMakeBookingPage() throws IOException {
        openScene("../fxml/makeBookings.fxml");
    }

    @FXML
    void exit() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log out confirmation");
        alert.setHeaderText("");
        alert.setContentText("Are you sure you want to log out?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            openScene("../fxml/login.fxml");
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    @FXML
    void openAdminPage(ActionEvent event) throws IOException {
        openScene("../fxml/adminPage.fxml");
    }

    @FXML
    void createNewBooking(ActionEvent event) throws IOException{
        openScene("../fxml/viewShowings.fxml");
    }

    @FXML
    void openSnacksPage(ActionEvent event) throws IOException {
        openScene("../fxml/snacksPage.fxml");
    }

    @FXML
    void manageBookings(ActionEvent event) throws IOException {
        openScene("../fxml/manageBookings.fxml");
    }

    @FXML
    void openBasket(ActionEvent event) throws IOException {
        openScene("../fxml/basketPage.fxml");
    }

    public void start(Stage window) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/homePage.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    private void populateSnackDetails(GridPane pane, Refreshment refreshment, int x, int y) {
        Label label = new Label(refreshment.getName() + "\n" + refreshment.getDescription() + "\n" + refreshment.getPriceFormatted());
        label.setFont(Font.font("Arial", 12));
        label.setWrapText(true);
        label.setMaxWidth(247);
        label.setMinWidth(247);
        label.setPrefWidth(247);
        label.setAlignment(Pos.TOP_LEFT);

        pane.add(label,y,x);

        JFXButton addToBasketButton = new JFXButton("Add to Basket");
        pane.getStylesheets().add(getClass().getResource("../res/styleSheet.css").toExternalForm());

        addToBasketButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                            Main.getBasket().addItem(refreshment);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);

                            alert.setTitle("Item added to basket!");
                            alert.setHeaderText(refreshment.getName() + " successfully added to basket");
                            alert.setContentText(Main.getBasket().toString());
                            alert.showAndWait();
                            showBasketButton();
                        }
                    });
                    pane.add(addToBasketButton,y,x+1);
                }

    @FXML
    private void showBasketButton(){
        if (!Main.getBasket().getItems().isEmpty()){
            basketButton.setDisable(false);
        }
        else {
            basketButton.setDisable(true);
        }
    }

    private void populateShowingListView(){
        Main.getShowings().sortShowings();
        ArrayList<Showing> showings = Main.getShowings().getShowings();
        int i = 0;
        for (Showing showing:showings) {
            if (i<=9) {
                BorderPane bp = new BorderPane();
                GridPane gp = new GridPane();
                gp.setPadding(new Insets (10,10,0,10));
                bp.setCenter(gp);
                gp.setPrefHeight(200);
                gp.setMinHeight(200);

                bp.setMaxSize(950, 200);
                bp.setPrefSize(950, 200);
                bp.setMinSize(950, 200);


                String posterUrl = showing.getFilm().getPoster();
                Image poster = new Image(posterUrl, 140, 190, true, false);
                ImageView posterView = new ImageView();
                posterView.minWidth(140);
                posterView.prefWidth(140);
                posterView.maxWidth(140);
                posterView.setImage(poster);
                bp.setLeft(posterView);

                String title = showing.getFilm().getTitle();
                String showingTime = showing.getShowingTimeFormatted();

                Label titleAndTime = new Label(title + "\n\n" + showing.getShowingDateFormatted(true)+"\n"+showingTime+
                        "\n\n\nTheater Number: " + showing.getTheater().getTheaterNumber());
                titleAndTime.setFont(Font.font("Arial",18));
                titleAndTime.setWrapText(false);
                titleAndTime.setMinWidth(300);
                titleAndTime.setPrefWidth(300);
                titleAndTime.setMaxWidth(300);
                gp.addColumn(0,titleAndTime);
                gp.getChildren().get(0).prefWidth(300);
                gp.getChildren().get(0).minWidth(300);
                gp.getChildren().get(0).maxWidth(300);
                gp.setAlignment(Pos.CENTER_LEFT);

                String ticketPrice = new Ticket(showing, new Seat()).getPriceFormatted();
                String vipTicketPrice = new Ticket(showing,new VipSeat()).getPriceFormatted();
                String filmPlot = showing.getFilm().getPlotShort();
                Label filmPlotLabel = new Label(filmPlot+"\n\nRatings:\n"+showing.getFilm().getRatings());
                filmPlotLabel.setFont(Font.font("Arial",14));
                filmPlotLabel.setWrapText(true);
                filmPlotLabel.setMinHeight(170);
                filmPlotLabel.setPrefHeight(170);
                filmPlotLabel.setMaxHeight(170);
                gp.addColumn(1,filmPlotLabel);

                Label seatsAvailable = new Label("Ticket Prices - STD: " +vipTicketPrice + " | VIP: " + ticketPrice+" | Seats available: "+ (showing.getAvailableSeats()));
                seatsAvailable.setFont(Font.font("Arial",14));
                bp.setBottom(seatsAvailable);
                BorderPane.setAlignment(seatsAvailable, Pos.CENTER_RIGHT);


                JFXButton showingButton = new JFXButton("Make Booking");
                BorderPane.setMargin(showingButton,new Insets(90,10,10,10));

                showingButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Main.setCurrentShowing(showing);
                        Stage stage = (Stage) showingsListView.getScene().getWindow();
                        try {
                            openScene("../fxml/selectSeats.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                showingButton.setAlignment(Pos.BOTTOM_CENTER);
                bp.setRight(showingButton);
                bp.getStylesheets().add(getClass().getResource("../res/styleSheet.css").toExternalForm());
                showingsListView.getItems().add(bp);
                i++;
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(!Main.getCurrentUser().getUserType().equals("Admin")){
            adminPageButton.setDisable(true);
        }
        populateShowingListView();
        showBasketButton();

        Refreshment popcorn = Main.getRefreshments().getItemByName("Popcorn");
        Refreshment softDrink = Main.getRefreshments().getItemByName("Soft Drink");
        Refreshment hotDog = Main.getRefreshments().getItemByName("Hot dog");
        Refreshment nachos = Main.getRefreshments().getItemByName("Nachos");

        populateSnackDetails(snackGridPane,popcorn,0,0);
        populateSnackDetails(snackGridPane,softDrink,0,1);
        populateSnackDetails(snackGridPane,hotDog,0,2);
        populateSnackDetails(snackGridPane,nachos,0, 3);
    }
}