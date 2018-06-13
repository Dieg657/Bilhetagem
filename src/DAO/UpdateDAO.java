/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.ClassesDB.Cliente;
import DAO.ClassesDB.Empresa;
import DAO.ClassesDB.Funcionario;
import DAO.ClassesDB.Status;
import DAO.ClassesDB.VooPoltrona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public final class UpdateDAO extends DAO {
    private static boolean bloquearNovosVoos = false;
    
    public UpdateDAO(){
        
    }
    
    private String operacao;
    
    private static final String updateCliente = "UPDATE `aviao`.`tb_cliente`\n" +
            "SET\n" +
            "`nm_cli` = ?,\n" +
            "`doc_cli` = ?,\n" +
            "`org_cli` = ? ,\n" +
            "`iduf_cli` = ? ,\n" +
            "`dtnasc_cli` = ? ,\n" +
            "`end_cli` = ? ,\n" +
            "`num_cli` = ? ,\n" +
            "`compl_cli` = ? ,\n" +
            "`bairro_cli` = ? ,\n" +
            "`cidade_cli` = ? ,\n" +
            "`idest_cli` = ? ,\n" +
            "`email_cli` = ? ,\n" +
            "`obs_cli` = ? \n" +
            "WHERE `cpf_cli` = ? ";
      
      private static final String updateFuncionario = "UPDATE `aviao`.`tb_funcionario`\n" +
            "SET\n" +
            "`nm_func` = ?,\n" +
            "`tel_func` = ? ,\n" +
            "`email_func` = ? ,\n" +
            "`idsexo_func` = ? ,\n" +
            "`obs_func` = ? ,\n" +
            "`cnpj_emp` = ? \n" +
            "WHERE `cpf_func` = ? ";
      
    private static final String updateEmpresa = "UPDATE `aviao`.`tb_empresa`\n" +
            "SET\n" +
            "`fantasia_emp` = ? ,\n" +
            "`inest_emp` = ? ,\n" +
            "`cnpj` = ? ,\n" +
            "`end_emp` = ? ,\n" +
            "`num_emp` = ? ,\n" +
            "`compl_emp` = ? ,\n" +
            "`cidade_emp` = ? ,\n" +
            "`idest_emp` = ? ,\n" +
            "`cep_emp` = ? ,\n" +
            "`email_emp` = ? ,\n" +
            "`obs_emp` = ? \n" +
            "WHERE `cnpj` = ? ";
    /*Mover o cliente de uma poltrona com problema para outra*/
    private static final String updateClienteVooPoltrona = "call updateCliPoltrona(?,?,?)";
    /*Define a poltrona como manutenção*/
    private static final String updateStatusPoltronaManutencao = "call updateStatusPoltronaManutencao(?,?,?)";
    /*Desvincula a poltrona da passagem, ao desvincular faz-se necessário vincular a passagem solta com novo itinerário*/
    private static final String updateStatusPoltronaLivre = "call updateStatusPoltronaLivre(?,?,?)";
    
    private static final String selectPoltronaLivre = "SELECT `tb_voo_poltrona`.`poltrona` FROM `aviao`.`tb_voo_poltrona`\n" +
            "WHERE `tb_voo_poltrona`.`voo_tag` = ? AND `tb_voo_poltrona`.`status` = 1";
    
    /**
     * @return the updateCliente
     */
    private String getUpdateCliente() {
        return updateCliente;
    }
    
    /**
     * @return the updateFuncionario
     */
    private String getUpdateFuncionario() {
        return updateFuncionario;
    }
    /**
     * @return the updateEmpresa
     */
    private String getUpdateEmpresa() {
        return updateEmpresa;
    }
     
    private static void setCliente(Cliente cliente, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, cliente.getNmCli());
        preparaSQL.setString(2, cliente.getDocCli());
        preparaSQL.setString(3, cliente.getOrgCli());
        preparaSQL.setInt(4, cliente.getIdufCli().getIdEstado());
        preparaSQL.setDate(5, new java.sql.Date(cliente.getDtnascCli().getTime()));
        preparaSQL.setString(6, cliente.getEndCli());
        preparaSQL.setString(7, cliente.getNumCli());
        preparaSQL.setString(8, cliente.getComplCli());
        preparaSQL.setString(9, cliente.getBairroCli());
        preparaSQL.setString(10, cliente.getCidadeCli());
        preparaSQL.setInt(11, cliente.getIdestCli().getIdEstado());
        preparaSQL.setString(12, cliente.getEmailCli());
        preparaSQL.setString(13, cliente.getObsCli());
        preparaSQL.setString(14, cliente.getCpfCli());
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
    private static void setVooTag(String vooTag, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, vooTag);
    }
    private static void setVooPoltrona(VooPoltrona poltrona, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, poltrona.getVooTag().getVooTag());
        preparaSQL.setInt(2, poltrona.getPoltrona());
        preparaSQL.setString(3, poltrona.getLocalizador().getPassLocalizador());
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
    private VooPoltrona getPoltronaLivre(ResultSet rs) throws SQLException{
        VooPoltrona obj = new VooPoltrona();
        obj.setPoltrona(rs.getInt("poltrona"));
        return obj;
    }    
    VooPoltrona moveParaAProximaPoltrona(VooPoltrona poltrona) throws SQLException{
        try {
            PreparedStatement preparaSQL;
            ResultSet resultadoSQL;
            VooPoltrona novaPoltrona;
            preparaSQL = SQLConnect.getInstance().prepareStatement(selectPoltronaLivre);
            setVooTag(poltrona.getVooTag().getVooTag(), preparaSQL);
            resultadoSQL = preparaSQL.executeQuery();
            if(resultadoSQL.next()){
                novaPoltrona = getPoltronaLivre(resultadoSQL);
                novaPoltrona.setVooTag(poltrona.getVooTag());
                novaPoltrona.setLocalizador(poltrona.getLocalizador());
                novaPoltrona.setStatus(new Status(2));
                return novaPoltrona;
            }else{
                throw new SQLException("Não há poltronas livres neste voo!");
            }
        } catch (SQLException ex) {
                System.out.println(ex.getMessage() + "\nNão foi possivel consultar no banco de dados");
        }finally{
            closeAll();
        }
        return null;
    }
    void atualizaCliente(Cliente cliente) throws SQLException{
        try {
            PreparedStatement preparaSQL;
            preparaSQL = SQLConnect.getInstance().prepareStatement(updateCliente);
            setCliente(cliente, preparaSQL);
            int executeUpdate = preparaSQL.executeUpdate();
            if(executeUpdate == 1)
                System.out.println("Atualizou no banco de dados!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\nNão foi possivel atualizar no banco de dados");
        }finally{
            closeAll();
        }
    }
    void atualizaFuncionario(Funcionario funcionario) throws SQLException{
        
    }
    void atualizaEmpresa(Empresa empresa) throws SQLException{
        
    }
    void atualizaClienteVooPoltrona(VooPoltrona poltrona) throws SQLException{
        /*
            Necessita do Localizador para colocar o cliente numa outra poltrona
        */
    }
    void atualizaStatusVooPoltrona(VooPoltrona poltrona, int op) throws SQLException{
        PreparedStatement preparaSQL;
        /*
        Definindo a poltrona como Livre ou em Manutençao
         */
        switch (op) {
            case 1:
                try {
                    preparaSQL = SQLConnect.getInstance().prepareStatement(updateStatusPoltronaLivre);
                    setVooPoltrona(poltrona, preparaSQL);
                    int executeUpdate = preparaSQL.executeUpdate();
                    if(executeUpdate == 1)
                        System.out.println("Atualizou poltrona para Livre no banco de dados!");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage() + "\nNão foi possivel atualizar no banco de dados");
                }finally{
                    closeAll();
                }   
                break;
            case 2:

                try {
                    preparaSQL = SQLConnect.getInstance().prepareStatement(updateClienteVooPoltrona);
                    setVooPoltrona(poltrona,preparaSQL);
                    int executeUpdate = preparaSQL.executeUpdate();
                    if(executeUpdate == 1)
                        System.out.println("Atualizou poltrona para Ocupada no banco de dados!");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage() + "\nNão foi possivel atualizar no banco de dados");
                }finally{
                    closeAll();
                }
                break;
            case 3:
                VooPoltrona nvPoltrona = new VooPoltrona();
                
                try {
                    nvPoltrona = moveParaAProximaPoltrona(poltrona); //Objeto com a posição nova de poltrona
                    
                    preparaSQL = SQLConnect.getInstance().prepareStatement(updateStatusPoltronaManutencao);
                    setVooPoltrona(poltrona, preparaSQL);
                    int executeUpdate = preparaSQL.executeUpdate();
                    if(executeUpdate == 1)
                        System.out.println("Atualizou poltrona para Manutenção no banco de dados!");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage() + "\nNão foi possivel atualizar no banco de dados");
                }finally{
                    closeAll();
                }   
                
                try {
  
                    /* Insere o objeto com a posição nova no banco de dados! */
                    preparaSQL = SQLConnect.getInstance().prepareStatement(updateClienteVooPoltrona);
                    setVooPoltrona(nvPoltrona, preparaSQL);
                    int executeUpdate = preparaSQL.executeUpdate();
                    if(executeUpdate == 1)
                        System.out.println("Atualizou poltrona para Ocupada no banco de dados!");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage() + "\nNão foi possivel atualizar no banco de dados");
                }finally{
                    closeAll();
                }
                
                break;
            default:
                break;
        }
    }
    
    
    @Override
    public void insertDataDB(Object obj) {
        throw new UnsupportedOperationException("Não é possível inserir numa consulta de atualização"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDataDB(Object obj) {
        switch(obj.getClass().getName()){
            case "DAO.ClassesDB.Cliente":{
                System.out.println("É a classe: " + obj.getClass().getName());
                try {
                    atualizaCliente((Cliente) obj);
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "DAO.ClassesDB.Funcionario":{
                System.out.println("É a classe: " + obj.getClass().getName());
                try {
                    atualizaFuncionario((Funcionario) obj);
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "DAO.ClassesDB.Voo":{
                System.out.println("É a classe: " + obj.getClass().getName());
                break;
            }
            case "DAO.ClassesDB.VooPoltrona":{
                System.out.println("É a classe: " + obj.getClass().getName());
                VooPoltrona poltrona = (VooPoltrona) obj;
                switch(poltrona.getStatus().getIdStatus()){
                    case 1:{
                        /*
                            Libera a poltrona para um nova passagem
                        */
                        try {
                            atualizaStatusVooPoltrona(poltrona,1);
                        } catch (SQLException ex) {
                            Logger.getLogger(UpdateDAO.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                    case 2:{
                        /*
                            Coloca a poltrona como ocupada
                        */
                        try {
                            atualizaStatusVooPoltrona(poltrona,2);
                        } catch (SQLException ex) {
                            Logger.getLogger(UpdateDAO.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                    case 3:{
                        /*
                            Move para a proxima poltrona livre, se não houver exibe mensagem de erro!
                        */
                        try {
                            atualizaStatusVooPoltrona(poltrona,3);
                        } catch (SQLException ex) {
                            Logger.getLogger(UpdateDAO.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                }
                break;
            }
             case "DAO.ClassesDB.Passagem":{
                System.out.println("É a classe: " + obj.getClass().getName());
                break;
            }
            case "DAO.ClassesDB.Empresa":{
                System.out.println("É a classe: " + obj.getClass().getName());
                try {
                    atualizaEmpresa((Empresa) obj);
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "DAO.ClassesDB.UsuarioCliente":{
                System.out.println("É a classe: " + obj.getClass().getName());
                break;
            }
            case "DAO.ClassesDB.UsuarioFuncionario":{
                System.out.println("É a classe: " + obj.getClass().getName());
                break;
            }
            default:{
                System.out.println("Classe nula: " + obj.getClass().getName());
                break;
            }
        }
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
