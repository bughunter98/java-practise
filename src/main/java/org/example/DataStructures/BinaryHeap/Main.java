package org.example.DataStructures.BinaryHeap;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(10);
        int[] arr = IntStream.of(5,10,20,30,40,50,60,1).toArray();
        binaryHeap.inputElementsToBeInserted(arr,"min");
        binaryHeap.levelOrderTraversal();
        System.out.println("Size of heap is "+binaryHeap.sizeOfBinaryHeap());
        System.out.println("peek of min heap is :"+binaryHeap.peekOfHeap());
        System.out.println("Extracted value from of min heap :"+binaryHeap.extractNodeFromMinOrMaxBinaryHeap("min"));
        System.out.println("Size of heap after extraction is "+binaryHeap.sizeOfBinaryHeap());
        System.out.println("Binary heap after extraction of value from min Heap");
        binaryHeap.levelOrderTraversal();
        binaryHeap.deleteEntireHeap();
        binaryHeap.levelOrderTraversal();


       BinaryHeap binaryHeap1 = new BinaryHeap(10);
        binaryHeap1.inputElementsToBeInserted(arr,"max");
        binaryHeap1.levelOrderTraversal();
        binaryHeap1.getParentofNode(1);
        System.out.println("peek of max heap is :"+binaryHeap1.peekOfHeap());
        System.out.println("Size of heap is "+binaryHeap1.sizeOfBinaryHeap());
        System.out.println("Extracted value from of max heap :"+binaryHeap1.extractNodeFromMinOrMaxBinaryHeap("max"));
        System.out.println("Size of heap after extraction is "+binaryHeap1.sizeOfBinaryHeap());
        System.out.println("Binary heap after extraction of value from max Heap");
        binaryHeap1.levelOrderTraversal();
        binaryHeap1.deleteEntireHeap();
        binaryHeap1.levelOrderTraversal();

    }
}
