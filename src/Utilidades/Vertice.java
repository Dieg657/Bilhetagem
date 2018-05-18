/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author puc
 */


public class Vertice {
    private final int IDVertice;
    private final String cidade;
    private ArrayList<Aresta> aresta = new ArrayList<>();
    private boolean ativo;
    
    Vertice(int ID, String cidade){
        this.IDVertice = ID;
        this.cidade = cidade;
    }
    
    public void criarConexao(int peso, Vertice destino){
        aresta.add(new Aresta(destino, peso));
    }
    
    public ArrayList<Aresta> getConexaoDaCidade(){
        return aresta;
    }
    
    public void imprimirCidade(){
        System.out.println("Cidade: " + cidade);
    }
    
    public int getID(){
        return IDVertice;
    }
    
    public void resetaMarcador(){
        ativo = false;
    }
    
    public void ativaMarcador(){
        ativo = true;
    }
    
    public boolean getMarcador(){
        return ativo;
    }
}