package org.example.leetcode;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(array);
        System.out.println("**************************************");
        rotateMatrixWithNewArray(array);
        System.out.println("**************************************");
        rotateMatrixWithNewArray1(array);
        System.out.println("**************************************");
        rotateMatrixWithoutNewArray(array);
        System.out.println("**************************************");
        System.out.println("Using indexing .. but i didnot understood .. need to check once");
        int[][] array1 = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(array1);
        System.out.println(Arrays.deepToString(array1));
    }

    private static void rotateMatrixWithoutNewArray(int[][] array) {
        // transposing the array will turn rows to coloumns and coloumns to rows
        // then mirroring the array will give solution
        transpose(array);
        reverseMatrix(array);
        printMatrix(array);

    }

    private static void reverseMatrix(int[][] array) {
        for (int i=0;i<array.length;i++){
            int left=0;
            int right=array[i].length-1;
            //for (int j=0;j<array.length;j++){
                while (left<right){
                    int temp = array[i][left];
                    array[i][left]=array[i][right];
                    array[i][right]=temp;
                    left++;
                    right--;
                }
            //}
        }

    }

    private static void transpose(int[][] array) {
        // we will just iterate over the first upper triangle above diagonal
        /*   1 2 3                               1 2 3
             4 5 6     ---> upper diagonal is      5 6
             7 8 9                                   9
        */
        for (int i=0;i<array.length-1;i++){ // so we need to traverse 2 rows as per above example .. so i need to travel
                                            // till 3-1 --> 2 rows
            for (int j=i+1;j<array.length;j++){ //so we need to traverse 3 coloumns as per above example .. so j need to travel
                int temp=array[i][j];         // till 3 coloumns
                array[i][j] = array[j][i];    // swapping the elements to lower diagonal
                array[j][i]=temp;
            }
        }
    }

    private static void rotateMatrixWithNewArray(int[][] array) {
        int [][] rotatedMatrix = new int[array.length][array.length];
        int col=0;
        for (int i=0;i<array.length;i++){
            int row = array.length-1;
            for (int j=0;j<array.length;j++){
                if (row>=0){
                    rotatedMatrix[i][j] = array[row][col];
                }
                row--;
            }
            col++;
        }
     printMatrix(rotatedMatrix);
    }

    private static void rotateMatrixWithNewArray1(int[][] array) {
        /*
        * 0,0 goes to--> 0,2
0,1 goes to--> 1,2
0,2-->         2,2

1,0-->0,1
1,1-->1,1
1,2-->2,1

2,0-->0,0
2,1-->1,0
2,2-->2,0
*/
        int [][] rotatedMatrix = new int[array.length][array.length];
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length;j++){
                rotatedMatrix[j][array.length-1-i] = array[i][j];
            }
        }
        printMatrix(rotatedMatrix);
    }
    public static void rotate(int[][] matrix) {
        for (int min = 0; min < matrix.length / 2; ++min) {
            final int max = matrix.length - min - 1;
            for (int i = min; i < max; ++i) {
                final int offset = i - min;
                final int top = matrix[min][i];
                matrix[min][i] = matrix[max - offset][min];
                matrix[max - offset][min] = matrix[max][max - offset];
                matrix[max][max - offset] = matrix[i][max];
                matrix[i][max] = top;
            }
        }
    }

    private static void printMatrix(int[][] array) {
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length;j++){
               System.out.printf("%d  ",array[i][j]);
            }
            System.out.println();
        }
    }
}
