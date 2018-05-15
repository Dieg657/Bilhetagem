/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.List;

/**
 *
 * @author puc
 */


public class Vertice {
    private int IDVertice;
    
    Vertice(int ID){
        this.IDVertice = ID;
    }
    
    List<Aresta> aresta;
    
}