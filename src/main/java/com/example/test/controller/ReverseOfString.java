package com.example.test.controller;



public class ReverseOfString {
    public static void main(String[] args) {
        String s= "Hello word";
        for(int i=s.length()-1;i>=0;i--){
            System.out.print(s.charAt(i));
        }
    }
}
