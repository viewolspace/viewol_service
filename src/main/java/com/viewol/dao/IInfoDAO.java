package com.viewol.dao;

import com.viewol.pojo.Info;
import com.youguu.core.util.PageHolder;

import java.util.List;

public interface IInfoDAO {

    int save(Info info);

    PageHolder<Info> queryInfo(String title, String startTime, String endTime, int pageIndex, int pageSize);

    List<Info> listInfo(int lastSeq, int pageSize);

}
