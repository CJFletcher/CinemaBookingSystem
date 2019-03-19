package fxmlControllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import model.Main;


import java.io.IOException;

public abstract class SceneCreator {

    public static void openScene(String sceneName) throws IOException {

        FXMLLoader loader = new FXMLLoader(Main.class.getResource(sceneName));
        Main.setRoot(loader.load());
        Scene scene = new Scene(Main.getRoot());
        Main.getStage().setScene(scene);
        Main.getStage().show();
    }
}


