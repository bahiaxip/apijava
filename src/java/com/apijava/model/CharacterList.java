package com.apijava.model;

public class CharacterList {
    public int available;
    public int returned;
    public String collectionURI;
    public CharacterSummary[] items;
    
    /*
    public CharacterList(int available, int returned, String collectionURI, CharacterSummary[] items){
        
    }
    */
    
    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public CharacterSummary[] getItems() {
        return items;
    }

    public void setItems(CharacterSummary[] items) {
        this.items = items;
    }
    
    
}
