package fxmlControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import model.Film;
import model.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static controller.HelperClass.centerImage;

public class LoginController extends SceneCreator implements Initializable {

    @FXML
    private JFXTextField usernameBox;

    @FXML
    private JFXPasswordField passwordBox;

    @FXML
    private JFXButton loginButton;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView posterImage;

    @FXML
    private AnchorPane leftAP;

    private int imageCount = 0;
    private ArrayList<Image> imageList = new ArrayList<>();


    @FXML
    void login(ActionEvent event) throws IOException {
        String username = usernameBox.getText();
        String password = passwordBox.getText();

        if (username.equals("Admin") && password.equals("Password")) {
            System.out.println("Login success");

        }
        if (username.equals("Admin")){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Login Error");
            alert.setHeaderText("Can not perform login");
            alert.setContentText("Password is incorrect");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Login Error");
            alert.setHeaderText("Can not perform login");
            alert.setContentText("Username is incorrect");
            alert.showAndWait();
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
        ArrayList<Film> films = Main.getFilms().getFilms();
        ObservableList<Film> filmsObservableList = FXCollections.observableArrayList(films);

        for (Film film : films) {
            String posterUrl = film.getPoster();
            /*Label label = new Label(posterUrl);
            ImageView posterImage = new ImageView(posterUrl);
            leftScrollPane.getChildren().add(posterImage);*/
            Image poster = new Image(posterUrl,5000,5000,true,false);
            imageList.add(poster);
            }

        posterImage.setImage(imageList.get(imageCount));
        centerImage(posterImage);
        }
    }

