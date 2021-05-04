package com.viewol.service;

import com.viewol.pojo.AdMedia;
import com.viewol.pojo.query.AdMediaQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

/**
 * Created by lenovo on 2018/6/29.
 */
public interface IAdMediaService {

    int addAdMedias(List<AdMedia> list);

    int delAdmedia(int companyId);

    List<AdMedia> listByCompanyId(int companyId);

    PageHolder<AdMedia> queryAdMedia(AdMediaQuery query);
}
