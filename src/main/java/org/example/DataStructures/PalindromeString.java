package org.example.DataStructures;

public class PalindromeString {
    public static void main(String[] args) {
        isStringaPalindrome(); // time comp : 0(n) and spaceComplexity also 0(n)
        isStringaPalindrome2();// time comp : 0(n) and The space complexity of this code is O(1) because it only
                               // uses a constant amount of extra space to store the start and end indices.
    }

    private static void isStringaPalindrome2() {
        String str = "malayalam";
        char[] charArray = str.toCharArray();
        int start = 0, end = charArray.length - 1;
        boolean isPalindrome = checkforPalindrome(charArray, str, start, end);
        if (isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }

    private static boolean checkforPalindrome(char[] charArray, String str, int start, int end) {
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static void isStringaPalindrome() {
        String str = "malayalam";
        StringBuffer stringBuffer = new StringBuffer(str);
        String reversedString = String.valueOf(stringBuffer.reverse());
        if (str.equals(reversedString)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}
