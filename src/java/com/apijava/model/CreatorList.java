package com.apijava.model;

public class CreatorList {
    public int available;
    public int returned;
    public String collectionURI;
    public CreatorSummary[] items;
    
    /*
    public CreatorList(int available, int returned, String collectionURI,CreatorSummary[] items){
        
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

    public CreatorSummary[] getItems() {
        return items;
    }

    public void setItems(CreatorSummary[] items) {
        this.items = items;
    }

    
    
}
