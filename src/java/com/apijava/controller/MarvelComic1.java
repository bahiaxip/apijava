package com.apijava.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static sun.management.Agent.error;

public class MarvelComic1 extends HttpServlet {
    Date dateFecha;
    String dateFecha2;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MarvelComic</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MarvelComic at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        */
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String apiKey = "c6ff3fcd050b34c2d4e02dcdb8100a1c";
        String hash="846dda40302baefb779ebbfce3edac5a";
        URL url = new URL("https://gateway.marvel.com/v1/public/comics?ts=1&apikey="+apiKey+"&hash="+hash);
        //json
        ObjectMapper mapper=new ObjectMapper();
        Map<String, Object> jsonMap = mapper.readValue(url, new TypeReference<Map<String,Object>>(){});
        
        Collection jsonCollection = jsonMap.values();
        
        ArrayList lista = new ArrayList(jsonCollection);
        LinkedHashMap lista2 = (LinkedHashMap) lista.get(6); //lista.get(6) es el objeto data
        //fechas
        ArrayList fechas=new ArrayList();
        lista2.forEach((k,v) -> {
           if(k=="results"){               
                Collection resultsCollection = (Collection) v;
                ArrayList resultsList=new ArrayList(resultsCollection);
                for(int i=0;i<resultsList.size();i++){
                    LinkedHashMap resultsMap = (LinkedHashMap)resultsList.get(i);
                    resultsMap.forEach((k2,v2) -> {
                    if(k2=="dates"){
                        
                        //System.out.println(v2);
                        Collection datesCollection = (Collection) v2;
                        ArrayList datesList = new ArrayList(datesCollection);
                        //System.out.println(dates.get(0));
                        for(int j=0;j<datesList.size();j++){
                            LinkedHashMap datesMap = (LinkedHashMap)datesList.get(1);                            
                            Collection dateCollection=(Collection) datesMap.values();
                            ArrayList dateList=new ArrayList(dateCollection);                            
                            //String dateString = dateList.get(1).toString();
                            //String dateString = dateList.get(1).toString();
                            
                            fechas.add(dateList.get(1));
                            
                            datesMap.forEach((k3,v3) ->{
                                /*
                                if(v3.){
                                    System.out.println("tiene array");
                                    System.out.println(v3);
                                }else{
                                    System.out.println("no tiene array");   
                                }
                                */
                                //Collection colFinal=(Collection) v3;
                                //ArrayList listaFinal = new ArrayList(colFinal);
                                /*
                                for(int h=0;h<listaFinal.size();h++){
                                    LinkedHashMap mapFinal= (LinkedHashMap) listaFinal.get(h);
                                    System.out.println(mapFinal);
                                }
                                */
                                 
                            });
                        }
                        //fechas.add(data3);
                    }
                });
                    //System.out.println("el dato "+i+", "+data.get(i));
                }
                
                //LinkedHashMap data2 = (LinkedHashMap)data.get(0);
                
                /*
                data2.forEach((k2,v2) -> {
                    if(k2=="dates"){
                        fechas.add(v2);
                    }
                });
                */
                
                /*
                Map<String,String> listParams = new LinkedHashMap<String,String>();
                data2.forEach((k2,v2)-> {
                    listParams.put(k2.toString(), v2.toString());
                    System.out.println("key2: "+k2+", value2: "+v2);
                });
                ObjectMapper mapper2 = new ObjectMapper();
                System.out.println("listParams: "+data2);
                System.out.println("listParams: "+listParams);
                */
           } 
        });
        /*
        System.out.println("fechas: "+fechas);
        //ordenar lista de fechas
        Collections.sort(fechas);
        System.out.println("fechas sort: "+fechas);
        String fecha1 =fechas.get(0).toString();
        System.out.println("fecha1: "+fecha1);
        System.out.println("fecha a cambiar: "+ fechas.getClass());
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            dateFecha = formato.parse(fecha1);
            dateFecha2=formato2.format(dateFecha.toString());
        }catch(ParseException ex){
            error ("Error al convertir fecha");
        }
        System.out.println("dateFecha: "+dateFecha2);
        */
        //es posible directamente pasar como atributo el jsonMap y desde el jsp desplegar el json
        /*
        Collection jsonCollection= jsonMap.values();
        ArrayList lista = new ArrayList(jsonCollection);
        //Es posible con HashMap o con LinkedHashMap
        //HashMap lista2 = (HashMap) lista.get(6);
        LinkedHashMap lista2 = (LinkedHashMap) lista.get(6);        
        lista2.forEach((k,v)-> {
            if(k=="results"){
                try {
                    Collection lista3 = (Collection) v;
                    ArrayList data=new ArrayList(lista3);
                    LinkedHashMap data2 = (LinkedHashMap)data.get(0);
                    System.out.println("lista3: "+data.get(0));
                    //no es necesario listParams nisiquiera el data2
                    Map<String,String> listParams = new LinkedHashMap<String,String>();
                    data2.forEach((k2,v2)-> {
                        listParams.put(k2.toString(), v2.toString());
                        System.out.println("key2: "+k2+", value2: "+v2);
                    });
                    ObjectMapper mapper2 = new ObjectMapper();
                    System.out.println("listParams: "+data2);
                    System.out.println("listParams: "+listParams);
                request.setAttribute("dato", data2);
                    request.getRequestDispatcher("marvel.jsp").forward(request, response);    
                } catch (ServletException ex) {
                    Logger.getLogger(MarvelComic.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MarvelComic.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            
        });
        */
        request.setAttribute("dato", jsonMap);
        request.getRequestDispatcher("marvel.jsp").forward(request, response);
        //Convertir en ArrayList 
        /*
        ArrayList miKey = new ArrayList(jsonMap.values());
        miKey.forEach((p)->{            
            System.out.println(p);
        });
        */
        //System.out.println(miKey.);
        //obtener indice del key data
            //Integer dato= miKey.indexOf("data");        
            //System.out.println(miKey.get(dato));
        
        //todas las keys del json (keySet())        
        //Set<String> keys = jsonMap.keySet();
        //Collection<String> keys2 = jsonMap.keySet();
        //System.out.println(keys2.toArray()[0]);
        /*if(jsonMap.containsKey("data")){
            //Set<Object> data= (Set<Object>) jsonMap.get("data");
            //System.out.println();
            //System.out.println(jsonMap.get("data"));
        }*/
        
        //Collection<Object> values=jsonMap.values();
        
        
        
        
        
        
        //System.out.println("value: "+value);
        /*
        jsonMap.forEach((k,v) -> {
            if(k=="data"){
                System.out.println("key: "+k+ ",value: "+v);
                System.out.println(v.getClass());
            }
            
        });
        */
        //System.out.println("llegando");        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
