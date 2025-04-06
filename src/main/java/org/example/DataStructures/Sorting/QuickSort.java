package org.example.DataStructures.Sorting;

public class QuickSort {
    public void quickSort(int[]nums , int low , int high){
        if (low>high){
            return;
        }
        int start = low;
        int end = high;
        int mid = start+(end-start)/2;
        int pivot = nums[mid];
        while (start<=end){
            while (nums[start]<pivot){
                start++;
            }
            while (nums[end]>pivot){
                end--;
            }
            if (start<=end){
                int temp = nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
                start++;
                end--;
            }
        }
        // now pivot is at correct index . please sort it into 2 halves
        quickSort(nums,low,end);
        quickSort(nums,start,high);
    }
}
