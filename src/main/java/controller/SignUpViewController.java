package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * FXML Controller class
 *
 * @author hoovb
 */
public class SignUpViewController extends View implements Initializable {

    
    @FXML
    private VBox signUpPane;

    @FXML
    private AnchorPane background;

    @FXML
    private JFXTextField usernameField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXButton createButton;

    @FXML
    private Label passwordError;

    @FXML
    private JFXPasswordField passwordField2;

    @FXML
    private Label usernameError;
    
    private User user = new User("", "");

    /**
     * Creates new user if email doesn't exist 
     * in database and both passwords match
     * @param event 
     */
    @FXML
    private void signUpListener(ActionEvent event) {
        getUser().createUser(usernameField.getText(), passwordField.getText(), passwordField2.getText());
        if (!getUser().isIsUniqueUser()) {
            this.usernameError.setVisible(true);
        }
        else {
            this.usernameError.setVisible(false);
        }
        
        if (!getUser().isSamePassword(passwordField.getText(), passwordField2.getText())) {
            this.passwordError.setVisible(true);
        }
        else {
            this.passwordError.setVisible(false);
        }
        
        if (getUser().isIsUniqueUser() && getUser().isIsSamePassword()) {
            changeView(signUpPane, "/fxml/LoginView2.fxml");
        }
    }
    
    /**
     * Takes user back to login screen
     * @param event 
     */
    @FXML
    private void backListener(ActionEvent event) {
        changeView(signUpPane, "/fxml/LoginView2.fxml");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * @return the signUpPane
     */
    public VBox getSignUpPane() {
        return signUpPane;
    }

    /**
     * @param signUpPane the signUpPane to set
     */
    public void setSignUpPane(VBox signUpPane) {
        this.signUpPane = signUpPane;
    }

    /**
     * @return the background
     */
    public AnchorPane getBackground() {
        return background;
    }

    /**
     * @param background the background to set
     */
    public void setBackground(AnchorPane background) {
        this.background = background;
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
     * @return the createButton
     */
    public JFXButton getCreateButton() {
        return createButton;
    }

    /**
     * @param createButton the createButton to set
     */
    public void setCreateButton(JFXButton createButton) {
        this.createButton = createButton;
    }

    /**
     * @return the passwordError
     */
    public Label getPasswordError() {
        return passwordError;
    }

    /**
     * @param passwordError the passwordError to set
     */
    public void setPasswordError(Label passwordError) {
        this.passwordError = passwordError;
    }

    /**
     * @return the passwordField2
     */
    public JFXPasswordField getPasswordField2() {
        return passwordField2;
    }

    /**
     * @param passwordField2 the passwordField2 to set
     */
    public void setPasswordField2(JFXPasswordField passwordField2) {
        this.passwordField2 = passwordField2;
    }

    /**
     * @return the usernameError
     */
    public Label getUsernameError() {
        return usernameError;
    }

    /**
     * @param usernameError the usernameError to set
     */
    public void setUsernameError(Label usernameError) {
        this.usernameError = usernameError;
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
