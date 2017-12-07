<%@page import="java.util.ArrayList"%>
<%@page import="infotech.model.UsuariosModel"%>
<%@page import="infotech.dao.UsuariosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%
    HttpSession sessao = request.getSession(true);
    String msgSucesso = request.getParameter("sucesso");
    String msgErro = request.getParameter("erro");
%>
<html>
    <head>
        <meta charset="utf-8">
        <title></title>
        <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="./css/estilo.css" rel="stylesheet" type="text/css"/>

        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <%
            request.getSession(true).invalidate();
        %>
        <%
            if (msgSucesso != null) {
                out.println(msgSucesso);
            }
            if (msgErro != null) {
                out.println(msgErro);
            }
        %>    
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
                    <a class="navbar-brand" >InfoTech - OS</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse topo" id="navbar-principal">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="" data-toggle="modal" data-target="#modal-login" ><span class=" btn btn-success btn-block"> Abertura de Ordem de Servico </span> </a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div>
        </nav>

        <!-- depoimentos -->
        <div class="topCasaFina-banner">
            <h1> InfoTech Assistência Técnica </h1>
            <p> Aqui você encontra qualidade e confiança!!  </p>
        </div>
        <section id="depoimentos" class="container">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="img/menu.jpeg" alt=""/>                        
                    </div>
                    <div class="item">
                        <img src="img/menu2.jpeg" alt=""/>
                    </div>
                    <div class="item">
                        <img src="img/menu3.jpeg" alt=""/>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </section>
        <!-- // depoimentos -->
    </div><!-- /.container-fluid -->
</nav>



<section id="nossos-produtos" class="container">
    <h2>Nossos Produtos</h2>

    <div class=" col-sm-6 col-md-4">
        <figure class="thumbnail">
            <img src="img/jbl-charge3.jpg" alt=""/>
            <figcaption class="caption">
                <h3>JBL - charge 3</h3>
                <p>Este é um produto original e garantido pelo fabricante por 12 meses.</p>
            </figcaption>	
        </figure>
    </div>

    <div class=" col-sm-6 col-md-4">
        <figure class="thumbnail">
            <img src="img/capinha.jpg" alt=""/>
            <figcaption class="caption">
                <h3>Capinhas transparente</h3>
                <p>A capinha tem a função de proteger o seu celular sem deixa-lo feio.</p>
            </figcaption>	
        </figure>
    </div>	

    <div class=" col-sm-6 col-md-4">
        <figure class="thumbnail">
            <img src="img/tela.jpg" alt=""/>
            <figcaption class="caption">
                <h3>Troca de Tela</h3>
                <p>Telas originais e garantidas por 90 dias. Qualidade você tem aqui.</p>
            </figcaption>	
        </figure>	
    </div>	

    <div class=" col-sm-6 col-md-4">
        <figure class="thumbnail">
            <img src="img/fone.jpg" alt=""/>
            <figcaption class="caption">
                <h3>Fones de Ouvido</h3>
                <p>Fones de qualidade para ouvir suas musicas no dia a dia!</p>
            </figcaption>	
        </figure>
    </div>

    <div class=" col-sm-6 col-md-4">
        <figure class="thumbnail">
            <img src="img/bateria-portatil.jpeg" alt=""/>
            <figcaption class="caption">
                <h3>Carregador Portatil</h3>
                <p>Carregue seu smatphone em qualquer lugar que estiver!</p>
            </figcaption>	
        </figure>
    </div>	

    <div class=" col-sm-6 col-md-4">
        <figure class="thumbnail">
            <img src="img/mause-teclado.jpeg" alt=""/>
            <figcaption class="caption">
                <h3>Mause e teclado sem fio</h3>
                <p>Telados e mauses sem fio, aqui tem!</p>
            </figcaption>	
        </figure>	
    </div>	
</section>

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

                <div class=" col-sm-6 col-md-4">
                    <!-- sobre nós-->
                    <address>	
                        <h2>Sobre nós</h2>
                        Desde 2017 InfoTech assistência técnica esta no mercado! 
                    </address>
                    <address>
                        Profissional qualificado e atualizado!
                    </address>
                    <address>
                        Atendimendo personalizado do jeito que você cliente merece!
                    </address>
                </div>
                <h2>Seviços Realizados</h2>

                <p>Mais de 100 clientes satisfeitos com os serviços.</p>
                <p>Mais de 500 atendidos no conforto de suas residências.</p>
                <!-- //sobre nós-->
            </div>
        </footer>
    </div>
</div>

<!-- Modal Login-->
<div id="modal-login" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h3 class="modal-title">Login</h3>
            </div>
            <div class="modal-body">
                <form action="./login" method="POST">
                    <div class="form-group">
                        <label for="email">Email </label>
                        <input type="email" class="form-control" id="email" name="email" required="Preencha">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Senha </label>
                        <input type="password" class="form-control" name="pwd" id="pwd" required="">
                    </div>
                    <button type="submit" name="acao" value="entrar" class="btn btn-success btn-block">Entrar</button>
                    <div id="cad-usu" class="text-center">
                        <a class="small mt-3" href="" data-toggle="modal" data-target="#modal-usuario" >Cadastrar novo usuario</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- /Modal Login-->


<!-- Modal Cadastro Usuario-->
<div id="modal-usuario" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h3 class="modal-title">Cadastro de Usuarios</h3>
            </div>
            <div class="modal-body">
                <form action="./usuario" method="POST">

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
                            <button type="submit" name="acao" value="cadastrar" class="btn btn-success btn-block">Cadastrar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="./jquery/jquery.js" type="text/javascript"></script>
<script src="./bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="./bootstrap/js/navbar-animation-fix.js" type="text/javascript"></script>
<!-- /Modal Cadastro Usuario-->

</body>
</html>