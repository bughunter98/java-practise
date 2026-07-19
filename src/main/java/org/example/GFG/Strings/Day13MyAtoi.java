package org.example.GFG.Strings;

public class Day13MyAtoi {
    public static void main(String[] args) {
        int a = myAtoi("  -0012g4");
        System.out.println(a);
    }

        private static int myAtoi(String s) {
            int sign=1,res=0,index=0;
            // Ignore white spaces.
            while (index<s.length() && s.charAt(index)==' '){
                index++;
            }
            // store the sign of number.
            if (index<s.length() && (s.charAt(index)=='-' || s.charAt(index) =='+')){
                if (s.charAt(index)=='-'){
                    sign=-1;
                }
               index++;
            }
            // construct the number digit by digit.
            while (index<s.length() && Character.isDigit(s.charAt(index))){
                int digit = s.charAt(index) - '0'; // Convert char to int
                // Handling overflow/underflow test case
                if (res > Integer.MAX_VALUE/10 ||
                        (res == Integer.MAX_VALUE/10 && digit > 7)){
                    return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                /* * Subtracting '0' (ASCII 48) converts the char digit to its actual int value.
                 * Example: '5' (ASCII 53) - '0' (ASCII 48) = 5.
                 * Without this, you'd be adding raw ASCII values, leading to wrong results.
                 */
                res = 10 * res + (digit);
                index++;
            }

            return res * sign;
        }
}
