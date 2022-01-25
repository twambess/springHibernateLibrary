package com.zaurtregulov.spring.mvc_hibernate_aop.dao;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Bookkeeping;
import com.zaurtregulov.spring.mvc_hibernate_aop.exceptions.KeepingException;

import java.util.List;

public interface BookkeepingDAO {
    List<Bookkeeping> getAllKeepings();

   void saveKeeping(Bookkeeping bookkeeping) throws KeepingException;

    Bookkeeping getKeeping(int id);

    void deleteKeeping(int id);
}