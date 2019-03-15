package controller;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.*;
import java.lang.String;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class HelperClass {

    public static boolean isEmailAddressValid(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        boolean validEmail = validator.isValid(email);
        return validEmail;
    }

    public static String replaceSpacesInString(String stringToFormat, String replacement) {
        String ret = (stringToFormat.replaceAll("\\s+", replacement));
        return ret;
    }

    public static String parseStringByChar(String str) {
        str = str.substring(str.indexOf(","));
        str = str.substring(1, str.indexOf(":"));
        return str;
    }

    public static void centerImage(ImageView imageView) {
        Image img = imageView.getImage();
        if (img != null) {
            double w = 0;
            double h = 0;

            double ratioX = imageView.getFitWidth() / img.getWidth();
            double ratioY = imageView.getFitHeight() / img.getHeight();

            double reducCoeff = 0;
            if (ratioX >= ratioY) {
                reducCoeff = ratioY;
            } else {
                reducCoeff = ratioX;
            }

            w = img.getWidth() * reducCoeff;
            h = img.getHeight() * reducCoeff;

            imageView.setX((imageView.getFitWidth() - w) / 2);
            imageView.setY((imageView.getFitHeight() - h) / 2);

        }
    }
}
//    public static void readObjectsFromFile(String filePath,Class className) throws IOException {
//        FileOutputStream out = new FileOutputStream(filePath);
//        ObjectOutputStream objout = new ObjectOutputStream(out);
//        objout.writeObject(className);
//        objout.flush();
//    }
//
//    public static void saveObjectsToFile(String filePath, Class className) throws IOException {
//        FileInputStream in = new FileInputStream("myFile");
//        ObjectInputStream objin = new ObjectInputStream(in);
//        className new = (className) objin.readObject();
//    }


    /*public static String[] stringToArray(String str){
        String[] ary = str.split("\",\"");
        for (String str1 : ary){
            String[] keyValue = str1.split("\":\"");
            Film f = new Film();
            if(keyValue[0].contains("Year")){
                f.setTitle(keyValue[1]);
            }
            System.out.println(f);
            System.out.println("Key: " + keyValue[0]);
            System.out.println("Value: " + keyValue[1]);
        }
        return ary;*/
