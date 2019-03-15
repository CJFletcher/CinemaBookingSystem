package fxmlControllers;

import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class MakeBookingController implements Initializable {

    private ArrayList<Seat> selectedSeats = new ArrayList<>();


    @FXML
    JFXListView<HBox> bookingsListView;
//    public ObservableList arrayListToObservable(String dataType, ArrayList listToConvert) {
//        ObservableList<dataType> newArrayList = FXCollections.observableArrayList(listToConvert);
//        return newArrayList;
//    }

    private void createSeats() {
        ArrayList<Showing> showings = Main.getShowings().getShowings();
        for (Showing showing : showings) {
            if (showing == Main.getCurrentShowing()) {
                ArrayList<Row> r = showing.getRows();
                for (Row row : r) {
                    HBox hBox = new HBox();
                    hBox.setPrefSize(50, 50);
                    Text l = new Text();
                    String rowLetter = row.getRowLetter();
                    l.setText("Row "+rowLetter);
                    hBox.getChildren().add(l);
                    bookingsListView.getItems().add(hBox);
                    for (Seat seat : row.getSeats()) {
                        StackPane sp = new StackPane();
                        sp.setPrefSize(40, 40);
                        Image seatImage = new Image("data/seatBlack.png",35,35,true,true);
                        ImageView seatImageView = new ImageView(seatImage);
                        sp.getChildren().add(seatImageView);
                        seatImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!selectedSeats.contains(seat)){
                                    selectedSeats.add(seat);
                                    Image seatImageSelected = new Image("res/back.jpg");
                                    seatImageView.setImage(seatImageSelected);
                                    System.out.println(selectedSeats);//DELETE
                                }
                                else {
                                    selectedSeats.remove(seat);
                                    seatImageView.setImage(seatImage);
                                    System.out.println(selectedSeats);//DELETE
                                }
                            }
                        });
                        hBox.getChildren().add(sp);
                    }
                }
            }
        }
    }

    @Override
    public void initialize (URL location, ResourceBundle resources){

        createSeats();
    }
}