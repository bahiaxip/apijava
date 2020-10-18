package com.apijava.model;

public class CharacterSummary {
    public String resourceURI;
    public String name;
    public String role;
    
    /*
    public CharacterSummary(String resourceURI, String name, String role){
        
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
