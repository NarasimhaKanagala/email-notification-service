package com.example.test.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCount {
    public static void main(String[] args) {
        String s = "I am an Indian";
        //Converting String into CharacterArray
        List<Character> ch = s.chars()// generates an IntStream  of Character codes
                .mapToObj(c -> (char) c)//Coverts these codes to a Stream<Character>
                .collect(Collectors.toList());

        Map<Character, Long> result = ch.stream()//apply stream on character array
                .filter(c -> !Character.isWhitespace(c))//ensures  spaces are  ignored in the count
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));//groups character and counts their occurrences

        System.out.print(result);
    }
}
