package org.example.Programs;

import java.util.Scanner;

public class numberofDigitsinInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Value");
        int val= scanner.nextInt();
        int count = 0;
        while (val!=0){
            val = val/10;
                count++;
        }
        int num = 1/10;
        System.out.println(num);
        System.out.println("number of digits is "+count);
    }
}
