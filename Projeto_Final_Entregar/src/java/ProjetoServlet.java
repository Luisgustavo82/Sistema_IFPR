/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Projeto;
import modelos.Usuario;

/**
 *
 * @author AI-Dev1
 * Tempo de dev: 10 min
 */
public class ProjetoServlet extends HttpServlet {

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
        
        HttpSession session = request.getSession();        
        if(session != null && session.getAttribute("userId") != null){
                    
            //encontra o usuario
            int userId = (int) session.getAttribute("userId");            
            Usuario user = new Usuario();
            for(Usuario u: Usuario.dados){
                if(u.getId() == userId){
                    user = u;
                    break;
                }
            }
            
            //obtem os dados do projeto
            String titulo = request.getParameter("titulo");
            String resumo = request.getParameter("resumo");
            String cliente = request.getParameter("cliente");
            String link = request.getParameter("link");
            String imagem = request.getParameter("imagem");

            //adicionar novo projeto à lista de dados
            Projeto p = new Projeto();
            p.setId(Projeto.lastId + 1);
            Projeto.lastId++;
            p.setTitulo(titulo);
            p.setResumo(resumo);
            p.setCliente(cliente);
            p.setLink(link);
            p.setImagem(imagem);
            
            //os projetos estão gravados dentro do objeto Usuario
            if(user.getProjetos() == null){
                user.setProjetos(new ArrayList(0));
            }
            
            user.getProjetos().add(p);
            
            response.sendRedirect("perfil.jsp");
            
        } else {
            response.sendRedirect("index.jsp");
        }
        
    }


}
