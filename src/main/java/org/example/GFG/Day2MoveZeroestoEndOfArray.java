package org.example.GFG;

public class Day2MoveZeroestoEndOfArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 0, 4, 3, 0, 5, 0};

        // Approach 1 .. Naive approach
        // using temp array
        int[] temp = new int[a.length];
        int counter=0;
        for (int i = 0; i < a.length;i++){
            if (a[i]!=0){
                temp[counter]=a[i];
                counter++;
            }

        }

        System.out.println("Approach 1:");
        for (int j : temp) {
            System.out.print(j + " ");
        }
        // Approach 2 : expected approach
        // single array with single iteration
        int[] b = {1, 2, 0, 4, 3, 0, 5, 0};
        int x = 0;
        for (int i=0;i<b.length;i++){
            // if both x and i are equal then inplace sort will happen .
            // else the positions will be swapped if i and x are diff.
            if (b[i]!=0){
                int tmp = b[i];
                b[i]=b[x];
                b[x]=tmp;
                x++;
            }
        }
        System.out.println();
        System.out.println("Approach 2:");
        for (int j : b) {
            System.out.print(j + " ");
        }

        n(a);

    }

    private static void n(int[] arr){
        int count = 0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=0){
                if (arr[i]!=arr[count]){
                    int temp = arr[count];
                    arr[count]=arr[i];
                    arr[i]=temp;
                }
                count++;
            }
        }
        System.out.println();
        for (int i: arr){
            System.out.print(i+" ");
        }
    }
}
