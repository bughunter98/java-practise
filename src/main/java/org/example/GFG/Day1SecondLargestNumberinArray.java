package org.example.GFG;

import java.util.Arrays;

public class Day1SecondLargestNumberinArray {
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
        System.out.println("Second largest Value using approach 1 is "+second);
        System.out.println("Smallest value in Array is "+smallest);


        //Approach - 2

        //1 . Input Array
       int [] array1 = {23,56,47,48,10,9,7};
        //2 . sort the array now array sorted in ascending and we can find largest val
        // generally we find the second lrgest element in arr[n-2] index but if there are
        //duplicate elements then that will not work hence we are looping
        Arrays.sort(array1);
        // 3 . Run for loop from second last element in array
        int secondLargestVal = getSecondLargestVal(array1);
        System.out.println("second largest val using approach 2 is "+secondLargestVal);

        // approach 3 - best approach
        int[] arr = new int[]{23,56,47,48,10,9,7};
        int largst = Integer.MIN_VALUE;
        int secondLargst = Integer.MIN_VALUE;
        for (int i =0;i<arr.length;i++){
            if (arr[i]>largst){
                secondLargst=largst;
                largst = arr[i];
            }
            else if (arr[i]<largst && arr[i]>secondLargst){
                secondLargst=arr[i];
            }
        }
        if (secondLargst == Integer.MIN_VALUE) {
            secondLargst=-1;
        }
        System.out.println("2nd largest element using best approach "+secondLargst);

    }

    private static int getSecondLargestVal(int[] array1) {
        for (int i=array1.length-2;i>=0;i--){
            if (array1[i]!=array1[array1.length-1]){
                return array1[i];
            }
        }
        return -1; // if no largest val is found return -1
    }
}
