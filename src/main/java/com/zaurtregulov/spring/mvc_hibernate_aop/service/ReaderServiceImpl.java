package com.zaurtregulov.spring.mvc_hibernate_aop.service;

import com.zaurtregulov.spring.mvc_hibernate_aop.dao.ReaderDAO;
import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ReaderServiceImpl implements ReaderService
{
    @Autowired
    private ReaderDAO readerDAO;
    @Override
    @Transactional
    public List<Reader> getAllReaders() {
        return readerDAO.getAllReaders();
    }

    @Override
    @Transactional
    public void saveReader(Reader reader) {
        readerDAO.saveReader(reader);
    }

    @Override
    @Transactional
    public Reader getReader(int id) {
        return readerDAO.getReader(id);
    }

    @Override
    @Transactional
    public void deleteReader(int id) { readerDAO.deleteReader(id);}

}
