package org.example.Programs;

public class EvenDigitSum {
    public static int getEvenDigitSum(int number){
        int temp = number , sum=0 , r = 0 , flag=0 ;
        if (number>=0){ //123456789   2 4 6 8
           while (number!=0){
               r=number%10;
               flag++;
               number = number/10;
               if (r%2==0){
                   sum = sum+r;
               }
           }
           return sum;
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(EvenDigitSum.getEvenDigitSum(252));
    }

}
