package org.example.DataStructures.LinkedList.udemy;

public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.push(5);
        singlyLinkedList.push(10);
        singlyLinkedList.push(15);
        singlyLinkedList.push(20);
        singlyLinkedList.push(25);
        System.out.println("List Size is" + singlyLinkedList.size);
        System.out.println("list head value is" + singlyLinkedList.head.data);
        System.out.println("list head next value is" + singlyLinkedList.head.next.data);
        System.out.println("List tail is" + singlyLinkedList.tail.data);
        //System.out.println("insert value "+singlyLinkedList.insert(6,2));
        System.out.println("list head next value is" + singlyLinkedList.head.next.data);
        singlyLinkedList.displayLinkedList();
        System.out.println("Linked List value at 0 position : " + singlyLinkedList.get(0).data);
        System.out.println("Linked List value at 1 position : " + singlyLinkedList.get(1).data);
        System.out.println("Linked List value at 2 position : " + singlyLinkedList.get(2).data);
        System.out.println("Linked List value at 3 position : " + singlyLinkedList.get(3).data);
        System.out.println("Linked List value at 4 position : " + singlyLinkedList.get(4).data);

        singlyLinkedList.rotate(3);
        System.out.println();
        System.out.println("List Size is" + singlyLinkedList.size);
        System.out.println("list head value is" + singlyLinkedList.head.data);
        System.out.println("list head next value is" + singlyLinkedList.head.next.data);
        System.out.println("list head next next value is" + singlyLinkedList.head.next.next.data);
        System.out.println("list head next next next value is" + singlyLinkedList.head.next.next.next.data);
        System.out.println("list head next next next next value is" + singlyLinkedList.head.next.next.next.next.data);
        System.out.println("List tail is" + singlyLinkedList.tail.data);
        System.out.println(singlyLinkedList.set(4, 9));
        System.out.println("removed data from 2nd index "+singlyLinkedList.remove(2).data);
        System.out.println("removed data from 100th index "+singlyLinkedList.remove(100).data);


    }

    private void displayLinkedList() {
        int size = 0;
        System.out.println("----Displaying the Linked List-----");
        Node current = head;
        if (head == null) {
            System.out.println("List is Empty");
            size = 1;
        } else {
            while (current != null) {
                System.out.print(current.data + "->");
                current = current.next;
                size++;
            }
            System.out.println();
        }
        System.out.println("Size of linked List is " + size);
    }

    public void push(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public Node pop() {
        // TODO
        Node tempNode = head;
        while (tempNode != tail) {
            tempNode = tempNode.next;
        }
        Node temp = tempNode;
        tempNode.next = null;
        return temp;
    }

    public boolean insert(int data, int index) {
        Node newNode = new Node(data);
        if (index < 0 || index >= size) {
            return false;
        } else {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else if (index == 1) {
                newNode.next = head;
                head = newNode;
            } else if (index == size) {
                tail.next = newNode;
                newNode.next = null;
                tail = newNode;
            } else {
                Node tempNode = head;
                int i = 0;
                while (i < index - 1) {
                    tempNode = tempNode.next;
                    i++;
                }
                Node nextNode = tempNode.next;
                tempNode.next = newNode;
                newNode.next = nextNode;
            }
        }
        size++;
        return true;
    }

    public Node get(int index) {
        Node node = head;
        if (index == 0) {
            return node;
        } else {
            for (int i = 0; i < index; i++) {
                if (node.next == null) {
                    return new Node(0);
                }
                node = node.next;
            }
            return node;
        }
    }

    // 1->2->3
    public String rotate(int number) {
        // TODO
        int index = number;
        if (number < 0) {
            index = number + size;
        }
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return "No Rotation";
        }

        Node previousNode = head;
        for (int i = 0; i < number - 1; i++) {
            previousNode = previousNode.next;
        }
        tail.next = head;  // here the tail is null and the previous head will be pointed and continued
        head = previousNode.next;
        tail = previousNode;
        previousNode.next = null;
        return "Success";
    }

    public boolean set(int index, int value) {
        // TODO
        //Node node = new Node(value);
        if (index == 0) {
            System.out.println("replaced value is " + head.data);
            head.data = value;
            return true;
        }
        Node tempNode = head;
        if (index > 0 && index < size) {
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.next;
            }
            System.out.println("replaced value is " + tempNode.data);
            tempNode.data = value;
            return true;
        }
        return false;
    }

    public Node remove(int index) {
        //TODO
        if (index < 0) {
            return new Node(0);
        }
        else if (index == 0) {
            Node node = head;
            if (size==1){
                head=tail=null;
            }
            else {
                head = head.next;
            }
            return node;
        }
        else if (index == size) {
            Node node = head;
            for (int i = 0; i < size - 1; i++) {
                node = node.next;
            }
            if (node == head) {
                head = tail = null;
                size--;
                return new Node(0);
            }
        } else if (index>size) {
            return new Node(0);
        } else {
            Node node = head;
            //0->1->2
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            Node tempNode = node.next;
            node.next = node.next.next;
            return tempNode;
        }
        return null;
    }
}
