<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="./css/style.css" rel="stylesheet" type="text/css">
        <title>${comic.getTitle()}</title>
    </head>
    <body>
        <div class="fondo">
            <div class="marvel">
                
            </div>
        </div>
        <div class="container">
            <%@include file="header.html" %>
        </div>
        <div class="container">
                <div class="card border-0 ">
                    <div class="row justify-content-center pb-3">
                        <div class="card-header b_light_blue text-white mt-2 rounded">
                            <span class="card-title  text-center arial bold  mt-1 f15">${comic.getTitle()}</span>
                        </div>
                    </div>
                    
                        <object class="mx-auto d-block " data="${comic.getThumbnail().getPath()}/landscape_incredible.${comic.getThumbnail().getExtension()}" >
                            <img class=" mx-auto d-block " src="./img/no-imagen.jpg" width="500" />
                        </object>
                    
                    <div class="container">
                        <div class="row ">
                            <div class="col-12  b_light_grey mt-4">
                                <div class="card-title mt-2 arial bold f15">Descripción</div>
                                <div class="card-body text-justify">
                                    <p class="arial f15">${comic.getDescription()}</p>
                                </div>
                                                              
                            </div>
                            
                        </div>
                    </div>
                    <div class="container">
                        <div class="row p-0 b_light_grey f14">
                            <div class="col-auto fondo_blanco arial mt-4 text-white border_dark_grey">
                                <div class="card-title  mt-2  bold pr-3 pl-3 text-dark ">ISBN</div>
                                <p class="light_green ">${comic.getIsbn()}</p>
                            </div>

                            <div class="col-auto fondo_blanco arial  mt-4 text-white border_dark_grey">
                                <div class="card-title   mt-2  bold pr-3 pl-3 text-dark ">FORMATO</div>
                                    <p class="light_green">${comic.getFormat()}</p>
                            </div>
                            <div class="col-auto fondo_blanco arial text-white mt-4 border_dark_grey">
                                <div class="card-title mt-2  bold pr-3 pl-3 text-dark">SERIE</div>
                                    <p class="light_green ">${comic.getSeries().getName()}</p>
                            </div>
                            <div class="col-auto fondo_blanco arial text-white mt-4 border_dark_grey">
                                <div class="card-title mt-2  bold pr-3 pl-3 text-dark">PRECIO</div>
                                    <p class="light_green">$${comic.getPrices()[0].getPrice()}</p>
                            </div>                            
                        </div>
                    </div>      
                </div>
        </div>
    </body>
</html>
