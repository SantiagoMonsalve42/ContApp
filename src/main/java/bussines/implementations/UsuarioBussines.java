/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines.implementations;

import bussines.interfaces.IUsuarioBussines;
import beans.UsuarioBean;
import data.implementations.UsuarioData;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class UsuarioBussines implements IUsuarioBussines<UsuarioBean> {
    UsuarioData data;

    public UsuarioBussines(){
        this.data = new UsuarioData();
    }
    
  
    public UsuarioBean create(UsuarioBean obj) {
        return this.data.create(obj);
    }

    public UsuarioBean update(UsuarioBean obj) {
        return this.data.update(obj);
    }

    public List<UsuarioBean> get() {
        return this.data.get();
    }

    public UsuarioBean get(int id) {
        return this.data.get(id);
    }

    public Boolean delete(int id) {
        return this.data.delete(id);
    }
    
}
