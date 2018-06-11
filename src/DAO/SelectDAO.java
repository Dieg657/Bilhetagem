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
import DAO.ClassesDB.Voo;
import DAO.ClassesDB.VooPoltrona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public final class SelectDAO extends DAO{
    
    public SelectDAO(){
        
    }
    
    //Status
    private static final String selectStatus = "SELECT * FROM aviao.tb_status";
    
    //Cliente
    private static final String selectCliente = "SELECT `tb_cliente`.`nm_cli`,\n" +
        "    `tb_cliente`.`doc_cli`,\n" +
        "    `tb_cliente`.`org_cli`,\n" +
        "    `tb_cliente`.`iduf_cli`,\n" +
        "    `tb_cliente`.`dtnasc_cli`,\n" +
        "    `tb_cliente`.`cpf_cli`,\n" +
        "    `tb_cliente`.`end_cli`,\n" +
        "    `tb_cliente`.`num_cli`,\n" +
        "    `tb_cliente`.`compl_cli`,\n" +
        "    `tb_cliente`.`bairro_cli`,\n" +
        "    `tb_cliente`.`cidade_cli`,\n" +
        "    `tb_cliente`.`idest_cli`,\n" +
        "    `tb_cliente`.`email_cli`,\n" +
        "    `tb_cliente`.`obs_cli`\n" +
        "FROM `aviao`.`tb_cliente`";
    private static final String selectClienteLogin = "SELECT `tb_usuario_cli`.`cpf_cli`,`tb_usuario_cli`.`usuario`,`tb_usuario_cli`.`senha` FROM `aviao`.`tb_usuario_cli`";
    
    private static final String selectFuncionario = "SELECT `tb_funcionario`.`nm_func`,\n" +
        "    `tb_funcionario`.`cpf_func`,\n" +
        "    `tb_funcionario`.`idtel_func`,\n" +
        "    `tb_funcionario`.`email_func`,\n" +
        "    `tb_funcionario`.`idsexo_func`,\n" +
        "    `tb_funcionario`.`obs_func`,\n" +
        "    `tb_funcionario`.`cnpj_emp`\n" +
        "FROM `aviao`.`tb_funcionario`";
    private static final String selectFuncionarioLogin = "SELECT `tb_usuario_func`.`cpf_func`,\n" +
        "    `tb_usuario_func`.`usuario`,\n" +
        "    `tb_usuario_func`.`senha`\n" +
        "FROM `aviao`.`tb_usuario_func`";
    
    //Voo
    private static final String selectVoo = "SELECT `tb_usuario_func`.`cpf_func`,\n" +
        "    `tb_usuario_func`.`usuario`,\n" +
        "    `tb_usuario_func`.`senha`\n" +
        "FROM `aviao`.`tb_usuario_func`";
    
    private static final String selectVooPoltrona = "SELECT `tb_voo_poltrona`.`idtb_voo_poltrona`,\n" +
        "    `tb_voo_poltrona`.`voo_tag`,\n" +
        "    `tb_voo_poltrona`.`poltrona`,\n" +
        "    `tb_voo_poltrona`.`localizador`,\n" +
        "    `tb_voo_poltrona`.`status`\n" +
        "FROM `aviao`.`tb_voo_poltrona`";
    
    private static final String selectPassagem = "SELECT `tb_passagem`.`cpf_passageiro`,\n" +
        "    `tb_passagem`.`pass_bagagem`,\n" +
        "    `tb_passagem`.`pass_localizador`\n" +
        "FROM `aviao`.`tb_passagem`";
    
    private static final String selectEstado = "SELECT `tb_estado`.`id_estado`,\n" +
        "    `tb_estado`.`estado`,\n" +
        "    `tb_estado`.`uf`\n" +
        "FROM `aviao`.`tb_estado`";
    
    private static final String selectEmpresa = "SELECT `tb_empresa`.`fantasia_emp`,\n" +
        "    `tb_empresa`.`inest_emp`,\n" +
        "    `tb_empresa`.`cnpj`,\n" +
        "    `tb_empresa`.`end_emp`,\n" +
        "    `tb_empresa`.`num_empresa`,\n" +
        "    `tb_empresa`.`compl_emp`,\n" +
        "    `tb_empresa`.`cidade_emp`,\n" +
        "    `tb_empresa`.`idest_emp`,\n" +
        "    `tb_empresa`.`cep_emp`,\n" +
        "    `tb_empresa`.`email_emp`,\n" +
        "    `tb_empresa`.`obs_emp`\n" +
        "FROM `aviao`.`tb_empresa`";

    /**
     * @return the selectStatus
     */
    public static String getSelectStatus() {
        return selectStatus;
    }

    /**
     * @return the selectCliente
     */
    public static String getSelectCliente() {
        return selectCliente;
    }

    /**
     * @return the selectClienteLogin
     */
    public static String getSelectClienteLogin() {
        return selectClienteLogin;
    }

    /**
     * @return the selectFuncionario
     */
    public static String getSelectFuncionario() {
        return selectFuncionario;
    }

    /**
     * @return the selectFuncionarioLogin
     */
    public static String getSelectFuncionarioLogin() {
        return selectFuncionarioLogin;
    }

    /**
     * @return the selectVoo
     */
    public static String getSelectVoo() {
        return selectVoo;
    }

    /**
     * @return the selectVooPoltrona
     */
    public static String getSelectVooPoltrona() {
        return selectVooPoltrona;
    }

    /**
     * @return the selectPassagem
     */
    public static String getSelectPassagem() {
        return selectPassagem;
    }

    /**
     * @return the selectEstado
     */
    public static String getSelectEstado() {
        return selectEstado;
    }

    /**
     * @return the selectEmpresa
     */
    public static String getSelectEmpresa() {
        return selectEmpresa;
    }
    
    private Cliente getCliente(ResultSet rs) throws SQLException{
        cliente = new Cliente();
        uf = new Estado();
        estado = new Estado();
        cliente.setNmCli(rs.getString("nm_cli"));
        cliente.setDocCli(rs.getString("doc_cli"));
        cliente.setOrgCli(rs.getString("org_cli"));
        uf.setIdEstado(rs.getInt("iduf_cli")); cliente.setIdufCli(uf);
        cliente.setDtnascCli(rs.getDate("dtnasc_cli"));
        cliente.setCpfCli(rs.getString("cpf_cli"));
        cliente.setEndCli(rs.getString("end_cli"));
        cliente.setNmCli(rs.getString("num_cli"));
        cliente.setComplCli(rs.getString("compl_cli"));
        cliente.setBairroCli(rs.getString("bairro_cli"));
        cliente.setCidadeCli(rs.getString("cidade_cli"));
        estado.setIdEstado(rs.getInt("idest_cli")); cliente.setIdestCli(estado);
        cliente.setEmailCli(rs.getString("email_cli"));
        cliente.setObsCli(rs.getString("obs_cli"));
        
        return cliente;
    }
    
    private Empresa getEmpresa (ResultSet rs) throws SQLException{
        empresa = new Empresa();
        estado = new Estado();
        empresa.setFantasiaEmp(rs.getString("fansisa_emp"));
        empresa.setInestEmp(rs.getString("inest_emp"));
        empresa.setCnpj(rs.getString("cnpj"));
        empresa.setEndEmp(rs.getString("end_emp"));
        empresa.setNumEmpresa(rs.getString("num_emp"));
        empresa.setComplEmp(rs.getString("compl_emp"));
        empresa.setCidadeEmp("cidade_emp");
        estado.setIdEstado(rs.getInt("idest_emp")); empresa.setIdestEmp(estado);
        empresa.setCepEmp(rs.getInt("cep_emp"));
        empresa.setEmailEmp(rs.getString("email_emp"));
        empresa.setObsEmp(rs.getString("obs_emp"));
        
        return empresa;
    }
    
    private Funcionario getFuncionario (ResultSet rs) throws SQLException{
        funcionario = new Funcionario();
        funcionario.setNmFunc(rs.getString("nm_func"));
        funcionario.setCpfFunc(rs.getString("cpf_func"));
        funcionario.setTelFunc(rs.getString("tel_func"));
        funcionario.setIdsexoFunc(rs.getInt("idsexo_func"));
        funcionario.setObsFunc(rs.getString("obs_func"));
        empresa = new Empresa();
        empresa.setCnpj(rs.getString("cnpj_emp")); funcionario.setCnpjEmp(empresa);
        
        return funcionario;
    }
    
    private Estado getEstado (ResultSet rs) throws SQLException{
        estado = new Estado();
        estado.setIdEstado(rs.getInt("id_estado"));
        estado.setEstado(rs.getString("estado"));
        estado.setUf(rs.getString("uf"));
        
        return estado;
    }
    
    private Status getStatus (ResultSet rs) throws SQLException{
        statusPoltrona = new Status();
        
        statusPoltrona.setIdStatus(rs.getInt("id_status"));
        statusPoltrona.setStatus(rs.getString("status"));
        
        return statusPoltrona;
    }
    
    private Passagem getPassagem (ResultSet rs) throws SQLException{
        passagem = new Passagem();
        cliente = new Cliente();
        cliente.setCpfCli(rs.getString("cpf_passageiro")); passagem.setCpfPassageiro(cliente);
        passagem.setPassBagagem(rs.getInt("pass_bagagem"));
        passagem.setPassLocalizador(rs.getString("pass_localizador"));
        
        return passagem;
    }
    
    private Voo getVoo (ResultSet rs) throws SQLException{
        voo = new Voo();
        empresa = new Empresa();
        
        voo.setVooTag(rs.getString("voo_tag"));
        voo.setOrigem(rs.getString("origem"));
        voo.setDestino(rs.getString("destino"));  
        voo.setDtPartida(rs.getDate("dt_partida"));
        voo.setHrPartida(rs.getTime("hr_partida"));
        empresa.setCnpj(rs.getString("cnpj_emp")); voo.setCpnjEmp(empresa);
        voo.setVlVoo(rs.getLong("vl_voo"));

        return voo;
    }
    
    private VooPoltrona getVooPoltrona (ResultSet rs) throws SQLException{
        statusPoltrona = new Status();
        voo = new Voo();
        poltrona = new VooPoltrona();
        passagem = new Passagem();
        
        poltrona.setIdtbVooPoltrona(rs.getInt("idtb_voo_poltrona"));
        voo.setVooTag(rs.getString("voo_tag")); poltrona.setVooTag(voo);
        passagem.setPassLocalizador(rs.getString("localizador")) ;poltrona.setLocalizador(passagem);
        statusPoltrona.setIdStatus(rs.getInt("status")); poltrona.setStatus(statusPoltrona);
        
        return poltrona;
    }
    
    public List<Estado> getEstadoAll(){
        try {
            List<Estado> lstEstado = new ArrayList<>();
            preparaSQL = (PreparedStatement) SQLConnect.getInstance().prepareStatement(getSelectEstado());
            resultadoSQL = preparaSQL.executeQuery();
            while (resultadoSQL.next()) {
                lstEstado.add(getEstado(resultadoSQL));
            }
            return lstEstado;
        } catch (SQLException ex) {
            Logger.getLogger(SelectDAO.class.getName()).log(Level.SEVERE, "Não foi possível executar a instrução no Banco de Dados", ex);
        }finally{
            closeAll();
        }
        return null;
    }
    
     public List<Status> getStatusAll(){
        try {
            List<Status> lstStatus = new ArrayList<>();
            preparaSQL = (PreparedStatement) SQLConnect.getInstance().prepareStatement(getSelectStatus());
            resultadoSQL = preparaSQL.executeQuery();
            while (resultadoSQL.next()) {
                lstStatus.add(getStatus(resultadoSQL));
            }
            return lstStatus;
        } catch (SQLException ex) {
            Logger.getLogger(SelectDAO.class.getName()).log(Level.SEVERE, "Não foi possível executar a instrução no Banco de Dados", ex);
        }finally{
            closeAll();
        }
        return null;
    }

    @Override
    public void insertDataDB(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDataDB(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOperacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOperacao(String operacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
