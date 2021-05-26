package com.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) //设置优先级，值越小，优先级越高
public class PersonProxy {
    @Before(value = "execution(* com.aopanno.User.add(..))")
    public void before(){
        System.out.println("Person bedfore.......");
    }

}
