/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import DAO.SQLConnect;
import Formulario.Login;
import Utilidades.GerarCidades;
import Formulario.formPrincipal;
import Utilidades.FormUtils;
import Utilidades.GerarDados;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
/**
 *
 * @author diego
 */
public class VendaPassagem {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException, UnsupportedEncodingException, Exception {
        GerarCidades objCidades = new GerarCidades();
        objCidades.criaConexaoCidades();
        
        GerarCidades.caminhoMinimo(objCidades.getCidadesConectadas().get(1), objCidades.getCidadesConectadas().get(9));

        Login form = new Login();
        form.setVisible(true);     
    }
    
}
