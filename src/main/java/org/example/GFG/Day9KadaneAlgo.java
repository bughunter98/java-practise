package org.example.GFG;

public class Day9KadaneAlgo {
    public static void main(String[] args) {
        // general bture force approach to find max sum of sub array .
        int[] array = {1 ,2, 3, -2, 5};
        int subSum;
        int maxSubArray = 0;
        for (int i=0;i< array.length;i++){
            subSum=0;
            for (int j=i;j< array.length;j++){
                subSum+=array[j];
                if (subSum>maxSubArray){
                    maxSubArray = subSum;
                }
            }
        }
        System.out.println("Max Sub array value is :"+maxSubArray);

        // but in the above algo the time complexity will be O(n2)
        // this can be bought down to O(n) using kadane's algorithm.
        int currSum=array[0],maxSum=array[0];
        for (int i=1;i<array.length;i++){
            currSum = max(array[i],currSum+array[i]);
            maxSum = max(maxSum,currSum);
        }

        System.out.println(maxSum);

        // or we can also wrtie kadane algo in below manner
        //  i felt this one easy.....
        int max  = Integer.MIN_VALUE,curr = 0;
        for (int i : array){
            curr+=i;
            max = max(curr,max);
            if (curr<0){
                curr=0;
            }
        }

        System.out.println(max);

    }

    private static int max(int val1,int val2){
        return val1 > val2 ? val1 : val2;
    }
}
