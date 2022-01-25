package com.zaurtregulov.spring.mvc_hibernate_aop.dao;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Reader;

import java.util.List;

public interface ReaderDAO {
    public List<Reader> getAllReaders();

   public void saveReader(Reader reader);

   public Reader getReader(int id);

   public void deleteReader(int id);
}
