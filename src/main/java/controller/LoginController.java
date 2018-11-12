/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.User;

/**
 *Controller for user Login
 * @author hoovb
 */
public class LoginController extends View implements Initializable {

    @FXML
    private JFXTextField usernameField;
    @FXML
    private JFXPasswordField passwordField;
    @FXML
    private Label errorMessage;
    @FXML
    private VBox rootPane;
    @FXML
    private AnchorPane background;
    @FXML
    private JFXButton submitButton;
    static User user;

    /**
     * Takes the user to the sign up page
     * @param event 
     */
   
    @FXML
    private void signUpView(ActionEvent event) {
        changeView(rootPane, "/fxml/SignUpView2.fxml");
    }

    /**
     * Validates email and password
     * and logs the user in if credentials
     * match the database.
     * @param event 
     */
    @FXML
    private void loginListener(ActionEvent event) {
        String username = getUsernameField().getText();
        System.out.println(username);
        String password = getPasswordField().getText();
        this.user = new User(username, password);
        if (user.isAuthenticated(user) == true) {
            HomeController hc = new HomeController();
            hc.setUsername(username);
            changeView(rootPane, "/fxml/HomeView2.fxml");
            System.out.println("AUTHORIZED, PROCEED"
                    + "\nWelcome " + user.getUsername());
        } else {
            System.out.println("Error: Authentication failed.");
            getErrorMessage().setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * @return the usernameField
     */
    public JFXTextField getUsernameField() {
        return usernameField;
    }

    /**
     * @param usernameField the usernameField to set
     */
    public void setUsernameField(JFXTextField usernameField) {
        this.usernameField = usernameField;
    }

    /**
     * @return the errorMessage
     */
    public Label getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(Label errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the passwordField
     */
    public JFXPasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * @param passwordField the passwordField to set
     */
    public void setPasswordField(JFXPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * @return the rootPane
     */
    public VBox getRootPane() {
        return rootPane;
    }

    /**
     * @param rootPane the rootPane to set
     */
    public void setRootPane(VBox rootPane) {
        this.rootPane = rootPane;
    }

    /**
     * @return the submitButton
     */
    public JFXButton getSubmitButton() {
        return submitButton;
    }

    /**
     * @param submitButton the submitButton to set
     */
    public void setSubmitButton(JFXButton submitButton) {
        this.submitButton = submitButton;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}
