/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Santiago
 */
public class UsuarioBean {
    private int id_usuario;
    private String usuario;
    private String email;
    private String password;
    private String documento;
    private int id_tipo_documento;

    public UsuarioBean(int id_usuario, String usuario, String email, String password, String documento, int id_tipo_documento) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.documento = documento;
        this.id_tipo_documento = id_tipo_documento;
    }
    public UsuarioBean(String usuario, String email, String password, String documento, int id_tipo_documento) {
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.documento = documento;
        this.id_tipo_documento = id_tipo_documento;
    }
    public UsuarioBean(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UsuarioBean() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }
    
    
}
