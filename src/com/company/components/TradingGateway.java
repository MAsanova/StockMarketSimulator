package com.company.components;

import com.company.components.additional.Order;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TradingGateway {
    private static int ordersCounter = 0;

    public static void addOrder(String symbol, char adType, int quantity, int cost) {
        ordersCounter++;
        Order order = new Order(adType, quantity, cost, ordersCounter);
        if (OrderBooks.getOrderBooksMap().containsKey(symbol)) {
            OrderBooks.getOrderBooksMap().get(symbol).add(order);
        } else {
            ArrayList<Order> orderList = new ArrayList<>();
            orderList.add(order);
            OrderBooks.getOrderBooksMap().put(symbol, orderList);
        }
        printAddOrder(symbol, order);
    }

    public static void cancelOrder(String symbol, char adType, int quantity, int cost) {
        for (Order order: OrderBooks.getOrderBooksMap().get(symbol)) {
            if (order.getAdType() == adType && order.getQuantity() == quantity && order.getCost() == cost) {
                OrderBooks.getOrderBooksMap().get(symbol).remove(order);
                printCancelOrder(symbol, order);
                return;
            }
        }
    }

    public static void printAddOrder(String symbol, Order order) {
        System.out.print("[" + ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z")) + "] ");
        System.out.print("Order with ID " + order.getOrderNumber());
        System.out.print(" added: " + symbol);
        System.out.print(" " + order.getAdType());
        System.out.print(" " + order.getQuantity());
        System.out.println(" @ " + order.getCost());
    }

    public static void printCancelOrder(String symbol, Order order) {
        System.out.print("[" + ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z")) + "] ");
        System.out.print("Order with ID " + order.getOrderNumber());
        System.out.print(" canceled: " + symbol);
        System.out.print(" " + order.getAdType());
        System.out.print(" " + order.getQuantity());
        System.out.println(" @ " + order.getCost());
    }

    public static int getOrdersCounter() {
        return ordersCounter;
    }

    public static void setOrdersCounter(int ordersCounter) {
        TradingGateway.ordersCounter = ordersCounter;
    }
}
