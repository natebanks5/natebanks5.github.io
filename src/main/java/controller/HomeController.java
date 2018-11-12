/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Caesar;
import javafx.stage.FileChooser;
import model.Email;
import model.Rekognition;
import model.Translation;
import model.Vigenere;

/**
 * FXML Controller class Calls responsible model classes based on user input
 *
 * @author hoovb
 */
public class HomeController extends View {

    @FXML
    private VBox homePane;

    @FXML
    private AnchorPane background;

    @FXML
    private JFXButton fileSelector;

    @FXML
    private JFXTextField encryptedField;

    @FXML
    private JFXButton decryptButton, translateButton;

    @FXML
    private Label caesarText, vigenereText, caesarLabel, vigenereLabel;

    @FXML
    private Stage stage;

    @FXML
    private Label selectedFileText;

    @FXML
    private JFXButton uploadButton;

    static String digitizedText;

    static boolean isDecryption;

    private Desktop desktop = Desktop.getDesktop();

    private String filePath;

    private FileChooser fileChooser = new FileChooser();
    private String username;
    private Caesar c = new Caesar();
    private Vigenere v = new Vigenere();
    private Translation t = new Translation();
    private Email email = new Email();

    /**
     * Initializes the controller class.
     */
    public void initialize(String username) {
        this.setUsername(username);
    }

    /**
     * Allows the user to select a .jpg or .png image file
     *
     * @param event
     */
    @FXML
    private void fileSelection(ActionEvent event) {
        LoginController lc = new LoginController();
        username = lc.getUser().getUsername();
        System.out.println("USERNAME: " + getUsername());
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png"));
        File selectedFile = fileChooser.showOpenDialog(getStage());
        if (selectedFile != null) {
            this.getSelectedFileText().setText("Selected File: " + selectedFile.getAbsolutePath());
            filePath = selectedFile.getAbsolutePath();
            this.getSelectedFileText().setVisible(true);
            this.getUploadButton().setVisible(true);
        }
    }

    /**
     * Calls AmazonRekognition to digitize the text in the selected image file
     *
     * @param event
     * @throws Exception
     */
    @FXML
    private void uploadListener(ActionEvent event) throws Exception {
        Rekognition r = new Rekognition();
        System.out.println("Selected picture path: " + filePath);
        getEncryptedField().setText(r.digitizeText(filePath));
    }

    /**
     * Decrypts the digitized text with both the caeser and vigenere ciphers
     *
     * @param event
     */
    @FXML
    private void decryptText(ActionEvent event) {
        isDecryption = true;

        digitizedText = getEncryptedField().getText();
        changeView(homePane, "/fxml/DecryptionView.fxml");
        /*
        String cResult = c.decrypt(text);
        String vResult = v.decrypt(text, "KEY");

        caesarLabel.setText("Caesar Cipher Result: ");
        caesarLabel.setVisible(true);
        vigenereLabel.setVisible(true);
        caesarText.setText(cResult);
        vigenereText.setText(vResult);

        email.sendEmail(getUsername(), text, cResult, vResult);

        System.out.println("Your Message Decrypted with Caesar Cipher: " + cResult);
        System.out.println("Your Message Decrypted with Vigenere Cipher: " + vResult); */

    }

    /**
     * Translates the text using Amazon Translate with a target language of
     * English
     *
     * @param event
     */
    @FXML
    private void translateText(ActionEvent event) {
        isDecryption = false;
        digitizedText = getEncryptedField().getText();

        changeView(homePane, "/fxml/DecryptionView.fxml");
    }

    private void hideDecryptLabels() {
        vigenereLabel.setVisible(false);
        vigenereText.setVisible(false);

        caesarLabel.setVisible(true);
    }

    /**
     * @return the homePane
     */
    public VBox getHomePane() {
        return homePane;
    }

    /**
     * @param homePane the homePane to set
     */
    public void setHomePane(VBox homePane) {
        this.homePane = homePane;
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
     * @return the fileSelector
     */
    public JFXButton getFileSelector() {
        return fileSelector;
    }

    /**
     * @param fileSelector the fileSelector to set
     */
    public void setFileSelector(JFXButton fileSelector) {
        this.fileSelector = fileSelector;
    }

    /**
     * @return the encryptedField
     */
    public JFXTextField getEncryptedField() {
        return encryptedField;
    }

    /**
     * @param encryptedField the encryptedField to set
     */
    public void setEncryptedField(JFXTextField encryptedField) {
        this.encryptedField = encryptedField;
    }

    /**
     * @return the decryptButton
     */
    public JFXButton getDecryptButton() {
        return decryptButton;
    }

    /**
     * @param decryptButton the decryptButton to set
     */
    public void setDecryptButton(JFXButton decryptButton) {
        this.decryptButton = decryptButton;
    }

    /**
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * @param stage the stage to set
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * @return the selectedFileText
     */
    public Label getSelectedFileText() {
        return selectedFileText;
    }

    /**
     * @param selectedFileText the selectedFileText to set
     */
    public void setSelectedFileText(Label selectedFileText) {
        this.selectedFileText = selectedFileText;
    }

    /**
     * @return the uploadButton
     */
    public JFXButton getUploadButton() {
        return uploadButton;
    }

    /**
     * @param uploadButton the uploadButton to set
     */
    public void setUploadButton(JFXButton uploadButton) {
        this.uploadButton = uploadButton;
    }

    /**
     * @return the desktop
     */
    public Desktop getDesktop() {
        return desktop;
    }

    /**
     * @param desktop the desktop to set
     */
    public void setDesktop(Desktop desktop) {
        this.desktop = desktop;
    }

    /**
     * @return the fileChooser
     */
    public FileChooser getFileChooser() {
        return fileChooser;
    }

    /**
     * @param fileChooser the fileChooser to set
     */
    public void setFileChooser(FileChooser fileChooser) {
        this.fileChooser = fileChooser;
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

}
