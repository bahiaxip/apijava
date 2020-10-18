<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.LinkedHashMap"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="./css/style.css" rel="stylesheet" type="text/css">
        <title>Recetas de ${selected} </title>
    </head>
    <body>
        <div class="fondo"></div>
        <div class="container">
            <%@ include file="header.html"%>  
            <div class="row justify-content-center pb-3">
                <div class="col-auto ">
                    <div class="text-center text-white b_light_green p-3 arial bold rounded mt-2 f15">
                    Lista de Recetas de EDAMAM API
                    </div>
                </div>
            </div>
        </div>
        <div class="container ">
            <% 
            //asignamos datos para la paginación en el arraylist pagination
            LinkedHashMap<String,Integer> datosPage=(LinkedHashMap<String,Integer>)request.getAttribute("page");
            ArrayList<Integer> pagination=new ArrayList();
            for(String dat:datosPage.keySet()){
                pagination.add(datosPage.get(dat));
            }
            String from=request.getAttribute("from").toString();
            int contador=0;
            int contadorCard=0;
            %>
            <div class="row justify-content-center ">
            <c:forEach items="${dato}" var="receta">
                <c:set value="${receta.recipe}" var="rece"/>
                    <% if(contadorCard%3==0){%>
                        <div class="card-group ">
                    <%
                    }                    
                    %>
                            <div class="card ">
                                <form action="./EdamamId" id="form_recipe" method="POST">
                                    <div class="hidden">
                                        <input type="hidden" name="recipe" id="recipe" value="${receta.recipe.ingredients}"/>
                                            
                                        
                                        <input type="hidden" name="title" value="${receta.recipe.label}"/>
                                        <input type="hidden" name="image" value="${receta.recipe.image}"/>
                                        <input type="hidden" name="calories" value="${receta.recipe.calories}"/>
                                        <input type="hidden" name="total_fat" value="${receta.recipe.totalNutrients.FAT.quantity}"/>
                                        <input type="hidden" name="saturated" value="${receta.recipe.totalNutrients.FASAT.quantity}"/>
                                        <input type="hidden" name="trans" value="${receta.recipe.totalNutrients.FATRN.quantity}"/>
                                        <input type="hidden" name="sugar" value="${receta.recipe.totalNutrients.SUGAR.quantity}"/>
                                        <input type="hidden" name="fiber" value="${receta.recipe.totalNutrients.FIBTG.quantity}"/>
                                        <input type="hidden" name="protein" value="${receta.recipe.totalNutrients.PROCNT.quantity}"/>
                                        <input type="hidden" name="total_weight" value="${receta.recipe.totalWeight}"/>
                                    </div>
                                <a  class="a_card_edamam" style="text-decoration:none" href="javascript:void(0)" onclick="this.parentNode.submit()" >
                                    <div class="card-header card_edamam">
                                        <div class="card-title text-center ">
                                            <p class="text_limit arial mt-1 bold f15" >${receta.recipe.label}</p>
                                        </div>
                                    </div>
                                    <div class="card-body text-center img_card_edamam">


                                        <object data="${receta.recipe.image}" width="300" height="250" type="image/jpg">
                                            <img src="./img/no-imagen.jpg" width="300" height="250">
                                        </object>
                                            <%-- anulado --%>
                                        <%-- para la imagen se puede hacer añadiendo un class con 
                                        una imagen por defecto en CSS pero aparece el icono "notfound" y 
                                        al colocar el alt="" pierde la anchura y altura --%>
                                        <%--<c:set var="im"  value="${receta.recipe.image}"/>--%>
                                        <%--<c:choose>
                                            <c:when test="${receta.recipe.image==null}">                                    
                                                <img src="./img/no-imagen.jpg" width="300" height="250"/>
                                            </c:when>
                                            <c:otherwise>
                                                <img src="${receta.recipe.image}" class="noimage" width="300" height="250"/>
                                            </c:otherwise>
                                        </c:choose>--%>
                                    </div>
                                </a>
                                </form>
                            </div>
                    <% if(contadorCard%3==0){%>
                        </div>
                    <%
                    }
                    contadorCard++;
                    %>
                        
                
            </c:forEach>
            </div>
                
                      
            <div class="col mt-3 pt-2 mb-3 pb-3">
                <ul class="pagination">
            <% 
            String bol="true";
            for(int i=1;i<pagination.get(0);i++){
            %>  
                  <%-- al ser tantas páginas solo se muestran 40 registros más y menos (4 por delante y por detrás)
                        de la página actual, el resto de páginas se sustituye por puntos suspensivos --%>  
                  <%-- 
                        
                  --%>
                <%
                    /* condición para comprobar si existen más de 4 páginas por delante o existen más de 4 páginas por detrás 
                    de la página actual*/
                    if(Integer.parseInt(from)+(pagination.get(4)*4)<=contador && contador<pagination.get(0)
                            || Integer.parseInt(from)-(pagination.get(4)*4)>=contador ){
                        /* bol obliga pasar la condición una vez y esperar a pasar por el else para volver a entrar */
                        if(bol=="true"){
                            /*se comprueba si no se está situado en la trasantepenúltima página ya que con ésta se repite la última página (o penúltima si existe resto) después de los puntos suspensivos, de esta forma evitamos la repetición y la muestra de los puntos suspensivos*/
                            if(Integer.parseInt(from)+(pagination.get(4)*4)!=pagination.get(3)){
                                /*si existen más de 4 páginas por delante se muestra el enlace de la primera página*/
                                if(Integer.parseInt(from)-(pagination.get(4)*4)>=contador){                             
                                %>
                                    <li class="page-item" >
                                        <a class="page-link"  href="./Edamams?q=${selected}&from=0"><%=i%></a>
                                    </li>
                                <%}
                                /*  */
                            %>                           
                                &nbsp;<li class="page-item disabled">
                                ...
                                </li>&nbsp;                            

                            <%
                                /*si existen más de 4 páginas por detrás se muestra el enlace de la última página (o penúltima si existe resto)*/
                                if(Integer.parseInt(from)+(pagination.get(4)*4)<=contador && contador<pagination.get(0)){

                                    /*evitamos linkear la página actual*/
                                    if(Integer.parseInt(from)==(i-1)*pagination.get(4)){%>
                                    <li class="page-item" >
                                        <span class="page-link"><%=i%></span>
                                    </li>
                                    <%
                                    }else{
                                    %>
                                    <li class="page-item " >
                                        <a class="page-link"  href="./Edamams?q=${selected}&from=<%=pagination.get(0)-(pagination.get(4)+pagination.get(2))%>"><%=pagination.get(3)/pagination.get(4)%></a>
                                    </li>
                                    <%      
                                    }
                                    
                                }
                            }
                        }
                        bol="false";
                    }else{
                        bol="true";
                        if(i<=pagination.get(1)){
                            /*evitamos linkear la página actual*/
                            if(Integer.parseInt(from)==(i-1)*pagination.get(4)){%>
                                <li class="page-item" >
                                    <span class="page-link"><%=i%></span>
                            </li>
                            <%
                            }else{
                        %>  
                                <li class="page-item">
                                    <a class="page-link"  href="./Edamams?q=${selected}&from=<%=contador%>"><%=i%></a>
                                </li>

                        <%  }   
                        }           
                    }
                    contador=contador+pagination.get(4);
                    %>
                
                    <%
                    }
                    %>
                    <!--resto-->
                    <% if(pagination.get(2)!=0){ %> 
                            <li class="page-item">
                                <a class="page-link"  href="./Edamams?q=${selected}&from=<%=pagination.get(3)%>"><%=pagination.get(1)+1%></a>
                            </li>
                    <%
                    }
                    %>
            </ul>
            </div>
            
        </div>
    </body>
</html>
