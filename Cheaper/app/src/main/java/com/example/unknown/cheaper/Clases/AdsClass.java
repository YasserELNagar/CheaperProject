package com.example.unknown.cheaper.Clases;

public class AdsClass {

    int ID;
    String ProductName;
    double price_befor_offer;
    double price_after_offer;
    String StoreName;

    public AdsClass(String ProductName,String StoreName , double price_befor_offer, double price_after_offer) {
        this.ProductName = ProductName;
        this.price_befor_offer = price_befor_offer;
        this.price_after_offer = price_after_offer;
        this.StoreName=StoreName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrice_befor_offer() {
        return price_befor_offer;
    }

    public void setPrice_befor_offer(double price_befor_offer) {
        this.price_befor_offer = price_befor_offer;
    }

    public double getPrice_after_offer() {
        return price_after_offer;
    }

    public void setPrice_after_offer(double price_after_offer) {
        this.price_after_offer = price_after_offer;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }
}
