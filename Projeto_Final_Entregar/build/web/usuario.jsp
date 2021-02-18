<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Usuário</title>
        
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
        
        <jsp:include page = "navbar.jsp" /> 
        
        <div class="container">
            <h1>Cadastro de Novo Usuário</h1>
        
            <form action="UsuarioServlet" method="post">
              <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" name="nome" id="nome" placeholder="Seu Nome">
              </div>
              <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="email@email.com">
              </div>
              <div class="form-group">
                <label for="idade">Idade:</label>
                <input type="text" class="form-control" name="idade" id="idade" placeholder="18">
              </div>
              <div class="form-group">
                <label for="senha">Senha:</label>
                <input type="password" class="form-control" name="senha" id="senha" placeholder="Password">
              </div>
              <div class="form-group">
                <label for="biografia">Biografia:</label>
                <textarea class="form-control" rows="3" name="biografia" id="biografia" placeholder="Sua biografia, sua história"></textarea>
              </div>     

              <a class="btn btn-default" href="index.jsp" role="button">Voltar para o Login</a>
              <button type="submit" class="btn btn-default">Confirmar Novo Usuário</button>

            </form>
        </div>
         
        <jsp:include page = "footer.jsp" /> 
        
        <script src="js/jquery-3.5.1.min.js" ></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
