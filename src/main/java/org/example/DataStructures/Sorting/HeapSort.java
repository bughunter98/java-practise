package org.example.DataStructures.Sorting;

import org.example.DataStructures.BinaryHeap.BinaryHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapSort {
    public static void heapSort(int[] arr){
        // using collections
        PriorityQueue<Integer> heap = new PriorityQueue<>(/*Collections.reverseOrder()*/);
        for (int j : arr) {
            heap.offer(j);
        }
        for (int i = 0;i< arr.length;i++){
            arr[i]=heap.poll();
        }

    }

    public static void heapSort1(int[] arr){
        BinaryHeap binaryHeap = new BinaryHeap(arr.length);
        for (int i=0;i< arr.length;i++){
            binaryHeap.insert(arr[i],"min");
        }
        for (int i=0;i<arr.length;i++){
            arr[i]= binaryHeap.extractNodeFromMinOrMaxBinaryHeap("min");
        }
    }
}
