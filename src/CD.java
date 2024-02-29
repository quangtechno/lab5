/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class CD {
    private String cd_ID;
    private String collection;
    private String type;
    private String title;
    private double Price;
    private int yearOfRelease;

    public CD(){
        
    }
    public CD(String cd_ID, String collection, String type, String title, double Price, int yearOfRelease) {
        this.cd_ID = cd_ID;
        this.collection = collection;
        this.type = type;
        this.title = title;
        this.Price = Price;
        this.yearOfRelease = yearOfRelease;
    }

    public void setCd_ID(String cd_ID) {
        this.cd_ID = cd_ID;
    }

    public String getCd_ID() {
        return cd_ID;
    }
    
    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "CD{" + "cd_ID=" + cd_ID + ", collection=" + collection + ", type=" + type + ", title=" + title + ", Price=" + Price + ", yearOfRelease=" + yearOfRelease + '}';
    }
    
}
