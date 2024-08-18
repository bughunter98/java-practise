package org.example.DataStructures.LinkedList.DoublyLinkedList;

import java.util.Scanner;

public class DoublyLinkedListMainClass {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;
        // 3 5 6
        System.out.println("""
                    ---------------------------------------------------------------------
                    Press 1 to insert data in Linked List
                    Press 2 to delete from linked list by location
                    Press 3 to delete from linked list by value
                    Press 4 to delete entire linked List
                    Press 5 to display Linked List
                    Press 6 to search Linked List
                    """);

        while (true){

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the data to insert in Linked List");
                    int data = scanner.nextInt();
                    System.out.println("Enter the location");
                    int location = scanner.nextInt();
                    doublyLinkedList.insertDoublyLinkedList(data,location);
                    break;
                case 2:
                    System.out.println("Enter location/index to delete");
                    int loc = scanner.nextInt();
                    doublyLinkedList.deleteInDoublyLinkedList(loc);
                    break;
                case 3:
                    /*System.out.println("Enter value to delete");
                    int val = scanner.nextInt();
                    doublyLinkedList.de(val);*/
                    break;
                case 4:
                    doublyLinkedList.deleteEntireLinkedList();
                    break;
                case 5:
                    doublyLinkedList.displayDoublyLinkedList();
                    System.out.println();
                    doublyLinkedList.reverseTraversalOfDoublyLinkedList();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Enter value to search");
                    int value = scanner.nextInt();
                    doublyLinkedList.searchNode(value);
                    break;
                default:
                    System.exit(1);
            }
        }
    }
}
