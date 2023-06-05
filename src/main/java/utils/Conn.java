/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Santiago
 */
public class Conn {
    public ConnectionImpl getConn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return (ConnectionImpl)DriverManager.getConnection("jdbc:mysql://localhost:3306/contapp","root","admin");  
        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
