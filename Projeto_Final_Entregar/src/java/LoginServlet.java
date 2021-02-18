/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Usuario;

/**
 *
 * @author AI-Dev1
 * Tempo de dev: 15 min
 */
public class LoginServlet extends HttpServlet {    

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
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        boolean logado = false;
        for(Usuario user: Usuario.dados) {
            if(user.getEmail().equals(email) && user.getSenha().equals(senha)){
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getId());
                logado=true;
                
                response.sendRedirect("perfil.jsp");
                break;
            }            
        }
        
        if(!logado){
            response.sendRedirect("index.jsp");
        }
        
    }

 

}
