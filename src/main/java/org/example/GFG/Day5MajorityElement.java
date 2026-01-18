package org.example.GFG;

import java.util.*;

public class Day5MajorityElement {
    public static void main(String[] args) {
        //int[] arr = {2, 2, 3, 1, 3, 2, 1, 1};
        int[] arr = {6, 6, 20 ,6, 20, 6, 6, 6, 6, 20, 6, 20, 6, 20 ,20, 20, 20};
        int floor_val = arr.length/3;
            Map<Integer,Integer> map = new HashMap<>();
            ArrayList<Integer> res = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            //if (map.containsKey(arr[i])){
                map.put(arr[i],map.getOrDefault(arr[i],0)+1); // or we can use get itself with is and else block
            //}
            /*else {
                map.put(arr[i],1);
            }*/
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue()>floor_val){
                res.add(entry.getKey());
            }
        }
        // i didn't understand this below logic but we need to do sorting
        // hence for now im commenting out the below code and using sorting for now
        /*if (res.size() == 2 && res.get(0) > res.get(1)) {
            int temp = res.get(0);
            res.set(0, res.get(1));
            res.set(1, temp);
        }*/
        Collections.sort(res);

        for (int ele: res){
            System.out.print(ele+" ");
        }
    }
}
