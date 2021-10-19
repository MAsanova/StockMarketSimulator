package com.company.components.additional;

public class Order {
    private char adType;
    private int quantity;
    private int cost;
    private int orderNumber;

    public Order(char adType, int quantity, int cost, int orderNumber){
        this.adType = adType;
        this.quantity = quantity;
        this.cost = cost;
        this.orderNumber = orderNumber;
    }

    public char getAdType() {
        return adType;
    }

    public void setAdType(char adType) {
        this.adType = adType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
