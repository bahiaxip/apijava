package com.apijava.controller;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfilesConfigFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.apijava.model.NasaAstronomyModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.scene.transform.Translate;


public class NasaAstronomy extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //response.setContentType("Video/mp4");
        
        NasaAstronomyModel dato;
        
        
        dato=new NasaAstronomyModel("a","b","c","d","e","f","g","h");
        
        //System.out.println(objeto.title);        
        //System.out.println(objeto.getTitle());
        
        /*
        InputStream is = url.openStream();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String read;
        while((read=br.readLine()) != null){
            sb.append(read);
        }
        br.close();
        System.out.println(sb.toString());
        
        ObjectMapper mapper=new ObjectMapper();
        JsonNode nam=mapper.readTree(sb.toString());
        JsonNode node1 = nam.get("title");
        System.out.println(node1);
        */
        //mapper.writeValue(new File("mijson.json"),nam);        
        //NasaAstronomyModel objetoModelo = mapper.readValue(nam, NasaAstronomyModel.class);
        //ArrayList<NasaAstronomyModel> objetoModelo = mapper.readValue(sb.toString(), mapper.getTypeFactory().constructCollectionType(ArrayList.class,NasaAstronomyModel.class));
        
        //convertir a json
        //String hola= mapper.writeValueAsString(nam);
        //System.out.println(hola);
            
        //JsonNode nam = mapper.readTree(sb.toString());
        //JsonFactory factory=mapper.getFactory();
        //JsonParser parser = factory.createParser(sb.toString());
        //JsonNode nam= mapper.readTree(parser);
        //System.out.println(nam.get("title"));
        
        //String nam = mapper.writeValueAsString(sb.toString());
        //JsonNode title=nam.get("title");
        //System.out.println(nam.get("copyright"));
        //System.out.println(title);
        
    }   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);        
        //obtenemos zona horaria Universal (UTC)
        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.UTC);
        String fecha= localDateTime.toLocalDate().toString();        
        
        //URL url=new URL("https://api.nasa.gov/planetary/apod?api_key=LhWmXfyqyKf4zhWIHkpd7cQ1XR08ISwmoMjZSfe7&date=2020-08-28");        
        URL url=new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date="+fecha);        
        //Se asignan los datos del objeto json solicitado al modelo de datos mediante la librería com.fasterxml.jackson
        ObjectMapper mapper =new ObjectMapper();        
        NasaAstronomyModel objetoJson = mapper.readValue(url,NasaAstronomyModel.class);
        String image=objetoJson.getUrl();        
        String[] split = image.split("/");
        //api.nasa.gov en ocasiones asigna videos de youtube en lugar de imágenes
        //si es video obtenemos imagen asociada a video de youtube y pasamos atributo image a JSP
        //para obtener la imagen asociada se obtiene el identificador y se sustituye por una de las siguiente rutas
        /*
        http://img.youtube.com/vi/VideoID/0.jpg
        http://img.youtube.com/vi/VideoID/1.jpg
        http://img.youtube.com/vi/VideoID/2.jpg
        http://img.youtube.com/vi/VideoID/3.jpg
        o
        http://img.youtube.com/vi/VideoID/default.jpg
        http://img.youtube.com/vi/VideoID/hqdefault.jpg
        http://img.youtube.com/vi/VideoID/mqdefault.jpg
        http://img.youtube.com/vi/VideoID/sddefault.jpg
        
        */
        if("www.youtube.com".equals(split[2])){
            int splitCount = split.length;
            String[] idYoutube=split[splitCount-1].split("\\?");            
            String idYoutubeClean=idYoutube[0];
            
            String ima="http://img.youtube.com/vi/"+idYoutubeClean+"/0.jpg";
            request.setAttribute("image", ima);            
        }
        String translateTitle;
        String translateExplanation;
        try{
            translateTitle = TranslateApp(objetoJson.getTitle());
        }catch(Exception ex){
            translateTitle = null;
        }
        try{
            translateExplanation = TranslateApp(objetoJson.getExplanation());
        }catch(Exception ex){
            translateExplanation=null;
        }
            
        request.setAttribute("title", translateTitle);
        request.setAttribute("explanation", translateExplanation);
        //System.out.println(dato);
        request.setAttribute("dato",objetoJson);
        request.getRequestDispatcher("nasa.jsp").forward(request,response);
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
    
    public String TranslateApp(String explanation){
        //para evitar errores en caso de null se devuelve null
    if(explanation!=null && explanation!=""){
            
        
        
        //AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();
        
        //AWSCredentialsProvider awsCreds = new ProfileCredentialsProvider(new ProfilesConfigFile(),"credentials");
        
        //AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
        //        .withCredentials(new )
        //ProfileCredentialsProvider
        AWSCredentialsProviderChain awsCreds = new AWSCredentialsProviderChain(new ProfileCredentialsProvider());
        AmazonTranslate translate = AmazonTranslateClient.builder()
                .withCredentials(awsCreds)
                .withRegion("us-west-2")
                .build();
        /*
        AmazonTranslate translate = AmazonTranslateClient.builder()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds.getCredentials()))
            .withRegion("us-west-2")
            .build();
        */
        
        TranslateTextRequest request = new TranslateTextRequest()
                .withText(explanation)
                .withSourceLanguageCode("en")
                .withTargetLanguageCode("es");
        TranslateTextResult result = translate.translateText(request);
        String text = result.getTranslatedText();        
        return text;
    }else{
        return null;
    }
    }
    public ArrayList TranslateApp(ArrayList<String> explanation){
        //para evitar errores en caso de null se devuelve null
        
        
            
        
        if(explanation!=null){     
            AWSCredentialsProviderChain awsCreds = new AWSCredentialsProviderChain(new ProfileCredentialsProvider());
            AmazonTranslate translate = AmazonTranslateClient.builder()
                    .withCredentials(awsCreds)
                    .withRegion("us-west-2")
                    .build();
            ArrayList<String> lista = new ArrayList<String>();
            for(String cadena: explanation){
                if(cadena!=null){
                    TranslateTextRequest request = new TranslateTextRequest()
                        .withText(cadena)
                        .withSourceLanguageCode("en")
                        .withTargetLanguageCode("es");
                    TranslateTextResult result = translate.translateText(request);
                    String text = result.getTranslatedText();
                    lista.add(text);
                }else{
                    lista.add(null);
                }

            }
            return lista;
        }else{
            return null;
        }
    }

}
