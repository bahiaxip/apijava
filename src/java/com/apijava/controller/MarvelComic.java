package com.apijava.controller;

import com.apijava.model.Comic;
import com.apijava.model.ComicDataWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarvelComic extends HttpServlet {
    //ArrayList resultsList;
    //File archivo;
    public int totalRegistros;
    public int numRegistros=10;
    public String offset;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        
        if(request.getParameter("offset")==null || request.getParameter("offset").isEmpty()){
            offset="0";            
        }else{
            offset=request.getParameter("offset");
        }
        
        int res=Integer.parseInt(offset);
        System.out.println("offset: "+offset);
        System.out.println("res: "+res);
        String apiKey = "c6ff3fcd050b34c2d4e02dcdb8100a1c";
        String hash="846dda40302baefb779ebbfce3edac5a";
        URL url = new URL("https://gateway.marvel.com/v1/public/comics?ts=1&offset="+offset+"&limit="+numRegistros+"&apikey="+apiKey+"&hash="+hash);
        
        //con javabeans
        ObjectMapper mapper1 = new ObjectMapper();
        ComicDataWrapper comic=null;
        try {
            comic = mapper1.readValue(url, ComicDataWrapper.class);
            //System.out.println(hola.getData().getResults()[5].getImages()[0].getPath());
        } catch (IOException iOException) {
                System.out.println("Error: "+iOException);
        }
        //paginación
        totalRegistros=comic.getData().getTotal();
        int numPaginas = totalRegistros/numRegistros;
        int resto = totalRegistros % numRegistros;
        int ultimo = totalRegistros - resto;
        LinkedHashMap page = new LinkedHashMap();
        page.put("total",totalRegistros);
        page.put("num",numPaginas);
        page.put("rest",resto);
        page.put("last",ultimo);
        page.put("numReg",numRegistros);
        request.setAttribute("page",page);
        request.setAttribute("offset",offset);
        
        //traducción
        NasaAstronomy nasa = new NasaAstronomy();        
        ArrayList<String> listTitle = new ArrayList<String>();
        ArrayList<String> listDescription = new ArrayList<String>();
        
        //se almacena en un arrayList
        //el for siempre es desde 0 hasta número de registros, ya que la url es la que trae los resultados
        //es decir, la url siempre trae X resultados y el for siempre empezará de 0 a X
        for(int i=0;i<numRegistros;i++){
            String title=comic.getData().getResults()[i].getTitle();
            listTitle.add(title);
            
            String description=comic.getData().getResults()[i].getDescription();
            listDescription.add(description);
        }
        System.out.println(listTitle);
        //se envía a translateApp (aws amazon)
        ArrayList<String> newListTitle=new ArrayList<String>();
        //anulamos la traducción del título, ya que ralentiza demasiado
        //ArrayList<String> newListDescription=new ArrayList<String>();
        newListTitle = nasa.TranslateApp(listTitle);
        //newListDescription=nasa.TranslateApp(listDescription);
        for(int i=0;i<newListTitle.size();i++){            
            comic.getData().getResults()[i].setTitle(newListTitle.get(i));
            //comic.getData().getResults()[i].setDescription(newListDescription.get(i));
        }
        
                
        
        
        
        
        
        /*
        //con LinkedHashMap
        ObjectMapper mapper=new ObjectMapper();
        Map<String, Object> jsonMap = mapper.readValue(url, new TypeReference<Map<String,Object>>(){});
        
        Collection jsonCollection = jsonMap.values();
        
        ArrayList lista = new ArrayList(jsonCollection);
        LinkedHashMap lista2 = (LinkedHashMap) lista.get(6); //lista.get(6) es el objeto data
        
        ArrayList fechas=new ArrayList();
        List<LinkedHashMap<String,Object>> map = new ArrayList<LinkedHashMap<String,Object>>();        
        lista2.forEach((k,v) -> {
           if(k=="results"){
                Collection resultsCollection = (Collection) v;
                resultsList=new ArrayList(resultsCollection);
                for(int i=0;i<resultsList.size();i++){                    
                    LinkedHashMap resultsMap = (LinkedHashMap)resultsList.get(i);
                    map.add(resultsMap);                    
                    resultsMap.forEach((k2,v2) -> {
                        if(k2=="dates"){                        
                            Collection datesCollection = (Collection) v2;
                            ArrayList datesList = new ArrayList(datesCollection);
                        }
                    });
                }
           } 
        });
*/      
        //linkedHashMap
        //request.setAttribute("dato",map);
        //javabean
        request.setAttribute("dato",comic.getData().getResults());
        request.getRequestDispatcher("marvel.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
/*****************pruebas anteriores *******************/
        //json
        
                
            //ArrayList<MarvelComic> miObjeto = mapper.readValue(resultsMap.toString(),MarvelComic.class);            
            //obtener el directorio por defecto
                //String path=System.getProperty("user.dir");
                //System.out.println(path);
            //Crear archivo
                //archivo = new File("./archivoNetbeans.txt");
            //Para que el archivo se cree fisícamente es necesario escribir algo
                //FileWriter fw = new FileWriter(archivo);
                //BufferedWriter bw = new BufferedWriter(fw);
                //bw.write("hola");
                //bw.close();
                
            //comprobar sistema operativo
                //String so = System.getProperty("os.name");
                //System.out.println(so);
            //comprobar separador por defecto del S.O. para establecer una ruta
                //System.out.println(File.separator);




//escribiendo resultado en json
        /*try {
                
                File json=new File("/home/xip/NetBeansProjects/ApiJava/web/marvel.json");
                mapper.writeValue(json, lista2);

                if(json.exists()){
                    System.out.println("crea archivo");
                }else{
                    System.out.println("No crea archivo");
                }
            } catch (Exception ex) {

                System.out.println("Excepción");
                Logger.getLogger("Excepción: "+MarvelComic.class.getName()).log(Level.SEVERE, null, ex);
            }
*/