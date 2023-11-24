package org.example.Programs;

import java.util.ArrayList;

public class sumofNumbersDivisibleby3and5 {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i =1 ; i<=1000 ; i++){
            if (i%3==0 && i%5==0){
                array.add(i);
            }
            //if (array.size()==5) break;
        }
        System.out.println(array);
        int sum = 0;
        System.out.println("Sum of all the digits that are divisible by 3 and 5 till 1000 is ");
        for (int i =0 ; i< array.size() ; i++){
            sum = sum + array.get(i);
        }
        System.out.println(sum);
        System.out.println("using java 8 to get sum ");
        System.out.println(array.stream().mapToInt(Integer::valueOf).sum());
    }
}
