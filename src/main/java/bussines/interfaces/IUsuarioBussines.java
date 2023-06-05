/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines.interfaces;

import beans.UsuarioBean;
import dto.ResponseDto;
import java.util.List;

/**
 *
 * @author Santiago
 */
public interface IUsuarioBussines <UsuarioBean>{
    ResponseDto<UsuarioBean> create(UsuarioBean obj);
    ResponseDto<UsuarioBean> update(UsuarioBean obj);
    ResponseDto<List<UsuarioBean>> get();
    ResponseDto<UsuarioBean> get(int id);
    ResponseDto<UsuarioBean> get(String email);
    ResponseDto<Boolean> delete(int id);
    ResponseDto<Boolean> login(UsuarioBean obj);
}
