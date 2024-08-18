package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://javaconceptoftheday.com/find-duplicates-in-array-in-java/#:~:text=%7D-,How%20To%20Find%20Duplicate%20Elements%20In%20Array%20In%20Java%20Using,that%20key%20is%20duplicate%20element.
public class duplicateValuesinArray {
    public static void main(String[] args) {
        int [] duplicateAray = {1,1,2,2,3,4,5,};
        int []  array = removeduplicatesinSortedArray(duplicateAray);
        int []  unSortedArray = removeduplicatesinUnSortedArray(duplicateAray);
        System.out.println("Sorted Array without duplicates is: "+Arrays.toString(array));
        System.out.println("Un Sorted Array without duplicates is: "+Arrays.toString(unSortedArray));
    }

    private static int[] removeduplicatesinUnSortedArray(int[] duplicateAray) {
        return null;

    }

    private static int[] removeduplicatesinSortedArray(int[] duplicateAray) {
        // return Arrays.stream(duplicateAray).distinct().toArray(); //using java 8
        /*Set<Integer> list = new HashSet<>(Arrays.asList(duplicateAray));
        list.removeIf(value->!list.add(value));*/
        // without java 8  {1,1,2,2,3,4,2,5,1};
        int[] arr = new int[duplicateAray.length];
        /*int index = 0 ;
        for (int i=0;i<duplicateAray.length;i++){
            boolean isDuplicate = false ;
            for (int j=i+1;j<duplicateAray.length;j++){
                if (duplicateAray[i]==duplicateAray[j]){
                    isDuplicate=true;
                    break;
                }
            }
            if (!isDuplicate){
                arr[index++] = duplicateAray[i];
            }
        }
        return arr;*/
        int index=0;
        for (int i=0;i<duplicateAray.length-1;i++){
           if (duplicateAray[i]!=duplicateAray[i+1]){
               arr[index] = duplicateAray[i];
               index++;
           }
           // this condition we are adding in order to add the last element in the array .
           // tihis will be added in each index but will be replaced by other numbers except the last index because of above for loop
           arr[index]=duplicateAray[duplicateAray.length-1];
        }
        return arr; // returns array but issue is it returns zeroes as well
        // we can also remove duplicates by creating an empty hashset and by iterating array adding elements into hashset would
        //do the job as hashset won't allow duplicated
    }
}
