package org.example.Programs;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        fibonacciForLoop();
    }

    private static void fibonacciForLoop() {
        int num1 = 0 ,  num2 = 1;
        System.out.println("enter the range of fibonacci series to print");
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        int output = 0;
        System.out.println("Fibonacci Series is : ");
        for (int i =0;i<range;i++){
            if (i==0){
                System.out.printf("%d , %d , ",num1,num2);
            }
            else {
                System.out.printf("%d , ",output);
            }
            output = num1+num2;
            num1=num2;
            num2=output;
        }
    }
}
