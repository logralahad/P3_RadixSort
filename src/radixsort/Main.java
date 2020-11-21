/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radixsort;

import java.util.Random;

/**
 *
 * @author logra
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista lista = new Lista();
        
        for(int i = 0; i < 1000001; ++i){
            Random rand = new Random();
            int valorDado = rand.nextInt(100001); 
            lista.insertar(valorDado);
        }
        
        System.out.print("Lista original: ");
        lista.recorrer();
        System.out.println("\n");
        
        System.out.print("Lista ordenada por RadixSort: ");
        lista.radixSort();
        lista.recorrer();
    }
    
}
