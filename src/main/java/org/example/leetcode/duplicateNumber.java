package org.example.leetcode;

import java.util.Arrays;

public class duplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,2};
        int[] arr1 = {1,1,2};
        int duplicateNum = findDuplicateNumber(arr);
        int countOfArrayWihoutDuplicates = removeDuplicate(arr1);
        System.out.println("Duplicate Number is "+duplicateNum);
        System.out.println("count of unique Numbers in array is "+countOfArrayWihoutDuplicates);
    }

    private static int removeDuplicate(int[] arr) {
        int count = 0;
        for (int i=1;i<arr.length;i++){
            if (arr[count]!=arr[i]){
                count++;
                arr[count]=arr[i];
            }
        }
        int[] finalArray = new int[count];
        for (int i=0;i<count;i++){
            finalArray[i]=arr[i];
        }
        System.out.println("Array without duplicates is "+Arrays.toString(finalArray));
     return count;
    }

    private static int findDuplicateNumber(int[] arr) {
        Arrays.sort(arr); // {1,2,2,3,4}
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]==arr[i+1]){
                return arr[i];
            }
        }
        return 0;
    }

}
