package org.example.Programs.Patterns;

import java.util.Scanner;

public class AlphabetPattern {
    public static void main(String[] args) {
        System.out.println("input the number");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        pattern1(count);

    }

    private static void pattern1(int count) {
        char alphabet = 'a';
        for (int i=0;i<count;i++){
            for (int j = 0;j<=i;j++){
                if ((i+j)%2==0){ // this logic is important
                    System.out.print(Character.toUpperCase(alphabet)+"\t");
                }
                else {
                    System.out.print(alphabet+"\t");
                }
                alphabet++;
            }
            System.out.println();
        }
    }
}
