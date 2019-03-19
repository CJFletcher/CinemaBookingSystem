package controller;


import java.io.*;
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

    public static void arrayOfStringsToTxt(ArrayList<String> arrayList, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        new File(fileName).createNewFile();
        for (String str : arrayList) {
            try{writer.write(str+"\n");}
            catch (NullPointerException e){
                System.out.println(e +" String in array returned Null value");
            }
        }
        writer.flush();
        writer.close();
    }


    //public static List<String> txtToArray2(String fileName) throws IOException {
    //    File f = new File(fileName);
    //    return readLines(f,"UTF-8");
    //}
}