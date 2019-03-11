package fxmlControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by u1863522 on 11/03/2019.
 */
public class MakeBooking {
    public ObservableList arrayListToObservable(String dataType, ArrayList listToConvert){
        ObservableList<String> newArrayList = FXCollections.observableArrayList(listToConvert);
        return newArrayList;
    }

}
