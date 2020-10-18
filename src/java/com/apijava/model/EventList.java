package com.apijava.model;

public class EventList {
    
    public int available;
    public int returned;
    public String collectionURI;
    public EventSummary[] items;
    
    /*
    public EventList(int available, int returned, String collectionURI, EventSummary[] items){
        
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

    public EventSummary[] getItems() {
        return items;
    }

    public void setItems(EventSummary[] items) {
        this.items = items;
    }
    
    
}
