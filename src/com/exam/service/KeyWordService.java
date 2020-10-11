package com.exam.service;

import com.exam.entity.KeyWord;

import java.util.List;

public interface KeyWordService {

    //查看所有关键词信息
    public List<KeyWord> findAll() throws Exception;

    //添加关键词
    public boolean addKeyWord(KeyWord keyWord) throws Exception;

    //删除关键词
    public boolean delKeyWord(KeyWord keyWord) throws Exception;
}
