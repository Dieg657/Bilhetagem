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
public class FactoryPessoa {
    public Pessoa getPessoa(String nome, String sexo) throws Exception{
        
        if(sexo.equals("Feminino"))
            return new Mulher(nome, sexo);
        if(sexo.equals("Masculino"))
            return new Homem(nome, sexo);
        else
            throw new Exception("Não há sexo definido");
    }
}
