package com.bookService;

import com.IService;
import com.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookService extends IService<Book> {
    @Override
    void insert(Book book) throws SQLException;

    @Override
    Book selectById(int id);

    @Override
    List<Book> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(Book book) throws SQLException;
}
