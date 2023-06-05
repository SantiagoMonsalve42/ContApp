/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.implementations;

import beans.CuentaBean;
import com.mysql.cj.jdbc.ConnectionImpl;
import data.interfaces.ICuentaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Conn;

/**
 *
 * @author Santiago
 */
public class CuentaData implements ICuentaData{

    public ConnectionImpl con;
    public CuentaData(){
        
    }
    public void OpenConnection(){
        Conn con = new Conn();
        this.con = con.getConn();
    }
    @Override
    public ArrayList<CuentaBean> getCuentasByEmail(String email) {
        this.OpenConnection();
        ArrayList<CuentaBean> resul = new ArrayList<>();
        String query = "SELECT c.NOMBRE nombre, tc.DESCRIPCION tipo_cuenta " +
                        "FROM tbl_cuenta c " +
                        "JOIN tbl_tipo_cuenta tc ON c.ID_TIPO_CUENTA = tc.ID_TIPO_CUENTA " +
                        "JOIN tbl_usuario u ON u.ID_USUARIO = c.ID_USUARIO " +
                        "WHERE u.EMAIL = ?";
        PreparedStatement st;  
        try {
            st = con.prepareStatement(query);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
              String nombre = rs.getString("nombre");
              String tcuenta = rs.getString("tipo_cuenta");
              CuentaBean account= new CuentaBean(nombre,tcuenta);
              resul.add(account);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
        }          
        return resul;
        
    }

    
    
}
