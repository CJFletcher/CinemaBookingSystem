package fxmlControllers;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import model.Basket;
import model.BuyableItem;
import model.Main;
import model.Snack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static fxmlControllers.SceneCreator.launchScene;

public class BasketPageController implements Initializable {

    private Basket basket = Main.getBasket();

    @FXML
    private JFXButton viewAllSnacksButton;

    @FXML
    private JFXButton homeButton;

    @FXML
    private JFXListView<BuyableItem> basketListView;

    @FXML
    private JFXButton removeSelectedItemButton;

    @FXML
    private JFXButton clearBasketButton;

    @FXML
    private JFXButton payWithCash;

    @FXML
    private JFXButton payWithCardButton;

    @FXML
    private JFXListView<?> showingsListView1;

    @FXML
    private JFXButton confirmCardDetailsButton;

    @FXML
    private JFXTextField cardNumber;

    @FXML
    private JFXTextField cvc;

    @FXML
    private JFXTextField cardMonth;

    @FXML
    private JFXTextField cardYear;

    @FXML
    private JFXButton printReceiptButton;

    @FXML
    private JFXTextArea receiptTextArea;

    @FXML
    void clearBasket(ActionEvent event) {
        Main.getBasket().getItems().clear();
        populateBasketListView();
    }

    @FXML
    void confirmCardDetails(ActionEvent event) {

    }

    @FXML
    void openHomePage(ActionEvent event) throws IOException {
        launchScene("../fxml/homePage.fxml");
    }

    @FXML
    void openSnacksPage(ActionEvent event) {

    }

    @FXML
    void payWithCard(ActionEvent event) {

    }

    @FXML
    void payWithCash(ActionEvent event) {

    }

    @FXML
    void printReceipt(ActionEvent event) {

    }

    @FXML
    void removeSelectedItemFromBasket(ActionEvent event) {
        BuyableItem selectedItem = basketListView.getSelectionModel().getSelectedItem();
        if(selectedItem!=null) {
            basket.removeItem(selectedItem);
            populateBasketListView();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No selection");
            alert.setHeaderText("Can not remove item from basket");
            alert.setContentText("Please select an item to remove");
            alert.showAndWait();
        }
    }

    void populateBasketListView(){
        basketListView.getItems().clear();
        basketListView.setDisable(false);
        if (!basket.getItems().isEmpty()) {
            for (BuyableItem item : basket.getItems()) {
                basketListView.getItems().add(item);
            }
        }else{
            basketListView.getItems().add(new Snack(0.00,"NO ITEMS IN BASKET",""));
            basketListView.setDisable(true);
            }
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateBasketListView();
    }
}

