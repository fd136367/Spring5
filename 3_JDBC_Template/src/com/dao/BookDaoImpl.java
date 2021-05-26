package com.dao;

import com.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    //注入JDBCTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        //创建sql语句
        String sql = "insert into t_book values(?,?,?,?,?,?,?)";
        //调用方法实现
        int update = jdbcTemplate.update(sql, book.getId(), book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImg_path());
        System.out.println(update);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set name = ? where id = ?";
        int update = jdbcTemplate.update(sql, book.getName(), book.getId());
        System.out.println(update);
    }

    @Override
    public void delete(String id) {
        String sql = "delete from t_book where id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    @Override
    public int count() {
        String sql = "select count(*) from t_book";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public Book findOne(String id) {
        String sql = "select * from t_book where id = ?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;

    }

    @Override
    public List<Book> findAll() {
        String sql = "select * from t_book";
        List<Book> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return query;
    }

    @Override
    public void batchAdd(List<Object[]> bachArray) {
        String sql = "insert into t_book values(?,?,?,?,?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, bachArray);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdate(List<Object[]> bachArray) {
        String sql = "update t_book set sales = ? where id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, bachArray);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDelete(List<Object[]> bachArray) {
        String sql = "delete from t_book where id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, bachArray);
        System.out.println(Arrays.toString(ints));
    }
}
