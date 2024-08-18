package org.example.DataStructures.LinkedList.SinglyLinkedList1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class SinglyLinkedList {
    public Node head ;
    public Node tail ;

    public int size ;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("---------------------------------------------------------------------\n" +
                "Press 1 to insert data in Linked List \nPress 2 to Search the Linked List\n"+
                "Press 3 to delete data from Linked List \n" +
                "Press 4 to delete entire Linked List \nPress 5 to display Linked List\n" +
                "Press 6 to reverse Linked List\n"+
                "Press 7 to remove duplicates from Linked List\n"+
                "Press 8 to return the nth to Last Node in the linked list");
        while (true){
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the data to insert in Linked List");
                    int data = scanner.nextInt();
                    System.out.println("Enter the location");
                    int location = scanner.nextInt();
                    singlyLinkedList.insertInLinkedList(data,location);
                    break;
                case 2:
                    System.out.println("Enter the value to search in linked List");
                    int value = scanner.nextInt();
                    singlyLinkedList.searchNode(value);
                    break;
                case 3:
                    System.out.println("Enter the location to delete data");
                    int loc = scanner.nextInt();
                    singlyLinkedList.deleteFromLinkedList(loc-1);
                    break;
                case 4:
                    singlyLinkedList.deleteEntireLinkedList();
                    break;
                case 5:
                    singlyLinkedList.displayLinkedList();
                    break;
                case 6:
                    singlyLinkedList.reverseSinglyLinkedList();
                    break;
                case 7:
                    Questions questions = new Questions();
                    questions.removeDuplicates();
                    break;
                case 8:
                    Questions questions1 = new Questions();
                    System.out.println("Enter the nth to last node you want to find.");
                    System.out.println("example : if the node has 5 elements then the 2nd last node will be the 4th node");
                    int n = scanner.nextInt();
                    System.out.println(n+"th  to the last node value is :"+questions1.nthToLast(singlyLinkedList,n).data);
                    break;
                default:
                    System.exit(1);
            }
        }
    }


    public void createSinglyLinkedList(int nodeValue){
        Node node = new Node();
        node.next=null;
        node.data=nodeValue;
        head=node;
        tail=node;
        //size=1; i am using this method in insert method so here already size logic is incremented . so commenting this for now
       // return head;
    }

    public void insertInLinkedList(int nodeValue , int location){
      Node node = new Node();
      node.data=nodeValue;
      //if list is empty we create a new linkedList
        if (head==null){
            createSinglyLinkedList(nodeValue);
        } else if (location==0) {
            node.next=head;
            head=node;
        } else if (location>=size) { // insert in last node of linked list
            node.next=null;
            tail.next=node;
            tail=node;
        }
        else { // insert in the middle of linked list
            Node tempNode = head;
            int index=0;
            while (index<location-1){
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
       size++;
        //displayLinkedList();
    }

    public void deleteFromLinkedList(int location){
        if (head==null){
            System.out.println("Linked List is Empty");
        } else if (location<=0) { // deleting node in the beginning
            head=head.next;
            size--;
            if (size==0){ //after deleting the node from beginning if list size is empty then we need to set tail to null
                tail=null;
            }
        } else if (location>=size) { // deletion at the end of the linked list
            Node tempNode = head;
            for (int i=0;i<size-1;i++){
                tempNode = tempNode.next;
            }
            if (tempNode==head){ // when we have only one element in linked list
                tail=head=null;
                size--;
            }
            tempNode.next=null;
            tail=tempNode;
            size--;
        } else { // deleting a node in specific location
            Node tempNode = head;
            for (int i=0 ;i<location-1;i++){
                tempNode=tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
        displayLinkedList();
    }
    public void deleteEntireLinkedList(){
        head=tail=null;
    }

    public void searchNode(int value){
        boolean found = false;
        if (head!=null){
            Node tempNode = head;
            for (int i=0;i<size;i++){
                if (tempNode.data == value){
                    System.out.println("found "+value+" at "+i+"th position");
                   // return true;
                    found=true;
                }
                if (tempNode.next!=null){
                    tempNode=tempNode.next;
                }
            }
        }
        else {
            System.out.println("List is empty");
        }
        if (!found){
            System.out.println("Value not found in linked list..");
        }
      //  return false;
    }
    public void displayLinkedList() {
        int size=0;
        System.out.println("----Displaying the Linked List-----");
       Node current = head;
        if (head == null) {
            System.out.println("List is Empty");
            size = 1;
        } else {
            while (current != null) {
                System.out.print(current.data);
                if (current.next!=null){
                    System.out.print( " -> ");
                }
                current = current.next;
                size++;
            }
            System.out.println();
        }
        System.out.println("Size of linked List is "+size);
    }
    private void reverseSinglyLinkedList(){
        // using stack
        Stack<Node> stack = new Stack<>();
        Node temp=head;
        while (temp.next!=null){
            stack.push(temp);
            temp=temp.next;
        }
        head=temp;
        while (!stack.isEmpty()){
            temp.next=stack.peek();
            stack.pop();
            temp=temp.next;
        }
        temp.next=null; // tail next should be null
    }

}
