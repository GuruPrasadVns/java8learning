package com.utility;

import com.interfaces.ApplePredicate;
import com.model.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleUtility {

    public static List<Apple> getApplesList(){
        return Arrays.asList(
                new Apple("green", 250),
                new Apple("green", 75),
                new Apple("green", 350),
                new Apple("green", 225),
                new Apple("green", 200),
                new Apple("green", 115),
                new Apple("red", 125),
                new Apple("red", 175),
                new Apple("red", 255),
                new Apple("red", 220)
        );
    }

    // Attempt 1
    public static List<Apple> filterGreenApple(List<Apple> applesList){
            List<Apple> result =  new ArrayList<>();

            for(Apple apple: applesList)
                if("green".equals(apple.getColor()))
                    result.add(apple);

            return result;
    }

    // Attempt2
    public static List<Apple> filterAppleByColor(List<Apple> applesList, String color){
        List<Apple> result =  new ArrayList<>();

        for(Apple apple: applesList)
            if(color.equals(apple.getColor()))
                result.add(apple);

        return result;
    }

    public static List<Apple> filterAppleByWeight(List<Apple> applesList, int weight){
        List<Apple> result =  new ArrayList<>();

        for(Apple apple: applesList)
            if(apple.getWeight() > weight)
                result.add(apple);

        return result;
    }

    // Attempt3 Very Bad

    public static List<Apple> filterApplesByColorOrWeight(List<Apple> appleList, String color, int weight, boolean flag){
        List<Apple> result =  new ArrayList<>();

        if(flag){
            for(Apple apple : appleList)
                if(color.equals(apple.getColor()))
                    result.add(apple);
        }else{
            for(Apple apple : appleList)
                if(apple.getWeight() > weight)
                    result.add(apple);
        }

        return appleList;
    }

    // Behavior Parameterization
    public static List<Apple> filterApples(List<Apple> appleList, ApplePredicate applePredicate){
        List<Apple> result = new ArrayList<>();

        for(Apple apple : appleList)
            if(applePredicate.test(apple))
                result.add(apple);

        return result;
    }


}
