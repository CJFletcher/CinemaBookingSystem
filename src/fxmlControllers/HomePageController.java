package fxmlControllers;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXScrollPane;
import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;
import controller.ShowingController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import model.Main;
import model.Showing;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    @FXML
    private AnchorPane rightAnchorPane;

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
    private VBox showingVBox;

    @FXML
    private Pane snackBoxLeft;

    @FXML
    private Pane snackBoxCenterLeft;

    @FXML
    private Pane SnackBoxCentreRight;

    @FXML
    private Pane SnackBoxRight;

    @FXML
    private JFXListView<BorderPane> showingsListView;

    public HomePageController() {
    }

    @FXML
    void createNewBooking(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "",
                yes,
                no);

        alert.setTitle("Date format warning");
        Optional<ButtonType> result = alert.showAndWait();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.getShowings().sortShowings();
        ShowingPageController showingPageController = new ShowingPageController();
        ArrayList<Showing> showings = Main.getShowings().getShowings();
        int i = 0;
        for (Showing showing:showings) {
            if (i<=9) {
                BorderPane bp = new BorderPane();
                bp.setMaxSize(950, 200);
                bp.setPrefSize(950, 200);
                bp.setMinSize(950, 200);

                String posterUrl = showing.getFilm().getPoster();
                Image poster = new Image(posterUrl, 200, 200, true, false);
                ImageView posterView = new ImageView();
                posterView.setImage(poster);
                bp.setCenter(posterView);

                String title = showing.getFilm().getTitle();
                String showingTime = showing.getShowingTimeFormatted();
                Label titleAndTime = new Label(title + "\n\n" + showing.getShowingDateFormatted()+"\n"+showingTime);
                titleAndTime.setFont(Font.font("Arial",18));
                bp.setLeft(titleAndTime);

                Label seatsAvailable = new Label("Seats available: " + Integer.toString(showing.getAvailableSeats()));
                seatsAvailable.setFont(Font.font("Arial",18));
                bp.setRight(seatsAvailable);

                JFXButton sButton = new JFXButton("Make booking");



                sButton.setOnAction((ActionEvent event) -> {
                    Main.setCurrentShowing(showing);
                    Stage stage = (Stage) showingsListView.getScene().getWindow();

                    try {
                        showingPageController.start(stage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                showingsListView.getItems().add(bp);
                i++;
            }
        }
    }
}
