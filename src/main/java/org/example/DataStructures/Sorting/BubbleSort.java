package org.example.DataStructures.Sorting;

public class BubbleSort {

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for (int i=0;i<n-1;i++){ // i will iterate till n-1 because after the
            // first round anyhow max element will be on last index also n+1 would give insex out ofbounds
            for (int j=0;j<n-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

        }
    }
    public static void bubbleSort1(int[] arr){
        int n = arr.length;
        for (int i=0;i<n;i++){
            for (int j=1;j<n-i;j++){
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }

        }
    }
}
