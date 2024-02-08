package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Java8Utiltiy {

    public static List<String> processStringUsingPredicate(List<String> strings, Predicate<String> predicate){
        List<String> result = new ArrayList<>();
        for(String string: strings){
            if(predicate.test(string))
                result.add(string);
        }

        return result;
    }

    public static void printStringUsingConsumer(List<String> strings, Consumer<String> consumer){
        for(String string : strings)
            consumer.accept(string);
    }

    public static List<Integer> processStringsUsingFunction(List<String> strings, Function<String, Integer> function){
        List<Integer> result = new ArrayList<>();
        for(String string : strings){
            result.add(function.apply(string));
        }
        return result;
    }
}
