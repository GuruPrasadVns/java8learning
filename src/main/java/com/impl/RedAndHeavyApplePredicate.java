package com.impl;

import com.interfaces.ApplePredicate;
import com.model.Apple;

public class RedAndHeavyApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor()) && apple.getWeight() > 150;
    }
}
