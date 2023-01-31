package huffman.proyectodiscretas;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    private Label lblNombreBeneficiario;

    @FXML
    private void switchToFuncionamiento() throws IOException{
        App.setRoot("algoritmo");
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
    private void switchToVerCodigo() throws IOException {
        App.setRoot("codigo");
    }

}
