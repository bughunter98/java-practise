package org.example.leetcode;

public class BuyandSellStockLeetCode121 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        maxProfit(prices);

    }
    private static int maxProfit(int[] prices) {
        int buy_price = prices[0];
        int profit=0;
        int day = 1;
        for (int i=1;i<prices.length;i++){
            if (prices[i]<buy_price){
                buy_price = prices[i];
                day++;
            }
            else {
                int current_profit= prices[i]-buy_price;
                profit=Math.max(current_profit,profit);
            }

        }
        System.out.println("Maximum profit that a customer can get is :"+profit+
                " if he had bought the stock at value:"+buy_price+
                " and on day "+day);
        return profit;
    }
}
