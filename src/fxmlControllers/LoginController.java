package fxmlControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Film;
import model.Main;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static controller.HelperClass.centerImage;

public class LoginController implements Initializable {

    private int imageCount = 0;
    private ArrayList<Image> imageList = new ArrayList<>();
    private HomePageController homePageController;

    @FXML
    private JFXTextField usernameBox;

    @FXML
    private JFXPasswordField passwordBox;

    @FXML
    public JFXButton loginButton;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView posterImage;

    @FXML
    private AnchorPane leftAP;

    @FXML
    private void focusPasswordBox(){
        passwordBox.requestFocus();
    }

    private boolean validateUser(){
        String username = usernameBox.getText();
        String password = passwordBox.getText();

        if (username.equals("Admin") && password.equals("Password")) {
            System.out.println("Login success");
            return true;
        }
        if (username.equals("Admin")){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Login Error");
            alert.setHeaderText("Can not perform login");
            alert.setContentText("Password is incorrect");
            alert.showAndWait();
        }
        if (!username.equals("Admin")){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Login Error");
            alert.setHeaderText("Can not perform login");
            alert.setContentText("Username is incorrect");
            alert.showAndWait();
        }
        return false;
    }

    @FXML
    public void login() throws Exception {
        if (validateUser()) {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            homePageController.start(stage);
        }
    }

    @FXML
    void cycleImage(){
        imageCount++;
        if (imageCount >= imageList.size()) {
            imageCount = 0;
        }
        posterImage.setImage(imageList.get(imageCount));
        centerImage(posterImage);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        homePageController = new HomePageController();
        ArrayList<Film> films = Main.getFilms().getFilms();
        ObservableList<Film> filmsObservableList = FXCollections.observableArrayList(films);

        for (Film film : films /*Main.getFilms().getFilms()*/) {
            String posterUrl = film.getPoster();
            Image poster = new Image(posterUrl,5000,5000,true,false);
            imageList.add(poster);
            }

        posterImage.setImage(imageList.get(imageCount));
        centerImage(posterImage);
        }
}

