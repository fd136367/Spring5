package com.test;

import com.config.TxConfig;
import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Test {
    @org.junit.Test
    public void testAccount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    //基于xml方式进行事务操作
    @org.junit.Test
    public void testAccount1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    //基于完全注解方式进行事务操作
    @org.junit.Test
    public void testAccount2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    //函数式风格创建对象，交给spring进行管理
    @org.junit.Test
    public void testGenericApplicationContext(){
        //创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //调用context的方法对象注册
        context.refresh();
        context.registerBean("user",User.class,() -> new User());
        //获取在spring注册对象
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}
