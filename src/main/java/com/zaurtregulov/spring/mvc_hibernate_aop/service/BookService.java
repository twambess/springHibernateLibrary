package com.zaurtregulov.spring.mvc_hibernate_aop.service;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();

    public void saveBook(Book book);

    public Book getBook(int id);

    public void deleteBook(int id);
}
