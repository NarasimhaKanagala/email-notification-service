import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Virtus {
    public static void main(String[] args) {
        String s ="Hello world";
        List<Character> characters = s.chars().mapToObj(c->(char)c).collect(Collectors.toList());
      //  System.out.println(characters);
        Map<Character,Long> countArray=characters.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(countArray);
    }

}
