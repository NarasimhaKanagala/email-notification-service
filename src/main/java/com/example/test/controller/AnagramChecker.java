package com.example.test.controller;

import java.util.Arrays;

public class AnagramChecker {
    public static void main(String[] args) {
        String s1 = "Listen";
        String s2 = "Silent";
        if (isAnagram(s1, s2)) {
            System.out.println("Both are anagrams");
        } else {
            System.out.println("Both are not anagrams");
        }
    }

    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }

}
