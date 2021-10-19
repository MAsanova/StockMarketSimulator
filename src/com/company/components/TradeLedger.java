package com.company.components;

import com.company.components.additional.Trade;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TradeLedger {
    public static ArrayList<Trade> executedTrades = new ArrayList<>();

    public static void printTrade(Trade trade) {
        System.out.print("[" + ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z")) + "] ");
        System.out.print("New execution with ID " + Trade.getExecutionNumber());
        System.out.print(":" + trade.getSymbol());
        System.out.print(" " + trade.getQuantity());
        System.out.print(" @ " + trade.getCost());
        System.out.print(" (orders " + trade.getOrderNumberToBuy());
        System.out.println(" and " + trade.getOrderNumberToSell() + ")");
    }
}
