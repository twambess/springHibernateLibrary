package com.zaurtregulov.spring.mvc_hibernate_aop.service;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Reader;

import java.util.List;

public interface ReaderService {
    public List<Reader> getAllReaders();

    public void saveReader(Reader reader);

    public Reader getReader(int id);

    public void deleteReader(int id);
}
