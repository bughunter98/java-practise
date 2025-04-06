package org.example.DataStructures.Sorting;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        // 5 3 4 7 2 8 6 9 1
        for (int i=1;i< arr.length;i++){
            int key = arr[i];
            int j = i;
            while (j>0 && arr[j-1]>key){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key;
        }
    }
}
