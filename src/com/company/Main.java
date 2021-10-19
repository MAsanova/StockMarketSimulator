package com.company;

import com.company.components.MatchingEngine;
import com.company.components.TradingGateway;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        welcomeMessage();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Timer timer = new Timer();
        timer.schedule(new MatchingEngine(), 0, 1000);

        while (true) {
            try {
                String inputString = reader.readLine();

                String[] inputParams = inputString.split(" ");
                String action = inputParams[0];
                String symbol = inputParams[1];
                char adType = Character.toLowerCase(inputParams[2].charAt(0));
                int quantity = Integer.parseInt(inputParams[3]);
                int cost = Integer.parseInt(inputParams[4]);

                if (checkInputDataCorrect(action, adType, quantity, cost)) {
                    if (action.equalsIgnoreCase("add")) {
                        TradingGateway.addOrder(symbol, adType, quantity, cost);
                    } else if (action.equalsIgnoreCase("cancel")) {
                        TradingGateway.cancelOrder(symbol, adType, quantity, cost);
                    }
                }
            } catch (Exception e) {
                welcomeMessage();
            }
        }
    }

    private static boolean checkInputDataCorrect(String action, char adType, int quantity, int cost) {
        if (!action.equalsIgnoreCase("add") && !action.equalsIgnoreCase("cancel")) {
            System.out.println("Only 2 actions available: add and cancel");
            return false;
        }
        if (adType != 'b' && adType != 's') {
            System.out.println("Unknown ad type");
            return false;
        }
        if (quantity <= 0) {
            System.out.println("The quantity must be greater than 0");
            return false;
        }
        if (cost <= 0) {
            System.out.println("The cost must be greater than 0");
            return false;
        }
        return true;
    }

    private static void welcomeMessage() {
        System.out.println("Input the order according to the form: add/cancel item buy/sell quantity cost");
        System.out.println("Example: add GOOG buy 100 50");
    }
}
