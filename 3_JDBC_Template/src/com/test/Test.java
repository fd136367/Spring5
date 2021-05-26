package com.test;


import com.entity.Book;
import com.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {

    @org.junit.Test
    public void testJDBCTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        //添加操作
//        Book book = new Book();
//        book.setName("如何纠正你的三观");
//        book.setAuthor("杨无");
//        book.setPrice(new BigDecimal(9999));
//        book.setSales(new BigDecimal(9999));
//        book.setStock(6666);
//        book.setImg_path("static/img/default.jpg");
//        bookService.addBook(book);
        //修改操作
//        Book book = new Book();
//        book.setName("如何拯救世界");
//        book.setId(20);
//        bookService.updateBook(book);

        //删除操作
//        bookService.deleteBook("20");

        //查询操作
//        int count = bookService.count();
//        System.out.println(count);

        //查询一条记录
//        Book one = bookService.findOne("5");
//        System.out.println(one);
        //查询所有记录
//        for (Book book : bookService.findAll()) {
//            System.out.println(book);
//        }
        //批量添加
//        List<Object[]> batchArray = new ArrayList<>();
//        Object[] o1 = {null,"废物练成手册","齐天","250","999","100","static/img/default.gif"};
//        Object[] o2 = {null,"如何加入桃园结义","齐云","400","9999","1000","static/img/default.gif"};
//        Object[] o3 = {null,"虎口夺食注意事项","齐飞","310","500","600","static/img/default.gif"};
//        batchArray.add(o1);
//        batchArray.add(o2);
//        batchArray.add(o3);
//        //调用批量添加方法
//        bookService.batchAdd(batchArray);

        //批量修改
//        List<Object[]> batchArray = new ArrayList<>();
//        Object[] o1 = {"99999",21};
//        Object[] o2 = {"99999",22};
//        Object[] o3 = {"99999",23};
//        batchArray.add(o1);
//        batchArray.add(o2);
//        batchArray.add(o3);
//        //调用批量添加方法
//        bookService.batchUpdate(batchArray);


    //批量删除
    List<Object[]> batchArray = new ArrayList<>();
    Object[] o1 = {21};
    Object[] o2 = {22};
        batchArray.add(o1);
        batchArray.add(o2);
    //调用批量添加方法
        bookService.batchDelete(batchArray);
}
}
