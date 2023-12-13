package com.classes;

import com.interfaces.QuackBehavior;

public class Squack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squack::quack");
    }
}
