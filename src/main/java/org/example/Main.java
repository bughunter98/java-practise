package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int size=6;
        int index=0;
        // to test diff btw for and while
        for (int i=0;i<size;i++){
            System.out.println("Hi");
        }
        while (index<size){
            System.out.println("Bye");
            index++;
        }
    }
}