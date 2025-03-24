package com.java.pratice;
import java.util.*;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FourthHighestSalary {
    public static void main(String[] args) {
        String[] arr={"china","-1","0","India","China","0","-1","India","Norway","-1"};


       Map<String,Long> countryCount = Stream.of(arr).filter(s->s.matches("^[A-Z,a-z].*")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       countryCount.forEach((contry,count)-> System.out.println(contry+" "+count));





    }
}