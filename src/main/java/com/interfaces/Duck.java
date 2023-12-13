package com.interfaces;

public abstract class Duck {
    private FlyBehavior flyBehavior;

    public void quack(){
        System.out.println("Duck::quack");
    }

    public void swim(){
        System.out.println("Duck::swim");
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public abstract void display();

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
