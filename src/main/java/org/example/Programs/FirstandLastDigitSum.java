package org.example.Programs;

public class FirstandLastDigitSum {
    public static int sumFirstAndLastDigit(int number){

        if (number>=0){
            int temp = number , sum=0 , r = 0 , flag=0 ;
            while(number!=0){
                //123
                r =  number%10;
                if(flag==0){
                    sum = sum+r;
                    flag++;
                }
                number = number/10;
                if(number==0){
                    sum = sum+r;
                }
            }
            return sum;
        }
        else if (number==0) return  0;
        else return -1;

    }

    public static void main(String[] args) {
        System.out.println(FirstandLastDigitSum.sumFirstAndLastDigit(123));
    }
}
