package com.impl;

import com.interfaces.ApplePredicate;
import com.model.Apple;

public class GreenApplePredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
