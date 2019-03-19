package fxmlControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import controller.HelperClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static controller.HelperClass.getAllTicketsInBasket;
import static fxmlControllers.SceneCreator.openScene;


public class SelectSeatsController implements Initializable {

    private ArrayList<Seat> selectedSeats = new ArrayList<>();

    @FXML
    private JFXButton viewAllSnacksButton;

    @FXML
    private JFXButton basketButton;

    @FXML
    private JFXButton homeButton;

    @FXML
    private JFXListView<HBox> bookingsListView;

    @FXML
    private ImageView posterImageView;

    @FXML
    private Text titleText;

    @FXML
    private Text runTimeText;

    @FXML
    private Text plotText;

    @FXML
    private Text dateText;

    @FXML
    private Text timeText;

    @FXML
    private JFXButton addToBasketButton;

    @FXML
    private Text totalTicketPriceText;

    @FXML
    private JFXListView<Seat> selectedSeatsListView;

    @FXML
    private Text vipPriceText;

    @FXML
    private Text standardPriceText;

    @FXML
    private ImageView ratingImageView;

    @FXML
    private Text ratingWarningText;

    @FXML
    private Text ratingWarningText1;

    @FXML
    private Text ratingWarningText2;

    @FXML
    private JFXCheckBox customerIDCheckBox;


    @FXML
    private void addTicketsToBasket(ActionEvent event) {
        addedToBasketPopup();
        if (!getTicketsNotInBasket().isEmpty()) {
            for (Ticket ticket : getTicketsNotInBasket()) {
                Main.getBasket().addItem(ticket);
            }
        }
        showBasketButton();
    }

    private ArrayList<Ticket> getTicketsNotInBasket() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        for (Seat seat:selectedSeats) {
            if (!getSeatsOfTicketsInBasket().contains(seat)){
                Ticket t = new Ticket(Main.getCurrentShowing(),seat);
                tickets.add(t);
            }
        }
        return tickets;
    }

    private ArrayList<Seat> getSeatsOfTicketsInBasket() {
        ArrayList<Seat> seats = new ArrayList<>();
        for (Ticket ticketInBasket : getAllTicketsInBasket()) {
            if (Main.getCurrentShowing() == ticketInBasket.getShowing()) {
                seats.add(ticketInBasket.getSeat());
            }
        }
        return seats;
    }

    private void addedToBasketPopup(){
        if(!getTicketsNotInBasket().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            StringBuilder s = new StringBuilder();
            for (Ticket ticket : getTicketsNotInBasket()) {
                s.append(ticket.toString() + " added to basket.\n");
            }

            alert.setTitle("Ticket(s) added to basket!");
            alert.setHeaderText(s.toString());
            alert.setContentText("Basket before tickets were added:\n" + Main.getBasket().toString());
            alert.showAndWait();
        }
    }

    @FXML
    void goToHomePage(ActionEvent event) throws IOException {
        openScene("../fxml/homePage.fxml");
    }

    @FXML
    void goToSnackPage(ActionEvent event) throws IOException {
        openScene("../fxml/snacksPage.fxml");
    }

    @FXML
    void gotToBasketPage(ActionEvent event) throws IOException {
        openScene("../fxml/basketPage.fxml");
    }

    private void updateTicketList(){
        selectedSeatsListView.getItems().clear();
        for (Seat seat:selectedSeats) {
            selectedSeatsListView.getItems().add(seat);
        }
    }

    private void updateTotalPrice(){
        double total = 0;
        if(selectedSeats.isEmpty())
            totalTicketPriceText.setText("£0.00");
        for (Seat seat:selectedSeats) {
            double ticketPrice = new Ticket(Main.getCurrentShowing(),seat).getPrice();
            total += ticketPrice;
            String ret = HelperClass.formatDoubleToGBPString(total);
            totalTicketPriceText.setText(ret);
        }
    }

    private void addTicketsInBasketToSelectedSeats() {
        for (BuyableItem item: Main.getBasket().getItems()) {
            if (item.getClass()==Ticket.class){
                Ticket ticket = (Ticket) item;
                if (ticket.getShowing()==Main.getCurrentShowing()) {
                    Seat s = ticket.getSeat();
                    selectedSeats.add(s);
                }
            }
        }
    }

    private void createSeats() {
        ArrayList<Showing> showings = Main.getShowings().getShowings();
        for (Showing showing : showings) {
            if (showing == Main.getCurrentShowing()) {
                ArrayList<Row> r = showing.getRows();
                for (Row row : r) {
                    HBox hBox = new HBox();
                    hBox.setPrefSize(50, 50);
                    hBox.setAlignment(Pos.CENTER);
                    Text l = new Text();
                    String rowLetter = row.getRowLetter();
                    l.setText("Row "+rowLetter);
                    hBox.getChildren().add(l);
                    bookingsListView.getItems().add(hBox);
                    for (Seat seat : row.getSeats()) {
                        StackPane sp = new StackPane();
                        sp.setPrefSize(40, 40);
                        Image seatImageBlack = new Image("res/seatBlack.png",35,35,true,true);
                        Image seatImageVip = new Image("res/seatBlue.png",35,35,true,true);
                        ImageView seatImageView = new ImageView(seatImageBlack);
                        if (seat.getClass()==VipSeat.class){
                            seatImageView.setImage(seatImageVip);
                        }
                        if (seat.getBookingStatus()){
                            Image seatImageGrey = new Image("res/seatGrey.png",35,35,true,true);
                            seatImageView.setImage(seatImageGrey);
                        }
                        if (selectedSeats.contains(seat)){
                            Image seatImageRed = new Image("res/seatRed.png",35,35,true,true);
                            seatImageView.setImage(seatImageRed);
                        }
                        sp.getChildren().add(seatImageView);
                        if (!seat.getBookingStatus()){
                        sp.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!selectedSeats.contains(seat)){
                                    selectedSeats.add(seat);
                                    Image seatImageRed = new Image("res/seatRed.png",35,35,true,true);
                                    seatImageView.setImage(seatImageRed);
                                    updateTicketList();
                                    updateTotalPrice();
                                }
                                else {
                                    selectedSeats.remove(seat);
                                    seatImageView.setImage(seatImageBlack);
                                    updateTicketList();
                                    updateTotalPrice();
                                    if (seat.getClass()==VipSeat.class){
                                        seatImageView.setImage(seatImageVip);
                                        updateTicketList();
                                        updateTotalPrice();
                                    }
                                }
                            }
                        });
                        }
                        hBox.getChildren().add(sp);
                    }
                }
            }
        }
    }

    @FXML
    private void showBasketButton(){
        if (!Main.getBasket().getItems().isEmpty()){
            basketButton.setDisable(false);
        }
        else {
            basketButton.setDisable(true);
        }
    }

    private void setRatingImageView(ImageView imageView){
        String rating = Main.getCurrentShowing().getFilm().getRated();
        if (rating.equals("G")){
            Image ratingImage = new Image("res/URating.png",46,46,true,true);
            imageView.setImage(ratingImage);
        }
        if (rating.equals("PG")){
            Image ratingImage = new Image("res/pgRating.png",46,46,true,true);
            imageView.setImage(ratingImage);
        }
        if (rating.equals("PG-13")){
            Image ratingImage = new Image("res/12ARating.png",46,46,true,true);
            imageView.setImage(ratingImage);
        }
        if (rating.equals("R")){
            Image ratingImage = new Image("res/18Rating.png",46,46,true,true);
            imageView.setImage(ratingImage);
        }
    }

    @FXML
    private void toggleAddToBasketButton(){
        if(!customerIDCheckBox.isSelected()){
            addToBasketButton.setDisable(true);
        }
        else{
            addToBasketButton.setDisable(false);
        }
    }

    private void hideCheckBoxAndText(){
        String rating = Main.getCurrentShowing().getFilm().getRated();
        if (rating.equals("G")||rating.equals("PG")){
            ratingWarningText.setVisible(false);
            ratingWarningText1.setVisible(false);
            ratingWarningText2.setVisible(false);
            customerIDCheckBox.setSelected(true);
            customerIDCheckBox.setVisible(false);
        }
    }

    @Override
    public void initialize (URL location, ResourceBundle resources){
        addTicketsInBasketToSelectedSeats();
        createSeats();
        Showing currentShowing = Main.getCurrentShowing();
        Film currentFilm = currentShowing.getFilm();
        titleText.setText(currentFilm.getTitle());
        runTimeText.setText(currentFilm.getRuntime());
        Image poster = new Image(currentFilm.getPoster());
        posterImageView.setImage(poster);
        plotText.setText(currentFilm.getPlotShort());
        dateText.setText(currentShowing.getShowingDateFormatted(false));
        timeText.setText(currentShowing.getShowingTimeFormatted());
        standardPriceText.setText(new Ticket(currentShowing,new Seat()).getPriceFormatted());
        vipPriceText.setText(new Ticket(currentShowing,new VipSeat()).getPriceFormatted());
        updateTotalPrice();
        updateTicketList();
        showBasketButton();
        setRatingImageView(ratingImageView);
        hideCheckBoxAndText();
        toggleAddToBasketButton();
    }
}