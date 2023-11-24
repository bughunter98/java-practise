package org.example.DataStructures;

//Extending an array after initialization: As we can't modify the array size after the declaration of the array,
// we can only extend it by initializing a new array and copying the values of the old array to the new array,
// and then we can assign new values to the array according to the size of the array declared.
public class RemoveEvenDigitsfromArray {
    public static void main(String[] args) {

        int[] array = {3,2,4,7,10,6,5};
        System.out.println("After removing even digits the elemtns in the array are :");
        //  System.out.println(removeEvenDigitsfromArray(array)); will return output like [I@511baa65
        int result[] = removeEvenDigitsfromArray(array);
        printArray(result);

    }

    public static void printArray(int[] result) {
        System.out.println("Elements in array are :");
        for (int i =0 ;i<result.length ; i++){
            System.out.print(result[i]+" ");
        }
    }

    private static int[] removeEvenDigitsfromArray(int[] array) {
        int length = array.length;
        int oddCount=0;
        int indexforResult=0;

        for (int i =0 ; i<length ; i++){
            if (array[i]%2!=0){
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        for (int i = 0;i<length;i++){
            if (array[i]%2!=0){
              result[indexforResult]= array[i];
              indexforResult++;
            }
        }
        return result;
    }
}

