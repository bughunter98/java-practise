package org.example.Programs;

public class ImpExample {
    public static int num;
    private static String[] stations = new String[]{
            "a","b","c","d","e"
    };

    public static void main(String[] args) {
        while (num<stations.length){
            if (stations[num++].length()<9){
                break;
            }
        }
        System.out.println(num);
    }
}
