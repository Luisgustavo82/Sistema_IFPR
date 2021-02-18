<%-- 
    Document   : index
    Created on : 15/12/2020, 12:09:57
    Author     : AI-Dev1
    Tempo de dev: 15 min
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrar</title>
        
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>    
        
        <jsp:include page = "navbar.jsp" /> 
        
        <div class="container">
            
            <h1>Login do Usuário</h1>

                <form action="LoginServlet" method="post">
                  <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" id="email" placeholder="Email">
                  </div>
                  <div class="form-group">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" name="senha" id="senha" placeholder="Password">
                  </div>
                    
                  <a class="btn btn-default" href="usuario.jsp" role="button">Cadastrar Novo Usuário</a>
                  <a class="btn btn-default" href="LoginSerlet.jata" role="button">Entrar na Plataforma</a>
                  
                </form>
                
            
        </div>        
        
        <jsp:include page = "footer.jsp" /> 
        
        <script src="js/jquery-3.5.1.min.js" ></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
