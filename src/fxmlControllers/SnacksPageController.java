package fxmlControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Main;
import model.Refreshment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static fxmlControllers.SceneCreator.openScene;

public class SnacksPageController implements Initializable {

    @FXML
    private JFXButton openBasketPageButton;

    @FXML
    private JFXButton homeButton;

    @FXML
    private JFXListView<HBox> snacksListView;

    @FXML
    private JFXListView<?> drinksListView;

    @FXML
    private void openBasketPage(ActionEvent event) throws IOException {
        openScene("../fxml/basketPage.fxml");
    }

    @FXML
    private void openHomePage(ActionEvent event) throws IOException {
        openScene("../fxml/homePage.fxml");
    }

    private void addedToBasketAlert(Refreshment refreshment){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Item added to basket!");
        alert.setHeaderText(refreshment.getName() + " successfully added to basket");
        alert.setContentText(Main.getBasket().toString());
        alert.showAndWait();
    }

    private void addedMultipleToBasketAlert(Refreshment refreshment, String timesAdded){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Item added to basket!");
        alert.setHeaderText(refreshment.getName() + " successfully added to basket "+timesAdded+" times.");
        alert.setContentText(Main.getBasket().toString());
        alert.showAndWait();
    }

    private void populateListView(JFXListView listView, String refreshmentType){
        for (Refreshment refreshment: Main.getRefreshments().getRefreshments()) {
            if (refreshment.getRefreshmentType().equalsIgnoreCase(refreshmentType)){
                HBox hBox = new HBox();
                hBox.getStylesheets().add(getClass().getResource("../res/styleSheet.css").toExternalForm());
                hBox.setPadding(new Insets(10,10,10,0));
                hBox.setSpacing(5);
                hBox.setPrefWidth(210);
                hBox.setMaxWidth(210);
                hBox.setAlignment(Pos.CENTER_RIGHT);
                Image foodImage = new Image(refreshment.getImagePath(),180,180,true,false);
                ImageView imageView = new ImageView(foodImage);
                hBox.getChildren().add(imageView);
                Text description = new Text(refreshment.getRefreshmentFormatted());
                description.setTextAlignment(TextAlignment.JUSTIFY);
                description.setWrappingWidth(120);
                hBox.getChildren().add(description);

                VBox vBox=new VBox();
                JFXButton addToBasketButton = new JFXButton();
                JFXComboBox amount = new JFXComboBox();

                amount.promptTextProperty().setValue("Number to add");
                amount.setLabelFloat(true);
                amount.setMinWidth(120);
                amount.setPrefWidth(120);
                vBox.getChildren().add(amount);
                ObservableList<Integer> options = FXCollections.observableArrayList();
                for (int i=1;i<10;i++) { options.add(i);}
                amount.setItems(options);

                addToBasketButton.setText("Add to basket");
                addToBasketButton.setMinWidth(120);
                addToBasketButton.setPrefWidth(120);
                addToBasketButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (amount.getSelectionModel().getSelectedItem() != null){
                            for (int i = 0;i<amount.getSelectionModel().getSelectedIndex()+1;i++) {
                                Main.getBasket().addItem(refreshment);
                            }
                            addedMultipleToBasketAlert(refreshment,String.valueOf(amount.getSelectionModel().getSelectedIndex()+1));
                        }
                        else {
                            Main.getBasket().addItem(refreshment);
                            addedToBasketAlert(refreshment);
                        }
                    }
                });
                vBox.getChildren().add(addToBasketButton);
                vBox.setAlignment(Pos.CENTER);
                hBox.getChildren().add(vBox);
                listView.getItems().add(hBox);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateListView(snacksListView,"Snack");
        populateListView(drinksListView,"Drink");
        }
    }

