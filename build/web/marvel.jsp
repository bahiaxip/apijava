<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedHashMap"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MARVEL API</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="./css/style.css" rel="stylesheet" type="text/css">
        <!--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>-->
    </head>
    <body>
        <div class="fondo">
            <div class="marvel"></div>
        </div>
        <div class="container ">
            <%@ include file="header.html"%>
            <div class="row justify-content-center bg-white mx-auto pb-3">                
                <div class="col-auto ">
                    <div class="text-center p-3 arial bold mt-2 b_light_blue text-white rounded f15">
                        Listado de Comics de Marvel API
                    </div>
                </div>
            </div>
        </div>
            <%
            LinkedHashMap<String,Integer> datosPage=(LinkedHashMap<String,Integer>)request.getAttribute("page");
            ArrayList<Integer> pagination=new ArrayList();
            for(String dat:datosPage.keySet()){
                pagination.add(datosPage.get(dat));
            }
            String offset=request.getAttribute("offset").toString();
            int contador=0;
            int contadorCard=0;
            %>
        <div class="container ">
            <div class="row bg-white mx-auto">
        <c:forEach items="${dato}" var="lista">            
                <div class="col-6 ">
                    <div class="card border-0">
                        <form action="./MarvelId" id="form_marvel" name="form_marvel" method="POST">
                            <input type="hidden" name="id" value="${lista.getId()}">                                   
                        
                            <a  class="" style="text-decoration:none" href="javascript:void(0)" onclick="this.parentNode.submit()" >
                                <div class="card-body text-center times panel_card bold">
                                    <img style='float:left' src="${lista.thumbnail.path}/portrait_small.${lista.thumbnail.extension}" />
                                    <div class="card-title pt-4 f15 pb-2">
                                        ${lista.title}
                                    </div>
                                </div>                
                                <%--<div class="card-body">
                                    <c:set var="description" value="${lista.description}"/>
                                    <c:if test="${description == null}" >
                                        <p class="text-center">Descripción no disponible</p>
                                    </c:if>                        
                                    ${lista.description}
                                </div>--%>
                            </a>
                        </form>
                    </div>
                </div>   
        </c:forEach>
            </div>
            <div class="col  pt-2 mb-3 pb-3 bg-white">
                <ul class="pagination mt-3 ml-3 ">
            <% 
            String bol="true";
            for(int i=1;i<pagination.get(0);i++){
            %>  
                  <%-- al ser tantas páginas solo se muestran 40 registros más y menos (4 por delante y por detrás)
                        de la página actual, el resto de páginas se sustituye por puntos suspensivos --%>  
                <%
                    if(Integer.parseInt(offset)+(pagination.get(4)*4)<=contador && contador<pagination.get(0)
                            || Integer.parseInt(offset)-(pagination.get(4))*4>=contador ){
                        if(bol=="true"){
                            
                            if(Integer.parseInt(offset)-(pagination.get(4)*4)>=contador){%>
                                <li class="page-item ">
                                    <a class="page-link" href="./MarvelComic?offset=0"><%=i%></a>
                                </li>
                            <%}
                        %>                            
                            &nbsp;<li style="padding-top:8px" class="page-item ">
                            ...
                            </li>&nbsp;
                            
                            
                        <%
                            if(Integer.parseInt(offset)+(pagination.get(4)*4)<=contador && contador<pagination.get(0)){%>
                                <li class="page-item">
                                    <a class="page-link" href="./MarvelComic?offset=<%=pagination.get(0)-pagination.get(4)%>"><%=pagination.get(1)%></a>
                                </li>
                            <%}
                        }
                        bol="false";
                    }else{
                        bol="true";
                if(i<=pagination.get(1)){
                    
                %>  
                        <li class="page-item bg-info">
                            <a class="page-link" href="./MarvelComic?offset=<%=contador%>"><%=i%></a>
                        </li>
                                                
                <%  }              
                }
                contador=contador+pagination.get(4);
                %>
                
            <%
            }
            %>
            <%-- anulamos la condición del resto --%>
            <% if(pagination.get(2)!=0){ %> 
                        <li class="page-item">
                            <a class="page-link" href="./MarvelComic?from=<%=pagination.get(3)%>"><%=pagination.get(1)+1%></a>
                        </li>
            <%
            }
            %>
            </ul>
            </div>
        </div>
    </body>
</html>