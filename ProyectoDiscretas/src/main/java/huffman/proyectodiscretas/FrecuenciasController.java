/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package huffman.proyectodiscretas;

import huffman.modelo.Frecuencia;
import huffman.modelo.HuffmanCode;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author Dereck Santander
 */
public class FrecuenciasController implements Initializable {
    
    
    @FXML
    private Label lbGanancia;

    @FXML
    private Label lblNombreBeneficiario;
     @FXML
    private TableView<Frecuencia> tvFrecuencias;
    @FXML
    private TableColumn<Frecuencia, String> tvLetrasColumn;
    @FXML
    private TableColumn<Frecuencia, Integer> tvFrecuenciasColumn;
    @FXML
    private TableColumn<Frecuencia, String> tvCodificacionColumn;
    @FXML
    private Label lblPesoInicial;
    @FXML
    private Label lblPesoFinal;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tvLetrasColumn.setCellValueFactory(new PropertyValueFactory<>("letra"));
        tvFrecuenciasColumn.setCellValueFactory(new PropertyValueFactory<>("frecuencia"));
        tvCodificacionColumn.setCellValueFactory(new PropertyValueFactory<>("codificacion"));
        tvFrecuencias.getItems().setAll(HuffmanCode.listado);
        lbGanancia.setText(String.valueOf(ArbolController.ganancia())+" %");
        lblPesoInicial.setText(ArbolController.pesoInicialArbol + " bits");
        lblPesoFinal.setText(ArbolController.pesoFinalArbol + " bits");
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
    private void switchToVerCodigo() throws IOException {
        App.setRoot("codigo");
    }
    

}
