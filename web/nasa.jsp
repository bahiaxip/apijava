<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NASA API</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="./css/style.css" rel="stylesheet" type="text/css">
        <!--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>-->
    </head>
    <body>
        <div class="fondo_nasa"></div>
        <div class="container">
            <%@ include file="header.html"%>            
            <div class="row mx-auto bg-white pb-3">
                <div class="col-1 ">
                    <img class="float-left"  src="./img/nasa.png" width="50" height="50">
                </div>
                <div class="col-10 text-center ">
                    <div class="row justify-content-center">
                        <div class="col-auto">
                            <div class="text-center bold rounded p-3 b_light_orange text-white mt-2 arial f15">
                                Imagen del día de NASA API
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-1 "></div>
                
            </div>
        </div>                
        <div class="container ">
            <div class="card">
                <div class="card-header text-center b_light_grey f15">
                    <%
                    if(request.getAttribute("title")!=null){                        
                    %>
                    <span class="arial bold "><%=request.getAttribute("title")%></span>
                    <%}else{%>
                        ${dato.title}
                    <%
                    }
                    %>
                </div>
                <div class=" text-center vh-50 mt-4">
                    <% if(request.getAttribute("image")!=null){%>
                        <img class="rounded" src="<%=request.getAttribute("image")%>" />
                    <%
                    }else{
                        
                    %>
                        <img class="rounded" src="${dato.url}" width="700"/>
                    <%
                    }
                    %>
                </div>
                <div class="card-body text-justify b_light_grey f15 mt-4 rounded">
                    <%
                    if(request.getAttribute("explanation")!=null){                        
                    %>
                    <p><%=request.getAttribute("explanation")%></p>
                            <%}else{%>
                    <p>${dato.explanation}</p>
                    <%
                    }
                    %>
                </div>
            </div>
        </div>
        
    </body>
</html>
