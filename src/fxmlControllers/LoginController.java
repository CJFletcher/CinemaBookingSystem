package fxmlControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import model.Basket;
import model.Film;
import model.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static controller.HelperClass.centerImage;

public class LoginController implements Initializable  {

    private int imageCount = 0;
    private ArrayList<Image> imageList = new ArrayList<>();
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(0);

    @FXML
    private JFXTextField usernameBox;

    @FXML
    private JFXPasswordField passwordBox;

    @FXML
    public JFXButton loginButton;

    @FXML
    private ImageView posterImage;

    @FXML
    private void focusPasswordBox(){
        passwordBox.requestFocus();
    }

    @FXML
    public void login(ActionEvent event) throws Exception {
        UserController users = Main.getUsers();
        String username = usernameBox.getText();
        String password = passwordBox.getText();
        if (users.validateUser(username,password)) {
            Main.setCurrentUser(users.getUserByUsername(username));
            executor.shutdown();
            SceneCreator.openScene("../fxml/homePage.fxml");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Can not perform login");
            alert.setContentText("Username or password is incorrect");
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
        Main.setBasket(new Basket());
        Main.setCurrentUser(null);
        Main.setCurrentShowing(null);
        for (Film film : films) {
            String posterUrl = film.getPoster();
            Image poster = new Image(posterUrl,5000,5000,true,true);
            imageList.add(poster);
            }

        posterImage.setImage(imageList.get(imageCount));
        centerImage(posterImage);

        //https://stackoverflow.com/questions/12908412/print-hello-world-every-x-seconds
        executor.scheduleAtFixedRate(this::cycleImage, 0, 3, TimeUnit.SECONDS);
    }
}

