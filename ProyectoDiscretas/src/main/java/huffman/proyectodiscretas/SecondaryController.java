package huffman.proyectodiscretas;

import huffman.modelo.ArbolBinario;
import huffman.modelo.HuffmanCode;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SecondaryController {

    @FXML
    private Button btnArbol;

    @FXML
    private Button btnCodigo;

    @FXML
    public TextField txtTextoGenerar;
    public static ArbolBinario arbol_vertice_raiz;
    public static String cadenaGenerada;

    @FXML
    void switchToExplicacion() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void switchToFuncionamiento() throws IOException {
        App.setRoot("algoritmo");
    }

    @FXML
    private void switchToVerArbol() throws IOException {
        App.setRoot("arbol");
    }

    @FXML
    private void switchToVerCodigo() throws IOException {
        App.setRoot("codigo");
    }

    @FXML
    void guardarTexto(MouseEvent event) throws IOException {
        Set<Character> conjuntoLetras = new HashSet<>();
        for (int i = 0; i < txtTextoGenerar.getText().length(); i++) {
            conjuntoLetras.add(txtTextoGenerar.getText().charAt(i));
        }
        if (conjuntoLetras.size() > 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Creación de arbol Huffman");
            alert.setTitle("Información");
            alert.setContentText("Se ha generado correctamente el árbol");
            alert.showAndWait();
            cadenaGenerada = txtTextoGenerar.getText();
            arbol_vertice_raiz = HuffmanCode.generador_Arbol(txtTextoGenerar.getText());
            btnArbol.setDisable(false);
            btnCodigo.setDisable(false);
            App.setRoot("arbol");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Creación de arbol Huffman");
            alert.setTitle("Error");
            alert.setContentText("No es posible generar el árbol. \nPor favor ingrese más de un caracter.");
            alert.showAndWait();
        }

    }

    public static ArbolBinario getAB() {
        return arbol_vertice_raiz;
    }
}
