package com.apijava.model;

public class ComicSummary {
    public String resourceURI;
    public String name;
    
    /*
    public ComicSummary(String resourceURI, String name){
        
    }
    */
    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
