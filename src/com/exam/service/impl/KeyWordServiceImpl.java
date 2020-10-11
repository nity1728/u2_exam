package com.exam.service.impl;

import com.exam.dao.impl.KeyWordDaoImpl;
import com.exam.entity.KeyWord;
import com.exam.service.KeyWordService;

import java.util.List;

public class KeyWordServiceImpl implements KeyWordService {

    KeyWordDaoImpl keyWordDao=new KeyWordDaoImpl();

    @Override
    public List<KeyWord> findAll() throws Exception {
        return keyWordDao.findAll();
    }

    @Override
    public boolean addKeyWord(KeyWord keyWord) throws Exception {
        return keyWordDao.addKeyWord(keyWord);
    }

    @Override
    public boolean delKeyWord(KeyWord keyWord) throws Exception {
        return keyWordDao.delKeyWord(keyWord);
    }
}
