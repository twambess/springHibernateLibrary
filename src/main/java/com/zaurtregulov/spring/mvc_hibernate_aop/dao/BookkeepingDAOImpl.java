package com.zaurtregulov.spring.mvc_hibernate_aop.dao;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Bookkeeping;
//import com.zaurtregulov.spring.mvc_hibernate_aop.exceptions.SessionException;
import com.zaurtregulov.spring.mvc_hibernate_aop.exceptions.KeepingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookkeepingDAOImpl implements BookkeepingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Bookkeeping> getAllKeepings() {
        Session session = sessionFactory.getCurrentSession();
        List<Bookkeeping> allKeepings = session.createQuery("from Bookkeeping " +
                "order by date", Bookkeeping.class).getResultList();

        return allKeepings;
    }

    @Override
    public void saveKeeping(Bookkeeping bookkeeping) throws KeepingException {

        Session session = sessionFactory.getCurrentSession();


        session.saveOrUpdate(bookkeeping);
    }

    @Override
    public Bookkeeping getKeeping(int id) {
        Session session = sessionFactory.getCurrentSession();
        Bookkeeping bookkeeping = session.get(Bookkeeping.class, id);

        return bookkeeping;
    }

    @Override
    public void deleteKeeping(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Bookkeeping> query = session.createQuery("delete from Bookkeeping " +
                "where id =:keepingId");
        query.setParameter("keepingId", id);
        query.executeUpdate();
    }
}