package huffman.modelo;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Dereck
 */
public class HuffmanCode {

    public static ArrayList<Frecuencia> listado = new ArrayList<>();
    public static ArrayList<String> letras;
    public static ArrayList<Integer> frecuencias = new ArrayList<>();

    public static ArbolBinario generador_Arbol(String entrada) {

        letras = new ArrayList<>();

        PriorityQueue<ArbolBinario> cola = new PriorityQueue<>((ArbolBinario a1, ArbolBinario a2) -> {
            return a1.peso - a2.peso;
        });
        // Se obtiene las letras sin repetir
        for (int i = 0; i < entrada.length(); i++) {
            if (!(letras.contains(String.valueOf(entrada.charAt(i))))) {
                letras.add(String.valueOf(entrada.charAt(i)));
            }
        }
        // Por cada letra se obtiene sus frecuencias
        System.out.println(letras);
        frecuencias.clear();
        for (String s : letras) {
            int conteo = 0;
            for (int i = 0; i < entrada.length(); i++) {
                if (String.valueOf(entrada.charAt(i)).equals(s)) {
                    conteo++;
                }
            }
            frecuencias.add(conteo);
        }
        System.out.println(frecuencias);

        // Añade un nodo a la cola, con cada letra y frecuencia
        for (int i = 0; i < letras.size(); i++) {
            cola.offer(new ArbolBinario(letras.get(i), frecuencias.get(i)));
        }
        /*
        while(!cola.isEmpty()){
            System.out.println(cola.poll().toString());
        }*/

        while (cola.size() != 1) { // Mientras no quede una, ejecuta:
            ArbolBinario pequeño = cola.poll(); // extrae dos elemento más a la izquierda(las letras con menores frecuencias) (a,b),c,d,e
            ArbolBinario grande = cola.poll();
            ArbolBinario resultado = new ArbolBinario((pequeño.descripcion + grande.descripcion), (pequeño.peso + grande.peso));
            resultado.i = pequeño;
            resultado.d = grande;
            cola.offer(resultado);
        }

        ArbolBinario a = cola.poll();

        for (String s : letras) {
            System.out.println(s + ": " + a.obtenerCodificacion(s));
        }
        
        listado.clear();
        
        for (int i = 0; i < letras.size(); i++) {
            listado.add(new Frecuencia(letras.get(i), frecuencias.get(i), a.obtenerCodificacion(letras.get(i))));
        }
        return a;
    }


}
