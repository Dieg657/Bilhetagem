/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guest-nw21sp
 */
public class SQLConnect {
    private static Connection conexao;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static StringBuilder result;
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
                Class.forName(driver);
                result = new StringBuilder(bancoDeDados);
                result.append("?useUnicode=true");
                result.append("&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
                result.append("&serverTimezone=UTC");
                result.append("&zeroDateTimeBehavior=exception");
                conexao = (Connection) DriverManager.getConnection(result.toString(),usuario,senha);
                System.out.println("Conexão criada com o banco de dados!");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage() + "\nHouve um erro de conexão!");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexao;
    }
}
