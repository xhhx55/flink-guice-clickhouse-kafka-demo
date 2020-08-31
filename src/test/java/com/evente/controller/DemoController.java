package com.evente.controller;

import com.evente.service.Animal;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class DemoController {

    @Inject
    @Named("dogServiceImpl")
    private Animal animal;

    public void test(){
        animal.move();
    }
}
