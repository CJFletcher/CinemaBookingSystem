package controller;

import model.Snack;

import java.io.*;
import java.util.ArrayList;

    public class SnackController implements Serializable{
        private final static String DATAFILEPATH = "./src/data/snacks.dat";
        private ArrayList<Snack> snacks = new ArrayList<>();

        public SnackController() {
            String popcornText = "Our popcorn is freshly popped, always carefully selected and you can choose from a range of sweet, salted or mixed.";
            String softDrinkText = "We are excited to offer a refreshing range of drinks including Pepsi MAX, Pepsi MAX Cherry, Pepsi, Diet Pepsi, 7up Free, Tango";
            Snack a = new Snack(5.20,"Popcorn - Large",popcornText);
            Snack b = new Snack(4.50,"Popcorn - Medium",popcornText);
            Snack c = new Snack(3.50,"Popcorn - Small",popcornText);
            Snack d = new Snack(3.20,"Soft Drink - Large",softDrinkText);
            Snack e = new Snack(2.80,"Soft Drink - Medium", softDrinkText);
            Snack f = new Snack(2.00,"Soft Drink - Large",softDrinkText);
            Snack g = new Snack(1.50,"Bottled Water","Cool, refreshing water.");
            Snack h = new Snack(2.00,"Hot Dog","Delicious sizzling hot dog, topped with ketchup & mustard");
            Snack i = new Snack(2.40,"Nachos","Nachos served with fiery jalapenos and your choice of dip: try them with salsa, warm cheese or sour cream.");

            snacks.add(a);
            snacks.add(b);
            snacks.add(c);
            snacks.add(d);
            snacks.add(e);
            snacks.add(f);
            snacks.add(g);
            snacks.add(h);
            snacks.add(i);
        }

        public ArrayList<Snack> getSnacks() {
            return snacks;
        }

        public void setSnacks(ArrayList<Snack> snacks) {
            this.snacks = snacks;
        }

        public void addItem(Snack item) {
            this.snacks.add(item);
        }

        public void removeItem(Snack item) {
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
            ArrayList<Snack> newObj = (ArrayList<Snack>) objin.readObject();
            this.snacks = newObj;
            objin.close();
        }

    }

