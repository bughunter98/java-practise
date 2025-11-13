package org.example.Programs;

import java.util.Arrays;

public class Palindrome {
    public static boolean isPalindrome(int number){
        int temp = number , r , rev=0;
        System.out.println("Initial value of Number is "+number);
        while(number!=0){
            r = number%10; //1221
            rev = (rev*10)+r;
            number = number/10;
        }
        System.out.println("number got modified to"+number);
        return temp==rev;
    }
    public static boolean isAnagram(String a , String b){
        if (a.length()==b.length()){
            char[] s1Array = a.toCharArray();
            char[] s2Array = b.toCharArray();
            Arrays.sort(s1Array);
            Arrays.sort(s2Array);
            return Arrays.equals(s1Array,s2Array);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome(-1221));
        String a = "cat";
        String b = "tac";
        System.out.println(Palindrome.isAnagram(a,b));

    }

}
