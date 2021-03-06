/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.ClassesDB.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public final class InsertDAO extends DAO{
    
    public InsertDAO(){
        // do nothing
    }
    
    private String operacao;
        
    //Cliente
    private static final String insertCliente = "INSERT INTO `aviao`.`tb_cliente`\n" +
        "(`nm_cli`,\n" +
        "`doc_cli`,\n" +
        "`org_cli`,\n" +
        "`iduf_cli`,\n" +
        "`dtnasc_cli`,\n" +
        "`cpf_cli`,\n" +
        "`end_cli`,\n" +
        "`num_cli`,\n" +
        "`compl_cli`,\n" +
        "`bairro_cli`,\n" +
        "`cidade_cli`,\n" +
        "`idest_cli`,\n" +
        "`email_cli`,\n" +
        "`obs_cli`)\n" +
        "VALUES\n" +
        "( ? ,\n" +
        " ? ,\n" +
        " ? ,\n" +
        " ? ,\n" +
        " ? ,\n" +
        " ? ,\n" +
        " ? ,\n" +
        " ? ,\n" +
        " ? ,\n" +
        " ? ,\n" +
        " ? ,\n" +
        " ? ,\n" +
        " ? ,\n" +
        " ? )";
    private static final String insertClienteLogin = "INSERT INTO `aviao`.`tb_usuario_cli` (`cpf_cli`,`usuario`,`senha`) VALUES ( ? , ? , ? )";
    
    
    //Funcionario
    private static final String insertFuncionario = "INSERT INTO `aviao`.`tb_funcionario`\n" +
            "(`nm_func`,\n" +
            "`cpf_func`,\n" +
            "`tel_func`,\n" +
            "`email_func`,\n" +
            "`idsexo_func`,\n" +
            "`obs_func`,\n" +
            "`cnpj_emp`)\n" +
            "VALUES\n" +
            "( ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? )";
    
    private static final String insertFuncionarioLogin = "INSERT INTO `aviao`.`tb_usuario_func`\n" +
            "(`cpf_func`,\n" +
            "`usuario`,\n" +
            "`senha`)\n" +
            "VALUES\n" +
            "( ? ,\n" +
            " ? ,\n" +
            " ? )";
    
    //Voo
    /*
        Campos obrigatórios: `voo_tag`,`origem`, `destino`, `dt_partida`, `hr_partida`,`cnpj_emp`, `vl_voo`
    */
    private static final String insertVoo = "call criaVoo(?, ?, ?, ?, ?, ?, ?)";
    
    /*
        Campos obrigatórios: `voo_tag`, quantidade de poltronas da aeronave
    */
    private static final String insertVooPoltrona = "call criaVooPoltrona( ? , ?)";

    
    //Passagem
    private static final String insertPassagem = "INSERT INTO `aviao`.`tb_passagem`\n" +
            "(`cpf_passageiro`,\n" +
            "`pass_bagagem`,\n" +
            "`pass_localizador`)\n" +
            "VALUES\n" +
            "( ? ,\n" +
            " ? ,\n" +
            " ? )";
    
    //Empresa
    private static final String insertEmpresa = "INSERT INTO `aviao`.`tb_empresa`\n" +
            "(`fantasia_emp`,\n" +
            "`inest_emp`,\n" +
            "`cnpj`,\n" +
            "`end_emp`,\n" +
            "`num_emp`,\n" +
            "`compl_emp`,\n" +
            "`cidade_emp`,\n" +
            "`idest_emp`,\n" +
            "`cep_emp`,\n" +
            "`email_emp`,\n" +
            "`obs_emp`)\n" +
            "VALUES\n" +
            "( ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? )";

    /**
     * @return the insertCliente
     */
    private String getInsertCliente() {
        return insertCliente;
    }

    /**
     * @return the insertClienteLogin
     */
    private String getInsertClienteLogin() {
        return insertClienteLogin;
    }

    /**
     * @return the insertFuncionario
     */
    private String getInsertFuncionario() {
        return insertFuncionario;
    }

    /**
     * @return the insertFuncionarioLogin
     */
    private String getInsertFuncionarioLogin() {
        return insertFuncionarioLogin;
    }

    /**
     * @return the insertVoo
     */
    private String getInsertVoo() {
        return insertVoo;
    }

    /**
     * @return the insertVooPoltrona
     */
    private String getInsertVooPoltrona() {
        return insertVooPoltrona;
    }

    /**
     * @return the insertPassagem
     */
    private String getInsertPassagem() {
        return insertPassagem;
    }

    /**
     * @return the insertEmpresa
     */
    private String getInsertEmpresa() {
        return insertEmpresa;
    }
    
    private static void setCliente(Cliente cliente, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, cliente.getNmCli());
        preparaSQL.setString(2, cliente.getDocCli());
        preparaSQL.setString(3, cliente.getOrgCli());
        preparaSQL.setInt(4, cliente.getIdufCli().getIdEstado());
        preparaSQL.setDate(5, new java.sql.Date(cliente.getDtnascCli().getTime()));
        preparaSQL.setString(6, cliente.getCpfCli());
        preparaSQL.setString(7, cliente.getEndCli());
        preparaSQL.setString(8, cliente.getNumCli());
        preparaSQL.setString(9, cliente.getComplCli());
        preparaSQL.setString(10, cliente.getBairroCli());
        preparaSQL.setString(11, cliente.getCidadeCli());
        preparaSQL.setInt(12, cliente.getIdestCli().getIdEstado());
        preparaSQL.setString(13, cliente.getEmailCli());
        preparaSQL.setString(14, cliente.getObsCli());
    }
    
    private static void setClienteLogin(UsuarioCliente usuario, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, usuario.getCpfCli());
        preparaSQL.setString(2, "");
        preparaSQL.setString(3, "12345");
    }
    
    private static void setEmpresa(Empresa empresa, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1,empresa.getFantasiaEmp());
        preparaSQL.setString(2,empresa.getInestEmp());
        preparaSQL.setString(3,empresa.getCnpj());
        preparaSQL.setString(4,empresa.getEndEmp());
        preparaSQL.setString(5,empresa.getNumEmpresa());
        preparaSQL.setString(6,empresa.getComplEmp());
        preparaSQL.setString(7,empresa.getCidadeEmp());
        preparaSQL.setInt(8,empresa.getIdestEmp().getIdEstado());
        preparaSQL.setInt(9,empresa.getCepEmp());
        preparaSQL.setString(10,empresa.getEmailEmp());
        preparaSQL.setString(11,empresa.getObsEmp());
    }
    
    private static void setFuncionario(Funcionario funcionario, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, funcionario.getNmFunc());
        preparaSQL.setString(2, funcionario.getCpfFunc());
        preparaSQL.setString(3, funcionario.getTelFunc());
        preparaSQL.setString(4, funcionario.getEmailFunc());
        preparaSQL.setInt(5, funcionario.getIdsexoFunc());
        preparaSQL.setString(6, funcionario.getObsFunc());
        preparaSQL.setString(7, funcionario.getCnpjEmp().getCnpj());
    }
    
    private static void setUsuarioFuncionario(UsuarioFuncionario usuario, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, usuario.getCpfFunc());
        preparaSQL.setString(2, "");
        preparaSQL.setString(3, "12345");
    }
    
    private static void setPassagem(Passagem passagem, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, passagem.getCpfPassageiro().getCpfCli());
        preparaSQL.setInt(2, passagem.getPassBagagem());
        preparaSQL.setString(3, passagem.getPassLocalizador());
    }
    
    private static void setVooPoltrona(VooPoltrona poltrona, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, poltrona.getVooTag().getVooTag());
        preparaSQL.setInt(2, poltrona.getPoltrona());
    }
    
    private static void setVoo(Voo voo, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, voo.getVooTag());
        preparaSQL.setString(2, voo.getOrigem());
        preparaSQL.setString(3, voo.getDestino());
        preparaSQL.setDate(4, (Date) voo.getDtPartida());
        preparaSQL.setTime(5, (Time) voo.getHrPartida());
        preparaSQL.setString(6, voo.getCpnjEmp().getCnpj());
        preparaSQL.setLong(7, voo.getVlVoo());
    }
    
    void gravaCliente(Cliente cliente) throws SQLException{
        PreparedStatement preparaSQL;
        ResultSet resultadoSQL;
        try {
            preparaSQL = SQLConnect.getInstance().prepareStatement(getInsertCliente());
            setCliente(cliente,preparaSQL);
            int executeUpdate = preparaSQL.executeUpdate();
            if(executeUpdate == 1)
                System.out.println("Inseriu no banco de dados!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\nNão foi possivel inserir no banco de dados");
        }finally{
            closeAll();
        }
        
    }
      
    void gravaFuncionario(Funcionario funcionario) throws SQLException{
        PreparedStatement preparaSQL;
         try {
            preparaSQL = SQLConnect.getInstance().prepareStatement(getInsertFuncionario());
            setFuncionario(funcionario, preparaSQL);
            int executeUpdate = preparaSQL.executeUpdate();
            if(executeUpdate == 1)
                System.out.println("Inseriu no banco de dados!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\nNão foi possivel inserir no banco de dados");
        }finally{
            closeAll();
        }
    }
    
    void gravaUsuarioCliente(UsuarioCliente usuario) throws SQLException{
        PreparedStatement preparaSQL;
         try {
            
             preparaSQL = SQLConnect.getInstance().prepareStatement(getInsertClienteLogin());
             setClienteLogin(usuario, preparaSQL);
             int executeUpdate = preparaSQL.executeUpdate();
             if(executeUpdate == 1)
                  System.out.println("Inseriu no banco de dados!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\nNão foi possivel inserir no banco de dados");
        }finally{
            closeAll();
        }
    }
    
    void gravaUsuarioFuncionario(UsuarioFuncionario usuario) throws SQLException{
        PreparedStatement preparaSQL;
         try {
             preparaSQL = SQLConnect.getInstance().prepareStatement(getInsertFuncionarioLogin());
             setUsuarioFuncionario(usuario, preparaSQL);
             int executeUpdate = preparaSQL.executeUpdate();
             if(executeUpdate == 1)
                  System.out.println("Inseriu no banco de dados!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\nNão foi possivel inserir no banco de dados");
        }finally{
            closeAll();
        }
    }
    
    void gravaVoo(Voo voo) throws SQLException{
        PreparedStatement preparaSQL;
        ResultSet resultadoSQL;
         try {
            preparaSQL = SQLConnect.getInstance().prepareStatement(getInsertVoo());
            setVoo(voo, preparaSQL);
            int executeUpdate = preparaSQL.executeUpdate();
            if(executeUpdate == 1)
                System.out.println("Inseriu no banco de dados!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\nNão foi possivel inserir no banco de dados");
        }finally{
            closeAll();
        }
    }
    void gravaVooPoltrona(VooPoltrona poltrona) throws SQLException{
        PreparedStatement preparaSQL;
        try {
            preparaSQL = SQLConnect.getInstance().prepareStatement(getInsertVooPoltrona());
            setVooPoltrona(poltrona, preparaSQL);
            int executeUpdate = preparaSQL.executeUpdate();
            if(executeUpdate == 1)
                System.out.println("Inseriu no banco de dados!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\nNão foi possivel inserir no banco de dados");
        }finally{
            closeAll();
        }
    }
    
    void gravaPassagem(Passagem passagem) throws SQLException{
        PreparedStatement preparaSQL;    
         try {
            preparaSQL = SQLConnect.getInstance().prepareStatement(getInsertPassagem());
            setPassagem(passagem, preparaSQL);
            int executeUpdate = preparaSQL.executeUpdate();
            if(executeUpdate == 1)
                System.out.println("Inseriu no banco de dados!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\nNão foi possivel inserir no banco de dados");
        }finally{
            closeAll();
        }
    }
    
    void gravaEmpresa(Empresa empresa) throws SQLException{
        PreparedStatement preparaSQL;    
         try {
            preparaSQL = SQLConnect.getInstance().prepareStatement(getInsertEmpresa());
            setEmpresa(empresa, preparaSQL);
            int executeUpdate = preparaSQL.executeUpdate();
            if(executeUpdate == 1)
                System.out.println("Inseriu no banco de dados!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\nNão foi possivel inserir no banco de dados");
        }finally{
            closeAll();
        }
    }

    @Override
    public void insertDataDB(Object obj) {
        switch(obj.getClass().getName()){
            case "DAO.ClassesDB.Cliente":{
                System.out.println("É a classe: " + obj.getClass().getName());
                try {
                    gravaCliente((Cliente) obj);
                } catch (SQLException ex) {
                    Logger.getLogger(InsertDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "DAO.ClassesDB.Funcionario":{
                System.out.println("É a classe: " + obj.getClass().getName());
                try {
                    gravaFuncionario((Funcionario) obj);
                } catch (SQLException ex) {
                    Logger.getLogger(InsertDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "DAO.ClassesDB.Voo":{
                System.out.println("É a classe: " + obj.getClass().getName());
                try {
                    gravaVoo((Voo) obj);
                    VooPoltrona vooPoltrona = new VooPoltrona();
                    vooPoltrona.setVooTag((Voo) obj);
                    vooPoltrona.setPoltrona(60);
                    gravaVooPoltrona(vooPoltrona);
                } catch (SQLException ex) {
                    Logger.getLogger(InsertDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "DAO.ClassesDB.VooPoltrona":{
                System.out.println("É a classe: " + obj.getClass().getName());
                break;
            }
             case "DAO.ClassesDB.Passagem":{
                System.out.println("É a classe: " + obj.getClass().getName());
                 try {
                     gravaPassagem((Passagem) obj);
                 } catch (SQLException ex) {
                     Logger.getLogger(InsertDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
                break;
            }
            case "DAO.ClassesDB.Empresa":{
                System.out.println("É a classe: " + obj.getClass().getName());
                try {
                    gravaEmpresa((Empresa) obj);
                } catch (SQLException ex) {
                    Logger.getLogger(InsertDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "DAO.ClassesDB.UsuarioCliente":{
                System.out.println("É a classe: " + obj.getClass().getName());
                try {
                    gravaUsuarioCliente((UsuarioCliente) obj);
                } catch (SQLException ex) {
                    Logger.getLogger(InsertDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "DAO.ClassesDB.UsuarioFuncionario":{
                System.out.println("É a classe: " + obj.getClass().getName());
                 try {
                    gravaUsuarioFuncionario((UsuarioFuncionario) obj);
                } catch (SQLException ex) {
                    Logger.getLogger(InsertDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            default:{
                System.out.println("Classe nula: " + obj.getClass().getName());
                break;
            }
        }
    }

    @Override
    public void updateDataDB(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOperacao() {
        return this.operacao;
    }

    @Override
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
}
