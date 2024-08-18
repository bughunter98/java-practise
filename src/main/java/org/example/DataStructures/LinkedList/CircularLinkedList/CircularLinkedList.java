package org.example.DataStructures.LinkedList.CircularLinkedList;

import java.util.Scanner;

public class CircularLinkedList {
    public Node head ;
    public Node tail ;
    public int size ;
    public int searchedValuePosition;

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true){
            System.out.println("""
                    ---------------------------------------------------------------------
                    Press 1 to insert data in Linked List
                    Press 2 to display Linked List
                    Press 3 to search Linked List
                    Press 4 to delete from linked list by location
                    Press 5 to delete from linked list by value
                    """);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the data to insert in Linked List");
                    int data = scanner.nextInt();
                    System.out.println("Enter the location");
                    int location = scanner.nextInt();
                    circularLinkedList.insertInLinkedList(data,location);
                    break;
                case 2:
                    circularLinkedList.displayLinkedList();
                    circularLinkedList.displayLinkedList1();
                    break;
                case 3:
                    System.out.println("Enter value to search");
                    int searchKey = scanner.nextInt();
                    boolean isValueFound =circularLinkedList.searchLinkedList(searchKey);
                    System.out.println("Value found :"+isValueFound);
                    break;
                case 4:
                    System.out.println("Enter position to delete");
                    int deleteKey = scanner.nextInt();
                    circularLinkedList.deleteFromLinkedListByLocation(deleteKey);
                    break;
                case 5:
                    System.out.println("Enter Value to delete");
                    int valueToDelete = scanner.nextInt();
                    circularLinkedList.deleteByValue(valueToDelete);
                    break;
                default:
                    System.exit(1);
            }
        }
    }
    public void createCircularLinkedList(int nodeValue){
        Node node = new Node();
        node.data=nodeValue;
        head=node;
        tail=node;
        node.next=head;
        size=1;
    }
    public void insertInLinkedList(int nodeValue , int location){
      Node newNode = new Node();
        newNode.data=nodeValue;
      //if list is empty we create a new linkedList
        if (head==null)
        {
            createCircularLinkedList(nodeValue);
        }
        else if (location==0)
        { //inserting the value in starting
            newNode.next=head;
            head=newNode;
            tail.next=head;
            size++;
        }
        else if (location>=size)
        { // insert in last node of linked list
            tail.next=newNode;
            tail=newNode;
            newNode.next=head;
            size++;
        }
        else { // insert in specific position of linked list
            System.out.println("you will be inserting data at "+location+" position");
            Node tempNode = head;
            int index=1;
            while (index<location-1){
                tempNode=tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = newNode;
            newNode.next= nextNode;
            size++;
        }
    }
    private void displayLinkedList() {
        System.out.println("----Displaying the Linked List-----");
       Node current = head;
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            do {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            while (current != head);
            System.out.println();
        }
        System.out.println("Size of linked List is "+size);
    }
    private void displayLinkedList1(){
        if (head!=null){
            Node tempNode = head;
            for (int i=0;i<size;i++){
                System.out.print(tempNode.data);
                if (i!=size-1){
                    System.out.print(" -> ");
                }
                tempNode=tempNode.next;
            }
            System.out.println();
        }
        else {
            System.out.println("Linked List is Empty");
        }
    }
    private boolean searchLinkedList(int value){
        if (head!=null){
            Node tempNode = head;
            for (int i=0;i<size;i++){
                if (tempNode.data==value){
                    int position = i+1;
                    this.searchedValuePosition=position;
                    System.out.println("Value found in Linked List at position : "+position);
                    return true;
                } else if (tempNode.next!=head) {
                    tempNode=tempNode.next;
                }
                else {
                    System.out.println("Value not found in linked list..");
                }
            }
            System.out.println();
        }
        else {
            System.out.println("Linked List Does not exist...");
        }
        return false;
    }
    private void deleteFromLinkedListByLocation(int location){
        if (head!=null){
            if (location==0 || location==1)
            {
                System.out.println("Deleting from beginning");
                head=head.next;
                tail.next=head;
                size--;
                if (size==0){
                    head=tail=null;
                }
            }
            else if (location>=size)
            {
                System.out.println("Deleting last node");
                Node tempNode = head;
                /*for (int i=0;i<size-1;i++){ // iterating till last but one node
                    tempNode = tempNode.next;
                }*/
                while (tempNode.next!=tail){
                    tempNode=tempNode.next;
                }
                if (tempNode==head){
                    head.next=null;
                    head=null;
                    size=0;
                }
                tail=tempNode;
                tempNode.next=head;
                size--;
            }
            else
            {
                Node tempNode = head;
                for (int i=1;i<location-1;i++){
                    tempNode = tempNode.next;
                }
                Node currentNode = tempNode.next;
                int deletedValue = tempNode.next.data;
                tempNode.next=currentNode.next;
                size--;
                System.out.printf("value deleted from position %d is %d : ",location,deletedValue);
            }
        }
        else {
            System.out.println("Linked List is Empty");
        }
    }
    private void deleteFromLinkedListByValue(int value){

        if (searchLinkedList(value)){
            if (searchedValuePosition==1)
            {
                head = head.next;
                tail.next=head;
                size--;
                System.out.printf("deleted %d at position %d ",value,searchedValuePosition);
                System.out.println();
            }
            else if (searchedValuePosition==size)
            {
                Node tempNode = head;
                for (int i=0;i<size-1;i++){
                    tempNode=tempNode.next;
                }
                if (tempNode==head){
                    head.next=null;
                    head=null;
                    size=0;
                }
                tail=tempNode;
                tempNode.next=head;
                size--;
                System.out.printf("deleted %d at position %d ",value,searchedValuePosition);
                System.out.println();
            }
            else
            {
                Node tempNode = head;
                for (int i=1;i<searchedValuePosition-1;i++){
                    tempNode = tempNode.next;
                }
                tempNode.next=tempNode.next.next;
                size--;
                System.out.printf("deleted %d at position %d ",value,searchedValuePosition);
                System.out.println();
            }
        }
        else {
            System.out.println("Value not present in linked list to delete");
        }
    }
    public void deleteByValue(int value) {
        if (size == 0) {
            System.out.println("Data deleted");;
        }

        if (head == tail && head.data == value) {
            head = null;
            tail = null;
            size = 0;
            System.out.println("Data Deleted");;
        }

        Node current = head;
        Node prev = null;

        do {
            if (current.data == value) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = current.next;
                }

                size--;
                System.out.println("Value Deleted");;
            }

            prev = current;
            current = current.next;
        } while (current != head);

       // System.out.println("Data not found");
    }
    private void deleteEntireCircularLinkedList(){
        if (head==null){
            System.out.println("Linked List doesnot exist");
        }
        else {
            head=null;
            tail.next=null;
            tail=null;
            System.out.println("Linked List has been deleted");
        }
    }
}
