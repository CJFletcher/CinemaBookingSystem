package fxmlControllers;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowingPageController {


    public void start(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/showingPage.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
