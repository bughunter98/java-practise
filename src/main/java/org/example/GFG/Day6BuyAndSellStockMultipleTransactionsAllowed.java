package org.example.GFG;

public class Day6BuyAndSellStockMultipleTransactionsAllowed {
    //Stock Buy and Sell - Multiple Transaction Allowed

    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};

        System.out.println("Max Profit that can be made is :"+maxProfit(prices));
    }
    static int maxProfit(int[] prices){

        int n = prices.length;
        int total = 0;

        for (int i=1;i<n;i++){
            if (prices[i]>=prices[i-1]){
                total = total+ (prices[i]-prices[i-1]);
            }
        }
        return total;
    }
}
