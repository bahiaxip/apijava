package com.apijava.model;

public class StorySummary {
    public String resourceURI;
    public String name;
    public String type;
    
    /*
    public StorySummary(String resourceURI, String name, String type){
        
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
