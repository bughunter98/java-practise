package org.example.GFG;

import java.util.Arrays;

public class Day8MinimizeTheMaxDiffBwHeights {
    public static void main(String[] args) {
       int[] arr = {1,8,10,6,4,6,9,1};
/*       int[] arr1 = {1, 5, 8, 10};
       int[] arr2 = {1,8,10,6,4,6,9,1};*/
       System.out.println("Max and min diff between heights is "+MinTheMaxBwHeights(arr,7));
       //System.out.println("Max and min diff between heights is "+MinTheMaxBwHeights(arr1,2));
       //System.out.println("Max and min diff between heights is "+MinTheMaxBwHeights(arr2,7));

    }
     //approach  ---> time comp : O(nlogn) , space O(1).
    private static int MinTheMaxBwHeights(int[] arr, int key) {
        // sort array
        Arrays.sort(arr);

        int res = arr[arr.length-1]-arr[0]; // this is the max diff after sorting


        int smallest = arr[0]+key; // after sorting the array we are adding +k to the smallest val
        int largest = arr[arr.length-1]-key; // after sorting the array we are sub -k to the largest val

        int current_max,current_min;

        for (int i =0;i<arr.length-1;i++) {
            current_min = minimum(smallest,arr[i+1]-key);
            current_max = maximum(largest,arr[i]+key);
            if (current_min<0) continue;
            res = minimum(res,current_max-current_min);
        }
        return res;
    }

    private static int maximum(int largest, int i) {
        if (largest>i)
            return largest;
        else
            return i;
    }

    private static int minimum(int smallest, int i) {
        if (smallest<i)
            return smallest;
        else
            return i;
    }
}
