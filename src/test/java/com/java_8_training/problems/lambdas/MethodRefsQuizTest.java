package com.java_8_training.problems.lambdas;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class MethodRefsQuizTest {


    //TODO: refactor to use a method reference
    @Test
    public void stringToIntegerQuiz(){

        Function<String, Integer> stringToInteger = Integer::parseInt;

        assertThat(2, is(stringToInteger.apply("2")));

    }

    //TODO: refactor to use a method reference
    @Test
    public void containsQuiz(){

        BiPredicate<List<String>, String> contains = List::contains;
        List<String> list = Arrays.asList("who", "how", "why");
//        list = list.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
//        System.out.println(list);
        boolean doesItContainIt = contains.test(Arrays.asList("who", "how", "why"), "who");

        assertEquals(true, doesItContainIt);

    }
}
