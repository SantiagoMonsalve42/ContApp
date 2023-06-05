/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines.implementations;

import beans.CuentaBean;
import bussines.interfaces.ICuentaBussines;
import data.implementations.CuentaData;
import dto.ResponseDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class CuentaBussines implements ICuentaBussines {

    CuentaData data;

    public CuentaBussines(){
        this.data = new CuentaData();
    }
    @Override
    public ResponseDto<ArrayList<CuentaBean>> getCuentasByEmail(String email) {
        List<CuentaBean> response = this.data.getCuentasByEmail(email);
        return new ResponseDto(
                response == null?201:200,
                response != null,
                response != null?"ok":"no content",
                response);
    }

    
    
}
