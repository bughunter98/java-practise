package org.example.DataStructures.Queues;

public class CircularQueue {
    int[] array;
    int top;
    int beginning;
    int size ;
    public CircularQueue(int size){
        this.array = new int[size];
        this.size = size;
        this.top=-1;
        this.beginning=-1;
        System.out.println("Circular Queue is created...with size :  "+size);
    }

    public boolean isEmpty(){
        return top==-1 ;
    }
    public boolean isFull(){
       return (top+1==beginning)||(beginning==0 && top+1==size);
    }
    public void printQueue(){
        if (array!=null){
            for (int i=0;i<array.length;i++){
                if (array[i]!=0){
                    System.out.print(array[i]);
                    if (i<array.length-1){
                        System.out.print("->");
                    }
                }
            }
        }
        else {
            System.out.println("Array cannot be printed as array is null");
        }
        System.out.println();
    }
    public void enQueue(int value){
        if (isFull()){
            System.out.println("Queue is full..Cannot insert");
        }
        else if(isEmpty()){
            beginning=0;
            top++;
            array[top]=value;
            System.out.println("Value Successfully inserted in queue");
        }
        else {
            top++;
            boolean flag = true;
            if (top>=size){
                if (array[0]==0){
                    top=0;
                }
                /*else {
                    System.out.println("Queue is Full Cannot insert");
                    flag=false;
                }*/
            }
            if (flag){
                array[top]=value;
                System.out.println("Value Successfully inserted in queue");
            }
        }
    }
    public void deQueue(){
        if (isEmpty()){
            System.out.println("Queue is empty .. cannot delete value ");
        }
        else {
            array[beginning]=0;
            System.out.println("DeQueued Successfully");
            if (beginning==top){
                // this condition will be true if there is only one element in the queue
                beginning=-1;
                top=-1;
            } else if (beginning+1==size) { // it means beginning points to last cell of the array .
                // now after dequeueing the last element beginning should start from zeroth index of array.
                beginning=0;
            }
            else {
                beginning++;
            }
        }
    }
    public void peek(){
        try {
            if (!isEmpty()){
                System.out.println("Peeked Value :"+array[beginning]);
            }
            else {
                System.out.println("Queue is Empty");
            }
        }
        catch (NullPointerException ex){
            System.out.println("Queue doesn't exist to peek.");
        }
    }
    public void deleteQueue(){
        array=null;
        System.out.println("Deleted Queue Successfully");
    }
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.isEmpty();
        circularQueue.isFull();
        System.out.println("Beginning :" +(circularQueue.beginning+1)+" Top :"+(circularQueue.top+1) );
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        circularQueue.enQueue(5);
        circularQueue.peek();
        circularQueue.deQueue();
        circularQueue.enQueue(6);
        circularQueue.enQueue(7);
        circularQueue.peek();
        circularQueue.printQueue();
        circularQueue.deleteQueue();
        circularQueue.peek();
    }
}
