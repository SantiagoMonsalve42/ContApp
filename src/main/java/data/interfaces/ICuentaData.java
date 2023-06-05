/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.interfaces;

import beans.CuentaBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago
 */
public interface ICuentaData {
    ArrayList<CuentaBean> getCuentasByEmail(String email);
}
