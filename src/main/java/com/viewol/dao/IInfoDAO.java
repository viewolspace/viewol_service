package com.viewol.dao;

import com.viewol.pojo.Info;
import com.viewol.pojo.query.InfoQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

public interface IInfoDAO {

    int save(int classify,Info info);

    int updateInfo(Info info);

    int deleteInfo(int id);

    Info getInfo(int id);

    int updateStatus(int id , int status);

    PageHolder<Info> queryInfo(InfoQuery query);

    List<Info> listInfo(int classify,int lastSeq, int pageSize);

    boolean isRepeat(String title);
}
