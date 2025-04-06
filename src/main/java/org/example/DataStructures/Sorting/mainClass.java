package org.example.DataStructures.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mainClass {
    public static void main(String[] args) {
        int[] arr= new int[]{5,2,9,6,4,3,8};
        int[] arr1 = new int[]{5,2,9,6,4,3,8};
        int[] arr2 = new int[]{5,2,9,6,4,3,8};
        int[] arr3 = new int[]{5,2,9,6,4,3,8};
        System.out.println("Array before Bubble sort : "+Arrays.toString(arr));
        BubbleSort.bubbleSort(arr);
        System.out.println("Array after Bubble sort  : " +Arrays.toString(arr));
        System.out.println("Array before Selection sort : "+Arrays.toString(arr1));
        SelectionSort.selectionSort(arr1);
        System.out.println("Array after Selection sort  : "+ Arrays.toString(arr1));
        System.out.println("Array before Insertion sort : "+Arrays.toString(arr2));
        InsertionSort.insertionSort(arr2);
        System.out.println("Array after Insertion sort  : "+ Arrays.toString(arr2));

        System.out.println("-------------------------------Bucket sort-----------------------------------");
        System.out.println("Array before Bucket sort : "+Arrays.toString(arr3));
        BucketSort.bucketSort(arr3);
        System.out.println("Array after Bucket sort : "+Arrays.toString(arr3));

        int[] array = {6,3,9,5,2,8};
        int[] array1 = {6,3,9,5,2,8};
        int[] mergeSortedArray =  MergeSort.mergeSort(array);
        System.out.println("Array before merge sort :" + Arrays.toString(array));
        System.out.println("Array after merge sort :" + Arrays.toString(mergeSortedArray));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Array before merge sort :" + Arrays.toString(array1));
        MergeSort.mergeSortInSameArray(array1,0,array1.length);
        System.out.println("Array after merge sort :" + Arrays.toString(array1));

        int[] heapArr = { 60, 20, 40, 70, 30, 10 };
        System.out.println("Before Heap Sorting: "
                + Arrays.toString(heapArr));
        HeapSort.heapSort(heapArr);
        HeapSort.heapSort1(heapArr);
        System.out.println("After Heap Sorting: "
                + Arrays.toString(heapArr));

        List<Integer> list = new ArrayList<>();
        //list.
    }

}
