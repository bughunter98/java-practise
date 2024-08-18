package org.example.leetcode;


/*
here both the arrays are sorted arrays and we need to merge them togeather
* Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
* */

import java.sql.Time;
import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
       int[] nums1 = new int[]{1,2,3,0,0,0}, nums2 = new int[]{2,5,6};
       int m = 3,n=3;
       merge(nums1,m,nums2,n); // my approach  here time complexity is (m+n)log(m+n) and space complexity is 1
       merge1(nums1,m,nums2,n); // youtube approach here time complexity is (m+n) and space complexity is 1
    }

    private static void merge1(int[] nums1, int m, int[] nums2, int n) { // 2 pointer approach
        int ptr1=m-1 ,ptr2=n-1 , k = m+n-1 ;
        long startTime,endtime;
        startTime = System.currentTimeMillis();
        while (ptr2>=0){
            if (ptr1>=0 && (nums1[ptr1]>nums2[ptr2])){
                nums1[k]=nums1[ptr1];
                k--;
                ptr1--;
            }
            else {
                nums1[k]=nums2[ptr2];
                k--;
                ptr2--;
            }
        }
        endtime = System.currentTimeMillis();
        System.out.println("Array using merge1 method : "+Arrays.toString(nums1));
        System.out.println("Time taken for merge1 method : "+(endtime-startTime)+"milli seconds");
    }
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        long startTime,endtime;
        startTime = System.currentTimeMillis();
        int counter=0;
        for (int i=m;i<m+n;i++){
            nums1[i]=nums2[counter];
            counter++;
        }
        Arrays.sort(nums1);
        endtime = System.currentTimeMillis();
        System.out.println("Array using merge method : "+Arrays.toString(nums1));
        System.out.println("Time taken for merge method : "+(endtime-startTime)+"milli seconds");
    }
}
