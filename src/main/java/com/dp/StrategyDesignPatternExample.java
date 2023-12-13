package com.dp;

import com.classes.*;

public class StrategyDesignPatternExample {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        duck.setFlyBehavior(new FlyWithWings());
        // changing flying behavior at run time.
        duck.setFlyBehavior(new FlyNoWay());

        duck.setQuackBehavior(new MuteQuack());
        duck.quack();
        duck.display();
        duck.performFly();
        duck.performQuack();
    }
}
