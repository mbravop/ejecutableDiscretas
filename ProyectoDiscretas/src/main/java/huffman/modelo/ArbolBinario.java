/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huffman.modelo;

/**
 *
 * @author Dereck, Jeremy Poveda, Carlos Salazar
 */
public class ArbolBinario {
    String descripcion;
    int peso;
    int altura;
    ArbolBinario i;
    ArbolBinario d;
    // d es la letra y p es el peso o frecuencia de la letra
    public ArbolBinario(String d, int p){
        descripcion=d;
        peso=p;
        i=null;
        d=null;
    }

    public ArbolBinario getI() {
        return i;
    }

    public ArbolBinario getD() {
        return d;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString(){
        return this.descripcion+": "+String.valueOf(this.peso);
    }

    public boolean esHoja(){
        return (i==null)&&(d==null);
    }

    public String obtenerCodificacion(String palabra){
        String codificacion="";
        String[] s = palabra.split("");
        for(String a: s){
            codificacion+=this.encontrado(a);
        }

        return codificacion;
    }

    private String encontrado(String letra){
        ArbolBinario tmp = this;
        String codificacion="";
        boolean encontrado=false;
        while(!encontrado){
            if(tmp.i.descripcion.contains(letra)){
                codificacion+="0";
                if(tmp.i.descripcion.equals(letra)){
                    return codificacion;
                }else{
                    tmp=tmp.i;
                }
            }else if(tmp.d.descripcion.contains(letra)){
                codificacion+="1";
                if(tmp.d.descripcion.equals(letra)){
                    return codificacion;
                }else{
                    tmp=tmp.d;
                }
            }
        }
        return codificacion;
    }
    public int retornarAltura() {
        altura = 0;
        retornarAltura(this,0);
        return altura;
    }
    private void retornarAltura(ArbolBinario ab,int nivel) {
        if (ab != null) {
            retornarAltura(ab.i, nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(ab.d, nivel + 1);
        }
    }
}
