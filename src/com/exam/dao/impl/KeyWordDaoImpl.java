package com.exam.dao.impl;

import com.exam.basedao.BaseDao;
import com.exam.dao.KeyWordDao;
import com.exam.entity.KeyWord;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KeyWordDaoImpl extends BaseDao implements KeyWordDao {

    @Override
    public List<KeyWord> findAll() throws Exception {
        String sql="select * from keyword";
        List<KeyWord> list=new ArrayList<KeyWord>();
        ResultSet rs=exeuQuery(sql);
        while (rs.next()){
            KeyWord kw=new KeyWord();
            kw.setId(rs.getInt(1));
            kw.setName(rs.getString(2));
            kw.setType(rs.getString(3));
            kw.setCreateDate(rs.getDate(4));
            list.add(kw);
        }
        getClose();
        return list;
    }

    @Override
    public boolean addKeyWord(KeyWord keyWord) throws Exception {
        String sql="insert into keyword(name,type,createDate)values (?,?,?)";
        Object [] objects={keyWord.getName(),keyWord.getType(),keyWord.getCreateDate()};
        int index=-1;
        index=exeuUpdate(sql,objects);
        getClose();
        if(index>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delKeyWord(KeyWord keyWord) throws Exception {
        String sql="delete from keyword where id=?";
        Object [] objects={keyWord.getId()};
        int index=-1;
        index=exeuUpdate(sql,objects);
        getClose();
        if(index>0){
            return true;
        }else {
            return false;
        }
    }
}
