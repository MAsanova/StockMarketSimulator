package com.company.components.additional;

public class Trade {
    private static int executionNumber = 0;

    private String symbol;
    private int quantity;
    private int cost;
    private int orderNumberToBuy;
    private int orderNumberToSell;

    public Trade (String symbol, int quantity, int cost, int orderNumberToBuy, int orderNumberToSell) {
        executionNumber++;

        this.symbol = symbol;
        this.quantity = quantity;
        this.cost = cost;
        this.orderNumberToBuy = orderNumberToBuy;
        this.orderNumberToSell = orderNumberToSell;
    }

    public static int getExecutionNumber() {
        return executionNumber;
    }

    public static void setExecutionNumber(int executionNumber) {
        Trade.executionNumber = executionNumber;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public int getOrderNumberToBuy() {
        return orderNumberToBuy;
    }

    public void setOrderNumberToBuy(int orderNumberToBuy) {
        this.orderNumberToBuy = orderNumberToBuy;
    }

    public int getOrderNumberToSell() {
        return orderNumberToSell;
    }

    public void setOrderNumberToSell(int orderNumberToSell) {
        this.orderNumberToSell = orderNumberToSell;
    }
}
