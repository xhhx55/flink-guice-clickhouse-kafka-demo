package com.evente.service.impl;

import com.evente.service.Animal;

/**
 *
 */
public class Dog implements Animal {
    @Override
    public void move() {
        System.out.println("A dog is running......");
    }
}