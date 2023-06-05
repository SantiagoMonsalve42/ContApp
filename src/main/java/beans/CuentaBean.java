/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Santiago
 */
public class CuentaBean {
    private String nombre;
    private String Tipo_Cuenta;

    public CuentaBean(String nombre, String Tipo_Cuenta) {
        this.nombre = nombre;
        this.Tipo_Cuenta = Tipo_Cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_Cuenta() {
        return Tipo_Cuenta;
    }

    public void setTipo_Cuenta(String Tipo_Cuenta) {
        this.Tipo_Cuenta = Tipo_Cuenta;
    }
    
}
