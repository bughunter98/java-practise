package org.example.GFG;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day3ReverseArray{
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2};
        int[] temp = new int[arr.length];
        int counter = 0;

        // Approach 1 Naive Approach .
        // reverse using temp array
        // time and space complexity is O(n)
        for (int i= arr.length-1;i>=0;i--){
            temp[counter]=arr[i];
            counter++;
        }
        System.out.println("Approach 1");
        for(int i=0;i<arr.length;i++){
            System.out.print(temp[i]+" ");
        }

        System.out.println();
        // Approach 2
        // Two pointer
        // time comp : O(n) . space comp : O(1)
        int[] arr1 = {4, 5, 1, 2};
        int left = 0;
        int right = arr1.length-1;

        while (left<right){
                int tmp = arr1[left];
                arr1[left] = arr1[right];
                arr1[right]=tmp;
                left++;
                right--;
        }
        System.out.println("Approach 2");
        for (int j : arr1) {
            System.out.print(j + " ");
        }

        System.out.println();

        // Approach 3
        // in built methods
        // time comp : O(n) . space comp : O(1)
        int[] arr2 = {4, 5, 1, 2};
        List<Integer> list = new java.util.ArrayList<>(Arrays.stream(arr2).boxed().toList());
        Collections.reverse(list);
        System.out.println("Approach 3");
        for (int j : list) {
            System.out.print(j + " ");
        }

        System.out.println();
        // Approach 4
        // by swapping in array

        // time comp : O(n) . space comp : O(1)
        int[] arr3 = {4, 5, 1, 2};
        int n = arr3.length;
        for (int i=0;i<n/2;i++){

            int tmp = arr3[i];
            arr3[i]=arr3[n-i-1];
            arr3[n-i-1] = tmp;

        }

        System.out.println("Approach 4");
        for (int j : arr3) {
            System.out.print(j + " ");
        }
    }
}
