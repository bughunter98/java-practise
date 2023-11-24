package org.example.Programs;

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

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome(-1221));
    }

}
