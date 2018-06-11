/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author diego
 */
public final class UpdateDAO extends DAO {
    
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
            "`cpf_cli` = ? ,\n" +
            "`end_cli` = ? ,\n" +
            "`num_cli` = ? ,\n" +
            "`compl_cli` = ? ,\n" +
            "`bairro_cli` = ? ,\n" +
            "`cidade_cli` = ? ,\n" +
            "`idest_cli` = ? ,\n" +
            "`email_cli` = ? ,\n" +
            "`obs_cli` = ? \n" +
            "WHERE `cpf_cli` = ? ";
      
      private static final String updateClienteLogin = "UPDATE `aviao`.`tb_usuario_cli`\n" +
            "SET\n" +
            "`cpf_cli` = ? ,\n" +
            "`usuario` = ? ,\n" +
            "`senha` = ? \n" +
            "WHERE `cpf_cli` = ? ";
      
      private static final String updateFuncionario = "UPDATE `aviao`.`tb_funcionario`\n" +
            "SET\n" +
            "`nm_func` = ?,\n" +
            "`cpf_func` = ? ,\n" +
            "`idtel_func` = ? ,\n" +
            "`email_func` = ? ,\n" +
            "`idsexo_func` = ? ,\n" +
            "`obs_func` = ? ,\n" +
            "`cnpj_emp` = ? \n" +
            "WHERE `cpf_func` = ? ";
      
    private static final String updateFuncionarioLogin = "UPDATE `aviao`.`tb_usuario_func`\n" +
            "SET\n" +
            "`cpf_func` = ? ,\n" +
            "`usuario` = ? ,\n" +
            "`senha` = ? \n" +
            "WHERE `cpf_func` = ?";    
    
    private static final String updateEmpresa = "UPDATE `aviao`.`tb_empresa`\n" +
            "SET\n" +
            "`fantasia_emp` = ? ,\n" +
            "`inest_emp` = ? ,\n" +
            "`cnpj` = ? ,\n" +
            "`end_emp` = ? ,\n" +
            "`num_empresa` = ? ,\n" +
            "`compl_emp` = ? ,\n" +
            "`cidade_emp` = ? ,\n" +
            "`idest_emp` = ? ,\n" +
            "`cep_emp` = ? ,\n" +
            "`email_emp` = ? ,\n" +
            "`obs_emp` = ? \n" +
            "WHERE `cnpj` = ? ";
    
    private static final String updateVoo = "UPDATE `aviao`.`tb_voo`\n" +
            "SET\n" +
            "`voo_tag` = ? ,\n" +
            "`origem` = ? ,\n" +
            "`destino` = ? ,\n" +
            "`dt_partida` = ? ,\n" +
            "`hr_partida` = ? ,\n" +
            "`cpnj_emp` = ? ,\n" +
            "`vl_voo` = ? \n" +
            "WHERE `voo_tag` = ? ";
    
    private static final String updateVooPoltrona = "UPDATE `aviao`.`tb_voo_poltrona`\n" +
            "SET\n" +
            "`voo_tag` = ? ,\n" +
            "`poltrona` =  ? ,\n" +
            "`localizador` = ? ,\n" +
            "`status` = ? \n" +
            "WHERE `poltrona` = ? AND `voo_tag` = ? ";
    
    private static final String updatePassagem = "UPDATE `aviao`.`tb_passagem`\n" +
            "SET\n" +
            "`cpf_passageiro` = ? ,\n" +
            "`pass_bagagem` = ? ,\n" +
            "`pass_localizador` = ? \n" +
            "WHERE `pass_localizador` = ? ";

    /**
     * @return the updateCliente
     */
    private String getUpdateCliente() {
        return updateCliente;
    }

    /**
     * @return the updateClienteLogin
     */
    private String getUpdateClienteLogin() {
        return updateClienteLogin;
    }

    /**
     * @return the updateFuncionario
     */
    private String getUpdateFuncionario() {
        return updateFuncionario;
    }

    /**
     * @return the updateFuncionarioLogin
     */
    private String getUpdateFuncionarioLogin() {
        return updateFuncionarioLogin;
    }

    /**
     * @return the updateEmpresa
     */
    private String getUpdateEmpresa() {
        return updateEmpresa;
    }

    /**
     * @return the updateVoo
     */
    private String getUpdateVoo() {
        return updateVoo;
    }

    /**
     * @return the updateVooPoltrona
     */
    private String getUpdateVooPoltrona() {
        return updateVooPoltrona;
    }

    /**
     * @return the updatePassagem
     */
    private String getUpdatePassagem() {
        return updatePassagem;
    }

    @Override
    public void insertDataDB(Object obj) {
        throw new UnsupportedOperationException("Não é possível inserir numa consulta de atualização"); //To change body of generated methods, choose Tools | Templates.
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
