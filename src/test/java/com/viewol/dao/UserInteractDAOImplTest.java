package com.viewol.dao;

import com.alibaba.fastjson.JSON;
import com.viewol.base.BaseTestClass;
import com.viewol.pojo.UserInteract;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserInteractDAOImplTest extends BaseTestClass {

    private IUserInteractDAO dao = (IUserInteractDAO) getInstance("userInteractDAO");


    @Test
    public void addUserInteract() {
        UserInteract userInteract = new UserInteract();
        userInteract.setClassify(1);
        userInteract.setType(1);
        userInteract.setThirdId(1);
        userInteract.setUserId(1);
        userInteract.setUserName("aaa");
        userInteract.setHeadImgUrl("bbbb");
        userInteract.setComment("sdjfsldkfjsdf");
        userInteract.setcTime(new Date());

        dao.addUserInteract(userInteract);
    }

    @Test
    public void testQueryList() {
        List<UserInteract> list = dao.queryList(1, UserInteract.CLASSIFY_PRODUCT, UserInteract.TYPE_COMMENT, 12);
        System.out.println(JSON.toJSON(list));
    }
}