package com.apijava.model;


public class ComicDataWrapper {
    public int code;
    public String status;
    public String copyright;
    public String attributionText;
    public String attributionHTML;
    public ComicDataContainer data;
    public String etag;
    
    //public ComicDataWrapper(){}
    
    /*
    public ComicDataWrapper(int code, String status,  String copyright,  String attributionText, LinkedHashMap data, 
             String attributionHTML,  String etag){        
        //this.code=code != null ? code : 0;
        this.code=code;
        this.status=status;
        this.copyright=copyright;
        this.attributionText=attributionText;
        this.attributionHTML = attributionHTML;
        this.data=data;
        this.etag= etag;
        
    }
    */
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public ComicDataContainer getData() {
        return data;
    }

    public void setData(ComicDataContainer data) {
        this.data = data;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
    
    
}
