package org.example.GFG;
// https://www.youtube.com/watch?v=Za8V4wkZKkM
public class Day12MaxCircularSubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{8,-8,9,-9,10,-11,12};
        int[] arr1 = new int[]{10,-3,-4,7,6,5,-4,-1};
        int[] arr2 = new int[]{4,-1,-2,3};
        System.out.println(getMaxCircularSubArraySum(arr));
        System.out.println(getMaxCircularSubArraySum(arr1));
        System.out.println(getMaxCircularSubArraySumUsingKadaneAlgo(arr));
        System.out.println(getMaxCircularSubArraySumUsingKadaneAlgo(arr1));
        System.out.println(getMaxCircularSubArraySumUsingKadaneAlgo(arr2));


    }

    // Naive approach.
    // Time comp : O(n2) , space comp : O(1)
    private static int getMaxCircularSubArraySum(int[] arr) {
        int n = arr.length;
        int res = arr[0];

        for (int i=0;i<n;i++){
            int currSum = 0;
            for (int j=0;j<n;j++){
                // need to get last index for every iteration.
                int circularIndex = (i+j)%n;
                currSum=currSum+arr[circularIndex];
                res = Math.max(res,currSum);
            }
        }
        return res;
    }


    private static int getMaxCircularSubArraySumUsingKadaneAlgo(int[] arr){
        // approach is
        // step 1 : find sum of all elements in array
        // step 2: use kadane's algo to get max sub arry sum
        // step 3 : next to get circular subarray sum use sumOfAllElements-minSubArray(we can use kadane's algo here but for minimum )
        // finally  required output is given by max(step1,step2).
        int n = arr.length;
        int currMaxSum=0,maxSum=0;
        int currMinSum=0,minSum=arr[0];
        int totalSum = 0 , maxCircularSubArraySum=0;
        int output = 0;
        for (int i=0;i<n;i++){
            // step1.
            totalSum = totalSum+arr[i];

            // step2
            currMaxSum = Math.max(currMaxSum+arr[i],arr[i]); // this is kadane's algo
            maxSum = Math.max(maxSum,currMaxSum);

            // step3
            // to find minsum and subract with totalSum
            currMinSum = Math.min(currMinSum+arr[i],arr[i]);
            minSum = Math.min(currMinSum,minSum);

            maxCircularSubArraySum = totalSum-minSum;

        }

        // If the minimum subarray is equal to total Sum
        // then we just need to return normalSum
        if (minSum==totalSum){
            return maxSum;
        }

        // final output
        output = Math.max(maxSum,maxCircularSubArraySum);
        return output;
    }
}
