package com.zaurtregulov.spring.mvc_hibernate_aop.dao;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ReaderDAOImpl implements ReaderDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Reader> getAllReaders() {

        Session session = sessionFactory.getCurrentSession();
       // List<Reader> allReaders = session.createQuery("from Reader", Reader.class)
      //          .getResultList();

        Query<Reader> query = session.createQuery("from Reader"
            , Reader.class);
        List<Reader> allReaders =query.getResultList();

        return allReaders;
    }

    @Override
    public void saveReader(Reader reader) {
    Session session =sessionFactory.getCurrentSession();

    session.saveOrUpdate(reader);


    }

    @Override
    public Reader getReader(int id) {
        Session session = sessionFactory.getCurrentSession();
    Reader reader = session.get(Reader.class, id);
    return reader;
    }

    @Override
    public void deleteReader(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Reader> query=session.createQuery("delete from Reader where id=:readerId");
        query.setParameter("readerId",id);
        query.executeUpdate();
    }
}
