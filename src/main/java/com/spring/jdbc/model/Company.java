package com.spring.jdbc.model;

/**
 * Created by Admin on 08.07.2016.
 */
public class Company {
    private  Integer order_id;
    private  String symbol;
    private String quanity;
    private Integer price;

    public Company(Integer order_id, String symbol, String quanity, Integer price) {
        this.order_id = order_id;
        this.symbol = symbol;
        this.quanity = quanity;
        this.price = price;
    }
    public Company(Integer order_id, String symbol) {
        this.order_id = order_id;
        this.symbol = symbol;

    }

    public Company(){

    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getQuanity() {
        return quanity;
    }

    public void setQuanity(String quanity) {
        this.quanity = quanity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return "Company{order_id= "+ this.order_id+
                " name= "  + this.symbol +
                " quanity=" + this.quanity+
                " price=" + this.price+"}";
    }
}
