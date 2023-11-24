package org.example.DataStructures;

// take 2 pointers . if i is not zero and j is zero then only swap them . else increment j till it finds value 0
// i to focus on non zero elements and j to focus on zero elements . if found swap else increment
public class MoveZerostoEndofArray {

    public static void main(String[] args) {
        MoveZerostoEndofArray zerostoEndofArray = new MoveZerostoEndofArray();

        int[] array = {4,0,5,9,0,10,0,3};
        zerostoEndofArray.moveZeroestoend(array);
        System.out.println("Array after moving zeroes to last is :");
        zerostoEndofArray.printArray(array);
    }

    private void moveZeroestoend(int[] array) {
        int j = 0;
        for (int i=0;i<array.length;i++) {
            if (array[i]!=0 && array[j]==0){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            if (array[j]!=0){
                j++;
            }
        }
    }

    private void printArray(int[] array) {
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
