/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import java.util.ArrayList;

/**
 *Model class for creating new users
 * @author hoovb
 */
public class User {
    
    private String username;
    private String password;
    private boolean isUniqueUser;
    private boolean isSamePassword;
    
    /**
     * Constructor for new user with an email and password
     * @param username
     * @param password 
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * Checks the database for the username and password the user enters
     * @param user
     * @return 
     */
    public boolean isAuthenticated(User user) {
        UserTable userTable = new UserTable();
        if (userTable.table.getItem("Username", user.getUsername()).get("Password").equals(user.getPassword())) {
            return true;
        }
            return false;
    }
    
    /**
     * Adds a new user to the database
     * @param username
     * @param password
     * @param password2 
     */
    public void createUser(String username, String password, String password2) {
        UserTable userTable = new UserTable();
        Item item = new Item()
                .withPrimaryKey("Username", username)
                .withString("Password", password);
        
        if (userTable.table.getItem("Username", username) == null && isSamePassword(password, password2)) {
            PutItemOutcome outcome = userTable.table.putItem(item);
            System.out.println(outcome.toString());
            System.out.println("User added to the database!");
            setIsUniqueUser(true);
            setIsSamePassword(true);
        }
        else if (!isSamePassword(password, password2)) {
            setIsSamePassword(false);
        }
        else if (userTable.table.getItem("Username", username) != null) {
            setIsUniqueUser(false);
        }
    }

    /**
     * Checks to see if both passwords are the same 
     * when creating an account
     * @param p1
     * @param p2
     * @return 
     */
    public boolean isSamePassword(String p1, String p2) {
        if (!p1.equals(null) && p1.equals(p2)) {
            return true;
        }
        return false;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * @return the isUniqueUser
     */
    public boolean isIsUniqueUser() {
        return isUniqueUser;
    }

    /**
     * @param isUniqueUser the isUniqueUser to set
     */
    public void setIsUniqueUser(boolean isUniqueUser) {
        this.isUniqueUser = isUniqueUser;
    }

    /**
     * @return the isSamePassword
     */
    public boolean isIsSamePassword() {
        return isSamePassword;
    }

    /**
     * @param isSamePassword the isSamePassword to set
     */
    public void setIsSamePassword(boolean isSamePassword) {
        this.isSamePassword = isSamePassword;
    }
    
    
}
