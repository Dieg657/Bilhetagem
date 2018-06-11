/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.ClassesDB.Cliente;
import DAO.ClassesDB.Empresa;
import DAO.ClassesDB.Estado;
import DAO.ClassesDB.Funcionario;
import DAO.ClassesDB.Passagem;
import DAO.ClassesDB.Status;
import DAO.ClassesDB.UsuarioCliente;
import DAO.ClassesDB.UsuarioFuncionario;
import DAO.ClassesDB.Voo;
import DAO.ClassesDB.VooPoltrona;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author diego
 */
public class DAO{
    protected static PreparedStatement preparaSQL;
    protected static ResultSet resultadoSQL;
    protected Empresa empresa;
    protected Cliente cliente;
    protected Voo voo;
    protected Estado estado;
    protected Estado uf;
    protected Funcionario funcionario;
    protected UsuarioCliente loginCliente;
    protected UsuarioFuncionario loginFuncionario;
    protected VooPoltrona poltrona;
    protected Passagem passagem;
    protected Status statusPoltrona;
    
    
    
    static void closeAll() {
        try {
            preparaSQL.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\nNão foi possível encerrar o preparo da consulta!");
        }
        try {
            resultadoSQL.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\nNão foi possível encerrar o preparo da consulta!");
        }
    }

}
