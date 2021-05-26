package com.test;

import com.autowire.Emp;
import com.bean.Orders;
import com.config.SpringConfig;
import com.conllectiontype.Book;
import com.conllectiontype.Course;
import com.conllectiontype.Stu;
import com.factorybean.MyBean;
import com.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;

public class TestDemo {


    @Test
    public void testCollection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Book book = context.getBean("book", Book.class);

        book.test();

    }


    @Test
    public void testmybean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        MyBean myBean = context.getBean("mybean", MyBean.class);

        System.out.println(myBean);

    }
    @Test
    public void testmybean1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        Course course = context.getBean("mybean", Course.class);

        System.out.println(course);

    }


    @Test
    //测试生命周期
    public void testmybean2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步 获取创建bean实例对象");
        System.out.println(orders);
        
        //手动让bean实例销毁
        context.close();
    }

    @Test
    //自动装配
    public void testmybean3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);

    }

    @Test
    //自动装配
    public void testService1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();

    }


    @Test
    //完全注解开发
    public void testService2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();

    }
}
