package org.example.DataStructures.LinkedList.DoublyLinkedList;
public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    public void createDoublyLinkedList(int nodeValue){
        DoublyNode newNode = new DoublyNode(nodeValue);
        newNode.prev=null;
        newNode.next=null;
        head=newNode;
        tail=newNode;
        size++;
    }
    public void insertDoublyLinkedList(int nodeValue , int position){

        DoublyNode newNode = new DoublyNode(nodeValue);
        if (head==null) // linkedList is Empty
        {
            createDoublyLinkedList(nodeValue);
        }
        else if (position==0)
        {
            newNode.next=head;
            newNode.prev=null;
            head.prev=newNode;
            head=newNode;
            size++;
            //10 5 13 4 15
        } else if (position>=size) {
            tail.next=newNode;
            newNode.prev=tail;
            newNode.next=null;
            tail=newNode;
            size++;
        }
        else {
            DoublyNode tempNode = head;
            int index=0;
            while (index<position-1){
                tempNode=tempNode.next;
                index++;
            }
            DoublyNode nextNode = tempNode.next;
            tempNode.next=newNode;
            newNode.prev=tempNode;
            newNode.next=nextNode;
            nextNode.prev=newNode;
            size++;
        }
    }
    public void displayDoublyLinkedList(){
        int size=0;
        System.out.println("----Displaying the Linked List-----");
        DoublyNode current = head;
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            while (current != null) {
                System.out.print(current.value);
                current = current.next;
                if (current!=null){
                        System.out.print(" --> ");
                }
                size++;
            }
            System.out.println();
        }
        System.out.println("Size of linked List is "+size);
    }
    public void reverseTraversalOfDoublyLinkedList(){
        DoublyNode temp = tail;
        if (tail==null){
            System.out.println("Tail not found to iterate in the reverse way....");
        }
        else {
            while (temp!=null){
                System.out.print(temp.value);
                temp=temp.prev;
                if (temp!=null){
                    System.out.print(" --> ");
                }
            }
            System.out.println();
        }
        System.out.println("Size of linked List is "+size);
    }
    public void searchNode(int value){
        boolean found = false;
        if (head!=null){
            DoublyNode tempNode = head;
            for (int i=0;i<size;i++){
                if (tempNode.value == value){
                    System.out.println("found "+value+" at "+i+"th position");
                    // return true;
                    if (tempNode.prev!=null){
                        System.out.println(value+" 's previous node value is : "+tempNode.prev.value+" located in "+(i-1)+" th position");
                    }
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
    public void deleteInDoublyLinkedList(int location){
        if (head==null){
            System.out.println("Linked List is Empty");
        }
        else if (location<=0) { // deleting node in the beginning
            head.next.prev=null;
            head=head.next;
            size--;
            if (size==0){ //after deleting the node from beginning if list size is empty then we need to set tail to null
                tail.prev=null;
                tail=null;
            }
        }
        else if (location>=size-1) { // must use size-1 // deleting at last
            if (size==1){
                head=null;
                tail=null;
                size--;
            }
            else {
                tail=tail.prev;
                tail.next=null;
                size--;
            }
        }
        else {
            DoublyNode tempNode = head;
            int index=0;
            while (index<location){
                tempNode=tempNode.next;
                index++;
            }
            DoublyNode prevNode = tempNode.prev;
            DoublyNode nextNode = tempNode.next;
            prevNode.next=nextNode;
            nextNode.prev=prevNode;
            System.out.println("Deleted "+tempNode.value+" from index : "+location);
            size--;
        }
    }
    public void deleteEntireLinkedList(){
        if (head==null){
            System.out.println("List is already empty");
        }
        else {
            head.next.prev=null;
            head=null;
            tail.prev=null;
            tail=null;
            System.out.println("LinkedList Deleted");
        }
    }
}
