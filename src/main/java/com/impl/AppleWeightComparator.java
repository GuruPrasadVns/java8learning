package com.impl;

import com.model.Apple;

import java.util.Comparator;

public class AppleWeightComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple a1, Apple a2) {
        if(a1.getWeight() < a2.getWeight())
            return -1;
        if(a1.getWeight() > a2.getWeight())
            return 1;
        return 0;
    }
}
