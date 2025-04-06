package org.example.DataStructures.Sorting;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        //5,2,9,6,4,3,8
        int n = arr.length;
       for (int i =0 ;i<n;i++){
           // find the maximum element in the array and swap with the correct index
           int lastIndex =  n-i-1;
           int indexOfMaxValue = getMaxIndex(arr , lastIndex);
           swap(arr,indexOfMaxValue,lastIndex);
       }
    }

    private static void swap(int[] arr , int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int getMaxIndex(int[] arr, int lastIndex) {
        int max = 0;
        for (int i = 0 ; i<lastIndex ; i++){
            if (arr[max]<arr[i]){
                max = i;
            }
        }
        return max;
    }
}
