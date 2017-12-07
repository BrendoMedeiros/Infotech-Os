<%@page import="java.util.ArrayList"%>
<%@page import="infotech.model.UsuariosModel"%>
<%@page import="infotech.dao.UsuariosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title></title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://markcell.github.io/jquery-tabledit/assets/css/bootstrap-yeti.min.css" rel="stylesheet" id="theme-file">
        <link href="https://markcell.github.io/jquery-tabledit/assets/css/prettify.min.css" rel="stylesheet">
        <link href="https://markcell.github.io/jquery-tabledit/assets/css/prettify-bootstrap.min.css" rel="stylesheet">
        <link href="https://markcell.github.io/jquery-tabledit/assets/css/font-awesome.min.css" rel="stylesheet">
        <link href="https://markcell.github.io/jquery-tabledit/assets/css/custom.css">
        <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estiloOs.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%          
            String idSessao = request.getSession().getAttribute("idUsuario").toString();
            if (idSessao.equals("")) {
                request.getRequestDispatcher("./index.jsp").forward(request, response);
            }
        %>
        <header>
            <!-- menu -->
            <nav id="bar" class="navbar navbar-default">
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
                            <li><a href="./os.jsp">Abrir outra OS</a></li>
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
                                        %></a>
                            </li>
                            <li><a href="" data-toggle="modal" data-target="#modal-usuario" >Logoff</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </header>

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
        <!-- ordem de serviço-->
        <div class="container">
            <div class="table-responsive">
                <table class="table table-striped table-bordered" id="cadastroDeOs">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Produto</th>
                            <th>Marca</th>
                            <th>Modelo</th>
                            <th>Problema Informado</th>
                            <th>Status</th>
                            <th>Problema Constatado</th>
                            <th>Data</th>
                        </tr>
                    </thead>
                    <tbody id="tbody">     

                    </tbody>
                </table>
            </div>
        </div>

        <script src="./jquery/jquery.js" type="text/javascript"></script>
        <script src="./bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="./bootstrap/js/navbar-animation-fix.js" type="text/javascript"></script>
        <script src="https://markcell.github.io/jquery-tabledit/assets/js/jquery.min.js"></script>
        <script src="https://markcell.github.io/jquery-tabledit/assets/js/bootstrap.min.js"></script>
        <script src="https://markcell.github.io/jquery-tabledit/assets/js/prettify.min.js"></script>
        <script src="https://markcell.github.io/jquery-tabledit/assets/js/tabledit.min.js"></script>

        <script>

            $(document).ready(function () {

                $.ajax({
                    type: 'GET',
                    url: './os?action=listaCadastroDeServico',
                    data: 'data',
                    mimeType: 'json',
                    success: function (retorno) {
                        var dados = retorno.data;
                        $.each(dados, function (i, dados) {
                            var body = "<tr>";
                            body += "<td>" + dados.idOs + "</td>";
                            body += "<td>" + dados.produto + "</td>";
                            body += "<td>" + dados.marca + "</td>";
                            body += "<td>" + dados.modelo + "</td>";
                            body += "<td>" + dados.problema + "</td>";
                            body += "<td>" + dados.status + "</td>";
                            body += "<td>" + dados.probConst + "</td>";
                            body += "<td>" + dados.data + "</td>";

                            body += "<td> <button type=\"button\" onClick=\"abreGerenciadorFotos(" + dados.idOs + ");\" class=\" btn btn-sm btn-default\"><span class=\"glyphicon glyphicon-camera\"></span></button> </td>";
                            body += "</tr>";
                            $("#tbody").append(body);
                        });
                        montaTabela();
                    },
                    error: function (erro) {
                        alert('Fail!-' + erro);
                    }
                });

            });
            function montaTabela() {
                $('#cadastroDeOs').Tabledit({
                    url: './os',
                    columns: {
                        identifier: [0, 'id'],
                        editable: [[1, 'produto'], [2, 'marca'], [3, 'modelo'], [4, 'probInfor'], [5, 'valores', '{"1": "A", "2": "AN", "3": "F"}']]
                    },
                    onDraw: function () {
                        console.log('onDraw()');
                    },
                    onSuccess: function (data, textStatus, jqXHR) {
                        console.log('onSuccess(data, textStatus, jqXHR)');
                        console.log(data);
                        console.log(textStatus);
                        console.log(jqXHR);
                    },
                    onFail: function (jqXHR, textStatus, errorThrown) {
                        console.log('onFail(jqXHR, textStatus, errorThrown)');
                        console.log(jqXHR);
                        console.log(textStatus);
                        console.log(errorThrown);
                    },
                    onAlways: function () {
                        console.log('onAlways()');
                    },
                    onAjax: function (action, serialize) {
                        console.log('onAjax(action, serialize)');
                        console.log(action);
                        console.log(serialize);
                    }
                });
            }

            function abreGerenciadorFotos(id) {

                $("#iframeFotos").attr("src", "./Fotos?idProduto=" + id + "&cmd=listar");
                $("#janelaFotos").modal();
            }
        </script>
    </body>
</html>