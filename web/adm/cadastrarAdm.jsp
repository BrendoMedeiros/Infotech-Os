<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title></title>
        <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/estilo.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container">
            <form action="../usuario" method="POST">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="nome">Nome </label>
                        <input type="text" class="form-control" id="nome" name="nome" required="Preencha">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="cpf">CPF </label>
                        <input type="text" class="form-control" id="cpf" name="cpf" required="">
                    </div>

                    <div class="form-group col-md-6">
                        <label for="tel">Telefone </label>
                        <input type="text" class="form-control" id="tel" name="tel" required="">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="end">Endereço </label>
                        <input type="text" class="form-control" id="end" name="end" required="">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="email">Email </label>
                        <input type="text" class="form-control" id="email" name="email" required="Preencha">
                    </div> 

                    <div class="form-group col-md-6">
                        <label for="senha">Senha </label>
                        <input type="password" class="form-control" id="senha" name="senha" required="">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12 text-center">
                        <button type="submit" name="acao" value="cadastrarAdm" class="btn btn-success btn-block">Cadastrar</button>
                    </div>
                </div>
            </form>
        </div>
        <script src="../jquery/jquery.js" type="text/javascript"></script>
        <script src="../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../bootstrap/js/navbar-animation-fix.js" type="text/javascript"></script>
        <!-- /Modal Cadastro de adm-->
    </body>
</html>
