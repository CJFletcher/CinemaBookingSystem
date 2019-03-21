package fxmlControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

import static controller.FilmController.newFilm;
import static fxmlControllers.SceneCreator.openScene;

public class AdminPageController implements Initializable {

    @FXML
    private JFXButton homeButton;

    @FXML
    private Text title;

    @FXML
    private ImageView posterImageView;

    @FXML
    private Text runTime;

    @FXML
    private Text plot;

    @FXML
    private Text titleText;

    @FXML
    private Text runTimeText;

    @FXML
    private Text plotText;

    @FXML
    private ImageView ratingImageView;

    @FXML
    private Text rating;

    @FXML
    private Text actors;

    @FXML
    private Text actorsText;

    @FXML
    private Text director;

    @FXML
    private Text directorText;

    @FXML
    private Text ratings;

    @FXML
    private Text ratingsText;

    @FXML
    private Text dateText;

    @FXML
    private Text timeText;

    @FXML
    private Text availableSeatsText;

    @FXML
    private Text theaterNumberText;

    @FXML
    private JFXButton searchFilmButton;

    @FXML
    private JFXTextField searchTitleTextField;

    @FXML
    private JFXTextField filmYearTextField;

    @FXML
    private JFXButton addFilmButton;

    @FXML
    private JFXDatePicker showingDatePicker;

    @FXML
    private JFXComboBox<String> filmCombo;

    @FXML
    private JFXTimePicker timePicker;

    @FXML
    private JFXComboBox<Theater> theatreComboBox;

    @FXML
    private JFXButton createShowingButton;

    private Film filmToAddToFilmList;

    @FXML
    private void goToHomePage(ActionEvent event) throws IOException {
        openScene("../fxml/homePage.fxml");
    }

    @FXML
    private void searchFilm(ActionEvent event) throws IOException {
        if(!searchTitleTextField.getText().isEmpty()&&filmYearTextField.getText().isEmpty()){
            try{filmToAddToFilmList = newFilm(searchTitleTextField.getText(),null);
            populateFilmDetails(filmToAddToFilmList);}
            catch (NullPointerException e){noFilmFoundAlert();
            }
        }
        if(!searchTitleTextField.getText().isEmpty()&&!filmYearTextField.getText().isEmpty()){
            try{
            filmToAddToFilmList = newFilm(searchTitleTextField.getText(),filmYearTextField.getText());
            populateFilmDetails(filmToAddToFilmList);}
            catch (NullPointerException e){noFilmFoundAlert();}
        }
    }

    private void noFilmFoundAlert(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("No film found");
        alert.setHeaderText("No film found with those details");
        alert.showAndWait();
    }

    @FXML
    private void addFilm(ActionEvent event) throws IOException {
        if(checkIfFilmExists()){
            Main.getFilms().addFilm(filmToAddToFilmList);
            Main.getFilms().saveFilmsToTxt();
        }
        populateComboBoxes();
    }

    @FXML
    private void createShowing(ActionEvent event) throws IOException, ClassNotFoundException {
        if (checkIfShowingBoxesAreFilled()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("New Showing");
            alert.setHeaderText("This will create a new showing, please ensure all details are correct before continuing.");
            alert.setContentText("Are you sure you want to do this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                LocalDate datePart = showingDatePicker.getValue();
                LocalTime timePart = timePicker.getValue();
                LocalDateTime localDateTime = LocalDateTime.of(datePart, timePart);
                Showing newShowing = new Showing(Main.getFilms().getFilmByTitle(filmCombo.getValue()),localDateTime,theatreComboBox.getValue());
                Main.getShowings().getShowings().add(newShowing);
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setTitle("Showing created");
                alert2.setHeaderText("Showing successfully created");
                alert2.showAndWait();
                Main.getShowings().saveShowings();
            }
        }
    }

    private boolean checkIfShowingBoxesAreFilled(){
        if (showingDatePicker.getValue() == null){
            return false;
        }
        if (timePicker.getValue()==null) {
            return false;
        }
        if (filmCombo.getValue()==null){
            return false;
        }
        if (theatreComboBox.getValue()==null){
            return false;
        }
        else{
            return true;
        }
    }

    private void populateFilmDetails(Film film) {
        if (film.getTitle() != null && film.getPoster() != null) {
            titleText.setText(film.getTitle());
            runTimeText.setText(film.getRuntime());
            plotText.setText(film.getPlotShort());
            Image poster = new Image(film.getPoster());
            posterImageView.setImage(poster);
            setRatingImageView(ratingImageView,film);
            actorsText.setText(film.getActors());
            directorText.setText(film.getDirector());
            ratingsText.setText(film.getRatings());
        }
    }

    private void setRatingImageView(ImageView imageView, Film film){
        String rating = film.getRated();
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

    private boolean checkIfFilmExists() {
        if (filmToAddToFilmList!=null) {
            for (Film film : Main.getFilms().getFilms()) {
                if (film.getTitle().equals(filmToAddToFilmList.getTitle()) && film.getYear().equals(film.getYear())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Film conflict");
                    alert.setHeaderText("Film already exists!");
                    alert.setContentText("Film not added");
                    alert.showAndWait();
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void populateComboBoxes(){
        theatreComboBox.getItems().clear();
        for (Theater theater:Main.getTheaters().getTheaters()) {
            theatreComboBox.getItems().add(theater);
        }
        filmCombo.getItems().clear();
        Main.getFilms().sortFilmsAlphabetically();
        for (Film film:Main.getFilms().getFilms()) {
            filmCombo.getItems().add(film.getTitle());
        }
        filterDatePicker();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filmToAddToFilmList = null;
        populateComboBoxes();
    }
}
