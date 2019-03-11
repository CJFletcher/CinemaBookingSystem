package fxmlControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.*;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class MakeBooking implements Initializable {
    public ObservableList arrayListToObservable(String dataType, ArrayList listToConvert) {
        ObservableList<String> newArrayList = FXCollections.observableArrayList(listToConvert);
        return newArrayList;
    }

    private void createSeats() {
        ArrayList<Showing> showings = Main.getShowings().getShowings();
        for (Showing showing : showings) {
            if (showing.getTheater().getTheaterNumber() == 1) {
                ArrayList<Row> r = showing.getRows();
                for (Row row : r) {
                    HBox h = new HBox();
                    h.setPrefSize(20, 20);
                    Text l = new Text();
                    String rowLetter = Character.toString(row.getRowLetter());
                    l.setText("Row "+rowLetter);
                    h.getChildren().add(l);
                    for (Seat seat : row.getSeats()) {
                        VBox v = new VBox();
                        v.setPrefSize(20, 20);
                    }
                }
            }
        }
    }

    @Override
    public void initialize (URL location, ResourceBundle resources){

    }
}