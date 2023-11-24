package org.example.DataStructures;

import java.util.Arrays;

public class MissingNumbers {
    public static void main(String[] args) {
        MissingNumbers missingNumbers = new MissingNumbers();
        int[] array = {2, 4, 1, 8, 6, 3, 7};
        int[] tempArray = createRangeArray(array.length + 1);
    //  int missingNumber = missingNumbers.findMissingNumberinRange(array,tempArray); // time comp : 0(n log n) // space comp : 0(n) we are sotring array in one more temp array
        int missingNumber = missingNumbers.missingNUmber(array); // time comp : 0(n) and space Complexity : 0(1)
        System.out.println("Missing Number is " + missingNumber);
    }

    private int missingNUmber(int[] array) {
        int n=array.length+1,sum = n*(n+1)/2;

        for (int i=0;i<array.length;i++){
            sum = sum-array[i];
        }
        return sum;
    }

    private static int[] createRangeArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i + 1;
        }
        return array;
    }


    private int findMissingNumberinRange(int[] array, int[] rangeArray) {
        int missingNumber = 0;
        boolean flag;
        Arrays.sort(array);
        try {
            for (int i = 0; i < rangeArray.length; i++) {
                flag = (rangeArray[i]!=array[i]);
                if (flag) {
                    missingNumber = rangeArray[i];
                    break;
                }
            }
        }
        catch (Exception e){
            missingNumber = rangeArray[rangeArray.length-1];
        }
        return missingNumber;
    }

}
