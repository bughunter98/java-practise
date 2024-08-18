package org.example.DataStructures.Queues;

public class QueueArray {
    int[] array;
    int top;
    int beginning;

    public QueueArray(int size){
        this.array=new int[size];
        this.top=-1;
        this.beginning=-1;
        System.out.println("Queue is successfully created with size of : "+size);
    }
    public boolean isFull(){
        return array.length-1  ==  top;
    }
    public boolean isEmpty(){
        return beginning==-1 || beginning == array.length;
    }
    public void enQueue(int value){
        if (isFull()){
            System.out.println("Queue is Full !!!");
        }
        else if (isEmpty()){
            beginning=0;
            top++;
            array[top]=value;
            System.out.println("Value Successfully inserted in queue");
        }
        else {
            top++;
            array[top]=value;
            System.out.println("Value Successfully inserted in queue");
        }
    }
    public void deQueue(){
        if (isEmpty()){
            System.out.println("Queue is empty .. cannot delete value ");
        }
        else {
            array[beginning]=0;
            beginning++;
            System.out.println("DeQueued Successfully");
        }
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
    public void peek(){
        if (!isEmpty()){
            System.out.println("Peeked Value :"+array[beginning]);
        }
        else {
            System.out.println("Queue is Empty");
        }
    }
    public void deleteQueue(){
        array=null;
        System.out.println("Deleted Queue Successfully");
    }
    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(5);
        System.out.println(queueArray.isFull());
        System.out.println(queueArray.isEmpty());
        queueArray.enQueue(1);
        queueArray.enQueue(2);
        queueArray.enQueue(3);
        queueArray.enQueue(4);
        queueArray.enQueue(5);
        System.out.println("Beginning :" +(queueArray.beginning+1)+" Top :"+(queueArray.top+1) );
        queueArray.printQueue();
        queueArray.deQueue();
       // queueArray.enQueue(6); will print queue is full .. hence in this case circular queue is benefecial
        queueArray.peek();
        queueArray.deQueue();
        System.out.println("Beginning :" +(queueArray.beginning+1)+" Top :"+(queueArray.top+1) );
        queueArray.deQueue();
        queueArray.printQueue();
        queueArray.peek();
        queueArray.deleteQueue();
        queueArray.printQueue();
    }
}
