package org.example.GFG;

import java.util.Scanner;

public class Day4RotateArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        // naive approach
        // In each iteration, shift the elements by one position to the left in a circular fashion (the first
        // element becomes the last). Perform this operation d times to rotate the elements to the left by d positions.

        // first iteration : 2 3 4 5 1
        // second iteration  3 4 5 1 2
        // third iteratiom : 4 5 1 2 3

        // Approach 1 time complexity will be O(n*d) space comp is O(1)
        System.out.println("Enter number of rotations");
        Scanner sc = new Scanner(System.in);
        int n = arr.length;
        int d = sc.nextInt();
        for (int i=0;i<d;i++){
          int a  = arr[0];
          for (int j=0;j< arr.length-1;j++){
              arr[j] = arr[j+1];
          }
          arr[n-1]=a;
        }
        System.out.println("Approach 1");
        printTheArray(arr);
        System.out.println();

        // Approach 2 both space and time complexity is O(n)
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] temp = new int[arr1.length];

        // to handle the case when d>n
        d=d%n;
        int part2= arr1.length - (arr1.length-d);
        int counter = 0;
        for (int i = part2;i< arr1.length;i++){
            temp[counter] = arr1[i];
            counter++;
        }
        for (int i=0;i<part2;i++){
           temp[counter] = arr1[i];
           counter++;
        }
        for (int i=0;i< arr1.length;i++){
            arr1[i]=temp[i];
        } // we can also use System.arrayCopy method also here
        System.out.println("Approach 2");
        printTheArray(arr1);

        System.out.println();

        // Approach 3 Time comp O(n) and space comp is (1)  -> efficient
        // 1 2 3      4 5 --> split
        // 3 2 1    5 4--> reverse each sub array
        // 4 5 1 2 3  . club them

        int[] arr2 = new int[]{1,2,3,4,5};
        reverseArray(arr2,0,d-1); // reversing the first sub Array
        reverseArray(arr2,d,arr2.length-1); // reversing the second sub Array
        reverseArray(arr2,0,arr2.length-1);// reverse entire array

        System.out.println("Approach 3");
        printTheArray(arr2);


    }
    private static void reverseArray(int[] arr , int start , int end){
        while (start<end){
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end]=tmp;
            start++;
            end--;
        }
    }

    private static void printTheArray(int[] arr) {
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]);
            if (i< arr.length-1){
                System.out.print(",");
            }
        }
    }
}
