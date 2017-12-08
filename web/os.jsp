<%@page import="java.util.ArrayList"%>
<%@page import="infotech.model.UsuariosModel"%>
<%@page import="infotech.dao.UsuariosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
       
        <meta charset="utf-8">
        <title></title>
        <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estiloOs.css" rel="stylesheet" type="text/css"/>

        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>

        <header>
            <!-- menu -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-principal" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand">InfoTech - OS</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse topo" id="navbar-principal">
                        <ul class="nav navbar-nav">
                            <li><a href="./hist.jsp">Historico</a></li>
                            
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a><span class="glyphicon glyphicon-user"></span> 
                                        <%
                                            try {
                                                UsuariosDAO usuDao = new UsuariosDAO();
                                                Integer id = (Integer) request.getSession().getAttribute("idUsuario");
                                                ArrayList<UsuariosModel> usuario = (ArrayList<UsuariosModel>) usuDao.procura(new UsuariosModel(id, null, null));
                                                out.print(usuario.get(0).getNome());
                                                if (usuario.size() > 0) {
                                                }
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                            }
                                        %>
                                </a>
                            </li>
                            <li><a href="" data-toggle="modal" data-target="#modal-usuario" >Logoff</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
        </header>

        <!-- ordem de serviço-->
        <div class="container">
            <form action="./os" method="POST">
                <div class="row">
                    <div class="form-group col-md-8">
                        <label for="prod">Produto</label>
                        <input type="text" class="form-control" id="prod" name="prod" required="Preencha">
                    </div>

                    <div class="form-group col-md-4">
                        <label for="marca">Marca</label>
                        <input type="text" class="form-control" id="marca" name="marca" required="">
                    </div>

                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="modelo">Modelo</label>
                        <input type="text" class="form-control" id="modelo" name="modelo" required="">
                    </div>

                    <div class="form-group col-md-4">
                        <label for="status">Status</label>
                        <!--<select type="text" class="form-control" id="status" name="status" required="">-->


                        <select type="text" class="form-control" id="status" name="status" required="">
                            <!--<select name="status">-->
                            <option value="aberto">A</option>
                            <option value="em andamento">AN</option>
                            <option value="finalizado">F</option>
                        </select>

                    </div>

                    <div class="form-group col-md-4">
                        <data for="data">Data</data> 
                        <input type="date" class="form-control" id="data" name="data" required="">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="probInfor">Problema Informado</label>
                        <textarea rows="6" type="text" class="form-control" id="probInfor" name="probInfor" required=""></textarea>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12 text-center">
                        <button type="submit" name="action" value="registrar" class="btn btn-success btn-block">Registrar</button>
                    </div>
                </div>
            </form>
        </div>


        <div class="row">
            <div class="container">
                <footer>
                    <div class="container">
                        <!-- endereço-->
                        <div class=" col-sm-6 col-md-4">
                            <address>	
                                <h2>Contato</h2>
                                <strong>InfoTech Assistência Técnica</strong><br>
                                Rua Mestre Fulgêncio, 2, Vila Floresta<br>
                                Inhumas, GO<br>
                                Tel: (62) 98431-0871 ou 98179-3747
                            </address>
                            <address>
                                E-mail: bc_1693@hotmail.com
                            </address>
                            <!-- //endereço-->
                        </div>
                        <!-- //sobre nós-->
                    </div>
                </footer>
            </div>
        </div>

        <!-- Modal logoff-->
        <div id="modal-usuario" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Sair</h3>

                        <p> Tem certeza de que deseja sair do seu usuario? </p>
                        <div class="form-group col-md-6 text-left">
                            <a role="button" aria-disabled="true" href="./principalOs.jsp" class="btn btn-success">Sair</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- /logoff-->

        <script src="./jquery/jquery.js" type="text/javascript"></script>
        <script src="./bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="./bootstrap/js/navbar-animation-fix.js" type="text/javascript"></script>
    </body>
</html>