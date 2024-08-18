package org.example.Programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Permutations {
    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,3,4,5};
        int[] array2 = new int[]{2,4,3,1,5};

        boolean isArrayAPermutation = permutation(array1, array2); // time complexity O(n log n)
        boolean isArrayAPermutation1 = permutation1(array1, array2);// time complexity O(n)
        boolean isArrayAPermutation2 = permutation2(array1, array2);// time complexity O(n) .. easy way
        System.out.println("Are arrays permutations ?" +isArrayAPermutation);
        System.out.println("Are arrays permutations ?" +isArrayAPermutation1);
        System.out.println("Are arrays permutations ?" +isArrayAPermutation2);

    }

    private static boolean permutation2(int[] array1, int[] array2) {
        if (array1.length!=array2.length){
            return false;
        }
        int sum1=0,sum2=0,prod1=1,prod2=1;
        for (int i=0;i<array1.length;i++){
            sum1+=array1[i];
            sum2+=array2[i];
            prod1*=array1[i];
            prod2*=array2[i];
        }
        return (sum1 == sum2) && (prod1 == prod2);
    }

    private static boolean permutation1(int[] array1, int[] array2) {
        // creating hashmap to update integer frequencies
        Map<Integer,Integer> hashMap = new HashMap<>();

        // Iterate through arr1 and update integer frequencies in hashMap
        for (int val: array1){
            hashMap.put(val,hashMap.getOrDefault(val,0)+1);
        }
        // Iterate through str2 and decrement integer frequencies
        for (int val : array2){
            if (!hashMap.containsKey(val)){  // If a character in str2 is not found in str1
                return false;
            }
            int count = hashMap.get(val);
            if (count==1){
                hashMap.remove(val); // Remove the character if its count becomes zero
            }else {
                hashMap.put(val, count - 1); // Decrement the count
            }

        }
        // If the HashMap is empty, all characters in arr1 have been matched and arr2 is a permutation of arr1
      return hashMap.isEmpty();
    }

    public static boolean permutation(int[] array1, int[] array2){

        if (array1.length!=array2.length){
            return false;
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        //boolean isPermutation = true;
        for (int i=0;i<array1.length;i++){
            if (array1[i]!=array2[i]){
                return false;
            }
        }
        return true;
    }
}
