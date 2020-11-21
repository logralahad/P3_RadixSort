/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radixsort;

/**
 *
 * @author logra
 */
public class Lista {
    
    Nodo inicio = null;
    
    public void insertar(int dato){
        Nodo nuevo = nuevoNodo(dato);
        if(!isEmpty()){
            nuevo.siguiente = inicio;
        }
        inicio = nuevo;
    }
    
    public void recorrer(){
        Nodo aux = inicio;
        while( aux != null ){
            System.out.print(aux.dato + " ");
            aux = aux.siguiente;
        }
    }
       
    public int num_digitos(Nodo raiz){
        int max = raiz.dato;
        int digitos = 0;
        
        while(raiz != null){
            if(raiz.dato > max) max = raiz.dato;
            raiz = raiz.siguiente;
        }
        
        while(max != 0){
            max /= 10;
            digitos++;
        }      
        return digitos;
    }
      
    public void radixSort(){
        int digitos = num_digitos(this.inicio);
        int exp = 1;
        Nodo aux = this.inicio;
        Lista ordenada = new Lista();
        Lista valores[] = new Lista[10];
        
        for(int i = 0; i < digitos; ++i){
            Lista temp = new Lista();
            while(aux != null){ // vaciar los números
                int posicion = (aux.dato / exp) % 10;  // encontramos el dígito correspondiente
                if(valores[posicion] == null){
                    valores[posicion] = new Lista();
                }
                valores[posicion].insertar(aux.dato);
                aux = aux.siguiente;
            }
            for(int j = 0; j < 10; ++j){
                while(valores[j] != null && valores[j].inicio != null){  // vaciamos el array de listas
                    temp.insertar(valores[j].inicio.dato);  // insertamos la lista semi ordenada
                    valores[j].inicio = valores[j].inicio.siguiente;
                }
            }
            exp *= 10;
            aux = temp.inicio;  // auxiliar lo movemos al inicio de la nueva lista
        }
        
        while(aux != null){
            ordenada.insertar(aux.dato);
            aux = aux.siguiente;
        }
        
        inicio = ordenada.inicio;
    }
    
    public boolean ordenado(Nodo raiz){
        while(raiz.siguiente != null){
            if(raiz.dato > raiz.siguiente.dato) return false;
            raiz = raiz.siguiente;
        }
        return true;
        
    }
    
    public boolean isEmpty(){
        return inicio == null;
    }
    
    public Nodo nuevoNodo(int dato){
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        nuevo.siguiente = null;
        return nuevo;
    }
    
}
