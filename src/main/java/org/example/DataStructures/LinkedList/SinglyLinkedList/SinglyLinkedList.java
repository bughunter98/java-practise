package org.example.DataStructures.LinkedList.SinglyLinkedList;


import java.util.Scanner;

public class SinglyLinkedList {

    public Node head = null;
    public Node tail = null;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("---------------------------------------------------------------------\n" +
                "Press 1 to insert at Beginning \nPress 2 to insert at End \nPress 3 to insert in specific position\n" +
                "Press 4 to Delete at Beginning \nPress 5 to Delete at End \nPress 6 to Delete in specific value\n "+
                "------------------------------------------------------------------------");
        while (true) {
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the data to insert at Beginning of Linked List");
                    int data = scanner.nextInt();
                    singlyLinkedList.insertDatainBeginning(data);
                    break;
                case 2:
                    System.out.println("Enter the data to insert at End of Linked List");
                    int data1 = scanner.nextInt();
                    singlyLinkedList.insertDataatEnd(data1);
                    break;
                case 3:
                    System.out.println("Enter the data to insert at specific position of Linked List");
                    System.out.println("Enter position and data");
                    int position = scanner.nextInt();
                    int data2 = scanner.nextInt();
                    singlyLinkedList.insertatNthPosition(position,data2);
                    break;
                case 4:
                    singlyLinkedList.deleteDataatBeginning();
                    break;
                case 5:
                    singlyLinkedList.deleteDataatEnd();
                    break;
                case 6:
                    System.out.println("Enter position to delete data");
                    int position1 = scanner.nextInt();
                    singlyLinkedList.deleteAtPosition(position1);
                    break;
                default:
                    System.exit(0);
            }
        }

    }

    private void deleteDataatBeginning() {
        if (head!=null){
            Node temp = head;
            head = head.next;
            displayLinkedList();
            System.out.println("Deleted Data is "+temp.data);
        }
    }

    private void deleteDataatEnd(){
        if (head ==  null){
            System.out.println("List is empty");
        }
        else {
            if (head!=tail){
                Node current = head;
                while (current.next!=tail){
                    current = current.next;
                }
                tail = current;
                tail.next=null;
                System.out.println("Deleted data is "+current.data);
                displayLinkedList();
            }
            else {
                head = tail = null;
            }
        }
    }
    private void deleteAtPosition(int position1) {
        if (head==null){
            System.out.println("List is empty...");
        }
        else {
          if (position1==1){
              head = head.next;
          }
          else {
              int count = 1;
              Node previous = head;
              while (count<position1-1){
                  previous = previous.next;
                  count++;
              }
              Node currentNode = previous.next;
              previous.next=currentNode.next;
          }
        }
        displayLinkedList();
    }

    private void insertDatainBeginning(int data) {
        Node node = new Node(data);
        if (head == null) { // if list is empty we are making the new node as head
            head = node;
            tail = node;
        } else { // making new node as head and moving the current head as second node
            Node tempNode = head;
            head = node;
            head.next = tempNode;
        }
        displayLinkedList();
    }
    private void insertDataatEnd(int data){
        Node node = new Node(data);
        if (head==null){
            head=node;
            tail=node;
        }
        else {
            tail.next = node;
            tail = node;
        }

        displayLinkedList();
    }

    private void insertatNthPosition(int position , int data){
        /* Example Demo
        linked list insertion at nth position
head = 6 , temp = 6 , current = null

first iteration

    current = 6 , temp = 5

second iteration

    current = 5 , temp = 4

third iteration

    current = 4 , temp = 3

fourth iteration

    this will break out of loop as we need to insert data in fourth position

    now current = 4 , temp = 3

    current.next to point to new data node and node.next to point to temp


        * */
        Node node = new Node(data);

        if (head==null){
            System.out.println("List is Empty so adding data in first node");
            head = node;
            tail = node;
        }
        else {
            Node current,temp ;
            temp = head;
            current =  null;
            for (int i=0;i<position-1;i++){
                current = temp;
                temp = temp.next;
            }
            current.next = node;
            node.next = temp;
        }
        displayLinkedList();
    }
    private void displayLinkedList() {
        int size=0;
        System.out.println("----Displaying the Linked List-----");
        Node current = head;
        if (head == null) {
            System.out.println("List is Empty");
            size = 1;
        } else {
            while (current != null) {
                System.out.print(current.data + "\t");
                current = current.next;
                size++;
            }
            System.out.println();
        }
        System.out.println("Size of linked List is "+size);
    }
}
