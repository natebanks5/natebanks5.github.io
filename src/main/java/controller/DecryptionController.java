/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Caesar;
import model.Email;
import model.Translation;
import model.Vigenere;

/**
 *
 * @author hoovb
 */
public class DecryptionController extends View implements Initializable {

    @FXML
    private VBox decryptionPane;

    @FXML
    private Label caesarLabel;

    @FXML
    private Label caesarText;

    @FXML
    private Label vigenereLabel;

    @FXML
    private Label vigenereText;

    @FXML
    private Label digitizedTextField;

    @FXML
    private JFXButton emailButton;

    @FXML
    private JFXButton homeButton;
    private String username;

    Caesar c = new Caesar();
    Vigenere v = new Vigenere();
    Translation t = new Translation();
    Email email = new Email();
    String cResult;
    String vResult;
    String tResult;
    HomeController hc = new HomeController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setLabels(HomeController.digitizedText);
    }

    public void setLabels(String text) {
        if (HomeController.isDecryption) {
            cResult = c.decrypt(text);
            vResult = v.decrypt(text, "KEY");

            digitizedTextField.setText("Digitized Text: " + text);
            caesarLabel.setText("Caesar Cipher Result: ");
            caesarLabel.setVisible(true);
            vigenereLabel.setVisible(true);
            caesarText.setText(cResult);
            vigenereText.setText(vResult);

            System.out.println("Your Message Decrypted with Caesar Cipher: " + cResult);
            System.out.println("Your Message Decrypted with Vigenere Cipher: " + vResult);
        } else {
            tResult = t.translateText(text);
            
            digitizedTextField.setText("Digitized Text: " + text);
            caesarLabel.setText("Translated Text: ");
            hideDecryptLabels();
            caesarText.setText(tResult);
            System.out.println("Your text translated to English is: " + tResult);
        }

    }

    private void hideDecryptLabels() {
        vigenereLabel.setVisible(false);
        vigenereText.setVisible(false);

        caesarLabel.setVisible(true);
    }

    @FXML
    void goHome(ActionEvent event) {
        changeView(decryptionPane, "/fxml/HomeView2.fxml");
    }

    @FXML
    void sendEmail(ActionEvent event) {
        if (HomeController.isDecryption) {
            email.sendEmail(LoginController.user.getUsername(), HomeController.digitizedText, cResult, vResult);
        } else {
            email.sendEmail(LoginController.user.getUsername(), HomeController.digitizedText, tResult);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setHeaderText("Email sent");
        alert.setContentText("An email has been sent to " + LoginController.user.getUsername());
        alert.showAndWait();
    }
}
