/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import beans.CuentaBean;
import bussines.implementations.CuentaBussines;
import com.google.gson.Gson;
import dto.ResponseDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago
 */
@WebServlet(name = "Cuenta", urlPatterns = {"/Cuenta"})
public class Cuenta extends HttpServlet {
    CuentaBussines objBussines;
    public Cuenta() {
        this.objBussines = new CuentaBussines();
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
        if("GET_ACCOUNTS".equals(tipo)){
            this.getAccountsByEmail(request, response);
        }
    }
    public void getAccountsByEmail(HttpServletRequest request, HttpServletResponse response){
            try {
                String mail = request.getParameter("mail");
                ResponseDto<ArrayList<CuentaBean>> resultado = this.objBussines.getCuentasByEmail(mail);
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
