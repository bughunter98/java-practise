package org.example.DataStructures.Sorting;

import java.util.Arrays;

public class MergeSort {
    // 6 3 9 5 2 8
    static int[] mergeSort(int[] arr){
        return mergeSortUsingNewArrays(arr);
    }
    private static int[] mergeSortUsingNewArrays(int[] arr) {
        if (arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    public static void mergeSortInSameArray(int[] arr,int start , int end) {

        if (end-start==1){
            return;
        }
        int mid = start+(end-start)/2; //  u can use this also start+end/2;
        mergeSortInSameArray(arr,start,mid);
        mergeSortInSameArray(arr,mid,end);

        mergeInPlace(arr , start , end , mid);
    }

    private static void mergeInPlace(int[] arr, int start, int end, int mid) {
        int[] newArray = new int[end-start];
        int i = start; // pointer for array1
        int j = mid; // pointer for second array
        int k= 0; // pointer for newArray
        while (i<mid && j<end){
            if (arr[i]<arr[j]){
                newArray[k]=arr[i];
                i++;
            }
            else {
                newArray[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i< mid){
            newArray[k]=arr[i];
            i++;
            k++;
        }
        while (j< end){
            newArray[k]=arr[j];
            j++;
            k++;
        }
        for (int l=0;l< newArray.length;l++) {
            arr[start + l] = newArray[l];
        }
    }

    private static int[] merge(int[] firstArr, int[] secondArr) {
        int[] newArray = new int[firstArr.length+secondArr.length];

        int i = 0; // pointer for array1
        int j = 0; // pointer for second array
        int k= 0; // pointer for newArray

        while (i<firstArr.length && j<secondArr.length){
            if (firstArr[i]<secondArr[j]){
                newArray[k]=firstArr[i];
                i++;
            }
            else {
                newArray[k] = secondArr[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays has more elements than that elements needs to be added into array

        // in below 2 while loops any one will run . 2 loops will never be executed because only one array can be
        // larger than the second
        while (i< firstArr.length){
            newArray[k]=firstArr[i];
            i++;
            k++;
        }
        while (j< secondArr.length){
            newArray[k]=secondArr[j];
            j++;
            k++;
        }
        return newArray;
    }

}
