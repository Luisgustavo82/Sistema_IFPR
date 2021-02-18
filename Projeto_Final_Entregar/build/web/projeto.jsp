<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Projeto</title>
        
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>        
        
        <jsp:include page = "navbar.jsp" /> 
        
        <div class="container">
            <h1>Cadastro de Novo Projeto</h1>
        
            <form action="ProjetoServlet" method="post">
              <div class="form-group">
                <label for="titulo">Títutlo:</label>
                <input type="text" class="form-control" name="titulo" id="titulo" placeholder="O Título do Projeto">
              </div>
              <div class="form-group">
                <label for="cliente">Cliente: </label>
                <input type="text" class="form-control" name="cliente" id="cliente" placeholder="Link para o seu cliente">
              </div>
              <div class="form-group">
                <label for="link">Link:</label>
                <input type="text" class="form-control" name="link" id="link" placeholder="Link do seu projeto no GitHub, etc...">
              </div>
              <div class="form-group">
                <label for="imagem">Imagem:</label>
                <input type="text" class="form-control" name="imagem" id="imagem" placeholder="O link de uma imagem ilustrativa">
              </div>
              <div class="form-group">
                <label for="resumo">Resumo:</label>
                <textarea class="form-control" rows="3" name="resumo" id="resumo" placeholder="Descrição do projeto..."></textarea>
              </div>     

              <a class="btn btn-default" href="perfil.jsp" role="button">Voltar para o Perfil</a>
              <button type="submit" class="btn btn-default">Confirmar Novo Projeto</button>

            </form>
        </div>
                
        <jsp:include page = "footer.jsp" /> 
        
        <script src="js/jquery-3.5.1.min.js" ></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
