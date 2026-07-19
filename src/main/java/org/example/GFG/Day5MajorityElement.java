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

        int[] arr1 = {6, 6, 20 ,6, 20, 6, 6, 6, 6, 20, 6, 20, 6, 20 ,20, 20, 20};

        ArrayList<Integer> output = getMajorityEleUsingMooreAlgo(arr1);
        System.out.println();
        output.forEach(val-> System.out.print(val+" "));
    }

    private static ArrayList<Integer> getMajorityEleUsingMooreAlgo(int[] arr1) {
        int ele1 =-1 , ele2 = -1;
        int count1 = 0 , count2= 0;
        int n = arr1.length;
        for(int ele : arr1){
            // Increment count for candidate 1
            if (ele1 == ele){
                count1++;
            }
            // Increment count for candidate 2
            else if (ele2==ele){
                count2++;
            }
            // New candidate 1 if count is zero
            else if (count1==0) {
                ele1=ele;
                count1++;
            }
            // New candidate 2 if count is zero
            else if (count2==0) {
                ele2=ele;
                count2++;
            }
            // Decrease counts if neither candidate
            else {
                count1--;
                count2--;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;

        // Count the occurrences of candidates
        for (int ele : arr1) {
            if (ele1 == ele) count1++;
            if (ele2 == ele) count2++;
        }

        // Add to result if they are majority elements
        if (count1 > n / 3)
            res.add(ele1);
        if (count2 > n / 3 && ele1 != ele2)
            res.add(ele2);

        // Sort the result if needed
        if (res.size() == 2 && res.get(0) > res.get(1)) {
            int temp = res.get(0);
            res.set(0, res.get(1));
            res.set(1, temp);
        }

        return res;
    }
}
