package org.example.DataStructures.Queues;


import org.example.DataStructures.LinkedList.SinglyLinkedList.Node;

public class QueueUsingLinkedList {
   public Node head;
   public Node tail;
   public int size;

   public boolean isEmpty(){
       return head==null;
   }
   public void enQUeue(int value){
       Node node = new Node(value);
       if (isEmpty()){
           head=node;
           tail=node;
       }
       else {
           node.next=null;
           tail.next=node;
           tail=node;
       }
       size++;
       System.out.println("Enqueued Successfully..");
   }
    public void displayQueue() {
        int size=0;
        //System.out.println("----Displaying the Linked List-----");
        Node current=head;
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
       // System.out.println("Size of linked List is "+size);
    }
    public void deQueue(){
       if (head==null){
           System.out.println("Queue is Empty. cannot Dequeue");
       }
       else {
           head=head.next;
           size--;
           System.out.println("Dequeued Successfully");
       }
    }
    public void peek(){

        Node current=head;
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            while (current.next != null) {
                //System.out.print(current.data);
                current = current.next;
            }
            System.out.println("Peek value : "+current.data);
            System.out.println();
        }

    }

    public static void main(String[] args) {
       QueueUsingLinkedList queue = new QueueUsingLinkedList();
       queue.isEmpty();
       queue.enQUeue(1);
       queue.enQUeue(2);
       queue.enQUeue(3);
       queue.enQUeue(4);
       queue.enQUeue(5);
       queue.deQueue();
       queue.peek();
       queue.enQUeue(1);
       queue.peek();
       queue.displayQueue();
    }
}
