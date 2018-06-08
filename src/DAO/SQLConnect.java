/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author guest-nw21sp
 */
public class SQLConnect {
    private static Connection conexao;
    
    private static final String bancoDeDados = "jdbc:mysql://localhost:3306/aviao";
    private static final String usuario = "root";
    private static final String senha = "12345";
    
    /**
     *
     * @return
     */
    public static synchronized Connection getInstance(){
        if(conexao == null){
            try {
                conexao = (Connection) DriverManager.getConnection(bancoDeDados,usuario,senha);
                System.out.println("Conexão criada com o banco de dados!");
            } catch (SQLException ex) {
                System.out.println("Houve um erro de conexão!");
            }
        }
        return conexao;
    }
}
