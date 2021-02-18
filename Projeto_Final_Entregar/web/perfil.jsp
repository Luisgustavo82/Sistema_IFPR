<%@page import="modelos.Projeto"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //tenta dar prioridade para o parametro enviado por GET
    String userIdParam = request.getParameter("userId");
    int userId=0;
    boolean logado=false;
    
    if(userIdParam != null){
        userId = Integer.parseInt(userIdParam);
    }else if(session != null && session.getAttribute("userId") != null){
        userId = (int)session.getAttribute("userId");
        logado=true;
    }

    //busca os dados do usuário recebido por parametro ou da sessão
    Usuario user = new Usuario();
    for(Usuario u: Usuario.dados){
        if(u.getId() == userId){
            user = u;
        }
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil de <%=user.getNome()%></title>
        
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/perfil.css">
    </head>
    <body>        
        
        <jsp:include page = "navbar.jsp" /> 
        
        <div class="container">                        
                                      

            <header>
                <h1><%=user.getNome()%></h1>

                <p><%=user.getBiografia()%></p>
            </header> 

            <% if(user.getProjetos() != null){ %>
            <section>                                 

                <h2>Projetos</h2>

                <% for(Projeto p: user.getProjetos()){ %>
                    <section class="card">
                        <h4><%=p.getTitulo()%></h4>

                        <figure>
                            <a href="<%=p.getCliente()%>">
                                <img src="<%=p.getImagem()%>">
                            </a>
                        </figure>

                        <p><%=p.getResumo()%></p>


                        <a class="externo" href="<%=p.getLink()%>">Acesse o Projeto</a>
                    </section>                                    
                <% } %>
            </section>

            <% } else if(logado) { %>

            <a class="btn btn-default" href="projeto.jsp" role="button">Adicione Projetos ao seu Perfil</a>

            <% } %>
            
        </div>
            
        <jsp:include page = "footer.jsp" />   
        
        <script src="js/jquery-3.5.1.min.js" ></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

