package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    //https://www.youtube.com/watch?v=dlATMslQ6Uc
    public int romanToInt(String s) {
        // MCMXCIV
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int result = map.get(s.charAt(s.length()-1));
        for (int i=s.length()-2;i>=0;i--){
            if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                result = result-map.get(s.charAt(i));
            }
            else {
                result = result+map.get(s.charAt(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }
}
