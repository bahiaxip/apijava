package com.apijava.model;

public class TextObject {
    public String type;
    public String language;
    public String text;
    
    
    /*
    public TextObject(String type, String language, String text){
        
    }
    */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
