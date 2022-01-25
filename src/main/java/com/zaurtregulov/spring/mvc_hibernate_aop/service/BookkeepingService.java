package com.zaurtregulov.spring.mvc_hibernate_aop.service;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Bookkeeping;
import com.zaurtregulov.spring.mvc_hibernate_aop.exceptions.KeepingException;

import java.util.List;

public interface BookkeepingService {
    List<Bookkeeping> getAllKeepings();

    void saveKeeping(Bookkeeping session) throws KeepingException;

    Bookkeeping getKeeping(int id);

    void deleteKeeping(int id);
}
