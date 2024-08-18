package org.example.leetcode;

import java.util.Arrays;

public class MiddleArray {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        int[] midArray = middleArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(midArray));
    }

    private static int[] middleArray(int[] array) {
        int[] myArray = new int[array.length-2];
        for (int i=0;i<myArray.length;i++){
           myArray[i]=array[i+1];
        }
        return myArray;
    }
}
