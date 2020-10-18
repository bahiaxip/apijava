package com.apijava.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Edamams extends HttpServlet {
    ArrayList recetaList;
    public int totalRegistros;
    public int numRegistros=12;
    public String selected;
    public String from;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.setCharacterEncoding("UTF-8");
        try{
            //si es null es que no encuentra el campo from, isEmpty() si está vacío
            if(request.getParameter("q")==null||request.getParameter("q").isEmpty()){
                selected="ensalada";
            }else{
                selected = request.getParameter("q");
            }
            if(request.getParameter("from")==null||request.getParameter("from").isEmpty()){
                from="0";
            }else{
                from=request.getParameter("from");
            }
        
        
            String api_id="7d56a3ff";
            String api_key = "028d98ef2d263641a8e1affbe64453d1";
            String urlString= "https://test-es.edamam.com/search";        
            //int initRegistro=0;
            int finalRegistro=Integer.parseInt(from)+numRegistros;        
            URL url = new URL(urlString+"?q="+selected+"&from="+from+"&to="+finalRegistro);
            //HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestMethod("GET");        
        
            ObjectMapper mapper = new ObjectMapper();
            Map<Object,Object> recetas = mapper.readValue(url, new TypeReference<Map<Object,Object>>(){});
            List<LinkedHashMap<String,Object>> recetasMap= new ArrayList<LinkedHashMap<String,Object>>();        
            recetas.forEach((k,v) -> {
                if(k=="count"){
                totalRegistros=(int) v;
                    System.out.println("totalregistros: "+v);
                }
                if(k=="hits"){
                    Collection recetaCol = (Collection) v;
                    recetaList = new ArrayList(recetaCol);
                    recetasMap.add((LinkedHashMap)recetaList.get(0));
                    System.out.println(recetasMap);

                }            
            });         
        
            int numPaginas=totalRegistros/numRegistros;
            int resto = totalRegistros % numRegistros;
            int ultimo = totalRegistros - resto;
            //System.out.println(resto);
            request.setAttribute("dato", recetaList);
            request.setAttribute("from", from);
            request.setAttribute("selected",selected);
            //System.out.println(recetaList);
            LinkedHashMap page=new LinkedHashMap<>();
            page.put("total", totalRegistros);
            page.put("num",numPaginas);
            page.put("rest", resto);
            page.put("last",ultimo);
            page.put("numRegistros",numRegistros);

            System.out.println(recetas.getClass());
            request.setAttribute("page",page);
            request.getRequestDispatcher("edamams.jsp").forward(request,response);
        }catch(Exception ex){
            //request.setAttribute("from", "0");
            request.getRequestDispatcher("edamam.jsp").forward(request,response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
