package com.service;

import com.dao.BookDao;
import com.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    //注入dao
    @Autowired
    private BookDao bookDao;

    //添加方法
    public void addBook(Book book){
        bookDao.add(book);
    }
    //修改的方法
    public void updateBook(Book book){
        bookDao.updateBook(book);
    }
    //删除方法
    public void deleteBook(String id){
        bookDao.delete(id);
    }
    //查询总记录数
    public int count(){
        return bookDao.count();
    }
    //查询一条记录数
    public Book findOne(String id){
        return bookDao.findOne(id);
    }
    //查询返回集合
    public List<Book> findAll(){
        return bookDao.findAll();
    }
    //批量添加
    public void batchAdd(List<Object[]> bachArray){
       bookDao.batchAdd(bachArray);
    }
    //批量修改
    public void batchUpdate(List<Object[]> bachArray){
        bookDao.batchUpdate(bachArray);
    }
    //批量删除
    public void batchDelete(List<Object[]> bachArray){
        bookDao.batchDelete(bachArray);
    }
}
