package com.designpattern.demo.beans;

import org.springframework.stereotype.Component;

@Component
public class Bean {
    public Bean() {
    }
    public void doSomething() {
        System.out.println("Doing something...");
    }

}
