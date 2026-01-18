package org.example.GFG;

public class AllPossibleSubArrays {
    public static void main(String[] args) {
        int[] arr = {2,3,8,7};
        int result=0;
        int subSum=0;
        for (int i=0;i< arr.length;i++){
            for (int j=i;j< arr.length;j++){
                for (int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

        // sum of sub arrays
        for (int i=0;i< arr.length;i++){
            subSum=0;
            for (int j=i;j< arr.length;j++){
                subSum+=arr[j];
                result+=subSum;
            }
        }
        System.out.println("Sum of sub array arr : "+result);
    }
}
