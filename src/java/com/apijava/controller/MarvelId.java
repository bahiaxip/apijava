package com.apijava.controller;

import com.apijava.model.ComicDataWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarvelId extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("id"));
        if(request.getParameter("id")!=null && !request.getParameter("id").isEmpty()){
            String id=request.getParameter("id");
            String apiKey = "c6ff3fcd050b34c2d4e02dcdb8100a1c";
            String hash="846dda40302baefb779ebbfce3edac5a";
            URL url = new URL("https://gateway.marvel.com/v1/public/comics/"+id+"?ts=1&apikey="+apiKey+"&hash="+hash);
            ObjectMapper mapper = new ObjectMapper();
            ComicDataWrapper comic=null;
            try {
                comic = mapper.readValue(url, ComicDataWrapper.class);
                //translate
                NasaAstronomy nasa= new NasaAstronomy();
                String title=nasa.TranslateApp(comic.getData().getResults()[0].getTitle());
                if(title==null || title.isEmpty())
                    title="Título no disponible";
                comic.getData().getResults()[0].setTitle(title);
                String description=nasa.TranslateApp(comic.getData().getResults()[0].getDescription());
                if(description==null || description.isEmpty())
                    description="Descripción no disponible";
                comic.getData().getResults()[0].setDescription(description);
                String format=nasa.TranslateApp(comic.getData().getResults()[0].getFormat());
                comic.getData().getResults()[0].setFormat(format);
                request.setAttribute("comic",comic.getData().getResults()[0]);                
                request.getRequestDispatcher("marvelId.jsp").forward(request, response);
                
            } catch (IOException iOException) {
                    System.out.println("Error: "+iOException);
            }
        }else{
            System.out.println("ID not found");
            request.getRequestDispatcher("index.html").forward(request, response);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
