package fxmlControllers;

import com.jfoenix.controls.*;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.*;
import org.apache.commons.validator.routines.CreditCardValidator;

import java.io.IOException;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import static controller.HelperClass.formatDoubleToGBPString;
import static controller.HelperClass.print;
import static fxmlControllers.SceneCreator.openScene;
import static model.Basket.*;

public class BasketPageController implements Initializable {

    private Basket basket = Main.getBasket();
    private ArrayList<JFXTextField> cardTextFields = new ArrayList<>();

    @FXML
    private JFXButton viewAllSnacksButton;

    @FXML
    private JFXButton homeButton;

    @FXML
    private JFXListView<BuyableItem> basketListView;

    @FXML
    private JFXButton removeSelectedItemButton;

    @FXML
    private JFXButton removeSameItemsButton;

    @FXML
    private JFXButton clearBasketButton;

    @FXML
    private JFXButton payWithCash;

    @FXML
    private JFXButton payWithCardButton;

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
    private Text totalText;

    @FXML
    private JFXTextField cardName;

    @FXML
    void clearBasket() {
        if (!basket.getItems().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Clear basket");
            alert.setHeaderText("This will clear ALL items in the basket");
            alert.setContentText("Are you sure you want to do this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Main.getBasket().getItems().clear();
                populateBasketListView();
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }

    @FXML
    void confirmCardDetails(ActionEvent event) {
        if (validateBasicCardDetails() && validateCardNumber() && validateCardMonth() && validateCardYear() && validateCardCvc()) {
            createReceipt();
        }
    }

    @FXML
    void openHomePage(ActionEvent event) throws IOException {
        receiptTextAreaNotEmptyAlert("../fxml/homePage.fxml");
    }

    @FXML
    void openSnacksPage(ActionEvent event) throws IOException {
        receiptTextAreaNotEmptyAlert("../fxml/snacksPage.fxml");
    }

    @FXML
    void payWithCard(ActionEvent event) {
        for (TextField tf : cardTextFields) {
            tf.setDisable(false);
        }
        confirmCardDetailsButton.setDisable(false);
        cardNumber.requestFocus();
    }

    void createReceipt() {
        Booking booking = createBooking();
        ArrayList<Ticket> tickets = booking.getTickets();
        ArrayList<Snack> snacks = getAllSnacksInBasket();
        ArrayList<Drink> drinks = getAllDrinksInBasket();
        if (!tickets.isEmpty()) {
            receiptTextArea.appendText("Booking ID:" + booking.getId() + "\n");
            for (Ticket ticket : tickets) {
                receiptTextArea.appendText(ticket.toString() + "\n");
            }
        }
        if (!snacks.isEmpty()) {
            receiptTextArea.appendText("\nSnacks:\n");
            for (Snack snack : snacks) {
                receiptTextArea.appendText(snack.toString() + "\n");
            }
        }
        if (!drinks.isEmpty()) {
            receiptTextArea.appendText("\nDrinks:\n");
            for (Drink drink : drinks) {
                receiptTextArea.appendText(drink.toString() + "\n");
            }
        }
        receiptTextArea.appendText("\nTotal: " + totalText.getText());
        Main.getBasket().getItems().clear();
        populateBasketListView();
        printReceiptButton.setDisable(false);
    }

    @FXML
    void payWithCash(ActionEvent event) {
        createReceipt();
    }

    @FXML
    void printReceipt(ActionEvent event) {
        print(receiptTextArea);
    }

    @FXML
    void removeSelectedItemFromBasket(ActionEvent event) {
        BuyableItem selectedItem = basketListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            basket.removeItem(selectedItem);
            updateListAndTotal();
        } else {
            noSelectionAlert();
        }
    }

    @FXML
    void removeSameItemFromBasket(ActionEvent event) {
        BuyableItem selectedItem = basketListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            basket.removeAllIdenticalItems(selectedItem);
            updateListAndTotal();
        } else {
            noSelectionAlert();
        }
    }

    private void cardDetailsError(TextField tf, String contentTextOptional) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Card details incorrect");
        alert.setHeaderText(tf.getPromptText() + " has invalid data");
        if (contentTextOptional != null) {
            alert.setContentText(contentTextOptional);
        } else {
            alert.setContentText("See on-screen prompts for help");
        }
        alert.showAndWait();
    }

    private void noSelectionAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No selection made");
        alert.setHeaderText("Can not remove item from basket");
        alert.setContentText("Please select an item to remove");
        alert.showAndWait();
    }

    private void receiptTextAreaNotEmptyAlert(String pageToOpen) throws IOException {
        if(!receiptTextArea.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Items in receipt area");
            alert.setHeaderText("Check if customer wants a receipt first");
            alert.setContentText("Are you sure you want to change page?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                openScene(pageToOpen);
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
        else{
            openScene(pageToOpen);}
    }

    private void populateBasketListView(){
        basketListView.getItems().clear();
        basketListView.setDisable(false);
        if (!basket.getItems().isEmpty()) {
            for (BuyableItem item : basket.getItems()) {
                basketListView.getItems().add(item);
            }
        } else{
            basketListView.getItems().add(new Refreshment(0.00, "NO ITEMS IN BASKET", "") {
            });
            setTotalText();
            basketListView.setDisable(true);
            disableCardPaymentDetails();
            disablePaymentButtons();
            confirmCardDetailsButton.setDisable(true);
        }
    }

    private void setTotalText(){
        totalText.setText(formatDoubleToGBPString(basket.calculateTotalPrice()));
    }

    private void updateListAndTotal(){
        populateBasketListView();
        setTotalText();
    }

    private void validateBlank(JFXTextField textField){
        RequiredFieldValidator validator = new RequiredFieldValidator();
        textField.getValidators().add(validator);
        validator.setMessage("Field required");
        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                    textField.validate();
                }
            }
        });
    }

    private void validateNumbersOnly(JFXTextField textField){
        NumberValidator numberValidator = new NumberValidator();
        textField.getValidators().add(numberValidator);
        numberValidator.setMessage("Numbers only");
        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                    textField.validate();
                }
            }
        });
    }

    private boolean validateCreditCard(String string){
        CreditCardValidator validator = new CreditCardValidator(CreditCardValidator.AMEX + CreditCardValidator.VISA + CreditCardValidator.MASTERCARD);
        return validator.isValid(string);
    }

    private boolean isValidMonth(String string) {
        if(string.length()==2) {
            try {
                return 0 < Integer.parseInt(string) && Integer.parseInt(string) <= 12;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    private boolean isValidCVC(String cvc){
        return Pattern.matches("^[0-9]{3,4}$", cvc);
    }

    boolean isValidYear(String string) {
        if(string.length()==2) {
            try {
                int year = Year.now().getValue();
                String yearString = String.valueOf(year);
                String yearFormat = yearString.substring(2);
                int yy =  Integer.parseInt(yearFormat);
                int yyPlus20 = yy+20;
                if (yyPlus20 >100) return  yy <= Integer.parseInt(string) && Integer.parseInt(string)+100 <= yyPlus20;
                else return  yy <= Integer.parseInt(string) && Integer.parseInt(string) <= yyPlus20;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    private void addCardTextFieldsToArray(){
        cardTextFields.add(cardNumber);
        cardTextFields.add(cardMonth);
        cardTextFields.add(cardYear);
        cardTextFields.add(cvc);
        cardTextFields.add(cardName);
    }

    private void addValidatorsToCardTextFields(){
        for (JFXTextField tf:cardTextFields) {
            if(tf != cardName) {
                validateBlank(tf);
                validateNumbersOnly(tf);
            }
        }
        validateBlank(cardName);
    }

    private void disablePaymentButtons(){
        if (basket.getItems().isEmpty()){
            payWithCardButton.setDisable(true);
            payWithCash.setDisable(true);
        }
    }

    private void enablePaymentButtons(){
        if (!basket.getItems().isEmpty()){
            payWithCardButton.setDisable(false);
            payWithCash.setDisable(false);
        }
    }

    private void disableCardPaymentDetails() {
        for (TextField tf : cardTextFields) {
            tf.setDisable(true);
        }
    }

    private Booking createBooking(){
        Booking booking = new Booking();
        ArrayList<Refreshment> refreshments = getAllRefreshmentsInBasket();
        for (Refreshment refreshment:refreshments) {
            booking.addRefreshment(refreshment);
        }
        ArrayList<Ticket> tickets = getAllTicketsInBasket();
        for (Ticket ticket:tickets) {
            booking.addTicket(ticket);
        }
        booking.setSeatsAsBooked();
        booking.calculateTotalPrice();
        Main.getBookings().addBooking(booking);
        saveStateOfBookingsAndShowings();
        return booking;
    }

    //Validates each textfield for Int only & not empty
    private boolean validateBasicCardDetails(){
        for (JFXTextField tf:cardTextFields) {
            if (!tf.validate()){
                cardDetailsError(tf,null);
                return false;
            }
        }
        return true;
    }

    private boolean validateCardNumber(){
        if (!validateCreditCard(cardNumber.getText())){
            cardDetailsError(cardNumber,"Card number is invalid");
            return false;
        }
        else return true;
    }

    private boolean validateCardMonth(){
        if (!isValidMonth(cardMonth.getText())){
            cardDetailsError(cardMonth,"Card Month is invalid, must be 01-12.");
            return false;
        }
        else return true;
    }

    private boolean validateCardYear(){
        if (!isValidYear(cardYear.getText())){
            cardDetailsError(cardYear,"Card Year is invalid, must be in format YY and in the next 20 years");
            return false;
        }
        else return true;
    }

    private boolean validateCardCvc(){
        if (!isValidCVC(cvc.getText())){
            cardDetailsError(cardYear,"CVC is invalid, must be 3-4 digits long");
            return false;
        }
        else return true;
    }

    private void saveStateOfBookingsAndShowings(){
        try {
            Main.getBookings().saveBookings();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Main.getShowings().saveShowings();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize (URL location, ResourceBundle resources){
        addCardTextFieldsToArray();
        addValidatorsToCardTextFields();
        populateBasketListView();
        setTotalText();
        enablePaymentButtons();

//        System.out.println(isValidMonth("12"));//true
//        System.out.println(isValidMonth("13"));//false
//        System.out.println(isValidMonth("1"));//false
//        System.out.println(isValidMonth("fd"));//false
//        System.out.println(isValidYear("19"));//true
//        System.out.println(isValidYear("fd"));//false
//        System.out.println(isValidYear("40"));//false 20 years upper limit
//        System.out.println(isValidYear("39"));//true
//        System.out.println(isValidYear("18"));//false
//        System.out.println(isValidYear("39"));//true
//        System.out.println(validateCreditCard("378282246310005"));//AMEX
//        System.out.println(validateCreditCard("4111111111111111"));//VISA
//        System.out.println(validateCreditCard("5555555555554444"));//MASTERCARD
//        System.out.println(validateCreditCard("37828224631000"));//INVALID
//        System.out.println(validateCreditCard("41111111111111111"));//INVALID
//        System.out.println(isValidCVV("1234"));//true
//        System.out.println(isValidCVV("123"));//true
//        System.out.println(isValidCVV("12345"));//false
//        System.out.println(isValidCVV("abc"));//false
//        System.out.println(isValidCVV("abcd"));//false
    }
}
