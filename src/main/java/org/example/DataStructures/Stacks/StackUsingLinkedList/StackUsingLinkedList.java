package org.example.DataStructures.Stacks.StackUsingLinkedList;

public class StackUsingLinkedList {
    public class Node{
        public int data;
        public Node next;

        public Node(int val){
            this.data=val;
            this.next=null;
        }
    }
    Node head;
   // public Node tail;
    public int size;
    public void push(int value){
        Node node = new Node(value);
        if (head==null){
            head=node;
        }
        else {
            node.next=head;
            head=node;
        }
        size++;
    }
    public void pop(){
        if (head == null) {
            System.out.println("Stack is Empty");
        }
        else {
            Node temp = head;
            head=head.next;
            size--;
            System.out.println("Popped Elemnt :"+temp.data);
        }
    }

    public void peek(){
        if (head == null) {
            System.out.println("Stack is Empty");
        }
        else {
            System.out.println("Peek Element value is :"+head.data);
        }
    }
    public void displayLinkedList() {
        int size=0;
        System.out.println("----Displaying the Stack-----");
        Node current = head;
        if (head == null) {
            System.out.println("Stack is Empty");
            //size = 1;
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
        System.out.println("Size of stack is "+size);
    }
    public void deleteStack(){
        head=null;
        System.out.println("Stack Deleted Successfully");
    }
    public boolean isEmpty(){
        return head==null;
    }

    public static void main(String[] args) {
        StackUsingLinkedList linkedList = new StackUsingLinkedList();
        linkedList.displayLinkedList();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.displayLinkedList();
        linkedList.peek();
        linkedList.pop();
        linkedList.peek();
        linkedList.push(4);
        linkedList.peek();
        System.out.println("Is Stack empty ?? : "+linkedList.isEmpty());
        linkedList.deleteStack();
        System.out.println("Is Stack empty ?? : "+linkedList.isEmpty());
    }

}
