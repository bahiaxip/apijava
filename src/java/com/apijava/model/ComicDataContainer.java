package com.apijava.model;

import java.util.LinkedHashMap;

public class ComicDataContainer {
    public int offset;
    public int limit;
    public int total;
    private int count;
    public Comic[] results=null;
    
    /*
    public ComicDataContainer(int offset,int limit, int total, int count, LinkedHashMap results){
        
    }
*/
    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Comic[] getResults() {
        return results;
    }

    public void setResults(Comic[] results) {
        this.results = results;
    }
    
    
}
