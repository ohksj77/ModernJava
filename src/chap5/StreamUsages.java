package chap5;

import chap4.Dish;

import java.util.Arrays;
import java.util.List;

import static chap4.Dish.menu;
import static java.util.stream.Collectors.toList;

public class StreamUsages {
    public static void main(String[] args) {

        List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(toList());

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)

        );

        List<Dish> slicedMenu1 = specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320).collect(toList());

        List<Dish> slicedMenu2 = specialMenu.stream().dropWhile(dish -> dish.getCalories() < 320).collect(toList());

        List<Dish> dishes1 = specialMenu.stream().filter(dish -> dish.getCalories() > 300).limit(3).collect(toList());

        List<Dish> dishes2 = specialMenu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());

        List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");

        List<Integer> wordLengths = words.stream().map(String::length).collect(toList());

        words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::print);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect(toList());


    }
}
