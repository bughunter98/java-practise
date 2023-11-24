package org.example.Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MergetwoArrays {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        int [] b = {6,7,8,9,10};

       // approach 1 :
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer intValues : a){
            arrayList.add(intValues);
        }
        for (Integer intValues : b){
            arrayList.add(intValues);
        }
        System.out.println(arrayList);
        // approach 2
        List list = new ArrayList(Arrays.asList(a));
        list.add(Arrays.asList(b));

    }
}
