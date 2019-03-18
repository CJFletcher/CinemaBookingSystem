package controller;

import javafx.print.PageLayout;
import javafx.print.PrinterJob;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import model.BuyableItem;
import model.Main;
import model.Snack;
import model.Ticket;
import org.apache.commons.validator.routines.EmailValidator;

import java.lang.String;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class HelperClass {

    public static boolean isEmailAddressValid(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
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

    public static String formatDoubleToGBPString(double number) {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "£" + df.format(number);
    }

    public static ArrayList<Ticket> getAllTicketsInBasket() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        for (BuyableItem item : Main.getBasket().getItems()) {
            if (item.getClass() == Ticket.class) {
                Ticket ticketInBasket = (Ticket) item;
                tickets.add(ticketInBasket);
            }
        }
        return tickets;
    }

    public static ArrayList<Snack> getAllSnacksInBasket() {
        ArrayList<Snack> snacks = new ArrayList<>();
        for (BuyableItem item : Main.getBasket().getItems()) {
            if (item.getClass() == Snack.class) {
                Snack snackInBasket = (Snack) item;
                snacks.add(snackInBasket);
            }
        }
        return snacks;
    }


    //https://stackoverflow.com/questions/36555291/how-do-i-print-only-text
    public static void print(TextArea textArea) {
        TextFlow printArea = new TextFlow(new Text(textArea.getText()));

        PrinterJob printerJob = PrinterJob.createPrinterJob();

        if (printerJob != null && printerJob.showPrintDialog(textArea.getScene().getWindow())) {
            PageLayout pageLayout = printerJob.getJobSettings().getPageLayout();
            printArea.setMaxWidth(pageLayout.getPrintableWidth());

            if (printerJob.printPage(printArea)) {
                printerJob.endJob();
                // done printing
            } else {
                System.out.println("Failed to print");
            }
        } else {
            System.out.println("Print cancelled");
        }
    }
}

/*    public static void readObjectsFromFile(String filePath,Class className) throws IOException {
        FileOutputStream out = new FileOutputStream(filePath);
        ObjectOutputStream objout = new ObjectOutputStream(out);
        objout.writeObject(className);
        objout.flush();
    }

    public static void saveObjectsToFile(String filePath, Class className) throws IOException {
        FileInputStream in = new FileInputStream("myFile");
        ObjectInputStream objin = new ObjectInputStream(in);
        className new = (className) objin.readObject();
    }


    public static String[] stringToArray(String str){
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
