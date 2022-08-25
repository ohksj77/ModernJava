package chap4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static chap4.Dish.menu;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class StreamExample {
    public static void main(String[] args) {

        List<String> lowCaloricDishesName = menu.stream().filter(d -> d.getCalories() < 400).sorted(comparing(Dish::getCalories))
                .map(Dish::getName).collect(toList());

        List<String> lowCaloricDishesName2 = menu.parallelStream().filter(d -> d.getCalories() < 400).sorted(comparing(Dish::getCalories))
                .map(Dish::getName).collect(toList());

        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
    }
}
