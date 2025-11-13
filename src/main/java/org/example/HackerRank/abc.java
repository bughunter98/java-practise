package org.example.HackerRank;

import java.util.* ;
import java.io.*;
class abc {

    public static void main(String args[]) {

        // Write code here
        Scanner sc = new Scanner(System.in);
        int basic = sc.nextInt();
        char grade = sc.next().charAt(0);
        String gradeStr = String.valueOf(grade).toUpperCase();
        if (basic>=0 &&basic<=750000){
            double hra = basic * 0.20;
            double da = basic * 0.50;
            double pf = basic * 0.11;

            int allow = 0;
            if(gradeStr.equalsIgnoreCase("A")){ allow = 1700;}
            else if(gradeStr.equalsIgnoreCase("B")){allow = 1500;}
            else {allow=1300;}

            float totalSalary = (float) (basic+hra+da+allow-pf);
            System.out.println(Math.round(totalSalary));
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a>=b && a>=c){
                System.out.println(a);
            } else if (b>=a && b>=c) {
                System.out.println(b);
            }
            else {
                System.out.println(c);
            }
        }

        int x = sc.nextInt();
        int y = sc.nextInt();

        if (x>0 &&y >0){System.out.println("1st Quadrant");}
        else if (x<0 && y>0) {System.out.println("2nd Quadrant");}
        else if (x<0 && y<0) {{System.out.println("3rd Quadrant");}}
        else if (x>0 && y<0) {{System.out.println("4th Quadrant");}}
        else {{System.out.println("Origin");}}


    }
}