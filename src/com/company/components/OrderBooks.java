package com.company.components;

import com.company.components.additional.Order;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class OrderBooks {
    private static LinkedHashMap<String, ArrayList<Order>> orderBooksMap = new LinkedHashMap<>();

    public static LinkedHashMap<String, ArrayList<Order>> getOrderBooksMap() {
        return orderBooksMap;
    }

    public static void setOrderBooksMap(LinkedHashMap<String, ArrayList<Order>> orderBooksMap) {
        OrderBooks.orderBooksMap = orderBooksMap;
    }
}
