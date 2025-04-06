package org.example.DataStructures.Search;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,5,2,6,3,7};
        int target = 6;
        boolean flag = false ;
        for (int i: arr){
            if (target == i){
                flag=true;
                break;
            }
        }
        if (flag){
            System.out.println("Element Found");
        }
        else {
            System.out.println("Element not found");
        }
    }
}
