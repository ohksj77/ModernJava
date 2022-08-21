package chap3;

import chap1_chap2.Apple;
import chap1_chap2.ApplePredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static chap1_chap2.Color.GREEN;
import static chap1_chap2.Color.RED;
import static java.util.Comparator.comparing;

public class AppleMethodReference {
    static List<Apple> inventory = Arrays.asList(
            new Apple(80, GREEN),
            new Apple(155, GREEN),
            new Apple(120, RED)
    );

    public static void main(String[] args) {
        inventory.sort(comparing(apple -> apple.getWeight()));
        inventory.sort(comparing(Apple::getWeight));
        Comparator<Apple> c = comparing(Apple::getWeight);
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));


    }

    public static <T> List<T> filterApples(List<T> inventory, chap1_chap2.Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T item: inventory){
            if(p.test(item)){
                result.add(item);
            }
        }
        return result;
    }
}
