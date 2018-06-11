/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.ClassesDB.*;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author diego
 */
public class InsertDAO extends DAO{
    
    public InsertDAO(){
        // do nothing
    }
    
        
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
            "`idtel_func`,\n" +
            "`email_func`,\n" +
            "`idsexo_func`,\n" +
            "`obs_func`,\n" +
            "`cnpj_emp`)\n" +
            "VALUES\n" +
            "( ? ,\n" +
            " ? ,\n" +
            " ? >,\n" +
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
    private static final String insertVoo = "INSERT INTO `aviao`.`tb_voo`\n" +
            "(`voo_tag`,\n" +
            "`origem`,\n" +
            "`destino`,\n" +
            "`dt_partida`,\n" +
            "`hr_partida`,\n" +
            "`cpnj_emp`,\n" +
            "`vl_voo`)\n" +
            "VALUES\n" +
            "( ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? )";
    private static final String insertVooPoltrona = "INSERT INTO `aviao`.`tb_voo_poltrona`\n" +
            "(`voo_tag`,\n" +
            "`poltrona`,\n" +
            "`localizador`,\n" +
            "`status`)\n" +
            "VALUES\n" +
            "( ? ,\n" +
            " ? ,\n" +
            " ? ,\n" +
            " ? )";
    
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
            "`num_empresa`,\n" +
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
    
    private void setCliente(Cliente cliente) throws SQLException{
        preparaSQL.setString(1, cliente.getNmCli());
        preparaSQL.setString(2, cliente.getDocCli());
        preparaSQL.setString(3, cliente.getOrgCli());
        preparaSQL.setInt(4, cliente.getIdufCli().getIdEstado());
        preparaSQL.setDate(5, (Date) cliente.getDtnascCli());
        preparaSQL.setLong(6, cliente.getCpfCli());
        preparaSQL.setString(7, cliente.getEndCli());
        preparaSQL.setString(8, cliente.getNumCli());
        preparaSQL.setString(9, cliente.getComplCli());
        preparaSQL.setString(10, cliente.getBairroCli());
        preparaSQL.setString(11, cliente.getCidadeCli());
        preparaSQL.setInt(12, cliente.getIdestCli().getIdEstado());
        preparaSQL.setString(13, cliente.getEmailCli());
        preparaSQL.setString(14, cliente.getObsCli());
    }
    
    private void setEmpresa(Empresa empresa) throws SQLException{
        preparaSQL.setString(1,empresa.getFantasiaEmp());
        preparaSQL.setString(2,empresa.getInestEmp());
        preparaSQL.setLong(3,empresa.getCnpj());
        preparaSQL.setString(4,empresa.getEndEmp());
        preparaSQL.setString(5,empresa.getNumEmpresa());
        preparaSQL.setString(6,empresa.getComplEmp());
        preparaSQL.setString(7,empresa.getCidadeEmp());
        preparaSQL.setInt(8,empresa.getIdestEmp().getIdEstado());
        preparaSQL.setInt(9,empresa.getCepEmp());
        preparaSQL.setString(10,empresa.getEmailEmp());
        preparaSQL.setString(11,empresa.getObsEmp());
    }
    
    private void setFuncionario(Funcionario funcionario) throws SQLException{
        preparaSQL.setString(1, funcionario.getNmFunc());
        preparaSQL.setLong(2, funcionario.getCpfFunc());
        preparaSQL.setLong(3, funcionario.getTelFunc());
        preparaSQL.setString(4, funcionario.getEmailFunc());
        preparaSQL.setInt(5, funcionario.getIdsexoFunc());
        preparaSQL.setString(6, funcionario.getObsFunc());
        preparaSQL.setLong(7, funcionario.getCnpjEmp().getCnpj());
    }
    
    private void setPassagem(Passagem passagem) throws SQLException{
        preparaSQL.setLong(1, passagem.getCpfPassageiro().getCpfCli());
        preparaSQL.setInt(2, passagem.getPassBagagem());
        preparaSQL.setString(3, passagem.getPassLocalizador());
    }
    
    private void setVooPoltrona(VooPoltrona poltrona) throws SQLException{
        preparaSQL.setString(1, poltrona.getVooTag().getVooTag());
        preparaSQL.setInt(2, poltrona.getPoltrona());
        preparaSQL.setString(3, poltrona.getLocalizador().getPassLocalizador());
        preparaSQL.setString(4, poltrona.getStatus().getStatus());
    }
    
    private void setVoo(Voo voo) throws SQLException{
        preparaSQL.setString(1, voo.getVooTag());
        preparaSQL.setString(2, voo.getOrigem());
        preparaSQL.setString(3, voo.getDestino());
        preparaSQL.setDate(4, (Date) voo.getDtPartida());
        preparaSQL.setTime(5, (Time) voo.getHrPartida());
        preparaSQL.setLong(6, voo.getCpnjEmp().getCnpj());
        preparaSQL.setLong(7, voo.getVlVoo());
    }
}
