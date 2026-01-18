package org.example.GFG;

import java.util.*;


public class Day11SmallestPossibleMissing {
    public static void main(String[] args) {
        int [] arr = {2, -3, 4, 1, 1, 7};
        int [] arr1 = {5,3,2,3,1};
        int [] arr2 = {-8,0,-1,-4,-3};
        int [] arr3 = {1,2,3,4,5,6};
        int [] arr4 = {2,3,1,-3,8,2};
        smallestPositiveNum(arr);
        smallestPositiveNum(arr1);
        smallestPositiveNum(arr2);
        smallestPositiveNum(arr3);
        int output = findFirstMissingPsitiveNum(arr);
        int output1 = findFirstMissingPsitiveNum(arr1);
        int output2 = findFirstMissingPsitiveNum(arr2);
        int output3 = missingNumber(arr3);
        int output4 = missingNumber(arr4);
        System.out.println(output);
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
        System.out.println(output4);
        //System.out.println(findFirstMissingPsitiveNum(arr1));
        //System.out.println(findFirstMissingPsitiveNum(arr2));
        //System.out.println(findFirstMissingPsitiveNum(arr3));
    }

    // approch 1 , sorting
    // time complexity O(nlogn) and space O(1)
    private static int missingNumber(int[] arr){
        Arrays.sort(arr);
        int res =1;
        for (int i=0;i< arr.length;i++){
            if (arr[i]==res){
                res++;
            } else if (arr[i]>res) {
                break;
            }
        }
        return res;
    }


    //approach 2
    // to use hashmap
    // time complexity O(n) and space O(n)
    private static void smallestPositiveNum(int[] arr){
        Map<Integer,Boolean> map = new HashMap<>();
        for (int j : arr) {
            if (j>0){
                map.put(j, true);
            }
        }
        int output =0;
        int i=1;
        boolean flag=true;
        while (flag){
            if (!map.containsKey(i)){
                output=i;
                flag=false;
            }
            i++;
        }
        System.out.println(output);
    }

     // approach 3 , swapping
    // time complexity O(n) and space O(1)
    private static int findFirstMissingPsitiveNum(int[] arr){
        int n=arr.length;
        for (int i=0;i<n;i++){
            int currElement = arr[i];
            if (currElement>=1 && currElement<=n){
                int position = currElement-1; //
                if (arr[position]!=currElement){
                    int temp = arr[position];
                    arr[position]=arr[i];
                    arr[i]=temp;
                    // we are doing thid becasue after swapping we need to
                    // again check if the swapped element is in its respective position
                    // or not
                    i--;
                }
            }
        }

        for (int i=0;i< arr.length;i++){
            if (i+1!=arr[i]){
                return i+1;
            }
        }
        return arr.length+1;
    }

}
