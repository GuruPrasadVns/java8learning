package com.classes;

import com.interfaces.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("MuteQuack::quack");
    }
}
