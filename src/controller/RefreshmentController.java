package controller;

import model.Refreshment;

import java.io.*;
import java.util.ArrayList;

    public class RefreshmentController implements Serializable{
        private final static String DATAFILEPATH = "./src/data/refreshments.dat";
        private ArrayList<Refreshment> refreshments = new ArrayList<>();

        public RefreshmentController() {
        }

        public ArrayList<Refreshment> getRefreshments() {
            return refreshments;
        }

        public void setRefreshments(ArrayList<Refreshment> refreshments) {
            this.refreshments = refreshments;
        }

        public void addSnack(Refreshment item) {
            this.refreshments.add(item);
        }

        public void removeSnack(Refreshment item) {
            this.refreshments.remove(item);
        }

        public Refreshment getItemByName(String name){
            for (Refreshment refreshment :this.refreshments) {
                if (refreshment.getName().toLowerCase().contains(name.toLowerCase())){
                    return refreshment;
                }
            }
            return null;
        }

        public void saveSnacks() throws IOException {
            FileOutputStream out = new FileOutputStream(DATAFILEPATH);
            ObjectOutputStream objout = new ObjectOutputStream(out);
            objout.writeObject(refreshments);
            objout.flush();
            objout.close();
        }

        public void loadSnacks() throws IOException, ClassNotFoundException {
            FileInputStream in = new FileInputStream(DATAFILEPATH);
            ObjectInputStream objin = new ObjectInputStream(in);
            ArrayList<Refreshment> refreshment = (ArrayList<Refreshment>) objin.readObject();
            this.refreshments = refreshment;
            objin.close();
        }
    }

