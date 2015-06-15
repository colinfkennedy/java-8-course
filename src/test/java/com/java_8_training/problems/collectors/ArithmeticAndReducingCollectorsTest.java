package com.java_8_training.problems.collectors;

import com.java_8_training.answers.collectors.Dish;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.function.BinaryOperator.minBy;
import static java.util.stream.Collectors.summarizingInt;
import static junit.framework.Assert.assertEquals;

@Ignore
public class ArithmeticAndReducingCollectorsTest {

    // See: Dish.menu.stream()

    @Test
    public <T> void leastCaloricDishMEAT() {
        Comparator<Dish> dishCalorieComparator = comparingInt(Dish::getCalories);
        BinaryOperator<Dish> minByCalories = minBy(dishCalorieComparator);
        Dish leastCaloricMEAT = Dish.menu.stream()
            .filter(dish -> Dish.Type.MEAT == dish.getType())
            .collect(Collectors.minBy(comparing(Dish::getCalories))).get();

        assertEquals("chicken", leastCaloricMEAT.getName());
    }

    @Test
    public void statisticsForVegetarianDishes() {
        IntSummaryStatistics vegetarianStats = Dish.menu.stream()
            .filter(Dish::isVegetarian)
            .collect(summarizingInt(Dish::getCalories));

        assertEquals(4, vegetarianStats.getCount());
        assertEquals(1550, vegetarianStats.getSum());
        assertEquals(120, vegetarianStats.getMin());
        assertEquals(387.5, vegetarianStats.getAverage());
        assertEquals(550, vegetarianStats.getMax());

    }
}
