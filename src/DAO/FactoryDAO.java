/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author diego.soares
 */
public class FactoryDAO {
    public DAO getDAO(String operacao){
        if(operacao.equals("insert"))
            return new InsertDAO();
        if(operacao.equals("update"))
            return new UpdateDAO();
        if(operacao.equals("select"))
            return new SelectDAO();
        else
            throw new RuntimeException("Não foi possivel definir a operação");  
    }
}
