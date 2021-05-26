package com.aopanno;

import org.springframework.stereotype.Component;

//创建类，在类里面定义方法
//被增强的方法
@Component
public class User {

    public void add(){
        System.out.println("add.......");
    }
}
