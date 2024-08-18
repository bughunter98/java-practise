package org.example.DataStructures.LinkedList.CircularDoublyLinkedList;

import org.example.DataStructures.LinkedList.DoublyLinkedList.DoublyNode;

public class CircularDoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    public void createCircularDoublyLinkedList(int value){
        DoublyNode newNode = new DoublyNode(value);
        head=newNode;
        tail=newNode;
        head.prev=newNode;
        tail.next=newNode;
        size = 1;
    }
    public void insertNode(int value, int location){
         DoublyNode newNode = new DoublyNode(value);
         if (head==null){
             createCircularDoublyLinkedList(value);
         }
         else if (location==0){
             newNode.next=head;
             newNode.prev=tail;
             head.prev=newNode;
             tail.next=newNode;
             head=newNode;
             size++;
         } else if (location>=size) {
             tail.next=newNode;
             newNode.prev=tail;
             newNode.next=head;
             tail=newNode;
             head.prev= tail;
             size++;
         }
         else {
             DoublyNode current = head;
             int index=0;
             while (index<location-1){
                 current = current.next;
                 index++;
             }
             DoublyNode nextNode = current.next;
             current.next=newNode;
             newNode.prev=current;
             newNode.next=nextNode;
             nextNode.prev=newNode;
             size++;
         }
    }
    public void traverseDoublyLinkedList(){
        System.out.println("Displaying in normal order");
         DoublyNode tempNode = head;
         int index=0;
         if (head!=null){
             while (index<size){
                 System.out.print(tempNode.value);
                 if (index!=size-1){
                     System.out.print(" -> ");
                 }
                 tempNode=tempNode.next;
                 index++;
             }
         }
         else {
             System.out.println("Linked List is Empty");
         }
    }
    public void reverseTraverseDoublyLinkedList(){
        System.out.println("Displaying in reverse order");

         int index=0;
         if (head!=null){
             DoublyNode tempNode = tail;
             while (index<size){
                 System.out.print(tempNode.value);
                 if (index!=size-1){
                     System.out.print(" -> ");
                 }
                 tempNode = tempNode.prev;
                 index++;
             }
         }
         else {
             System.out.println("Linked List is Empty");
         }
    }
    public boolean searchValue(int value){
         DoublyNode tempNode = head;
         int index=0;
        // boolean flag = false;
         if (head!=null){
             while (index<size){
                 if (value==tempNode.value){
                     //flag=true;
                     System.out.println(value+" found at index : "+index);
                     return true;
                 }
                 tempNode=tempNode.next;
                 index++;
             }
             System.out.println("Value not found in Circular Doubly Linked List");
             return false;
         }
         else {
             System.out.println("linked List  is empty");
         }
         return false;
    }

   public void deleteNodeFromLinkedListByLocation(int location){
        if (head!=null){
            if (location==0){
                if (size==1){
                    deletingNodeifListHasOneElement(location);
                }
                else {
                    deletingNodeFromHead(head.value,location);
                }
            }
            else if (location>=size-1) { // make sure about this size-1
                if (size==1){
                    deletingNodeifListHasOneElement(location);
                }
                else {
                    deletingNodeFromTail();
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
        else {
            System.out.println("Linked List is empty");
        }
   }

    private void deletingNodeifListHasOneElement(int location) {
        System.out.println("Deleted "+head.value+" from index : "+location);
        head.prev=null;
        head.next=null;
        head=tail=null;
        size--;
    }

    public void deleteNodeFromLinkedListByValue(int value){
       DoublyNode tempNode = head;
       DoublyNode prevNode = null;
       int index=0;
       boolean flag = false;
       if (head!=null){
           //3 4 5 6
           // here if the searched node is at 0th index then as prevNode is declared as null in line no 143 and will cause NPE
           // so i have added it as special condition below.
           while (index<size){
               if (value==tempNode.value && index==0){
                   deletingNodeFromHead(value,index);
                   break;
               }
               else {
                   if (value==tempNode.value){
                       flag=true;
                       System.out.println(value+" deleted at index : "+index);
                       break;
                   }
                   prevNode=tempNode;
                   tempNode=tempNode.next;
                   index++;
               }
           }
           if (flag && index>0 && index<size-1){
               deletingNodeInMiddleOfLinkedList(prevNode,tempNode);
           }
           else if (flag && index>0 && index>=size-1) {
               deletingNodeFromTail();
           }
           else {
               if (index!=0){
                   System.out.println("Value not found in Circular Doubly Linked List");
               }
           }
       }
       else {
           System.out.println("linked List  is empty");
       }
   }
    private void deletingNodeFromHead(int value, int index) {
        head=head.next;
        head.prev=tail;
        tail.next=head;
        size--;
        System.out.println(value+" deleted at index : "+index);
    }
    private void deletingNodeFromTail() {
        tail=tail.prev;
        tail.next=head;
        head.prev=tail;
        size--;
    }
    private void deletingNodeInMiddleOfLinkedList(DoublyNode prevNode, DoublyNode tempNode) {
        prevNode.next=tempNode.next;
        tempNode.next.prev=prevNode;
        size--;
    }
    public void deleteEntireLinkedList() {
        if (head==null){
            System.out.println("Linked list is already empty");
        }
        else {
           // head.next.prev=null;
            head=null;
            /*tail.next=null;
            tail.prev=null;*/
            tail=null;
            size=0;
        }
    }
}
