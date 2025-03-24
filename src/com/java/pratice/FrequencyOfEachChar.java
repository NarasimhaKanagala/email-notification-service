package com.java.pratice;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;

public class FrequencyOfEachChar {
    public static void main(String[] args){
        List<String> words =Arrays.asList("pen","pencil","song","pee");

        //combine the words into single word
        String s = String.join("",words);
        System.out.println(s);

        //create a frequency map of each character
        Map<Character,Long> frequencyMap =s.chars().mapToObj(c->(char)c).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(frequencyMap);
        // Print the frequency of each character
         frequencyMap.forEach((character, frequency) -> System.out.println(character + ": " + frequency));

    }
}
