package org.example.Programs;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueArray {
    public static void main(String[] args) {
        int[] intArray = new int[]{1,2,3,4,5,6};
        boolean isArrayUnique = isUniqueArray(intArray); // time complexity O(n square)
        System.out.println("is the array unique ? Ans: "+isArrayUnique);
    }


    private static boolean isUniqueArray(int[] intArray) {
        for (int i =0;i<intArray.length;i++){
            for (int j=i+1;j<intArray.length;j++){
                if (intArray[i]==intArray[j]){
                    return false;
                }
            }
        }
        return true;
    }
}
