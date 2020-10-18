<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="./css/style.css" rel="stylesheet" type="text/css">
        <title>EDAMAM API</title>
    </head>
    <body>
        
        <div class="fondo"></div>
        <!--
        <div class="fondo_comun fondo1"></div>
        <div class="fondo_comun fondo2"></div>
        <div class="fondo_comun fondo3"></div>
        <div class="fondo_comun fondo4"></div>
        <div class="fondo_comun fondo5"></div>
        -->
        
        <div class="container ">
            <%@ include file="header.html"%>
            <div class="row justify-content-center bg-white mx-auto pb-3">
                <div class="col-auto ">
                    <div class="text-center text-white b_light_green p-3 arial bold rounded mt-2 f15">
                        Lista de Recetas de EDAMAM API
                    </div>
                </div>
            </div>
        </div>
        <div class="container ">
            <div class="row bg-white mx-auto ">
                <div class="col-12 col-lg-6" >
                    <div class="row">
                        <ul class="d-flex list-unstyled">
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=ensalada" title="Recetas de ensalada"><img class="img-fluid rounded-circle" src="img/edamam/ensalada-veraniega.jpg"/></a></li>                            
                        </div>
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=pollo" title="Recetas de pollo"><img class="img-fluid rounded-circle" src="img/edamam/pollo.jpg"/></a></li>
                        </div>
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=arroz" title="Recetas de arroz"><img style="max-height:100px" class="img-fluid rounded-circle" src="img/edamam/arroz.jpg"/></a></li>
                        </div>
                    </div>
                    <div class="row">
                        <ul class="d-flex list-unstyled">
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=pasta" title="Recetas de pasta"><img class="img-fluid rounded-circle" src="img/edamam/pasta.jpg"/></a></li>
                        </div>
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=sopa" title="Recetas de sopa"><img class="img-fluid rounded-circle" src="img/edamam/sopa.jpg"/></a></li>
                        </div>
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=revuelto" title="Recetas de revuelto"><img class="img-fluid rounded-circle" src="img/edamam/revuelto_gambas.jpg"/></a></li>
                        </div>
                    </div>
                    <div class="row">
                        <ul class="d-flex list-unstyled">
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=verdura" title="Recetas de verdura"><img class="img-fluid rounded-circle" src="img/edamam/verdura.jpg"/></a></li>
                        </div>
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=pizza" title="Recetas de pizza"><img class="img-fluid rounded-circle pt-2" src="img/edamam/pizza.jpg"/></a></li>
                        </div>
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=pescado" title="Recetas de pescado"><img class="img-fluid rounded-circle" src="img/edamam/pescado.jpg"/></a></li>
                        </div>
                    </div>
                </ul>
                    </div>
                <!--<div class="col-6">
                    <a class="btn btn-secondary btn-block" href="./Edamams?q=ensalada">Ensaladas</a>
                    <a class="btn btn-info btn-block" href="./Edamams?q=pollo">Pollo</a>
                    <a class="btn btn-secondary btn-block" href="./Edamams?q=arroz">Arroz</a>
                    <a class="btn btn-info btn-block" href="./Edamams?q=pasta">Pastas</a>
                    <a class="btn btn-secondary btn-block" href="./Edamams?q=postre">Postres</a>
                    <a class="btn btn-info btn-block" href="./Edamams?q=fruta">Fruta</a>
                    <a class="btn btn-secondary btn-block" href="./Edamams?q=batido">Batidos</a>
                    <a class="btn btn-info btn-block" href="./Edamams?q=sopa">Sopas</a>
                    <a class="btn btn-secondary btn-block" href="./Edamams?q=revuelto">Revueltos</a>
                </div>-->
                
                <div class="col-12 col-lg-6">
                    <div class="row">
                        <ul class="d-flex list-unstyled">
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=helado" title="Recetas de helado"><img class="img-fluid rounded-circle" src="img/edamam/helado-de-mora.jpg"   /></a></li>                            
                        </div>
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=fruta" title="Recetas de fruta"><img class="img-fluid rounded-circle" src="img/edamam/fruta.jpg"  /></a></li>                            
                        </div>
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=tarta" title="Recetas de tarta"><img style="max-height:100px" class="img-fluid rounded-circle" src="img/edamam/tarta.jpg"  /></a></li>
                        </div>
                    </div>
                    <div class="row">
                        <ul class="d-flex list-unstyled">
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=batido" title="Recetas de batido"><img class="img-fluid rounded-circle" src="img/edamam/batido.jpg"  /></a></li>                            
                        </div>
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=cafe" title="Recetas de cafe"><img class="img-fluid rounded-circle" src="img/edamam/cafe.jpg"  /></a></li>                            
                        </div>
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=bizcocho" title="Recetas de bizcocho"><img style="max-height:100px" class="img-fluid rounded-circle" src="img/edamam/bizcocho.jpg"  /></a></li>
                        </div>
                    </div>
                    <div class="row">
                        <ul class="d-flex list-unstyled">
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=pastel" title="Recetas de pastel"><img class="img-fluid rounded-circle" src="img/edamam/pastel.jpg"  /></a></li>                            
                        </div>
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=cupcakes" title="Recetas de cupcakes"><img class="img-fluid rounded-circle" src="img/edamam/cupcakes.jpg"  /></a></li>                            
                        </div>
                        <div class="col-4">
                            <li class="li_edamam_img"><a href="./Edamams?q=mousse" title="Recetas de mousse"><img style="max-height:100px" class="img-fluid rounded-circle" src="img/edamam/mousse.jpg"  /></a></li>
                        </div>
                    </div>
                    <!--<a class="btn btn-secondary btn-block" href="./Edamams?q=bizcocho">Batido</a>
                    <a class="btn btn-info btn-block" href="./Edamams?q=cupcakes">Helados</a>
                    <a class="btn btn-secondary btn-block" href="./Edamams?q=pastel">Ternera</a>
                    <a class="btn btn-info btn-block" href="./Edamams?q=mousse">Sushi</a>
                    <a class="btn btn-secondary btn-block" href="./Edamams?q=pescado">Pescado</a>-->
                </div>
            </div>
        </div>
    </body>
</html>
