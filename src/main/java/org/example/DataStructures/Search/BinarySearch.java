package org.example.DataStructures.Search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int target = 7;

        int result = binarySearch(arr, target);
        if (result==-1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index : "+result);
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        // 1 3 5 7 9 10 13
        while (start<=end){
            int mid = start+(end-start)/2; // this is similar to start+end/2;
            if (arr[mid]==target){
                return mid;
            }
            if (arr[mid]>target){ // target is less than middle
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }
}
