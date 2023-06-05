/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.implementations;

import data.interfaces.IUsuarioData;
import beans.UsuarioBean;
import bussines.interfaces.IUsuarioBussines;
import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Conn;
import utils.Utilidades.UtilidadesString;

/**
 *
 * @author Santiago
 */
public class UsuarioData implements IUsuarioData{
    public ConnectionImpl con;
    public UsuarioData(){
        
    }
    public void OpenConnection(){
        Conn con = new Conn();
        this.con = con.getConn();
    }
    @Override
    public UsuarioBean create(UsuarioBean obj) {
        this.OpenConnection();
        PreparedStatement stmt;  
        UsuarioBean userResponse=null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbl_usuario (usuario,email,PASSWORD,documento,id_tipo_documento) VALUES (?,?,?,?,?)");
            stmt.setString(1, obj.getUsuario());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, UtilidadesString.getSha256(obj.getPassword()));
            stmt.setString(4, obj.getDocumento());
            stmt.setInt(5,obj.getId_tipo_documento());
            int count = stmt.executeUpdate();
            userResponse=(count > 0)?obj:null;
            con.close();  
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR MESSAGE: "+ex.getMessage());
        } catch(Exception ex){
            System.out.println("ERROR MESSAGE: "+ex.getMessage());
        } finally {
            
            return userResponse;
        }
    }

    @Override
    public UsuarioBean update(UsuarioBean obj) {
        this.OpenConnection();
        PreparedStatement stmt;  
        UsuarioBean userResponse=null;
        try {
            stmt = con.prepareStatement("UPDATE tbl_usuario SET PASSWORD = ? VALUES WHERE ID_USUARIO = ?");
            stmt.setString(1, UtilidadesString.getSha256(obj.getPassword()));
            stmt.setInt(5,obj.getId_usuario());
            int count = stmt.executeUpdate();
            userResponse=(count > 0)?obj:null;
            con.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR MESSAGE: "+ex.getMessage());
        } catch(Exception ex){
            System.out.println("ERROR MESSAGE: "+ex.getMessage());
        }finally{
             
           return userResponse; 
        }
        
    }

    @Override
    public List<UsuarioBean> get() {
      this.OpenConnection();
      List<UsuarioBean> resul = null;
      String query = "SELECT * FROM tbl_usuario";
      Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
              int id = rs.getInt("id_usuario");
              String usuario = rs.getString("usuario");
              String email = rs.getString("email");
              String documento = rs.getString("documento");
              int id_tipo_documento = rs.getInt("id_tipo_documento");
              UsuarioBean user= new UsuarioBean(id,usuario,email,null,documento,id_tipo_documento);
              resul.add(user);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            return resul;
        }
        
    }

    @Override
    public UsuarioBean get(int id_usuario) {
      this.OpenConnection();
      UsuarioBean resul = null;
      String query = "SELECT * FROM tbl_usuario where id_usuario = "+id_usuario;
      Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
              int id = rs.getInt("id_usuario");
              String usuario = rs.getString("usuario");
              String email = rs.getString("email");
              String documento = rs.getString("documento");
              int id_tipo_documento = rs.getInt("id_tipo_documento");
              UsuarioBean user= new UsuarioBean(id,usuario,email,null,documento,id_tipo_documento);
              resul = user;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            return resul;
        }
    }

    @Override
    public Boolean delete(int id) {
        this.OpenConnection();
        PreparedStatement stmt;  
        Boolean userResponse=false;
        try {
            stmt = con.prepareStatement("delete tbl_usuario WHERE ID_USUARIO = ?");
            stmt.setInt(1,id);
            userResponse = stmt.execute();
            con.close();  
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR MESSAGE: "+ex.getMessage());
        } catch(Exception ex){
            System.out.println("ERROR MESSAGE: "+ex.getMessage());
        }finally{
            
           return userResponse; 
        }
    }

    @Override
    public UsuarioBean getByEmail(String email) {
        this.OpenConnection();
        UsuarioBean resul = null;
        String query = "SELECT * FROM tbl_usuario where email = '"+email+"'";
        Statement st;
          try {
             st = con.createStatement();
              ResultSet rs = st.executeQuery(query);
              while (rs.next())
              {
                int id = rs.getInt("id_usuario");
                String usuario = rs.getString("usuario");
                String emailrp = rs.getString("email");
                String documento = rs.getString("documento");
                String password = rs.getString("password");
                int id_tipo_documento = rs.getInt("id_tipo_documento");
                UsuarioBean user= new UsuarioBean(id,usuario,emailrp,password,documento,id_tipo_documento);
                resul = user;
              }
              st.close();
          } catch (SQLException ex) {
              Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
          }finally{
              
              return resul;
          }
    }
    
    @Override
    public Boolean verifyExists(UsuarioBean obj) {
        this.OpenConnection();
        int records=0;
        PreparedStatement stmt;  
        UsuarioBean userResponse=null;
        
        try {
            con.createStatement();
            stmt = con.prepareStatement("select count(1) from tbl_usuario where usuario = ? or email = ? or documento = ?");
            stmt.setString(1, obj.getUsuario());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getDocumento());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                records = rs.getInt(1);
            }
             con.close(); 
        } catch (SQLException ex) {
            con.close();
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR MESSAGE: "+ex.getMessage());
        } catch(Exception ex){
            System.out.println("ERROR MESSAGE: "+ex.getMessage());
        } finally {
            return (records == 0);
        }
    }
    
}
