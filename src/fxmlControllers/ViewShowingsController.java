package fxmlControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import controller.ShowingController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static fxmlControllers.SceneCreator.openScene;

public class ViewShowingsController implements Initializable{

    private ShowingController showings = Main.getShowings();

    @FXML
    private JFXButton viewAllSnacksButton;

    @FXML
    private JFXButton basketButton;

    @FXML
    private JFXButton homeButton;

    @FXML
    private ImageView posterImageView;

    @FXML
    private Text standardPriceText;

    @FXML
    private Text vipPriceText;

    @FXML
    private Text titleText;

    @FXML
    private Text runTimeText;

    @FXML
    private Text plotText;

    @FXML
    private ImageView ratingImageView;

    @FXML
    private Text actorsText;

    @FXML
    private Text directorText;

    @FXML
    private Text ratingsText;

    @FXML
    private JFXButton chooseSeatsButton;

    @FXML
    private JFXComboBox<String> chooseFilmComboBox;

    @FXML
    private JFXDatePicker showingDatePicker;

    @FXML
    private JFXListView<Showing> showingsListView;

    @FXML
    private Text dateText;

    @FXML
    private Text timeText;

    @FXML
    private Text availableSeatsText;

    @FXML
    private Text theaterNumberText;

    @FXML
    private void addShowingsByDate(ActionEvent event) {
        showingsListView.getItems().clear();
        chooseFilmComboBox.getSelectionModel().clearSelection();
        LocalDate dateSelected = showingDatePicker.getValue();
        ArrayList <Showing> showingsList = showings.getShowings();
        for (Showing showing:showingsList) {
            if (showing.getShowingDate().equals(dateSelected)){
                showingsListView.getItems().add(showing);
            }
        }
    }

    @FXML
    private void addShowingsByFilm(ActionEvent event) {
        showingsListView.getItems().clear();
//        showingDatePicker.getEditor().clear();
        String selectedFilmTitle = chooseFilmComboBox.getValue();
        ArrayList <Showing> showingsList = showings.getShowings();
        for (Showing showing:showingsList) {
            if(showing.getFilm().getTitle().equals(selectedFilmTitle)){
                showingsListView.getItems().add(showing);
            }
        }
    }

    @FXML
    private void goToChooseSeatsScreen(ActionEvent event) throws IOException {
        if (Main.getCurrentShowing() != null){
            openScene("../fxml/selectSeats.fxml");
        }
        else {noSelectionAlert();}
    }

    @FXML
    private void goToHomePage(ActionEvent event) throws IOException {
        openScene("../fxml/homePage.fxml");
    }

    @FXML
    private void goToSnackPage(ActionEvent event) throws IOException {
        openScene("../fxml/snacksPage.fxml");
    }

    @FXML
    private void gotToBasketPage(ActionEvent event) throws IOException {
        openScene("../fxml/basketPage.fxml");
    }


    //https://stackoverflow.com/questions/48238855/how-to-disable-past-dates-in-datepicker-of-javafx-scene-builder
    private void filterDatePicker(){
        showingDatePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0 || date.getDayOfWeek()!= DayOfWeek.SATURDAY);
            }
        });
    }

    private void noSelectionAlert(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No selection made");
        alert.setHeaderText("Can not choose seats");
        alert.setContentText("Please select a showing");
        alert.showAndWait();
    }

    @FXML
    private void populateShowingDetails(MouseEvent event){
        Showing selectedShowing = showingsListView.getSelectionModel().getSelectedItem();
        if (selectedShowing != null) {
            standardPriceText.setText(new Ticket(selectedShowing, new Seat()).getPriceFormatted());
            vipPriceText.setText(new Ticket(selectedShowing, new VipSeat()).getPriceFormatted());
            titleText.setText(selectedShowing.getFilm().getTitle());
            runTimeText.setText(selectedShowing.getFilm().getRuntime());
            plotText.setText(selectedShowing.getFilm().getPlotShort());
            Image poster = new Image(selectedShowing.getFilm().getPoster());
            posterImageView.setImage(poster);
            setRatingImageView(ratingImageView, selectedShowing);
            actorsText.setText(selectedShowing.getFilm().getActors());
            directorText.setText(selectedShowing.getFilm().getDirector());
            ratingsText.setText(selectedShowing.getFilm().getRatings());
            dateText.setText(selectedShowing.getShowingDateFormatted(false));
            timeText.setText(selectedShowing.getShowingTimeFormatted());
            theaterNumberText.setText(Integer.toString(selectedShowing.getTheater().getTheaterNumber()));
            availableSeatsText.setText(Integer.toString(selectedShowing.getAvailableSeats()));
            Main.setCurrentShowing(selectedShowing);
        }
    }


    private void setRatingImageView(ImageView imageView, Showing currentShowing){
        String rating = currentShowing.getFilm().getRated();
        if (rating.equals("G")){
            Image ratingImage = new Image("res/URating.png",46,46,true,true);
            imageView.setImage(ratingImage);
        }
        if (rating.equals("PG")){
            Image ratingImage = new Image("res/pgRating.png",46,46,true,true);
            imageView.setImage(ratingImage);
        }
        if (rating.equals("PG-13")){
            Image ratingImage = new Image("res/12ARating.png",46,46,true,true);
            imageView.setImage(ratingImage);
        }
        if (rating.equals("R")){
            Image ratingImage = new Image("res/18Rating.png",46,46,true,true);
            imageView.setImage(ratingImage);
        }
    }

    private void populateShowingComboBox(){
        for (Film film:Main.getFilms().getFilms()) {
            chooseFilmComboBox.getItems().add(film.getTitle());
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.setCurrentShowing(null);
        Main.getFilms().sortFilmsAlphabetically();
        populateShowingComboBox();
        filterDatePicker();
    }
}
