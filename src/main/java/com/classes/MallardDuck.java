package com.classes;

import com.interfaces.Duck;
import com.interfaces.FlyBehavior;

public class MallardDuck extends Duck  {

    @Override
    public void display() {
        System.out.println("MallardDuck::display");
    }
}
