package com.viewol.service;

import com.viewol.pojo.Info;
import com.viewol.pojo.query.InfoQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

public interface IInfoService {

    int save(int classify,Info info);

    int updateInfo(Info info);

    int deleteInfo(int id);

    PageHolder<Info> queryInfo(InfoQuery query);

    List<Info> listInfo(int classify,int lastSeq, int pageSize);

    Info getInfo(int id);

    int updateStatus(int id , int status);

    boolean isRepeat(String contentUrl);
}
