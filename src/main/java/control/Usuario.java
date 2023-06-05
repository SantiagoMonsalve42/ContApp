/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import beans.UsuarioBean;
import bussines.implementations.UsuarioBussines;
import com.google.gson.Gson;
import dto.ResponseDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 *
 * @author Santiago
 */
@WebServlet(name = "Usuario", urlPatterns = {"/usuario"})
public class Usuario extends HttpServlet {
    UsuarioBussines objBussines;
    public Usuario() {
        this.objBussines = new UsuarioBussines();
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("TIPO_ACCION");
        switch(tipo){
            case "GETBYEEMAIL":
                   this.getMyEmail(request, response);
                 break;
            default:
                break;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String tipo = request.getParameter("TIPO_ACCION");
        if("REGISTRO".equals(tipo)){
            this.registro(request, response);
        }else{
            this.login(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public void registro(HttpServletRequest request, HttpServletResponse response){
        try {
            String documento = request.getParameter("documento");
            String tipo_documento = request.getParameter("tipo_documento");
            String user = request.getParameter("user");
            String mail = request.getParameter("mail");
            String pass = request.getParameter("pass");
            UsuarioBean objReq = new UsuarioBean(user,mail,pass,documento,Integer.parseInt(tipo_documento));
            ResponseDto<UsuarioBean> resultado = this.objBussines.create(objReq);
            String responseString = new Gson().toJson(resultado);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(responseString);
            out.flush();
           
        }catch(Exception e){
            System.out.println(e);
        } 
    }
    public void getMyEmail(HttpServletRequest request, HttpServletResponse response){
       try {
            String email = request.getParameter("email");
            ResponseDto<UsuarioBean> resultado = this.objBussines.get(email);
            String responseString = new Gson().toJson(resultado);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(responseString);
            out.flush(); 
        }catch(Exception e){
            System.out.println(e);
        } 
    }
     public void login(HttpServletRequest request, HttpServletResponse response){
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("pass");
            UsuarioBean objReq = new UsuarioBean(email,password);
            ResponseDto<Boolean> resultado = this.objBussines.login(objReq);
            String responseString = new Gson().toJson(resultado);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(responseString);
            out.flush(); 
        }catch(Exception e){
            System.out.println(e);
        } 
    }
}
