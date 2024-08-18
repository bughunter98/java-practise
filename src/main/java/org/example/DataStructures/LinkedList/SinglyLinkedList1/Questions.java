package org.example.DataStructures.LinkedList.SinglyLinkedList1;

import java.util.HashSet;
import java.util.Scanner;

class Questions{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Questions questions= new Questions();
        questions.solvingLinkedListSum();
        System.out.println("----------------");
        questions.findMiddleOfLinkedList();
        System.out.println("----------------");
        questions.reverseLinkedList();
        System.out.println("---------------------");
        System.out.println("Enter key to rotate linked List");
        int key = scanner.nextInt();
        questions.rotateLinkedList(key);

    }
    /*public void displayLinkedList() {
        int size=0;
        System.out.println("----Displaying the Linked List-----");
        Node current = node;
        if (node == null) {
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
    }*/
    public void solvingLinkedListSum() {
        Questions question = new Questions();
        SinglyLinkedList linkedList1=new SinglyLinkedList();
        linkedList1.insertInLinkedList(7,0);
        linkedList1.insertInLinkedList(1,1);
        linkedList1.insertInLinkedList(6,2);

        SinglyLinkedList linkedList2=new SinglyLinkedList();
        linkedList2.insertInLinkedList(5,0);
        linkedList2.insertInLinkedList(9,1);
        linkedList2.insertInLinkedList(2,2);

        SinglyLinkedList sum = question.sumLists(linkedList1,linkedList2);
        Node node = sum.head;
        while (node!=null){
            System.out.print(node.data);
            if (node.next!=null){
                System.out.print(" -> ");
            }
            node=node.next;
        }
        System.out.println();
    }
    // Question 1
    void removeDuplicates() {
        // Note : when ever we hear about this removing duplicates better use hashset
        // 1 2 1 3
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        HashSet<Integer> hashSet = new HashSet<>();
        Node currentNode = singlyLinkedList.head;
        Node prevNode=null;
        while (currentNode!=null){
            int currentValue = currentNode.data;;
            if (hashSet.contains(currentValue)){
                prevNode.next=currentNode.next;
                singlyLinkedList.size--;
            }else {
                hashSet.add(currentValue);
                prevNode=currentNode;
            }
            currentNode=currentNode.next;
        }
    }

    // Question 2
    // Find nth last element from linked List
    Node nthToLast(SinglyLinkedList linkedList , int n){
        // 2 pointers approach
        Node pointer1=linkedList.head;
        Node pointer2=linkedList.head;
        // now first we will move the pointer 2 to the nth position and then after that
        // we move both the pointers with same pace
        // 1 2 3 4 5 6 7
        for (int i=0;i<n;i++){
            if (pointer2==null){
                return null;
            }
            pointer2 = pointer2.next;
        }
        while (pointer2!=null){
            pointer1=pointer1.next; // this will now have the nth last node .
            pointer2=pointer2.next;
        }
        return pointer1;
    }

    public Node sumLists(){
        SinglyLinkedList linkedList1 = new SinglyLinkedList();
        linkedList1.insertInLinkedList(7,0);
        linkedList1.insertInLinkedList(1,1);
        linkedList1.insertInLinkedList(6,2);

        SinglyLinkedList linkedList2 = new SinglyLinkedList();
        linkedList2.insertInLinkedList(5,0);
        linkedList2.insertInLinkedList(9,1);
        linkedList2.insertInLinkedList(2,2);

        Node node1 = linkedList1.head;
        Node node2 = linkedList2.head;
        Node node3 = new Node(0) , current=node3;

        // 7->1->6
        // 5->9->2
        int carry=0;
        while (node1!=null || node2!=null){
            int val1 = node1!=null ? node1.data:0;
            int val2 = node2!=null ? node2.data:0;
            int sum =0;
            sum=carry + val1+val2;
            carry=sum/10;

            current.next=new Node(sum%10);
            current=current.next;
            if (node1!=null) node1=node1.next;
            if (node2!=null) node2=node2.next;
        }
        if (carry>1){
            current.next=new Node(carry);
        }

        return node3.next;
    }

    public SinglyLinkedList sumLists(SinglyLinkedList list1,SinglyLinkedList list2){
        Node n1 = list1.head;
        Node n2 = list2.head;
        int carry =0;
        SinglyLinkedList resultList = new SinglyLinkedList();
        int index=0;
        while (n1!=null || n2!=null){
            int result = carry;
            if (n1!=null){
                result = result+n1.data;
                n1 = n1.next;
            }
            if (n2!=null){
                result=result+n2.data;
                n2=n2.next;
            }
            resultList.insertInLinkedList(result%10,index);
            carry = result/10;
            index++;
        }
        return resultList;
    }

    // Geeks for Geeks Questions

    public SinglyLinkedList getLinkedList(){
        SinglyLinkedList linkedList =  new SinglyLinkedList();
        linkedList.insertInLinkedList(1,0);
        linkedList.insertInLinkedList(2,1);
        linkedList.insertInLinkedList(3,2);
        linkedList.insertInLinkedList(4,3);
        linkedList.insertInLinkedList(5,4);
        linkedList.insertInLinkedList(6,6);
        return linkedList;
    }

    // middle value of linked list
    public void findMiddleOfLinkedList(){
        // https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
        SinglyLinkedList linkedList = getLinkedList();
        Node current = linkedList.head;
        for (int i=0;i<linkedList.size/2;i++){
            if (current.next!=null){
                current=current.next;
            }
        };
        System.out.println("Middle Value of Linked List is "+current.data);
    }
    public void reverseLinkedList(){
        // 1 2 3 4 5 6
        System.out.println("Reversed Linked List");
        SinglyLinkedList linkedList = getLinkedList();
        Node current=linkedList.head;
        Node prev = null;
        Node nextNode ;
        while (current!=null){
            nextNode=current.next;
            current.next=prev;
            prev = current;
            current=nextNode;
        }
        // displaying reversed linked list
         while (prev!=null){
             System.out.print(prev.data);
             if (prev.next!=null){
                 System.out.print("->");
             }
             prev=prev.next;
         }
    }
    public void reverseLinkedList1(){
        SinglyLinkedList singlyLinkedList = getLinkedList();
        Node currentNode = singlyLinkedList.head;
        Node prevNode=null;
        Node nextNode;
        while (currentNode!=null){
            nextNode=currentNode.next;
            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode=nextNode;
        }
    }
    public void rotateLinkedList(int key){
        // 1 2 3 4 5 6   and key = 3;
        // output :  4->5->6->1->2->3
        SinglyLinkedList linkedList = getLinkedList();
        Node temp = linkedList.head;
        Node current = linkedList.head;
        boolean flag = false;
        int tempSize =0;
        for (int i=0;i<key;i++){
            current=current.next;
        }
        for (int i=0;i< linkedList.size;i++){

                System.out.print(current.data);
                if (current.next!=null){
                    System.out.print("->");
                }
                tempSize++;
                current=current.next;
                if (current==null){
                    flag=true;
                    break;
                }
        }
        if (flag){
            int remainingSize = linkedList.size-tempSize;
            for (int i=0;i<remainingSize;i++){
                if (i==0){ // after printing from k th place to end of list the last value shoudl get arrow
                    System.out.print("->");
                }
                System.out.print(temp.data);
                if (i<remainingSize-1){
                    System.out.print("->");
                }
                temp=temp.next;
            }
        }
    }

}

