package org.example.HackerRank;

import java.util.HashMap;
import java.util.Map;

public class TimeConversion {
    public static String timeConversion(String s) {
        // Write your code here
        // hh:mm:ssAM or hh:mm:ssPM
        if (s.length()!=10 || (s.substring(8).equalsIgnoreCase("PM")||
                s.substring(8).equalsIgnoreCase("AM"))){
            String hour  =  s.substring(0,2);
            String min  = s.substring(3,5);
            String sec = s.substring(6,8);
            String amOrPm = s.substring(8);
            Map<String,Integer> map = getHashmap();
            if ("AM".equalsIgnoreCase(amOrPm)){
                if (Integer.parseInt(hour)<12){
                    return String.format("%s:%s:%s",hour,min,sec);
                }
                else {
                    return String.format("00:%s:%s",min,sec);
                }
            }
            if ("PM".equalsIgnoreCase(amOrPm)){
                if (Integer.parseInt(hour)<12){
                    return String.format("%s:%s:%s", map.get(hour),min,sec);
                }
                else {
                    return String.format("12:%s:%s",min,sec);
                }
            }

        }
        return "Invalid Format";
    }


    private static Map<String, Integer> getHashmap() {
        Map<String,Integer> pmMap = new HashMap<>();
        int hours = 13;
        for (int i= 1;i<10;i++){
            pmMap.put("0"+i,hours);
            hours++;
        }
        pmMap.put("10",22);
        pmMap.put("11",23);
        pmMap.put("12",12);
        return pmMap;
    }

    public static void main(String[] args) {
        String time = "01:01:00PM";
        System.out.println(timeConversion(time));

    }
}
