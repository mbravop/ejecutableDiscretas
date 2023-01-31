/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package huffman.proyectodiscretas;

import huffman.modelo.*;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Dereck Santander
 */
public class ArbolController implements Initializable {

    @FXML
    private ScrollPane SpArbol;
    
    public static String pesoInicialArbol;
    public static String pesoFinalArbol;

    /**
     * Initializes the controller class.
     */
    public static int altura;
    private static final int RADIO_CIRCULO = 5;
    private static int DISTANCIA_HIJOS;
    private static final int DISTANCIA_VERTICAL = 50;
    private static int X_canvas;
    private static int Y_canvas;

    static Canvas CanvasHuffmanTree;
    private static GraphicsContext gc;

    private static void drawHuffmanTree(GraphicsContext gc, ArbolBinario vertice, int x, int y, int nivel) {
        gc.setFill(Color.BLACK);
        gc.fillOval(x - RADIO_CIRCULO, y - RADIO_CIRCULO, RADIO_CIRCULO * 2, RADIO_CIRCULO * 2);
        if (vertice.esHoja()) {
            // Si el nodo es una hoja, escribe el carácter en el centro del círculo
            gc.setFill(Color.RED);
            gc.setFont(new Font("Times New Roman", 16));
            if (vertice.getDescripcion().equals(" ")) {
                gc.fillText("(-)", x, y + 20);
            }
            gc.fillText(vertice.getDescripcion(), x, y + 20);
        }

        // Dibuja el hijo izquierdo del nodo, si existe
        if (vertice.getI() != null) {
            gc.setFill(Color.BLACK);
            gc.setFont(new Font("Times New Roman", 14));
            gc.fillText("1", x - 30, y+(nivel*3+1));
            // Dibuja una línea que conecte el nodo actual con el hijo izquierdo
            int child_x = x + DISTANCIA_HIJOS / (int) Math.pow(1.80, (nivel + 1));
            gc.setStroke(Color.BLACK);
            gc.strokeLine(x, y, child_x, y + DISTANCIA_VERTICAL);
            drawHuffmanTree(gc, vertice.getI(), child_x, y + DISTANCIA_VERTICAL, nivel + 1);
        }
        // Dibuja el hijo derecho del nodo, si existe
        if (vertice.getD() != null) {
            gc.setFill(Color.BLACK);
            gc.setFont(new Font("Times New Roman", 14));
            gc.fillText("0", x + 25, y+(nivel*3+1));
            // Dibuja una línea que conecte el nodo actual con el hijo derecho
            int child_x = x - DISTANCIA_HIJOS / (int) Math.pow(1.80, (nivel + 1));
            gc.setStroke(Color.BLACK);
            gc.strokeLine(x, y, child_x, y + DISTANCIA_VERTICAL);
            drawHuffmanTree(gc, vertice.getD(), child_x, y + DISTANCIA_VERTICAL, nivel + 1);
        }
    }

    public static double ganancia() {
        double pesoinicial = 0;
        double pesofinal = 0;
        for(Frecuencia f: HuffmanCode.listado){
            pesoinicial+= f.getFrecuencia()*8;
            pesofinal+= f.getCodificacion().length()*f.getFrecuencia();
        }
        pesoInicialArbol = pesoinicial +"";
        pesoFinalArbol = pesofinal +"";
        
        double ganancia = (1-((pesofinal)/(pesoinicial)))*100;
        
        return Math.round(ganancia*100)/100.0;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        altura = SecondaryController.arbol_vertice_raiz.retornarAltura();
        DISTANCIA_HIJOS = 100 * altura;
        X_canvas = 350 * altura;
        Y_canvas = 100 * altura;
        CanvasHuffmanTree = new Canvas(X_canvas, Y_canvas);
        gc = CanvasHuffmanTree.getGraphicsContext2D();
        drawHuffmanTree(gc, SecondaryController.arbol_vertice_raiz, X_canvas / 2, 20, 0);
        SpArbol.setContent(CanvasHuffmanTree);
    }

    @FXML
    void switchToExplicacion() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void switchToFuncionamiento() throws IOException {
        App.setRoot("algoritmo");
    }

    @FXML
    private void switchToGenerarNuevo() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToVerCodigo() throws IOException {
        App.setRoot("codigo");
    }

    @FXML
    private void switchToFrecuencia() throws IOException{
        App.setRoot("frecuencias");
    }

}
