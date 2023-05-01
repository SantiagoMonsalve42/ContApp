/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines.interfaces;

import beans.UsuarioBean;
import java.util.List;

/**
 *
 * @author Santiago
 */
public interface IUsuarioBussines <UsuarioBean>{
    UsuarioBean create(UsuarioBean obj);
    UsuarioBean update(UsuarioBean obj);
    List<UsuarioBean> get();
    UsuarioBean get(int id);
    Boolean delete(int id);
}
