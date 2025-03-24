package com.java.pratice;

import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args) {
        String str="({[]})";
        boolean isBalanced= checkBalancedParentheses(str);
        if(isBalanced){
            System.out.println("isBalanced");
        }else{
            System.out.println("Not balanced");
        }
    }

    public static boolean checkBalancedParentheses(String str){
        Stack<Character>stack=new Stack<>();
        for(char ch:str.toCharArray()){
            if(ch == '('|| ch == '{' ||ch == '['){
                stack.push(ch);
            } else if (ch==')'||ch=='}'||ch==']') {
             if(stack.isEmpty()){
             return false;
            }
             char top=stack.pop();
             if(!isMatchingPair(top,ch)){
                 return false;
             }
            }
        }
        return stack.isEmpty();
    }
    private static boolean isMatchingPair(char open,char close){
        return (open=='('||close==')')||
                (open=='{'||close=='}')||
                (open=='['||close==']');
    }
}
