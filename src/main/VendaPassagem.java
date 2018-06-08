/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import DAO.SQLConnect;
import Utilidades.GerarCidades;
import Formulario.formPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author diego
 */
public class VendaPassagem {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        GerarCidades objCidades = new GerarCidades();
        objCidades.criaConexaoCidades();
        
        objCidades.caminhoMinimo(objCidades.getCidadesConectadas().get(1), objCidades.getCidadesConectadas().get(9));
        
        formPrincipal form = new formPrincipal();
        form.setVisible(true);
        
        SQLConnect.getInstance();
        String sql = "SELECT * FROM tb_status";
        Statement stmt = SQLConnect.getInstance().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()) {            
            System.out.println("ID: " + rs.getInt("id_status") + ", Status: " + rs.getString("status"));
        }
        
        
        /*
        FactoryPessoa factory = new FactoryPessoa();
        Pessoa pessoa;
        
        String nome = "Aline dos Santos Soares";
        String sexo = "Masculino";
        
        try {
            pessoa = factory.getPessoa(nome, sexo);
            System.out.println("O sexo do passageiro é: " + pessoa.getSexo());
        } catch (Exception excep) {
            System.out.println(excep.getMessage());
        }*/
    }
    
}
