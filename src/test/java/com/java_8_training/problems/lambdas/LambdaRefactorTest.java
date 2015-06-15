package com.java_8_training.problems.lambdas;

import com.java_8_training.answers.lambdas.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class LambdaRefactorTest {

    //TODO: refactor to use lambda expression
    @Test
    public void sortInventoryByDecreasingWeight() {
        List<Apple> inventory = asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
        inventory.sort((a1, a2) -> a2.getWeight().compareTo(a1.getWeight()));
        assertThat(inventory, is(asList(new Apple(155, "green"), new Apple(120, "red"), new Apple(80, "green"))));
    }

    // TODO: refactor to use lambda expression
    // TODO: refactor to use standard functional interface
    @Test
    public void filterGreenApples() {

        List<Apple> inventory = asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

        List<Apple> greenApples = filterApples(inventory, a -> "green".equals(a.getColor()));

        assertThat(greenApples, is(asList(new Apple(80, "green"), new Apple(155, "green"))));

    }

    //TODO: refactor using lambda expressions
    //TODO: is there anything else we can do?
    @Test
    public void squareNumber() {
        UnaryOperator<Integer> square = integer -> integer * integer;

        assertThat(square.apply(2), is(4));
    }


    private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : inventory) {
            if (p.test(a)) {
                result.add(a);
            }
        }
        return result;
    }
}
