package com.apijava.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.LinkedHashMap[];
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Comic {
    
    public int id,digitalId,pageCount;
    public String title,variantDescription,description,isbn,upc,diamondCode,ean,issn,format,
            resourceURI;
    public double issueNumber;
    //la API indica Date pero la librería jackson devuelve un error para solucionarlo pasamos a String
    //public Date modified=null;
    public String modified;
    public TextObject[] textObjects;
    public SeriesSummary series;
    public ComicSummary[] variants,collections,collectedIssues;
    public Image thumbnail;
    public CreatorList creators;
    public CharacterList characters;
    public StoryList stories;
    public EventList events;
    public Url[] urls;
    public ComicPrice[] prices;
    public ComicDate[] dates;
    public Image[] images;
    /*
    public Comic(){
        
    }
*/
    /*
    public Comic(
            Integer id, 
            Integer digitalId,
            String title, 
            double issueNumber,
            String variantDescription,
            String description,
            Date modified, 
            String isbn,
            String upc, 
            String diamondCode,
            String ean, 
            String issn,
            String format,
            Integer pageCount,
            LinkedHashMap[] textObjects,
            String resourceURI,
            LinkedHashMap[] urls,            
            LinkedHashMap series,
            LinkedHashMap[] variants,
            LinkedHashMap[] collections,
            LinkedHashMap[] collectedIssues,
            LinkedHashMap[] dates, 
            LinkedHashMap[] prices,
            Image thumbnail,
            LinkedHashMap[] images,
            LinkedHashMap creators,
            LinkedHashMap characters, 
            LinkedHashMap stories, 
            LinkedHashMap events){
        this.id=id;
        this.digitalId=digitalId;
        this.title=title;
        this.issueNumber=issueNumber;
        this.variantDescription=variantDescription;
        this.description=description;
        this.modified=modified;
        this.isbn=isbn;
        this.upc=upc;
        this.diamondCode=diamondCode;        
        this.ean=ean;
        this.issn=issn;
        this.format=format;
        this.pageCount=pageCount;
        this.textObjects=textObjects;
        this.resourceURI=resourceURI;
        this.urls=urls;
        this.series=series;
        this.variants=variants;
        this.collections=collections;
        this.collectedIssues=collectedIssues;
        this.dates=dates;
        this.prices=prices;
        this.collections=collections;
        this.thumbnail=thumbnail;
        this.images=images;
        this.creators=creators;
        this.characters=characters;
        this.stories=stories;
        this.events=events;
        
        
        
    }
*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(int digitalId) {
        this.digitalId = digitalId;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public double getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(double issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        //System.out.println("modified: "+modified);
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        //pattern.setLenient(false);
        //SimpleDateFormat newPattern = new SimpleDateFormat("yyyy-MM-dd");
        //String fechaString = modified.toString();
        //Date fechaDate = null;
        try {
            
            
                this.modified=modified;
                
            
            //fechaDate=format.parse()
            //Date dato = pattern.parse(fecha);
            //System.out.println("date valido: "+ pattern);
            //String nuevaFecha=newPattern.format(dato);
            //this.modified=new Date(nuevaFecha);
            //this.modified=modified;
        } catch (Exception ex) {
            
            //Logger.getLogger(Comic.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: "+ex);
            
        }
    }

    public TextObject[] getTextObjects() {
        return textObjects;
    }

    public void setTextObjects(TextObject[] textObjects) {
        this.textObjects = textObjects;
    }

    public Url[] getUrls() {
        return urls;
    }

    public void setUrls(Url[] urls) {
        this.urls = urls;
    }

    public ComicSummary[] getVariants() {
        return variants;
    }

    public void setVariants(ComicSummary[] variants) {
        this.variants = variants;
    }

    public ComicSummary[] getCollections() {
        return collections;
    }

    public void setCollections(ComicSummary[] collections) {
        this.collections = collections;
    }

    public ComicSummary[] getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(ComicSummary[] collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    public ComicDate[] getDates() {
        return dates;
    }

    public void setDates(ComicDate[] dates) {        
        this.dates = dates;
    }

    public ComicPrice[] getPrices() {
        return prices;
    }

    public void setPrices(ComicPrice[] prices) {
        this.prices = prices;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public SeriesSummary getSeries() {
        return series;
    }

    public void setSeries(SeriesSummary series) {
        this.series = series;
    }

    public CreatorList getCreators() {
        return creators;
    }

    public void setCreators(CreatorList creators) {
        this.creators = creators;
    }

    public CharacterList getCharacters() {
        return characters;
    }

    public void setCharacters(CharacterList characters) {
        this.characters = characters;
    }

    public StoryList getStories() {
        return stories;
    }

    public void setStories(StoryList stories) {
        this.stories = stories;
    }

    public EventList getEvents() {
        return events;
    }

    public void setEvents(EventList events) {
        this.events = events;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }
    
}
