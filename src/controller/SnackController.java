package controller;

import model.Snack;

import java.io.*;
import java.util.ArrayList;

    public class SnackController implements Serializable{
        private final static String DATAFILEPATH = "./src/data/snacks.dat";
        private ArrayList<Snack> snacks = new ArrayList<>();

        public SnackController() {
        }

        public ArrayList<Snack> getSnacks() {
            return snacks;
        }

        public void setSnacks(ArrayList<Snack> snacks) {
            this.snacks = snacks;
        }

        public void addSnack(Snack item) {
            this.snacks.add(item);
        }

        public void removeSnack(Snack item) {
            this.snacks.remove(item);
        }

        public Snack getItemByName(String name){
            for (Snack snack:this.snacks) {
                if (snack.getName().toLowerCase().contains(name.toLowerCase())){
                    return snack;
                }
            }
            return null;
        }

        public void saveSnacks() throws IOException {
            FileOutputStream out = new FileOutputStream(DATAFILEPATH);
            ObjectOutputStream objout = new ObjectOutputStream(out);
            objout.writeObject(snacks);
            objout.flush();
            objout.close();
        }

        public void loadSnacks() throws IOException, ClassNotFoundException {
            FileInputStream in = new FileInputStream(DATAFILEPATH);
            ObjectInputStream objin = new ObjectInputStream(in);
            ArrayList<Snack> snack = (ArrayList<Snack>) objin.readObject();
            this.snacks = snack;
            objin.close();
        }

    }

