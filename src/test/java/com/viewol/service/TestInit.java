package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/7/9.
 */
public class TestInit extends BaseTestClass {
    private ICategoryService categoryService = (ICategoryService)getInstance("categoryService");

    private ICompanyService companyService = (ICompanyService)getInstance("companyService");

    private IProductService productService = (IProductService)getInstance("productService");


    private IFUserService ifUserService = (IFUserService) getInstance("fUserService");


    private IBUserService bUserService = (IBUserService) getInstance("bUserService");


    private IUserCardService userCardService = (IUserCardService)getInstance("userCardService");




    @Test
    public void testInit(){
        boolean isCategory = false;

        boolean isCom = false;

        boolean isProduct = false;

        boolean isFuser = false;

        boolean isBuser = false;

        boolean isUserCard = true;


        int comId = 1;

        if(isCategory){
            //添加分类

            String category_com = "0001";

            String category_pro = "0002";

            //初始化分类
            String[] coms = new String[]{"视频监控","防盗报警","出入口控制","安检排爆","实体防护","智能楼宇","人工智能","软件平台及解决方案","其他"};

            for(String com:coms){
                Category c = new Category();
                c.setParentId(category_com);
                c.setName(com);
                c.setType(Category.TYPE_COM);
                c.setNum(1);
                categoryService.addCategory(c);
            }

            String json = "{“分类1”:[{\"分类1.1\":[\"分类1.1.1\",\"分类1.1.2\"]},{\"分类1.2\":[\"分类1.2.1\",\"分类1.2.2\"]}]}";

            Category c = new Category();
            c.setParentId(category_pro);
            c.setName("分类1");
            c.setType(Category.TYPE_PRODUCT);
            c.setNum(1);
            String id = categoryService.addCategory(c);

            c = new Category();
            c.setParentId(id);
            c.setName("分类1.1");
            c.setType(Category.TYPE_PRODUCT);
            c.setNum(1);
            String id_1 = categoryService.addCategory(c);

            c = new Category();
            c.setParentId(id_1);
            c.setName("分类1.1.1");
            c.setType(Category.TYPE_PRODUCT);
            c.setNum(1);
            categoryService.addCategory(c);

            c = new Category();
            c.setParentId(id_1);
            c.setName("分类1.1.2");
            c.setType(Category.TYPE_PRODUCT);
            c.setNum(1);
            categoryService.addCategory(c);



            c = new Category();
            c.setParentId(id);
            c.setName("分类1.2");
            c.setType(Category.TYPE_PRODUCT);
            c.setNum(1);
            String id_2 = categoryService.addCategory(c);

            c = new Category();
            c.setParentId(id_2);
            c.setName("分类1.2.1");
            c.setType(Category.TYPE_PRODUCT);
            c.setNum(1);
            categoryService.addCategory(c);

            c = new Category();
            c.setParentId(id_2);
            c.setName("分类1.2.2");
            c.setType(Category.TYPE_PRODUCT);
            c.setNum(1);
            categoryService.addCategory(c);
        }

        if(isCom){
            //添加展商
            Company company = new Company();
            company.setName("展商股份有限公司");
            company.setShortName("展商公司");
            company.setPlace("B-5");
            company.setLogo("");
            company.setCanApply(Company.CANAPPLY_YES);
            company.setIsRecommend(Company.ISRECOMMEND_YES);
            company.setProductNum(5);
            company.setContent("233123123123123");

            List<String> categorys = new ArrayList<>();
            categorys.add("00010008");

            companyService.addCompany(company,categorys);
        }

        if(isProduct){
            Product p = new Product();
            p.setContent("内容");
            p.setCompanyId(comId);
            p.setCategoryId("0002000100020002");
            p.setPdfName("说明书");
            p.setIsRecommend(0);
            p.setRecommendNum(0);
            p.setName("摄像头");
            p.setStatus(0);
            p.setPdfUrl("");
            productService.addProduct(p);
        }

        if(isFuser){
            FUser user = new FUser();
            user.setUserName("张三");
            user.setCompany("张三的公司");
            user.setPosition("总经理");
            user.setPhone("13811111111");
            user.setEmail("zhanngsan@gongsi.com");
            user.setAge(46);
            user.setUuid("aasdasdahiuhhjkjknkj1");
            ifUserService.addFUser(user,"openId1","aasdasdahiuhhjkjknkj1", FUserBind.TYPE_WEIXIN);

            user = new FUser();
            user.setUserName("李四");
            user.setCompany("李四的公司");
            user.setPosition("经理");
            user.setPhone("13811111112");
            user.setEmail("lisi@gongsi.com");
            user.setAge(29);
            user.setUuid("aasdasdahiuhhjkjknkj2");
            ifUserService.addFUser(user,"openId2","aasdasdahiuhhjkjknkj2", FUserBind.TYPE_WEIXIN);


            user = new FUser();
            user.setUserName("王五");
            user.setCompany("王五的公司");
            user.setPosition("总经理");
            user.setPhone("13811111113");
            user.setEmail("wangwu@gongsi.com");
            user.setAge(32);
            user.setUuid("aasdasdahiuhhjkjknkj3");
            ifUserService.addFUser(user,"openId3","aasdasdahiuhhjkjknkj3", FUserBind.TYPE_WEIXIN);
        }


        if(isBuser){
            BUser user = new BUser();
            user.setUserName("业务员1");
            user.setCompanyId(comId);
            user.setPosition("总经理");
            user.setPhone("13811111116");
            user.setStatus(0);
            user.setOpenId("1q123123123123123121");
            user.setUuid("waasdasdahiuhhjkjknkj1");
            bUserService.addBUser(user);

            user = new BUser();
            user.setUserName("业务员2");
            user.setCompanyId(comId);
            user.setPosition("业务代表");
            user.setPhone("13811111117");
            user.setStatus(0);
            user.setOpenId("1q123123123123123122");
            user.setUuid("waasdasdahiuhhjkjknkj2");
            bUserService.addBUser(user);

            user = new BUser();
            user.setUserName("业务员3");
            user.setCompanyId(comId);
            user.setPosition("销售总监");
            user.setPhone("13811111118");
            user.setStatus(0);
            user.setOpenId("1q123123123123123123");
            user.setUuid("waasdasdahiuhhjkjknkj3");
            bUserService.addBUser(user);
        }

        if(isUserCard){
            UserCard userCard = new UserCard();
            userCard.setCompanyId(comId);
            userCard.setfUserId(1);
            userCard.setbUserId(1);
            userCardService.addUserCard(userCard);

            userCard = new UserCard();
            userCard.setCompanyId(comId);
            userCard.setfUserId(2);
            userCard.setbUserId(2);
            userCardService.addUserCard(userCard);

            userCard = new UserCard();
            userCard.setCompanyId(comId);
            userCard.setfUserId(3);
            userCard.setbUserId(3);
            userCardService.addUserCard(userCard);
        }


    }
}
