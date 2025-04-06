package org.example.HackerRank;

import  java.util.*;
import java.util.stream.IntStream;

public class DiagonalDifference {
    public static void diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int left = IntStream.range(0, arr.size()).map(i->arr.get(i).get(i)).sum(); // Primary diagonal (i == j)
        int right = IntStream.range(0, arr.size()).map(i->arr.get(i).get(arr.size()-1-i)).sum(); // // Secondary diagonal (i + j == size - 1)
        int diff = left-right<0 ? -(left-right): left-right;
        System.out.println("Diagonal difference is : "+diff +"where left and right values are : "+left +" and "+right);

    }
    public static void diagonalDifferenceUsingStreams(List<List<Integer>> arr) {
        // Write your code here
        int left =0,right=0;
        for (int i=0;i<arr.size();i++){
            for (int j=0;j< arr.size();j++){
                if (i==j){
                    left =left+arr.get(i).get(j);
                }
                if (i+j==arr.size()-1){
                    right = right+arr.get(i).get(j);
                }
            }
        }
        int diff = left-right<0 ? -(left-right): left-right;
        System.out.println("Diagonal difference is : "+diff +"where left and right values are : "+left +" and "+right);
    }
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(Arrays.asList(1, 2, 3));
        listOfLists.add(Arrays.asList(4, 5, 6));
        listOfLists.add(Arrays.asList(7, 8, 9));
        diagonalDifference(listOfLists);
        diagonalDifferenceUsingStreams(listOfLists);
        for (int i=0;i<6;i++){
            /*for (int j=0;j<=6-i-1;j++){
                System.out.print(" ");
            }*/
            System.out.print(" ".repeat(6-i-1).concat("*".repeat(i+1)));
            /*for (int k =0;k<=i;k++){
                System.out.print("*");
            }*/
            System.out.println();
        }
    }
}
