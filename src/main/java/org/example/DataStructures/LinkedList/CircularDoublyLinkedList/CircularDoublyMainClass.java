package org.example.DataStructures.LinkedList.CircularDoublyLinkedList;

import java.util.Scanner;

public class CircularDoublyMainClass {
    public static void main(String[] args) {
        CircularDoublyLinkedList doublyLinkedList = new CircularDoublyLinkedList();
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
                    doublyLinkedList.insertNode(data,location);
                    break;
                case 2:
                    System.out.println("Enter location/index to delete");
                    int loc = scanner.nextInt();
                    doublyLinkedList.deleteNodeFromLinkedListByLocation(loc);
                    break;
                case 3:
                    System.out.println("Enter value to delete");
                    int val = scanner.nextInt();
                    doublyLinkedList.deleteNodeFromLinkedListByValue(val);
                    break;
                case 4:
                    doublyLinkedList.deleteEntireLinkedList();
                    break;
                case 5:
                    doublyLinkedList.traverseDoublyLinkedList();
                    System.out.println();
                    doublyLinkedList.reverseTraverseDoublyLinkedList();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Enter value to search");
                    int value = scanner.nextInt();
                    doublyLinkedList.searchValue(value);
                    break;
                default:
                    System.exit(1);
            }
        }
    }
}
// 3 4 5 6