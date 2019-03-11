package fxmlControllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public abstract class SceneCreator {

    public void launchSceneNewStage(String sceneName) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sceneName));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void launchSceneInStage(Stage currentStage, String sceneName) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sceneName));
        Parent root = fxmlLoader.load();
        currentStage.setScene(new Scene(root));
        currentStage.show();
    }
}

