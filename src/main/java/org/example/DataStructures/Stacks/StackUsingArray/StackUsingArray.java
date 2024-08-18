package org.example.DataStructures.Stacks.StackUsingArray;

public class StackUsingArray {
    int[] array;
    int top;
    public StackUsingArray(int size){
        this.array=new int[size];
        this.top=-1;
        System.out.println("Stack Created Successfully with size of "+size);
    }

    // isEmptyMethod
    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top==array.length-1;
    }
    public void push(int value){
        if (!isFull()){
            array[top+1]=value;
            top++;
            System.out.println("Value Pushed Successsfully");
        }
        else {
            System.out.println("Stack is full . Cannot push the data");
        }
    }
    public int pop(){
        int topOfStack = -1;
        if (!isEmpty()){
            topOfStack = array[top];
            array[top]=0;
            top--;
        }
        else {
            System.out.println("Cannot pop as Array is empty");
        }
        return topOfStack;
    }
    public int peek(){
        if (!isEmpty()){
            return array[top];
        }
        else {
            return -1;
        }
    }
    public void deleteStack(){
        array=null;
        System.out.println("Deleted array Successfully");
    }
    public void printStack(){
        if (array!=null){
            for (int i=0;i<array.length;i++) {
                if (array[i] != 0) {
                    System.out.print(array[i]);
                    if (i != top) {
                        System.out.print("->");
                    }
                }
            }
        }
        else {
            System.out.println("Array is Empty");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        System.out.println("peek val : "+stack.peek());
        stack.printStack();
        System.out.println(stack.pop());
        System.out.println("is stack empty ??  : "+stack.isEmpty());
        System.out.println("is stack full ??  : "+stack.isFull());
        System.out.println("peek val : "+stack.peek());
        stack.printStack();
        stack.deleteStack();
        stack.printStack();

    }
}
