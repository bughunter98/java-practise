package org.example.DataStructures;

public class ReSizeArray {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        ReSizeArray reSizeArray = new ReSizeArray();
        System.out.println("Array Size initially is "+array.length);
        array = reSizeArray.reSize(array,20);
        System.out.println("Array Size after resizing is "+array.length);
        array[19]=6;
        reSizeArray.printArray(array);
    }
    private void printArray(int[] array) {
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    private int[] reSize(int[] array, int capacity) { // if we use this method as void it will be garbage colected after the method executed
        // hence we are returning the array.
        int[] temp = new int[capacity];
        for (int i=0;i<array.length;i++){
            temp[i]=array[i];
        }
        return temp;
    }
}
