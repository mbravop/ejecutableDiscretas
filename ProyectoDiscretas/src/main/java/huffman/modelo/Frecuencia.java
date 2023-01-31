/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huffman.modelo;

/**
 *
 * @author Dereck Santander
 */
public class Frecuencia {
    private String letra;
    private int frecuencia;
    private String codificacion;

    public Frecuencia(String letra, int frecuencia, String codificacion) {
        this.letra = letra;
        this.frecuencia = frecuencia;
        this.codificacion=codificacion;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getCodificacion() {
        return codificacion;
    }

    public void setCodificacion(String codificacion) {
        this.codificacion = codificacion;
    }
    
}
