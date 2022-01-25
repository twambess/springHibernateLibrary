package com.zaurtregulov.spring.mvc_hibernate_aop.service;

import com.zaurtregulov.spring.mvc_hibernate_aop.dao.BookkeepingDAO;
import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Bookkeeping;
import com.zaurtregulov.spring.mvc_hibernate_aop.exceptions.KeepingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookkeepingServiceImpl implements BookkeepingService {

    @Autowired
    private BookkeepingDAO bookkeepingDAO;

    @Override
    @Transactional
    public List<Bookkeeping> getAllKeepings() {
        return bookkeepingDAO.getAllKeepings();
    }

    @Override
    @Transactional
    public void saveKeeping(Bookkeeping session) throws KeepingException {
        bookkeepingDAO.saveKeeping(session);
    }

    @Override
    @Transactional
    public Bookkeeping getKeeping(int id) {

        return bookkeepingDAO.getKeeping(id);
    }

    @Override
    @Transactional
    public void deleteKeeping(int id) {
        bookkeepingDAO.deleteKeeping(id);
    }
}
