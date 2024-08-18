package org.example.DataStructures.Stacks;

import java.util.Stack;

public class BalancedParenthesis {
    public void isBalanced(String expression){
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<expression.length();i++){
            char x = expression.charAt(i);
            if (x =='(' || x=='{' || x=='['){
                stack.push(x);
            }
            else {
                if (!stack.isEmpty() && (
                        (x==')' && stack.peek()=='(' )||
                        (x=='}' && stack.peek()=='{' )||
                        (x==']'&& stack.peek()=='['))){
                    stack.pop();
                }
                else {
                     stack.push(x);
                }
            }
        }
        if (stack.isEmpty()){
            System.out.println("Balanced");
        }
        else {
            System.out.println("Not Balanced");
        }
    }
    public static boolean isBalanced1(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void isBalancedWihoutUsingStack(String expression){

    }
    public static void main(String[] args) {
        BalancedParenthesis balancedParenthesis = new BalancedParenthesis();
        balancedParenthesis.isBalanced("{[]}{()[]}");
        balancedParenthesis.isBalanced("[()]{}{[()()]()}");
        balancedParenthesis.isBalanced("[(])");

    }
}
