package com.zaurtregulov.spring.mvc_hibernate_aop.dao;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Book;

import java.util.List;

public interface BookDAO {
    public List<Book> getAllBooks();

    public void saveBook(Book book);

    public Book getBook(int id);

    public void deleteBook(int id);
}
