package org.example.Programs;

import java.util.Scanner;

public class NoOfPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println("Total no of permutations possible for the entered val "+s+" is "+permutations(s));

    }
    private static int permutations(int n){
        int val = 1;
        if (n>0){
          val= (n*permutations(n-1));
        }
        return val;
    }
}
