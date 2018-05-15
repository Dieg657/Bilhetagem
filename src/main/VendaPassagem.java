/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author diego
 */
public class VendaPassagem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FactoryPessoa factory = new FactoryPessoa();
        Pessoa pessoa;
        
        String nome = "Aline dos Santos Soares";
        String sexo = "Masculino";
        
        try {
            pessoa = factory.getPessoa(nome, sexo);
            System.out.println("O sexo do passageiro é: " + pessoa.getSexo());
        } catch (Exception excep) {
            System.out.println(excep.getMessage());
        }       
    }
    
}
