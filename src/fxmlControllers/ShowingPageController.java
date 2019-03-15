package fxmlControllers;


import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Main;
import model.Showing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowingPageController implements Initializable{

    public ShowingPageController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(Showing showing: Main.getShowings().getShowings())
            if (Main.getCurrentShowing()==showing){
            //TODO
            }
    }
}
