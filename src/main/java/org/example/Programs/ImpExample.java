package org.example.Programs;

import java.util.Arrays;
import java.util.List;

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
        String word = "saiteja";
        char a = 'a';
        char b = 'b';
        System.out.println(word.charAt(0));
        System.out.println(word.charAt(1));
        System.out.println(word.charAt(2));
        System.out.println(word.charAt(3));
        System.out.println(word.charAt(4));
        System.out.println(a+b);
        System.out.println(a+""+b);
        charPrint();
        // Arrays.asList vs List.of() .. both can be used for creating a list. the diff is
        // Arrays.asList is not resizable but is mutable ..(values can be changed)
        // List.of is immutable ..(values can't be changed)

        var asList = Arrays.asList("Sunday","Monday","Tuesday");
        var listOf = List.of("Sunday","Monday","Tuesday");
        asList.set(0,"Saturday"); // modifying zeroth index
        //listOf.set(0,"Saturday"); // will throw unsupported exception as list.of is immutable
        System.out.println(asList);
        System.out.println(listOf);
    }

    public static void charPrint(){
        char[] ch;
        String str = "abcdefg";
        ch = str.toCharArray();
        char sum = 0;
        for (int i=0;i<ch.length;i++){
            sum = ch[i];
            System.out.println("Sum  "+sum);
        }

    }
}
