/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines.implementations;

import bussines.interfaces.IUsuarioBussines;
import beans.UsuarioBean;
import data.implementations.UsuarioData;
import dto.ResponseDto;
import java.sql.SQLException;
import java.util.List;
import utils.Utilidades;

/**
 *
 * @author Santiago
 */
public class UsuarioBussines implements IUsuarioBussines<UsuarioBean> {
    UsuarioData data;

    public UsuarioBussines(){
        this.data = new UsuarioData();
    }

    @Override
    public ResponseDto<UsuarioBean> create(UsuarioBean obj) {
        UsuarioBean response= null;
        if(this.data.verifyExists(obj)){
            response = this.data.create(obj);
        }
        return new ResponseDto(
                response == null?500:200,
                response != null,
                response != null?"ok":"No se pudo crear el usuario, verifique que el usuario, email o documento no hayan sido registrado antes",
                response);
    }

    @Override
    public ResponseDto<UsuarioBean> update(UsuarioBean obj) {
        UsuarioBean response= null;
        response = this.data.update(obj);
        return new ResponseDto(
                response == null?500:200,
                response != null,
                response != null?"ok":"no se pudo actualizar el usuario",
                response);
    }

    @Override
    public ResponseDto<List<UsuarioBean>> get() {
        List<UsuarioBean> response= null;
        response = this.data.get();
        return new ResponseDto(200,response != null,"ok",response);
    }

    @Override
    public ResponseDto<UsuarioBean> get(int i) {
        UsuarioBean response= null;
        response = this.data.get(i);
        return new ResponseDto(
                response == null?500:200,
                response != null,
                response != null?"ok":"no se pudo obtener el usuario",
                response);
    }

    @Override
    public ResponseDto<UsuarioBean> get(String email) {
        UsuarioBean response= null;
        response = this.data.getByEmail(email);
        return new ResponseDto(
                response == null?500:200,
                response != null,
                response != null?"ok":"no se pudo obtener el usuario",
                response);
    }

    @Override
    public ResponseDto<Boolean> delete(int i) {
        Boolean response= false;
        response = this.data.delete(i);
        return new ResponseDto(
                !response?500:200,
                response,
                response?"ok":"no se pudo eliminar el usuario",
                response);
    }

    @Override
    public ResponseDto<Boolean> login(UsuarioBean obj) {
        UsuarioBean existe= null;
        String message ="OK";
        
        existe = this.data.getByEmail(obj.getEmail());
        if(existe == null){
            message = "No existe el usuario con ese email.";
            return new ResponseDto(404,false,message,false);
        }else{
            if(existe.getPassword().equals(Utilidades.UtilidadesString.getSha256(obj.getPassword()))){
                return new ResponseDto(200,true,message,true);
            }else{
                message = "Usuario o contraseña incorrecta.";
                return new ResponseDto(404,false,message,true);
            }
        }
    }
    
  
   
}
