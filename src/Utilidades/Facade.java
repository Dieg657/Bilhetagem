/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import DAO.DAO;
import DAO.FactoryDAO;
import DAO.SelectDAO;

/**
 *
 * @author diego.soares
 */
public final class Facade {
    private static Facade singleton;
    private static DAO objDAO;
    private static FactoryDAO factoryDAO;
    
    public void insertDataDB(String operacao, Object obj){
        try {
            factoryDAO = new FactoryDAO();
            objDAO = factoryDAO.getDAO(operacao.toLowerCase());
            objDAO.insertDataDB(obj);
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\nNão foi possivel inserir no banco de dados!");
        }
    }
    
    public void updateDataDB(String operacao, Object obj){
        try {
            factoryDAO = new FactoryDAO();
            objDAO = factoryDAO.getDAO(operacao.toLowerCase());
            objDAO.updateDataDB(obj);
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\nNão foi possivel atualizar no banco de dados!");
        }
    }
    
    /**
     *
     * @param operacao
     * @return
     */
    public static SelectDAO selectDataDB(String operacao){
        try {
            factoryDAO = new FactoryDAO();
            objDAO = factoryDAO.getDAO(operacao.toLowerCase());
            return (SelectDAO) objDAO;
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\nNão foi possivel atualizar no banco de dados!");
        }
        return null;
    }
    
    public static synchronized Facade getInstance(){
        try {
             if(singleton == null){
                 singleton = new Facade();
             }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\nNão foi possível obter a instância da classe!");
        }
        return singleton;
    }    
}
