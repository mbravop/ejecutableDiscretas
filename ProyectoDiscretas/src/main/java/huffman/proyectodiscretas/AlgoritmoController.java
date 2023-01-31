/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package huffman.proyectodiscretas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Dereck Santander
 */
public class AlgoritmoController {
    
    @FXML
    void switchToExplicacion() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void switchToGenerarNuevo() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToVerArbol() throws IOException {
        App.setRoot("arbol");
    }

    @FXML
    private void switchToVerCodigo() throws IOException{
        App.setRoot("codigo");
    }
    
}
