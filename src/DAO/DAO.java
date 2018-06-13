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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author diego
 */
public abstract class DAO{
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
        
    public void closeAll() {

    }
    
    public abstract void insertDataDB(Object obj);
    public abstract void updateDataDB(Object obj);
    public abstract String getOperacao();
    public abstract void setOperacao(String operacao);
}
