/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123200147;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 *
 * @author lenovo
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost:3306/movie_db";
    String DBusername = "root";
    String DBpassword = "";
    
    
    String data[] = new String[2];
    Connection conn;
    Statement statement;
    static String [] username;
    public Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Connection Successful");
        }catch(Exception ex){
            System.out.println("Connection Failed " + ex.getMessage() );
        }
}
}