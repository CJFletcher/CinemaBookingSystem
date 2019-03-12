package fxmlControllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Main;


import java.io.IOException;

public abstract class SceneCreator {

    public static void launchSceneNewStage (String sceneName) throws IOException {


    }

    public void launchSceneInStage(Stage currentStage, String sceneName) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sceneName));
        Parent root = fxmlLoader.load();
        currentStage.setScene(new Scene(root));
        currentStage.show();
    }
}


