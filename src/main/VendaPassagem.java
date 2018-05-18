/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import Utilidades.GerarCidades;

/**
 *
 * @author diego
 */
public class VendaPassagem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GerarCidades objCidades = new GerarCidades();
        objCidades.criaConexaoCidades();
        
        /*for (int i = 0; i < 26; i++) {
            objCidades.getCidadesConectadas().get(0).getConexaoDaCidade().get(i).getDestino().imprimirCidade();
        }*/
        
        objCidades.caminhoMinimo(objCidades.getCidadesConectadas().get(0), objCidades.getCidadesConectadas().get(2));
        /*
        FactoryPessoa factory = new FactoryPessoa();
        Pessoa pessoa;
        
        String nome = "Aline dos Santos Soares";
        String sexo = "Masculino";
        
        try {
            pessoa = factory.getPessoa(nome, sexo);
            System.out.println("O sexo do passageiro é: " + pessoa.getSexo());
        } catch (Exception excep) {
            System.out.println(excep.getMessage());
        }*/
    }
    
}
