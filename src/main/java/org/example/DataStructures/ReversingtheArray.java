package org.example.DataStructures;


import java.util.List;

public class ReversingtheArray {
    public static void main(String[] args) {
        int[] array = {2,11,5,10,7,8};
        int start=0, end=array.length-1;
        System.out.println("Input Array is ");
        printArray(array);
        /* if we want to just print reversed array
        System.out.println("After Reversing");
        for (int i=end;i>=start;i--){
            System.out.print(array[i]+ " ");
        }*/
        double now= System.currentTimeMillis();
        int[] reversedArray = reversetheArray(array,start,end);
        printArray(reversedArray);
        System.out.println("Time Taken for reversing Array :  "+(System.currentTimeMillis()-now)+ "milliseconds");

    }

    private static int[] reversetheArray(int[] array, int start, int end) {
        //Scanner sc = new Scanner(System.in);
        int[] finalArray;

        //System.out.println("for reversing array by using one array press 1 or for reversing array by using two arrays press 2");
        int userValue =  /*sc.nextInt()*/2;
        if (userValue==1){

            System.out.println("reversed array is :");
            finalArray = reversetheArrayUsing1Array(array,start,end);
        }
        else if (userValue==2){

            System.out.println("reversed array is :");
            finalArray = reversetheArrayUsing2Arrays(array);
        }
        else {
            System.out.println("Please choose the options wisely....");
            finalArray = new int[]{0,0,0,0,0,0};
        }
        return finalArray;
    }

    private static int[] reversetheArrayUsing1Array(int[] array, int start, int end) {
        while (start<end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }

    private static int[] reversetheArrayUsing2Arrays(int[] array) {
        int reversedArray[] = new int[array.length];
        /*while (start<reversedArray.length+(reversedArray.length/2)){
            reversedArray[start] = array[end];
            start++;
            end--;
            if (end<0 || start>array.length){
                break;
            }
        }*/ // we can use this logic as well but understanding it is bit difficult
        int jindex= array.length;
        for (int i = 0;i<array.length;i++){
            reversedArray[jindex-1] = array[i];
            jindex--;
        }
        return reversedArray;
    }
    //if the elements are given in the form of array then below is the implementation
    private List<Integer> reverseArray(List<Integer> list){
        int start = 0 , end = list.size()-1;
        while (start<end){
            Integer temp = list.get(start);
            list.set(start,list.get(end));
            list.set(end,list.get(temp));
            start++;
            end--;
        }
        return list;
    }

    private static void printArray(int[] array) {
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
