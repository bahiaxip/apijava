package com.apijava.model;

public class StoryList {
    public int available;
    public int returned;
    public String collectionURI;
    public StorySummary[] items;
    /*
    public StoryList(int available, int returned, String collectionURI, StorySummary[] items){
        
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

    public StorySummary[] getItems() {
        return items;
    }

    public void setItems(StorySummary[] items) {
        this.items = items;
    }
}