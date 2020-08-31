package com.evente.service.impl;

import com.evente.service.Animal;

/**
 *
 */
public class Bird implements Animal {
    @Override
    public void move() {
        System.out.println("A bird is flying....");
    }
}
