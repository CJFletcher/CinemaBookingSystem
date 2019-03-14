package controller;

import model.BuyableItem;

import java.io.*;
import java.util.ArrayList;

    public class BuyableItemController implements Serializable{
        private final static String DATAFILEPATH = "./src/data/buyableItems.dat";

        private ArrayList<BuyableItem> items = new ArrayList<>();

        public BuyableItemController(ArrayList<BuyableItem> items) {
            this.items = items;
        }

        public ArrayList<BuyableItem> getItems() {
            return items;
        }

        public void setItems(ArrayList<BuyableItem> items) {
            this.items = items;
        }

        public void addItem(BuyableItem item) {
            this.items.add(item);
        }

        public void removeItem(BuyableItem item) {
            this.items.remove(item);
        }

        public void saveBookings() throws IOException, ClassNotFoundException {
            FileOutputStream out = new FileOutputStream(DATAFILEPATH);
            ObjectOutputStream objout = new ObjectOutputStream(out);
            objout.writeObject(items);
            objout.flush();
            objout.close();
        }

        public void loadBookings() throws IOException, ClassNotFoundException {
            FileInputStream in = new FileInputStream(DATAFILEPATH);
            ObjectInputStream objin = new ObjectInputStream(in);
            ArrayList<BuyableItem> newObj = (ArrayList<BuyableItem>) objin.readObject();
            this.items = newObj;
            objin.close();
        }

    }

