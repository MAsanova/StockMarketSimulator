package com.company.components;

import com.company.components.additional.Order;
import com.company.components.additional.Trade;
import java.util.*;

public class MatchingEngine extends TimerTask {
    @Override
    public void run() {
        int maxCost = 0;
        int orderNumberToBuy = 0;
        int orderNumberToSell = 0;
        String symbol = "";
        int quantity = 0;
        int orderIDToBuy = 0;
        int orderIDToSell = 0;

        for (Map.Entry<String, ArrayList<Order>> orderBook : OrderBooks.getOrderBooksMap().entrySet()) {
            for (int i = 0; i < orderBook.getValue().size(); i++) {
                if (orderBook.getValue().get(i).getAdType() == 'b' && orderBook.getValue().get(i).getCost() > maxCost) {
                    for (int j = 0; j < orderBook.getValue().size(); j++) {
                        if (orderBook.getValue().get(j).getAdType() == 's' &&
                                orderBook.getValue().get(i).getCost() >= orderBook.getValue().get(j).getCost()) {
                            maxCost = orderBook.getValue().get(i).getCost();
                            orderNumberToBuy = i;
                            orderIDToBuy = orderBook.getValue().get(i).getOrderNumber();
                            orderNumberToSell = j;
                            orderIDToSell = orderBook.getValue().get(j).getOrderNumber();
                            symbol = orderBook.getKey();
                        }
                    }
                }
            }
        }

        if (maxCost > 0) {
            int quantityToBuy = OrderBooks.getOrderBooksMap().get(symbol).get(orderNumberToBuy).getQuantity();
            int quantityToSell = OrderBooks.getOrderBooksMap().get(symbol).get(orderNumberToSell).getQuantity();
            if (quantityToBuy > quantityToSell) {
                quantity = quantityToSell;
                quantityToBuy -= quantityToSell;
                quantityToSell = 0;
                OrderBooks.getOrderBooksMap().get(symbol).get(orderNumberToBuy).setQuantity(quantityToBuy);
                OrderBooks.getOrderBooksMap().get(symbol).get(orderNumberToSell).setQuantity(quantityToSell);
            } else if (quantityToBuy < quantityToSell) {
                quantity = quantityToBuy;
                quantityToSell -= quantityToBuy;
                quantityToBuy = 0;
                OrderBooks.getOrderBooksMap().get(symbol).get(orderNumberToBuy).setQuantity(quantityToBuy);
                OrderBooks.getOrderBooksMap().get(symbol).get(orderNumberToSell).setQuantity(quantityToSell);
            } else {
                quantity = quantityToBuy;
                quantityToBuy = 0;
                quantityToSell = 0;
                OrderBooks.getOrderBooksMap().get(symbol).get(orderNumberToBuy).setQuantity(quantityToBuy);
                OrderBooks.getOrderBooksMap().get(symbol).get(orderNumberToSell).setQuantity(quantityToSell);
            }

            for (int i = 0; i < OrderBooks.getOrderBooksMap().get(symbol).size(); i++) {
                if (OrderBooks.getOrderBooksMap().get(symbol).get(i).getQuantity() == 0) {
                    OrderBooks.getOrderBooksMap().get(symbol).remove(i);
                    i--;
                }
            }

            Trade trade = new Trade(symbol, quantity, maxCost, orderIDToBuy, orderIDToSell);
            TradeLedger.printTrade(trade);
            TradeLedger.executedTrades.add(trade);
        }
    }
}
