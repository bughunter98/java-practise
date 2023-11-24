package org.example.Programs;

import java.util.Arrays;

public class SecondLargestNumberinArray {
    public static void main(String[] args) {

        // Approach -1

        //1. input Array
        int [] array = {23,56,47,48,10,9,7};
        int second,smallest;
        Integer largest = second =Integer.MIN_VALUE;

        // 2. First for loop to find largest number in array and assign to variable largest
        for (int i=0;i<array.length;i++){
            largest=Math.max(largest,array[i]);
        }
        //3 . second for loop to compare the largest value and find second largest value.
        smallest=array[0];
        for (int i=0;i<array.length;i++){
            if (array[i]!=largest){
                second=Math.max(second,array[i]);
                //smallest=Math.min(smallest,array[i]);
            }
            if (array[i]<smallest){
                smallest=array[i];
            }
        }
        System.out.println("Second largest Value is "+second);
        System.out.println("Smallest value in Array is "+smallest);


        //Approach - 2

        //1 . Input Array
        int [] array1 = {23,56,47,48,10,9,7};
        //2 . sort the array now array sorted in ascending and we can find largest val
        Arrays.sort(array1);
        // 3 . Run for loop from second last element in array
        for (int i=array1.length-2;i>=0;i--){
            if (array1[i]!=array1[i-1]){
                System.out.println("Second largest Value is "+array1[i]);
                return;
            }
        }




    }
}
