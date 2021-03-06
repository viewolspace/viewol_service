package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Company;
import com.viewol.pojo.query.CompanyQuery;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/6/28.
 */
public class CompanyServiceImplTest extends BaseTestClass{

    private ICompanyService service = (ICompanyService)getInstance("companyService");


    private Company beanCompany(){
        Company company = new Company();
        company.setId(4);
        company.setName("展商一222");
        company.setLogo("");
        company.setCanApply(1);
        company.setIsRecommend(0);
        company.setProductNum(5);
        company.setContent("233123123123123");
        return company;
    }


    @Test
    public void addCompany(){

        List<String> categoryIds  =  new ArrayList<>();
        categoryIds.add("00010001");
        categoryIds.add("00010002");
        categoryIds.add("00010003");


        System.out.println(service.addCompany(2,beanCompany(),categoryIds));

    }


    @Test
    public void updateCompany(){

        List<String> categoryIds  =  new ArrayList<>();
        categoryIds.add("00010001");
        categoryIds.add("00010002");
        categoryIds.add("00010004");

        System.out.println(service.updateCompany(beanCompany(),categoryIds));
    }

    @Test
    public void getCompany(){
        System.out.println(service.getCompany(3));
    }

    @Test
    public void queryCompany(){
        CompanyQuery query = new CompanyQuery();
        query.setExpoId(2);
        System.out.println(service.queryCompany(query));
    }

    @Test
    public void queryRecommentCompany(){
        System.out.println(service.queryRecommentCompany(1));
    }

    @Test
    public void delRecomment(){
        System.out.println(service.delRecomment(1));
    }

    @Test
    public void addRecomment(){
        System.out.println(service.addRecomment(1, 12));
    }


    @Test
    public void listCompany(){
//        System.out.println(service.listCompany(2,null,null,0,10));
    }


    @Test
    public void impCompany(){

        try {
            String s = org.aspectj.util.FileUtil.readAsString(new File("D:\\工作数据\\其他\\liebiao.txt"));

            String[] ss = s.split("\r\n");

            for(String com:ss){
                String[] temp = com.split("\\|");
//                System.out.println(temp[0]);
                Company company = new Company();
                company.setName(temp[0]);
                company.setLogo("");
                company.setCanApply(1);
                company.setIsRecommend(0);
                company.setProductNum(5);
                company.setPlace(temp[1]);
                company.setContent("");

                List<String> categoryIds  =  new ArrayList<>();
                categoryIds.add("00010001");


                service.addCompany(2,company,categoryIds);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        List<String> categoryIds  =  new ArrayList<>();
//        categoryIds.add("00010001");
//        categoryIds.add("00010002");
//        categoryIds.add("00010003");
//
//
//        System.out.println(service.addCompany(beanCompany(),categoryIds));

    }

}
