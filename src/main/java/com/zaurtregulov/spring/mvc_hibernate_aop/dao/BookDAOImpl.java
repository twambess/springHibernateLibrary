package com.zaurtregulov.spring.mvc_hibernate_aop.dao;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

        @Repository
        public class BookDAOImpl implements BookDAO {
            @Autowired
            private SessionFactory sessionFactory;
            @Override
            public List<Book> getAllBooks() {

                Session session = sessionFactory.getCurrentSession();
                // List<Reader> allReaders = session.createQuery("from Reader", Reader.class)
                //          .getResultList();

                Query<Book> query = session.createQuery("from Book"
                        , Book.class);
                List<Book> allBooks =query.getResultList();

                return allBooks;
            }

            @Override
            public void saveBook(Book book) {
                Session session =sessionFactory.getCurrentSession();

                session.saveOrUpdate(book);


            }

            @Override
            public Book getBook(int id) {
                Session session = sessionFactory.getCurrentSession();
                Book book = session.get(Book.class, id);
                return book;
            }

            @Override
            public void deleteBook(int id) {
                Session session = sessionFactory.getCurrentSession();
                Query<Book> query=session.createQuery("delete from Book where id=:bookId");
                query.setParameter("bookId",id);
                query.executeUpdate();
            }
        }

