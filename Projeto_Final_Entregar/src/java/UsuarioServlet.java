/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Usuario;

/**
 *
 * @author AI-Dev1
 * Tempo de dev: 10 min
 */
public class UsuarioServlet extends HttpServlet {

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
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String biografia = request.getParameter("biografia");
        int idade = Integer.parseInt(request.getParameter("idade"));
        
        
        Usuario novo = new Usuario();
        novo.setNome(nome);
        novo.setEmail(email);
        novo.setSenha(senha);
        novo.setBiografia(biografia);
        novo.setIdade(idade);
        novo.setId(Usuario.lastId + 1);
        Usuario.lastId++;
        
        Usuario.dados.add(novo);
        
        HttpSession session = request.getSession();
        session.setAttribute("userId", novo.getId());

        response.sendRedirect("perfil.jsp");
    }

}
