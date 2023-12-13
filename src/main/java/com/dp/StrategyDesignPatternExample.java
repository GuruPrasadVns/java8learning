package com.dp;

import com.classes.FlyNoWay;
import com.classes.FlyWithWings;
import com.classes.MallardDuck;

public class StrategyDesignPatternExample {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        duck.setFlyBehavior(new FlyWithWings());
        // changing flying behavior at run time.
        duck.setFlyBehavior(new FlyNoWay());
        duck.quack();
        duck.display();
        duck.performFly();
    }
}
