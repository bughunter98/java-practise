package org.example.leetcode;

import java.util.Arrays;

public class BestScore {
    public static void main(String[] args) {
       int[] myArray = new int[] {84,85,86,87,85,90,85,83,23,45,84,1,2,0};
       int[] twoBestScores = new int[2];
       int max = Integer.MIN_VALUE;
       int secondMax = Integer.MIN_VALUE;
       for (int i:myArray){
          if (i>max){
              secondMax=max;
              max=i;
          }
          else if (i>secondMax && i<max){
              secondMax=i;
          }
       }
       twoBestScores[0]=max;
       twoBestScores[1]=secondMax;
        System.out.println(Arrays.toString(twoBestScores));
    }
}
