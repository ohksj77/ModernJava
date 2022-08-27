package chap4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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

        List<String> threeHighCaloricDishNames = menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName)
                .limit(3).collect(toList());

        List<String> title = Arrays.asList("1", "2", "3");
        title.stream().forEach(System.out::println);

        List<String> names = menu.stream().filter(dish -> {
            System.out.println("dish.getCalories() = " + dish.getCalories());
            return dish.getCalories() > 300;
        }).map(dish -> {
            System.out.println("dish.getName() = " + dish.getName());
            return dish.getName();
        }).limit(3).collect(toList());
        System.out.println("names = " + names);

        menu.stream().forEach(System.out::println);
    }
}
