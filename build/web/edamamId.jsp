<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="./css/style.css" rel="stylesheet" type="text/css">
        <title>${map.title}</title>
    </head>
    <body>
        <div class="fondo"></div>
        <div class="container">
            <%@include file="header.html" %>
                <div class="card border-0">
                    <div class="row justify-content-center pb-3">
                        <div class="card-header b_light_green text-white mt-2 rounded">
                            <span class="card-title text-center arial bold mt-1 f15">${map.title}</span>
                        </div>
                    </div>
                        <object class="mx-auto d-block " data="${map.image}" width="500">
                            <img class="mx-auto d-block " src="./img/no-imagen.jpg" width="500" />
                        </object>
                    
                    <div class="container">
                        <div class="row justify-content-center f14">
                            <div class="col-6  b_light_grey mt-4 ">
                                    <div class="card-title mt-2 arial bold ">Ingredientes</div>

                                    <c:forEach items="${map.recipe}" var="receta" varStatus="in">
                                    <ul class="">                                
                                        <li><p>${receta}</p></li>
                                    </ul>                            
                                    </c:forEach>                            
                            </div>
                            <div class="col-6  b_light_grey  mt-4">
                                <div class="card-title mt-2 arial bold">Información Nutricional</div>
                                <ul >
                                    <li><p>Grasas: <span class="nutrition_span ">${map.totalFAT}g.</span> </p></li>
                                    <li><p>Grasas Saturadas: <span class="nutrition_span ">${map.FASAT}g.</span> </p></li>
                                    <li><p>Grasas Trans: <span class="nutrition_span ">${map.FATRN}g.</span> </p></li>
                                    <li><p>Azúcares: <span class="nutrition_span ">${map.SUGAR}g.</span> </p></li>
                                    <li><p>Fibra: <span class="nutrition_span ">${map.FIBTG}g.</span></p></li>
                                    <li><p>Proteinas: <span class="nutrition_span ">${map.PROCNT}g.</span> </p></li>                                        
                                </ul>                                    
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row p-0 f14">
                            <div class="col-auto b_light_grey pt-2">
                                <div class="card-title mt-2 arial bold pr-3 pl-3">Calorías</div>
                                <p class="text-center light_green">${map.calories}kcal</p>
                            </div>

                            <div class="col-auto b_light_grey pt-2 ">
                                <div class="card-title mt-2 arial bold pr-3 pl-3">Peso</div>
                                <p class="text-center light_green">${map.totalWeight}g</p>
                            </div>                                                       
                        </div>
                    </div>      
                </div>
        </div>
    </body>
</html>
