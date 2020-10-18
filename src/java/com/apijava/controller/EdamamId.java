package com.apijava.controller;

import java.io.IOException;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EdamamId", urlPatterns = {"/EdamamId"})

public class EdamamId extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //necesaria codificación utf8 (al pasar vía POST)
        request.setCharacterEncoding("UTF-8");
        
        String recipe,title,image,totalFAT,FASAT,FATRN,SUGAR,FIBTG,PROCNT,totalWeight,calories;
        recipe=request.getParameter("recipe");
        
        title=request.getParameter("title");
        image=request.getParameter("image");
        double cal=Double.parseDouble(request.getParameter("calories"));
        //si en lugar de # usamos 0 se rellena de 0 delante
        DecimalFormat formato = new DecimalFormat("####.##");
        calories = formato.format(cal);        
        //Se asignan todas las variables
        totalFAT = request.getParameter("total_fat");
        FASAT = request.getParameter("saturated");
        FATRN = request.getParameter("trans");
        SUGAR = request.getParameter("sugar");
        FIBTG = request.getParameter("fiber");
        PROCNT = request.getParameter("protein");
        totalWeight = request.getParameter("total_weight");
        
        //Se comprueban si vienen vacías para evitar errores al recortar decimales        
        if(totalFAT.length() != 0 || totalFAT != ""){
            double fat=Double.parseDouble(totalFAT);
            totalFAT=formato.format(fat);
        }
        if(FASAT.length() != 0 || FASAT != ""){
            double fat=Double.parseDouble(FASAT);
            FASAT=formato.format(fat);
        }
        if(FATRN.length() != 0 || FATRN != ""){
            double fat=Double.parseDouble(FATRN);
            FATRN=formato.format(fat);            
        }
        if(SUGAR.length() != 0 || SUGAR != ""){
            double fat=Double.parseDouble(SUGAR);
            SUGAR=formato.format(fat);
        }
        if(FIBTG.length() != 0 || FIBTG != ""){
            double fat=Double.parseDouble(FIBTG);
            FIBTG=formato.format(fat);
        }
        if(PROCNT.length() != 0 || PROCNT != ""){
            double fat=Double.parseDouble(PROCNT);
            PROCNT=formato.format(fat);
        }
        if(totalWeight.length() != 0 || totalWeight != ""){
            double fat=Double.parseDouble(totalWeight);
            totalWeight=formato.format(fat);
        }
        //System.out.println("recipe: "+recipe);
        //recipe=recipe.replaceAll("\\[","").replaceAll("\\]","");
        recipe=recipe.replaceAll("\\[|\\]","");
        //Reemplazando tb corchetes
        //recipe=recipe.replaceAll("\\[|\\]|\\{|\\}","");
        String restSubRecipe=recipe;
        ArrayList listSubRecipe = new ArrayList();
        int indexof=restSubRecipe.indexOf("{");
        
        while(indexof != -1){
            int numFirstBracketOpen = restSubRecipe.indexOf("{");
            int numFirstBracketClose = restSubRecipe.indexOf("}");
            String subRecipe = restSubRecipe.substring(numFirstBracketOpen+1, numFirstBracketClose);
            int numStart = subRecipe.indexOf("text");
            int numEnd = subRecipe.indexOf("quantity");
            String subRecipeIngredient = subRecipe.substring(numStart+5,numEnd-2);
            restSubRecipe = restSubRecipe.substring(numFirstBracketClose+1,restSubRecipe.length());
            listSubRecipe.add(subRecipeIngredient);
            indexof = restSubRecipe.indexOf("{");
        }
        //anulado
        /*
        LinkedHashMap<Integer,String> ingredientsMap = new LinkedHashMap();
        for(int i=0;i<listSubRecipe.size();i++){
            ingredientsMap.put(i, listSubRecipe.get(i));            
        }
        System.out.println("ingredientsMap: "+ingredientsMap);
        */
        
        LinkedHashMap map = new LinkedHashMap();
        map.put("recipe", listSubRecipe);
        map.put("title", title);
        map.put("image", image);
        map.put("calories", calories);
        map.put("totalFAT", totalFAT);
        map.put("FASAT", FASAT);
        map.put("FATRN", FATRN);
        map.put("SUGAR", SUGAR);
        map.put("FIBTG", FIBTG);
        map.put("PROCNT", PROCNT);
        map.put("totalWeight", totalWeight);
        request.setAttribute("map", map);
        request.getRequestDispatcher("edamamId.jsp").forward(request,response);

        /*
        //enviando datos(título de receta y lista de ingredientes) a la API Edemam y devuelve tipode dieta, lista de calorías, nutrientes,... 
        //datos de autenticación
            String urlString = "https://test-es.edamam.com/api/nutrition-details";
            String api_id="7d56a3ff";
            String api_key = "028d98ef2d263641a8e1affbe64453d1";
            String parameters= "?app_id="+api_id+"&app_key="+api_key;
            //estableciendo datos de conexión
            URL url = new URL(urlString+parameters);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            //enviando datos vía POST
            con.setDoOutput(true);            
            //objeto JSON
            String input = "{\"title\" : \"Ensalada de Col Cremosa\",\"yield\" : \"6.0\",\"ingr\" : [\"1/2 taza de mayonesa o aderezo para ensaladas\",\"1/4 taza de crema agria\",\"1 cucharada de azúcar\",\"2 cucharaditas de jugo de limón\",\"2 cucharaditas de mostaza Dijon\",\"1/2 cucharadita de semillas de apio\"]}";        
            
            //enviando dato
            OutputStream os = con.getOutputStream();
            os.write(input.getBytes("UTF-8"));
            os.flush();
            //con.connect();
            System.out.println(con.getResponseCode());
            //Obteniendo y mostrando respuesta
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(con.getInputStream());            
            System.out.println(node);
        */
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
/*anulado
    private String outputParametersList(HttpServletRequest request) {
    Enumeration<String> names = request.getParameterNames();
	if(!names.hasMoreElements()) return "";
	
	StringBuilder sb = new StringBuilder();
	
	sb.append("<ul>");
    while(names.hasMoreElements()) {
    	String name = names.nextElement();
    	String value = request.getParameter(name);
    	
    	sb.append("<li>");
        sb.append(name + ": " + value);
        sb.append("</li>");
    }
    sb.append("</ul>");
	
	return sb.toString();
}
    */
    /*
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
        HttpServletRequest peticion = (HttpServletRequest)request;
        System.out.println(peticion,getRequestURI());
        chain.doFilter(request,response);
    }
    */
}
