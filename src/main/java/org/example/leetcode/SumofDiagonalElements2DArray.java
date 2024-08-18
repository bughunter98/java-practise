package org.example.leetcode;

import java.util.Arrays;

public class SumofDiagonalElements2DArray {
    public static void main(String[] args) {
      int[][] myArray2D= new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(myArray2D));
        System.out.println("Length of 2D Array: "+myArray2D.length);
        int sum = 0;
        for (int i=0;i<myArray2D.length;i++){
            for (int j=0;j<myArray2D[i].length;j++){
                if (i==j){
                   sum+=myArray2D[i][j];
                }
            }
        }
        System.out.println("Sum of diagonal elements is : "+sum);
    }
}
