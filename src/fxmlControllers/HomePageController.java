package fxmlControllers;

import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
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
import model.Basket;
import model.Main;
import model.Showing;
import model.Snack;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    @FXML
    private JFXButton manageBookingsButton;

    @FXML
    private JFXButton manageFilmsButton;

    @FXML
    private JFXButton createNewBookingButton;

    @FXML
    private JFXButton manageShowingsButton;

    @FXML
    private JFXButton createNewBookingButton1;

    @FXML
    private JFXButton basketButton;

    @FXML
    private JFXButton exitButton;

    @FXML
    private Pane snackBoxLeft;

    @FXML
    private Pane snackBoxCenterLeft;

    @FXML
    private Pane snackBoxCentreRight;

    @FXML
    private Pane snackBoxRight;

    @FXML
    private JFXListView<BorderPane> showingsListView;

    public HomePageController() {
    }

    @FXML
    void createNewBooking(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Main.setBasket(new Basket());
            Main.setCurrentUser(null);
            Main.setCurrentFilm(null);
            Main.setCurrentShowing(null);
            Main.setCurrentTheater(null);

            Parent root = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
            Stage primaryStage = (Stage) exitButton.getScene().getWindow();
            primaryStage.setTitle("Cinema Booking System");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }


    @FXML
    void manageBookings(ActionEvent event) {
//        Stage stage = (Stage) manageBookingsButton.getScene().getWindow();
//        manageBookings.start(stage);
    }

    @FXML
    void manageFilms(ActionEvent event) {
//        Stage stage = (Stage) manageFilmsButton.getScene().getWindow();
//        manageFilms.start(stage);
    }

    @FXML
    void manageShowings(ActionEvent event) {
//        Stage stage = (Stage) manageShowingsButton.getScene().getWindow();
//        manageShowings.start(stage);
    }

    @FXML
    void openBasket(ActionEvent event) {
//        Stage stage = (Stage) basketButton.getScene().getWindow();
//        basketController.start(stage);
    }

    public void start(Stage window) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/homePage.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    private void populateSnackDetails(Pane pane,Snack snack) {
        Label label = new Label(snack.getName() + "\n" + snack.getDescription() + "\n" + snack.getPriceFormatted());
        label.setFont(Font.font("Arial", 12));
        label.setWrapText(true);
        label.setMaxWidth(247);
        label.setMinWidth(247);
        label.setPrefWidth(247);

        pane.getChildren().add(label);

        JFXButton addTobasketButton = new JFXButton("Add to Basket");
        pane.getStylesheets().add(getClass().getResource("../res/styleSheet.css").toExternalForm());

        addTobasketButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                            Main.getBasket().addItem(snack);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);

                            alert.setTitle("Item added to basket!");
                            alert.setHeaderText(snack.getName() + " successfully added to basket");
                            alert.setContentText(Main.getBasket().toString());
                            alert.showAndWait();
                        }
                    });
                    addTobasketButton.setAlignment(Pos.BOTTOM_CENTER);
                    pane.getChildren().add(addTobasketButton);
                }

    @FXML
    private void showBasketButton(){
        if (!Main.getBasket().getItems().isEmpty())
        basketButton.setDisable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.getShowings().sortShowings();
        ShowingPageController showingPageController = new ShowingPageController();
        ArrayList<Showing> showings = Main.getShowings().getShowings();
        int i = 0;
        for (Showing showing:showings) {
            if (i<=9) {
                BorderPane bp = new BorderPane();
                HBox hb = new HBox();
                hb.setPadding(new Insets (10,10,0,10));
                bp.setCenter(hb);

                bp.setMaxSize(950, 200);
                bp.setPrefSize(950, 200);
                bp.setMinSize(950, 200);


                String posterUrl = showing.getFilm().getPoster();
                Image poster = new Image(posterUrl, 200, 200, true, false);
                ImageView posterView = new ImageView();
                posterView.setImage(poster);
                bp.setLeft(posterView);

                String title = showing.getFilm().getTitle();
                String showingTime = showing.getShowingTimeFormatted();

                Label titleAndTime = new Label(title + "\n\n" + showing.getShowingDateFormatted()+"\n"+showingTime+
                        "\n\n\n Theater Number: " + showing.getTheater().getTheaterNumber());
                titleAndTime.setFont(Font.font("Arial",18));
                titleAndTime.setWrapText(false);
                titleAndTime.setMinWidth(300);
                titleAndTime.setPrefWidth(300);
                titleAndTime.setMaxWidth(300);
                hb.getChildren().add(titleAndTime);

                String filmPlot = showing.getFilm().getPlotShort();
                Label filmPlotLabel = new Label(filmPlot+"\n\nRatings:\n"+showing.getFilm().getRatings());
                filmPlotLabel.setFont(Font.font("Arial",14));
                filmPlotLabel.setWrapText(true);
                filmPlotLabel.setMinHeight(170);
                filmPlotLabel.setPrefHeight(170);
                filmPlotLabel.setMaxHeight(170);
                hb.getChildren().add(filmPlotLabel);

                Label seatsAvailable = new Label("Seats available: " + (showing.getAvailableSeats()));
                seatsAvailable.setFont(Font.font("Arial",14));
                bp.setBottom(seatsAvailable);
                bp.setAlignment(seatsAvailable, Pos.CENTER_RIGHT);


                JFXButton showingButton = new JFXButton("Make Booking");
                bp.setMargin(showingButton,new Insets(90,10,10,10));

                showingButton.setOnAction((ActionEvent event) -> {
                    Main.setCurrentShowing(showing);
                    Stage stage = (Stage) showingsListView.getScene().getWindow();

                    try {
                        showingPageController.start(stage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                showingButton.setAlignment(Pos.BOTTOM_CENTER);
                bp.setRight(showingButton);
                bp.getStylesheets().add(getClass().getResource("../res/styleSheet.css").toExternalForm());
                showingsListView.getItems().add(bp);
                i++;
            }
        }

        Snack popcorn = Main.getSnacks().getItemByName("Popcorn");
        Snack softDrink = Main.getSnacks().getItemByName("Soft Drink");
        Snack hotDog = Main.getSnacks().getItemByName("Hot dog");
        Snack nachos = Main.getSnacks().getItemByName("Nachos");

        populateSnackDetails(snackBoxLeft,popcorn);
        populateSnackDetails(snackBoxCenterLeft,softDrink);
        populateSnackDetails(snackBoxCentreRight,hotDog);
        populateSnackDetails(snackBoxRight,nachos);

        if (Main.getBasket().getItems().isEmpty()){
            basketButton.setDisable(true);
        }

    }
}
