/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package huffman.proyectodiscretas;

import huffman.modelo.HuffmanCode;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
/**
 * FXML Controller class
 *
 * @author Dereck Santander
 */
public class CodigoController implements Initializable {


    @FXML
    private Label lblNombreBeneficiario;
    @FXML
    private TextField txtTextoCodificar;
    @FXML
    private Text lbCodigo;
    @FXML
    private Label lbAltura;
    
    private String cadenasNoEncontradas;
    @FXML
    private Label lblPresentacionTexto;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtTextoCodificar.setPromptText("Cadena original: "+ SecondaryController.cadenaGenerada);
        lbAltura.setText(String.valueOf(SecondaryController.arbol_vertice_raiz.retornarAltura()));
        lblPresentacionTexto.setText("Texto codificado a partir de cadena original:");
        lbCodigo.setText(SecondaryController.arbol_vertice_raiz.obtenerCodificacion(SecondaryController.cadenaGenerada));
    }
    
    @FXML
    void switchToExplicacion() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void switchToFuncionamiento() throws IOException{
        App.setRoot("algoritmo");
    }

    @FXML
    private void switchToGenerarNuevo() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToArbol() throws IOException {
        App.setRoot("arbol");
    }

    @FXML
    private void switchToVerCodigo() throws IOException{
        App.setRoot("codigo");
    }
    
    @FXML
    private void generarCodificacion() {
        ArrayList<String> letras = HuffmanCode.letras;
        String input =  txtTextoCodificar.getText();
        if(input == ""){
            lbCodigo.setText("");
            Alert alerta= new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("ERROR");
            alerta.setContentText("Ingrese una cadena de caracteres para codificar por favor");
            alerta.showAndWait();
        }
        ArrayList<String> input_sin_repetir = new ArrayList<>();
        Boolean valido = true;
        for(int i=0; i<input.length();i++){
            if(!(letras.contains(String.valueOf(input.charAt(i))))){
                if(!(input_sin_repetir.contains(String.valueOf(input.charAt(i))))){
                    input_sin_repetir.add(String.valueOf(input.charAt(i)));
                }
                txtTextoCodificar.setText("");
                valido = false;
            }
        }
        cadenasNoEncontradas = "Los siguientes caracteres no están en el árbol:\n";
        for(String s:input_sin_repetir){
            cadenasNoEncontradas+=("• "+s+ "\n");
        }
        if(valido){
            lblPresentacionTexto.setText("Nuevo texto codificado: ");
            lbCodigo.setText(SecondaryController.arbol_vertice_raiz.obtenerCodificacion(input));
        }else{
            lbCodigo.setText("");
            Alert alerta= new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("ERROR");
            alerta.setContentText(cadenasNoEncontradas);
            alerta.showAndWait();
        }
    }

}
