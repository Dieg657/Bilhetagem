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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public final class SelectDAO extends DAO{
    private String operacao = null;

    public SelectDAO(){
        
    }
    
    //Status
    private static final String selectStatus = "SELECT `tb_status`.`id_status`,\n" +
                                                "    `tb_status`.`status`\n" +
                                                "FROM `aviao`.`tb_status`";
        
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
    private static final String selectClienteLogin = "SELECT `tb_usuario_cli`.`cpf_cli`,`tb_usuario_cli`.`usuario`,`tb_usuario_cli`.`senha` FROM `aviao`.`tb_usuario_cli` \n" 
            + "WHERE `cpf_cli` = ? AND `senha` = ?";
    
    private static final String selectFuncionario = "SELECT `tb_funcionario`.`nm_func`,\n" +
        "    `tb_funcionario`.`cpf_func`,\n" +
        "    `tb_funcionario`.`tel_func`,\n" +
        "    `tb_funcionario`.`email_func`,\n" +
        "    `tb_funcionario`.`idsexo_func`,\n" +
        "    `tb_funcionario`.`obs_func`,\n" +
        "    `tb_funcionario`.`cnpj_emp`\n" +
        "FROM `aviao`.`tb_funcionario`";
    
    private static final String selectEmpresaCPF = "SELECT `tb_empresa`.`cnpj` FROM `tb_empresa` INNER JOIN `tb_funcionario`\n" + 
            "ON `tb_empresa`.`cnpj` = `tb_funcionario`.`cnpj_emp`\n" + 
            " WHERE `tb_funcionario`.`cpf_func` = ? ";
    
    private static final String selectFuncionarioLogin = "SELECT `tb_usuario_func`.`cpf_func`,\n" +
        "    `tb_usuario_func`.`usuario`,\n" +
        "    `tb_usuario_func`.`senha`\n" +
        "FROM `aviao`.`tb_usuario_func`" +
        "WHERE `cpf_func` = ? AND `senha` = ?";
    
    //Voo
    private static final String selectVoo = "SELECT `tb_voo`.`voo_tag`,\n" +
        "    `tb_voo`.`origem`,\n" +
        "    `tb_voo`.`destino`,\n" +
        "    `tb_voo`.`dt_partida`,\n" +
        "    `tb_voo`.`hr_partida`,\n" +
        "    `tb_voo`.`cnpj_emp`,\n" +
        "    `tb_voo`.`vl_voo`\n" +
        "FROM `aviao`.`tb_voo` ";
        
    
    private static final String selectVooPoltrona = "SELECT `tb_voo_poltrona`.`idtb_voo_poltrona`,\n" +
        "    `tb_voo_poltrona`.`voo_tag`,\n" +
        "    `tb_voo_poltrona`.`poltrona`,\n" +
        "    `tb_voo_poltrona`.`localizador`,\n" +
        "    `tb_voo_poltrona`.`status`\n" +
        "FROM `aviao`.`tb_voo_poltrona`";
    
    private static final String selectVooPoltronaLivre = "SELECT `tb_voo_poltrona`.`idtb_voo_poltrona`,\n" +
        "    `tb_voo_poltrona`.`voo_tag`,\n" +
        "    `tb_voo_poltrona`.`poltrona`,\n" +
        "    `tb_voo_poltrona`.`localizador`,\n" +
        "    `tb_voo_poltrona`.`status`\n" +
        "FROM `aviao`.`tb_voo_poltrona` WHERE `status` = 1 AND `voo_tag` = ?";
    
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
        "    `tb_empresa`.`num_emp`,\n" +
        "    `tb_empresa`.`compl_emp`,\n" +
        "    `tb_empresa`.`cidade_emp`,\n" +
        "    `tb_empresa`.`idest_emp`,\n" +
        "    `tb_empresa`.`cep_emp`,\n" +
        "    `tb_empresa`.`email_emp`,\n" +
        "    `tb_empresa`.`obs_emp`\n" +
        "FROM `aviao`.`tb_empresa`";
    
    // <editor-fold defaultstate="collapsed" desc="Prepara parametros"> 
    private static void setVoo(Voo voo, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, voo.getOrigem());
        preparaSQL.setString(2, voo.getDestino());
        preparaSQL.setDate(3, new java.sql.Date(voo.getDtPartida().getTime()));
    }
    
    private static void setVooPoltrona(VooPoltrona poltrona, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, poltrona.getVooTag().getVooTag());
    }
    
    private static void setStatus(Status status, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setInt(1, status.getIdStatus());
    }
    
    private static void setUsuarioLogin(UsuarioCliente usuario, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, usuario.getCpfCli());
        preparaSQL.setString(2, usuario.getSenha());
    }
    
    private static void setUsuarioFuncionario(UsuarioFuncionario usuario, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, usuario.getCpfFunc());
        preparaSQL.setString(2, usuario.getSenha());
    }
    
    private static void setEmpresa (Empresa empresa, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, empresa.getFantasiaEmp());
        preparaSQL.setString(2, empresa.getCnpj());
    }
    
    private static void setEmpresaCPF(String cpf, PreparedStatement preparaSQL) throws SQLException{
        preparaSQL.setString(1, cpf);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Consultas com Parametros"> 
    public UsuarioCliente getUsuarioCliente(UsuarioCliente usuario){
        PreparedStatement preparaSQL;    
        ResultSet resultadoSQL;
        try {
            UsuarioCliente usuarioLogin;
            preparaSQL = SQLConnect.getInstance().prepareStatement(getSelectClienteLogin());
            setUsuarioLogin(usuario, preparaSQL);
            resultadoSQL = preparaSQL.executeQuery();
            while (resultadoSQL.next()) {
                usuarioLogin = getUsuario(resultadoSQL);
                return usuarioLogin;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(SelectDAO.class.getName()).log(Level.SEVERE, "Não foi possível executar a instrução no Banco de Dados", ex);
        }finally{
            closeAll();
        }
        return null;
    }
    public UsuarioFuncionario getUsuarioFuncionario(UsuarioFuncionario usuario){
        PreparedStatement preparaSQL;    
        ResultSet resultadoSQL;
        try {
            UsuarioFuncionario usuarioLogin;
            preparaSQL = SQLConnect.getInstance().prepareStatement(getSelectFuncionarioLogin());
            setUsuarioFuncionario(usuario, preparaSQL);
            resultadoSQL = preparaSQL.executeQuery();
            while (resultadoSQL.next()) {
                usuarioLogin = getUsuarioFuncionario(resultadoSQL);
                return usuarioLogin;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(SelectDAO.class.getName()).log(Level.SEVERE, "Não foi possível executar a instrução no Banco de Dados", ex);
        }finally{
            closeAll();
        }
        return null;
    }
    
    public List<Voo> getVooComParametros(Voo voo){
        PreparedStatement preparaSQL;    
        ResultSet resultadoSQL;
        try {
            List<Voo> lstVoo = new ArrayList<>();
            preparaSQL = SQLConnect.getInstance().prepareStatement(getSelectVoo() + "WHERE (`tb_voo`.`origem` = ? AND `tb_voo`.`destino`= ? ) \n"+
                    "OR `tb_voo`.`dt_partida` = ? ");
            setVoo(voo, preparaSQL);
            resultadoSQL = preparaSQL.executeQuery();
            while (resultadoSQL.next()) {
                lstVoo.add(getVoo(resultadoSQL));
            }
            return lstVoo;
        } catch (SQLException ex) {
            Logger.getLogger(SelectDAO.class.getName()).log(Level.SEVERE, "Não foi possível executar a instrução no Banco de Dados", ex);
        }finally{
            closeAll();
        }
        return null;
    }
    
    public List<VooPoltrona> getVooPoltronaParametros(VooPoltrona poltrona){
        PreparedStatement preparaSQL;    
        ResultSet resultadoSQL;
        try {
            List<VooPoltrona> lstPoltrona = new ArrayList<>();
            preparaSQL = SQLConnect.getInstance().prepareStatement(getSelectVooPoltrona()+ "WHERE `tb_voo_poltrona`.`voo_tag` = ? ");
            setVooPoltrona(poltrona, preparaSQL);
            resultadoSQL = preparaSQL.executeQuery();
            while (resultadoSQL.next()) {
                lstPoltrona.add(getVooPoltrona(resultadoSQL));
            }
            return lstPoltrona;
        } catch (SQLException ex) {
            Logger.getLogger(SelectDAO.class.getName()).log(Level.SEVERE, "Não foi possível executar a instrução no Banco de Dados", ex);
        }finally{
            closeAll();
        }
        return null;
    }
    
    public List<VooPoltrona> getPoltronaLivre(VooPoltrona poltrona) throws SQLException{
        PreparedStatement preparaSQL;    
        ResultSet resultadoSQL;
        try {
            List<VooPoltrona> lstPoltrona = new ArrayList<>();
            preparaSQL = SQLConnect.getInstance().prepareStatement(getSelectVooPoltronaLivre());
            setVooPoltrona(poltrona, preparaSQL);
            resultadoSQL = preparaSQL.executeQuery();
            while (resultadoSQL.next()) {
                lstPoltrona.add(getVooPoltrona(resultadoSQL));
            }
            return lstPoltrona;
        } catch (SQLException ex) {
            Logger.getLogger(SelectDAO.class.getName()).log(Level.SEVERE, "Não foi possível executar a instrução no Banco de Dados", ex);
        }finally{
            closeAll();
        }
        return null;
    }
    
    public Status getStatusParametros(Status status){
        PreparedStatement preparaSQL;    
        ResultSet resultadoSQL;
        try {
            Status resultStatus = new Status();
            preparaSQL = SQLConnect.getInstance().prepareStatement(getSelectStatus() + " WHERE `tb_status`.`id_status` = ?");
            setStatus(status, preparaSQL);
            resultadoSQL = preparaSQL.executeQuery();
            while (resultadoSQL.next()) {
                resultStatus = getStatus(resultadoSQL);
            }
            return resultStatus;
        } catch (SQLException ex) {
            Logger.getLogger(SelectDAO.class.getName()).log(Level.SEVERE, "Não foi possível executar a instrução no Banco de Dados", ex);
        }finally{
            closeAll();
        }
        return null;
    }
    
    public Empresa getEmpresaCNPJ(String CPF) throws SQLException{
        PreparedStatement preparaSQL;    
        ResultSet resultadoSQL;
        try {
            Empresa empresa = new Empresa();
            preparaSQL = SQLConnect.getInstance().prepareStatement(selectEmpresaCPF);
            setEmpresaCPF(CPF, preparaSQL);
            resultadoSQL = preparaSQL.executeQuery();
            while (resultadoSQL.next()) {
                empresa = getEmpresaCNPJ(resultadoSQL);
            }
            return empresa;
        } catch (SQLException ex) {
            Logger.getLogger(SelectDAO.class.getName()).log(Level.SEVERE, "Não foi possível executar a instrução no Banco de Dados", ex);
        }finally{
            closeAll();
        }
        return null;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Consultas sem Parametros"> 
    public List<Empresa> getEmpresas() throws SQLException{
        PreparedStatement preparaSQL;    
        ResultSet resultadoSQL;
        try {
            List<Empresa> lstEmpresa = new ArrayList<>();
            preparaSQL = SQLConnect.getInstance().prepareStatement(getSelectEmpresa());
            resultadoSQL = preparaSQL.executeQuery();
            while (resultadoSQL.next()) {
                lstEmpresa.add(getEmpresa(resultadoSQL));
            }
            return lstEmpresa;
        } catch (SQLException ex) {
            Logger.getLogger(SelectDAO.class.getName()).log(Level.SEVERE, "Não foi possível executar a instrução no Banco de Dados", ex);
        }finally{
            closeAll();
        }
        return null;
    }
    
    public Empresa getEmpresa(Empresa empresa) throws SQLException{
        PreparedStatement preparaSQL;    
        ResultSet resultadoSQL;
        try {
            Empresa resEmpresa = new Empresa();
            preparaSQL = SQLConnect.getInstance().prepareStatement(getSelectEmpresa() + 
                    " WHERE `fantasia_emp` = ? AND `cnpj` = ?");
            setEmpresa(empresa, preparaSQL);
            resultadoSQL = preparaSQL.executeQuery();
            while (resultadoSQL.next()) {
                resEmpresa = getEmpresa(resultadoSQL);
                return resEmpresa;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SelectDAO.class.getName()).log(Level.SEVERE, "Não foi possível executar a instrução no Banco de Dados", ex);
        }finally{
            closeAll();
        }
        return null;
    }
        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters"> 
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
    /**
     * @return the selectVooPoltronaLivre
     */
    public static String getSelectVooPoltronaLivre() {
        return selectVooPoltronaLivre;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="ResultSet">  
    
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
    
    private UsuarioCliente getUsuario(ResultSet rs) throws SQLException{
        cliente = new Cliente(rs.getString("cpf_cli"));
        loginCliente = new UsuarioCliente(cliente.getCpfCli());
        loginCliente.setUsuario("usuario");
        loginCliente.setUsuario("senha");
        
        return loginCliente;
    }
    
    private Empresa getEmpresa (ResultSet rs) throws SQLException{
        empresa = new Empresa();
        estado = new Estado();
        empresa.setFantasiaEmp(rs.getString("fantasia_emp"));
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
    
      
    private Empresa getEmpresaCNPJ (ResultSet rs) throws SQLException{
        empresa = new Empresa();
        empresa.setCnpj(rs.getString("cnpj"));
        
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
    
    private UsuarioFuncionario getUsuarioFuncionario(ResultSet rs) throws SQLException{
        funcionario = new Funcionario(rs.getString("cpf_func"));
        loginFuncionario = new UsuarioFuncionario(funcionario.getCpfFunc());
        loginFuncionario.setUsuario("usuario");
        loginFuncionario.setUsuario("senha");
        
        return loginFuncionario;
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
        
        voo.setVooTag(rs.getString("voo_tag"));
        voo.setOrigem(rs.getString("origem"));
        voo.setDestino(rs.getString("destino"));  
        voo.setDtPartida(rs.getDate("dt_partida"));
        voo.setHrPartida(rs.getTime("hr_partida"));
        voo.setCpnjEmp(new Empresa(rs.getString("cnpj_emp")));
        voo.setVlVoo(rs.getLong("vl_voo"));

        return voo;
    }
    
    private VooPoltrona getVooPoltrona (ResultSet rs) throws SQLException{
        statusPoltrona = new Status();
        voo = new Voo();
        poltrona = new VooPoltrona();
        passagem = new Passagem();
        
        poltrona.setIdtbVooPoltrona(rs.getInt("idtb_voo_poltrona"));
        voo.setVooTag(rs.getString("voo_tag"));  poltrona.setVooTag(voo);
        poltrona.setPoltrona(rs.getInt("poltrona"));
        passagem.setPassLocalizador(rs.getString("localizador")); poltrona.setLocalizador(passagem);
        statusPoltrona.setIdStatus(rs.getInt("status"));
        statusPoltrona = getStatusParametros(statusPoltrona);
        poltrona.setStatus(statusPoltrona);
        
        return poltrona;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Dados para cmbEstado e cmbUF"> 
    public List<Estado> getEstadoAll(){
        PreparedStatement preparaSQL;    
        ResultSet resultadoSQL;
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
        PreparedStatement preparaSQL;    
        ResultSet resultadoSQL;
        try {
            List<Status> lstStatus = new ArrayList<>();
            preparaSQL = SQLConnect.getInstance().prepareStatement(getSelectStatus());
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
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Funções herdadas"> 
    @Override
    public void insertDataDB(Object obj) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

    @Override
    public void updateDataDB(Object obj) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
    // </editor-fold>
    
    @Override
    public String getOperacao() {
         return this.operacao;
     }
    
    @Override
    public void setOperacao(String operacao) {
         this.operacao = operacao;
     }
    
}
