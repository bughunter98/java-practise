package org.example.DataStructures.Stacks;

public class ThreeInOneStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOneStack(int stackSize){
        stackCapacity=stackSize;
        values=new int[stackSize*numberOfStacks];
        sizes=new int[numberOfStacks];
    }

    public boolean isFull(int stackNum){
        return sizes[stackNum]==stackCapacity;
    }
    public boolean isEmpty(int stackNum){
        return sizes[stackNum]==0;
    }

    public int indexOfTop(int stackNum){ // if there are 3 stacks then they will be 0,1,2
        int offset = stackNum*stackCapacity;
        int size = sizes[stackNum];
        return offset+size-1!= -1 ? offset+size-1 : 0;
        // because if indexofTop  is -1 then while printing array[-1] will give indexoutofBounds
    }

    public void push(int val, int stackNum){
        if (isFull(stackNum)){
            System.out.println("Stack "+(stackNum+1)+" is Full , cannot push");
        }
        else {
            sizes[stackNum]++; // because initially stack size will be zero
            values[indexOfTop(stackNum)]=val;
            System.out.println("pushed :"+val+" into stack :"+(stackNum+1));
        }
    }
    public void pop(int stackNum){
        if (isEmpty(stackNum)){
            System.out.println("stack is already empty . so cannot pop");
        }
        else {
            int top = indexOfTop(stackNum);
            int val = values[top];
            values[top]=0;
            sizes[stackNum]--;
            System.out.println("popped :"+val+" from stack :"+(stackNum+1));
        }
    }
    public void printStack(int stackNum){
        int top = indexOfTop(stackNum);
        for (int i=top-1;i<stackNum*stackCapacity+stackCapacity;i++){
            System.out.print(values[i]);
            if (i<stackNum*stackCapacity+stackCapacity-1){
                System.out.print("->");
            }
        }
        System.out.println();
    }
    public void peek(int stackNum){
        if (isEmpty(stackNum)){
            System.out.println("Stack "+(stackNum+1)+" is empty cannot peek");
        }
        else {
            System.out.println("Peek value of Stack :"+(stackNum+1)+" is :"+indexOfTop(stackNum));
        }

    }

    public static void main(String[] args) {
        ThreeInOneStack threeInOne = new ThreeInOneStack(3);
        threeInOne.push(1,0);
        threeInOne.push(2,0);
        threeInOne.push(3,0);
        threeInOne.push(4,1);
        threeInOne.push(5,1);
        threeInOne.push(6,1);
        threeInOne.push(7,2); // stackNum val 2 means here this will be 3rd stack as 0 is 1st and 1 is second stack
        threeInOne.push(8,2);
        threeInOne.push(9,2);
        threeInOne.pop(0);
        threeInOne.pop(1);
        threeInOne.pop(2);
        threeInOne.printStack(0);
        threeInOne.printStack(1);
        threeInOne.printStack(2);
        threeInOne.peek(0);
        threeInOne.peek(1);
        threeInOne.peek(2);
    }
}
