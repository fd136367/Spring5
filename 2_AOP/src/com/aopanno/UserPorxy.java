package com.aopanno;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 2.创建增强类（编写增强逻辑）
 * 1）在增强类里面创建方法，让不同方法代表不同通知类型
 */
//增强的类
@Component
@Aspect //生成代理对象
public class UserPorxy {

    @Pointcut(value = "execution(* com.aopanno.User.add(..))")
    public void pointdemo(){ }


    //前置通知
//    @Before()注解表示作为前置通知
    @Before(value = "pointdemo()")
    public void before(){
        System.out.println("bedfore.......");
    }

    //最终通知
    @After(value = "pointdemo()")
    public void After(){
        System.out.println("After.......");
    }
    //后置通知（返回通知）
    @AfterReturning(value = "pointdemo()")
    public void AfterReturning(){
        System.out.println("AfterReturning.......");
    }
    //异常通知
    @AfterThrowing(value = "pointdemo()")
    public void AfterThrowing(){
        System.out.println("AfterThrowing.......");
    }
    //环绕通知
    @Around(value = "pointdemo()")
    public void Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("增强之前.......");
        proceedingJoinPoint.proceed();
        System.out.println("增强之后.......");
    }
}
