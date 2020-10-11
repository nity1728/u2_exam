package com.exam.dao;

import com.exam.entity.KeyWord;

import java.util.List;

public interface KeyWordDao {

    //查看所有关键词信息
    public List<KeyWord> findAll() throws Exception;

    //添加关键词
    public boolean addKeyWord(KeyWord keyWord) throws Exception;

    //删除关键词
    public boolean delKeyWord(KeyWord keyWord) throws Exception;
}
