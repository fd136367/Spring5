package com.dao;

import com.entity.Book;

import java.util.List;

public interface BookDao {
    //添加的方法
    void add(Book book);

    //修改的方法
    void updateBook(Book book);

    //删除的方法
    void delete(String id);

    //查询总记录数
    int count();

    //查询一条记录数
    Book findOne(String id);

    //查询返回集合
    List<Book> findAll();
    //批量添加
    void batchAdd(List<Object[]> bachArray);
    //批量修改
    void batchUpdate(List<Object[]> bachArray);
    //批量删除
    void batchDelete(List<Object[]> bachArray);
}
