/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author hoovb
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Parent class for all View controllers.
 * Responsible for changing the view.
 *
 * @author hoovb
 */
public class View {


    public void changeView(VBox currentPane, String resourceName) {
        try {
            VBox pane = FXMLLoader.load(getClass().getResource(resourceName));
            currentPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
