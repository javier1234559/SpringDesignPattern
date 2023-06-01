package com.designpattern.demo.service;

import com.designpattern.demo.beans.Bean;
import org.springframework.stereotype.Service;

@Service
public class BeanService {
    private final Bean bean ;

    public BeanService(Bean  bean){
        this.bean = bean ;
    }
    public void doSomethingWithBean(){
        System.out.println("Inside of BeanSerivce");
        bean.doSomething();
    }
}
