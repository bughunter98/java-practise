package org.example.DataStructures;

import java.util.Scanner;

/* Time and Space Complexity of 2D Arrays
 *    opertaion                       Time Complexity                  space complexity
 *  1 Creating empty array                 O(1)                             O(mn)
 *  2 Inserting value at position          O(1)                             O(1)
 *  3 traversing an array                  O(mn)                            O(1)
 *  4 Accessing given cell                 O(1)                             O(1)
 *  5 searching a given value              O(mn)                            O(1)
 *  6 deleting value at position           O(1)                             O(1)
 */

public class TwodimensionalArray {
    public static void main(String[] args) {

        System.out.println("""
                ---------------------------------------------------------------------
                Press 1 to insert into 2D Array \s
                Press 2 to print 2D Array
                Press 3 to Search the value \s
                Press 4 to Delete the Value \s
                 ------------------------------------------------------------------------""");
        int i, j, choice;

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number of rows to be created");
        i = scanner.nextInt();
        System.out.println("enter the number of coloumns to be created");
        j = scanner.nextInt();
        int[][] twoDArray = new int[i][j];
        while (true) {
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    insertIntoTwoDArray(twoDArray, i, j, scanner);
                    break;
                case 2:
                    printTwoDArray(twoDArray, i, j);
                    break;
                case 3:
                    searchingTwoDArray(twoDArray, i, j, scanner);
                    break;
                case 4:
                    deleteValuein2DArray(twoDArray, i, j, scanner);
                    break;
                default:
                    System.exit(1);
            }
        }
    }

    private static void searchingTwoDArray(int[][] twoDArray, int row, int col, Scanner scanner) {
        System.out.println("Enter the value to be searched in array");
        int val = scanner.nextInt();
        int rowFound = 0, colFound = 0;
        boolean isFound = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (val == twoDArray[i][j]) {
                    isFound = true;
                    rowFound = i + 1;
                    colFound = j + 1;
                    break;
                }
            }
        }
        if (isFound) {
            System.out.println("Value found in the array at " + rowFound + "th row" + colFound + "th column");
        } else {
            System.out.println("Value is not present in array");
        }
    }

    private static void deleteValuein2DArray(int[][] twoDArray, int row, int col, Scanner scanner) {
        System.out.println("Enter the value to be deleted in array");
        int val = scanner.nextInt();
        int rowFound = 0, colFound = 0;
        boolean isFound = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (val == twoDArray[i][j]) {
                    isFound = true;
                    rowFound = i;
                    colFound = j;
                    twoDArray[i][j] = Integer.MIN_VALUE;
                    //break; commenting break because array might have duplicate values
                    // so incase duplicate value also needs to be deleted breaking loop is not good option
                }
            }
        }
        if (isFound) {
            System.out.println("Value Deleted in the array at " + rowFound + "th row" + colFound + "th column");
        } else {
            System.out.println("Value is not present in array");
        }
    }

    private static void printTwoDArray(int[][] twoDArray, int row, int col) {
        System.out.println("Printing Array :");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) { // we can use j<col also instead of twoDArray[i].length
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void insertIntoTwoDArray(int[][] twoDArray, int row, int col, Scanner scanner) {
        System.out.println("insert the " + row * col + "no. of elements to be added into array");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int value = scanner.nextInt();
                twoDArray[i][j] = value;
            }
        }
    }
}
