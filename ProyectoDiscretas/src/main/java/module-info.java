module huffman.proyectodiscretas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens huffman.proyectodiscretas to javafx.fxml;
    opens huffman.modelo to javafx.base;
    exports huffman.proyectodiscretas;
}
