package org.example.DataStructures.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class BucketSort {
    public static void bucketSort(int[] arr){
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;
        for (int val : arr){
            if (val>maxValue){
                maxValue=val;
            }
        }
        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i=0;i<buckets.length;i++){
            buckets[i] = new ArrayList<>();
        }
        for (int value : arr ){
            int bucketNumber = (int) Math.ceil(((float)value*numberOfBuckets)/(float)maxValue);
            buckets[bucketNumber-1].add(value);
            System.out.println("Printing buckets before sorting");
            printBuckets(buckets);
        }

        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        System.out.println("Printing buckets after sorting");
        printBuckets(buckets);

        AtomicInteger index= new AtomicInteger();
        for (int i=0;i<buckets.length;i++){
            buckets[i].forEach(bucket->{
                arr[index.get()] = bucket;
                index.getAndIncrement();
            });
        }


    }

    public static void printBuckets(ArrayList<Integer>[] buckets){
        for (int i=0;i<buckets.length;i++){
            System.out.println("Bucket no "+i+" ");
            for (int j=0;j<buckets[i].size();j++){
                System.out.print(buckets[i].get(j)+" ");
            }
            System.out.println();
        }
    }
}
