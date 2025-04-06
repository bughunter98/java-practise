package org.example.DataStructures.BinaryHeap;

public class BinaryHeap {
    // why heap is implemented with array even tough its a binary tree
    // ans : https://stackoverflow.com/questions/37634731/data-structures-if-heaps-are-trees-why-are-they-implemented-internally-with-li

    int[] array;
    int sizeOfTree;

    public BinaryHeap(int size){
        array = new int[size+1] ; // adding 1 to size because i'm skipping zeroth index for better calculations.
        sizeOfTree=0; // not using this keyword as we are not using the same names in the arguments.
        System.out.println("Successfully created binary heap of size : " +size);
    }

    public boolean isEmpty(){
        return sizeOfTree == 0;
    }

    public Integer peekOfHeap(){
        System.out.println(sizeOfTree==0 ? "Tree is empty":"");
        return sizeOfTree == 0 ? null : array[1];
    }
    public int sizeOfBinaryHeap(){
        return sizeOfTree;
    }
    // as binary heap has root nodes sorted we can easily identify the root nodes using level order traversal.
    public void levelOrderTraversal(){
        // starting from index 1 as we insert our array values from first index
        if (sizeOfTree==0){
            System.out.println("Cannot Traverse an empty heap");
        }
        for (int i=1;i<=sizeOfTree;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("\n");
    }
    //heapify the binary heap after inserting the element into binary heap
    // heapifying from bottom to top because the element is inserted always at bottom and to as left as possible in the binary tree.
    public void insert(int value, String heapType){
        if (sizeOfTree==0){
            array[1] = value;
        }
        else {
            array[sizeOfTree+1]=value;
        }
        sizeOfTree++;
        //System.out.println("inserted "+value+" into the binary heap successfully....");
        heapifyFromBottomToTop(sizeOfTree,heapType);
    }

    public void getParentofNode(int nodeValue){
        int nodeIndex=0,parentNode;
        boolean flag = false;
        for (int i=1;i<=sizeOfTree;i++){
            if (nodeValue==array[i]){
                nodeIndex = i;
                flag = true;
                break;
            }
        }
        parentNode = nodeIndex/2;
        System.out.println(flag ? "Found "+nodeValue+" at position "+nodeIndex+". And its parent node is "+array[parentNode]:
                "Node not found in the binary heap");
    }

    public int extractNodeFromMinOrMaxBinaryHeap(String heapType){
        // the only element that can be extracted from the binary heap is the root node;
        // after the root node is extracted we replace it with last node of binary heap and we heapify the binary heap
        int extractedNode = peekOfHeap();
        // replace the extracted root with last value of binary heap;
        array[1]=array[sizeOfTree];
        array[sizeOfTree]=0;
        sizeOfTree--;
        // we successfully deleted the last index and replaced to root now.
        // now we need to heapify the binary heap from top to bottom.
        heapifyFromTopToBottom(1,heapType);
        return extractedNode;
    }

    private void heapifyFromBottomToTop(int index , String heapType){
        int parentNode = index/2;
        if (index <= 1){
            // as we know root node is located in 1st index we need not heapify further
            return;
        }
        if ("min".equalsIgnoreCase(heapType)){
            if (array[index]<array[parentNode]){
                swapElements(index,parentNode,true);
            }
        }
        if ("max".equalsIgnoreCase(heapType)){
            if (array[index]>array[parentNode]){
                swapElements(index,parentNode,true);
            }
        }
        //index = parentNode; // after swapping we need to move to that index to check with the new swapped nodes parent...
        heapifyFromBottomToTop(parentNode,heapType);
    }

    private void heapifyFromTopToBottom(int parentIndex , String heapType){

        int leftChildIndex = 2*parentIndex;
        int rightChildIndex = 2*parentIndex+1;
        int swapChild= 0;

        //it means we dont have any child for the node
        if (sizeOfTree < leftChildIndex){
            return;
        }
        // incase of min heap : if both the children are smaller than the parent node then we take the
        // smallest value of children and swap
        if ("max".equalsIgnoreCase(heapType)){
            // that means the node is having only left child
            if (sizeOfTree==leftChildIndex){
                if (array[parentIndex]<array[leftChildIndex]){
                    swapElements(parentIndex,leftChildIndex,false);
                }
                // we are returning here because in case of top down approach already the above parent nodes would
                // have been sorted so we need not heapify them again .
                return;
            }
            else {
                // which ever child is greater among the 2 childs we take that and we swap
                swapChild = array[leftChildIndex]>array[rightChildIndex] ? leftChildIndex : rightChildIndex;
                if (array[parentIndex]<array[swapChild]){
                    swapElements(parentIndex,swapChild,false);
                }
            }

        }
        else if ("min".equalsIgnoreCase(heapType)) {
            // that means the node is having only left child
            if (sizeOfTree==leftChildIndex){
                if (array[parentIndex]>array[leftChildIndex]){
                    swapElements(parentIndex,leftChildIndex,false);
                }
                // we are returning here because in case of top down approach already the above parent nodes would
                // have been sorted so we need not heapify them again .
                return ;
            }
            else {
                // which ever child is greater among the 2 childs we take that and we swap
                swapChild = array[leftChildIndex]<array[rightChildIndex] ? leftChildIndex : rightChildIndex;
                if (array[parentIndex]>array[swapChild]){
                    swapElements(parentIndex,swapChild,false);
                }
            }

        }
        heapifyFromTopToBottom(swapChild,heapType);

    }

    private void swapElements(int a , int  b , boolean useThirdVariableToSwap){
        if (useThirdVariableToSwap){
            int temp=array[a];
            array[a]=array[b];
            array[b]=temp;
        }
        else {
            // swapping without using third variable
            array[a]=array[a]+array[b];
            array[b]=array[a]-array[b];
            array[a]=array[a]-array[b];
        }
    }

    public void inputElementsToBeInserted(int[] values,String heapType){
        for (int value : values) {
            insert(value, heapType);
        }
        }

    public void deleteEntireHeap(){
        array = null;
        sizeOfTree=0;
        System.out.println("Deleted Binary Heap Successfully");
    }

}
