package controller;

import model.User;

import java.io.*;
import java.util.ArrayList;

public class UserController implements Serializable{
    private final static String DATAFILEPATH = "./src/data/users.dat";
    private ArrayList<User> users = new ArrayList<>();

    public UserController() {
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public User getUserByFirstName(String name){
        for (User user :this.users) {
            if (user.getFirstName().toLowerCase().contains(name.toLowerCase())){
                return user;
            }
        }
        return null;
    }

    public User getUserByLastName(String name){
        for (User user :this.users) {
            if (user.getFirstName().toLowerCase().contains(name.toLowerCase())){
                return user;
            }
        }
        return null;
    }

    public User getUserByUsername(String name){
        for (User user :this.users) {
            if (user.getUsername().equals(name)){
                return user;
            }
        }
        return null;
    }

    public void saveUsers() throws IOException {
        FileOutputStream out = new FileOutputStream(DATAFILEPATH);
        ObjectOutputStream objout = new ObjectOutputStream(out);
        objout.writeObject(users);
        objout.flush();
        objout.close();
    }

    public boolean validateUser(String userName, String password){
        if(!users.isEmpty()) {
            for (User user : users) {
                if(user.getUsername().equals(userName) && user.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException("User database is empty");
    }

    public void loadUsers() throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(DATAFILEPATH);
        ObjectInputStream objin = new ObjectInputStream(in);
        ArrayList<User> refreshment = (ArrayList<User>) objin.readObject();
        this.users = refreshment;
        objin.close();
    }
}
