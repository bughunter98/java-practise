package org.example.GFG;

public class Day7BuyAndSellStockSingleTransaction {
    public static void main(String[] args) {
        int[] arr = {7,10,1,3,6,9,2};
        int[] arr1 = {7,6,4,3,1};
        int[] arr2 = {1,3,6,9,11};
        int[] arr3 = {3,10,1,2};
        // finding the min Value and min Index
        int maxProfit = maximumProfit(arr);
        int maxProfit1 = maximumProfit(arr1);
        int maxProfit2 = maximumProfit(arr2);
        int maxProfit3 = maximumProfitWihoutUsingMathLibraries(arr3);

        System.out.println("Max profit for arr "+maxProfit);
        System.out.println("Max profit for arr1 "+maxProfit1);
        System.out.println("Max profit for arr2 "+maxProfit2);
        System.out.println("Max profit for arr3 "+maxProfit3);
    }

    private static int maximumProfit(int[] arr) {
        int minSoFar=arr[0];
        int maxSoFar=0;
        for (int i=1;i<arr.length;i++){
        // 1. Update the lowest price we've seen until today
          minSoFar = Math.min(minSoFar,arr[i]);
          // calculate the profit for the day .
          int currentProfit = arr[i]-minSoFar;
          // find max profit
          maxSoFar = Math.max(currentProfit,maxSoFar);
        }
        return maxSoFar;
    }
    private static int maximumProfitWihoutUsingMathLibraries(int[] arr) {
        int minSoFar=arr[0];
        int maxSoFar=0;
        for (int i=1;i<arr.length;i++){
            // 1. Update the lowest price we've seen until today
            if (arr[i]<minSoFar){
                minSoFar=arr[i];
            }
            else {
                // check the current profit for minsofar
                int currentProfit = arr[i] - minSoFar;
                // find max profit
                if (currentProfit>maxSoFar){
                    maxSoFar= currentProfit;
                }

            }
        }
        return maxSoFar;
    }
}
