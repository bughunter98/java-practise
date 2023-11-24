package org.example.DataStructures;

import java.util.Arrays;

public class MinimumandMaximumValueofArray {
    private int findMinimum(int[] array){
        int min = array[0];
        for (int i = 1;i<array.length;i++){
            if (array[i]<min){
                min= array[i];
            }
        }
        return min;
    }
    private int findMaximum(int[] array){
        int max = array[0];
        for (int i = 1;i<array.length;i++){
            if (array[i]>max){
                max = array[i];
            }
        }
        return max;
    }

    private int findSecondMaximumValueusingSortMethod(int[] array){
        Arrays.sort(array);
        return array[array.length-2];
    }
    private int findSecondMaximumValue(int[] array){
        //my approach
        /*int max = array[0],secondMax = array[0];
        for (int i=1;i<array.length;i++){
            if (array[i]>max){
                max=array[i];
            }
        }

        for (int j=0;j<array.length;j++){
            if (array[j]!=max && max!=secondMax){
                if (array[j]>secondMax){
                    secondMax = array[j];
                }
            }
        }*/// commenting this because time complexity is 0(n2)
        int max = Integer.MIN_VALUE,secondMax = Integer.MIN_VALUE;
        for (int i=0;i<array.length;i++){
            if (array[i]>max){
                secondMax=max;
                max=array[i];
            }
            else if (array[i]>secondMax && array[i]<max){
                secondMax=array[i];
            }
        }
        return secondMax;
    }


    public static void main(String[] args) {
        int[] array = {5,9,22,23,1,15,2,16,20};
        MinimumandMaximumValueofArray minimumValueofArray = new MinimumandMaximumValueofArray();
        System.out.println("Minimum Value in Array is :"+minimumValueofArray.findMinimum(array));
        System.out.println("Maximum Value in Array is :"+minimumValueofArray.findMaximum(array));
        System.out.println("Second Maximum Value in Array is :"+minimumValueofArray.findSecondMaximumValue(array));
        System.out.println("Second Maximum Value in Array is :"+minimumValueofArray.findSecondMaximumValueusingSortMethod(array));
    }
}
