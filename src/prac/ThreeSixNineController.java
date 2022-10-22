package prac;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSixNineController {

    private final List<Integer> numOf369 = List.of(3, 6, 9);
    private final Predicate<String> has369 = i -> numOf369.stream().anyMatch(o -> i.contains(o.toString()));

    //@PostMapping
    public String do369(String input) {
        if (has369.test(input)) return numConverter(input);
        return input;
    }

    private String numConverter(String str) {
        return Arrays.stream(str.split(""))
                .mapToInt(Integer::parseInt)
                .filter(numOf369::contains)
                .mapToObj(o -> "짝")
                .collect(Collectors.joining());
    }

}

class Main {

    public static void main(String[] args) {
        Stream.of(new ThreeSixNineController()).map(i -> i.do369("1244")).forEach(System.out::println);
    }

}
