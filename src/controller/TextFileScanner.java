package controller;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class TextFileScanner {

    //https://stackoverflow.com/questions/16100175/store-text-file-content-line-by-line-into-array
    public static ArrayList<String> txtToArray(String filename) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(filename));
        String str;

        ArrayList<String> list = new ArrayList<String>();
        while ((str = in.readLine()) != null) {
            list.add(str);
        }
        return list;
    }
}