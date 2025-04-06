package org.example.HackerRank;

public class NumberLineJumps {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        boolean flag=false;
        for (int i=0;i<10000;i++){
            x1=x1+v1;
            x2=x2+v2;
            if (x1==x2){
                flag=true;
                break;
            }
        }
        return  flag ? "YES":"NO";
    }

    public static void main(String[] args) {
        System.out.println(kangaroo(0,3,4,2));
        System.out.println(kangaroo(0,2,5,3));
    }
}
