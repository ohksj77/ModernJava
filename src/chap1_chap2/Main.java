package chap1_chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chap1_chap2.Color.*;

public class Main {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED)
        );

//        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
//        System.out.println(greenApples);
//
//        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
//        System.out.println(heavyApples);
//
//        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> GREEN.equals(a.getColor()));
//        System.out.println(greenApples2);
//
//        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
//        System.out.println(heavyApples2);
//
//        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || BROWN.equals(a.getColor()));
//        System.out.println(weirdApples);
    }
    public static <T> List<T> filterApples(List<T> inventory, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T item: inventory){
            if(p.test(item)){
                result.add(item);
            }
        }
        return result;
    }
}
