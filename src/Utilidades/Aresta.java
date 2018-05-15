/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author puc
 */
public class Aresta {
    private Vertice dest;
    private int peso;
    
    Aresta(Vertice destino, int peso){
        this.dest = destino;
        this.peso = peso;
    }
    
    public int getPeso(){
        return this.peso;
    }
    
    public Vertice getDestino(){
        return this.dest;
    }
}
