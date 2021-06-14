package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IProductIdeaNewDAO;
import com.viewol.pojo.ProductIdeaNew;
import com.viewol.pojo.query.ProductIdeaNewQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2019/7/25.
 */
@Repository("productIdeaNewDAO")
public class ProductIdeaNewDAOImpl extends BaseDAO<ProductIdeaNew> implements IProductIdeaNewDAO {

    @Override
    public ProductIdeaNew getProductIdea(int id) {
        return super.get(id);
    }

    @Override
    public int addProductIdea(ProductIdeaNew productIdea) {
        Date d = new Date();
        productIdea.setcTime(d);
        productIdea.setmTime(d);
        return super.insert(productIdea);
    }

    @Override
    public int deleteProductIdea(int id) {
        return super.delete(id);
    }

    @Override
    public int updateProductIdea(ProductIdeaNew productIdea) {
        Date d = new Date();
        productIdea.setmTime(d);
        return super.update(productIdea);
    }

    @Override
    public int updateStatus(int productId, int status) {
        Map<String,Object> map = new HashMap<>();
        map.put("productId",productId);
        map.put("status",status);
        return super.updateBy("updateStatus",map);
    }

    @Override
    public int updateNum(int productId) {
        Map<String,Object> map = new HashMap<>();
        map.put("productId",productId);
        return super.updateBy("updateNum",map);
    }

    @Override
    public PageHolder<ProductIdeaNew> queryProductIdea(ProductIdeaNewQuery query) {
        return super.pagedQuery("findByParams",query.map(),query.getPageIndex(),query.getPageSize());
    }

    @Override
    public int countByCompanyId(int companyId) {
        return super.count("countByCompanyId11", companyId);
    }


    @Override
    public List<ProductIdeaNew> list(String cid, String productName,int productId, int pageIndex, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        if(cid!=null && !"".equals(cid)){
            try{
                int c = Integer.parseInt(cid);
                if(c>1){
                    if(c==2){
                        map.put("categoryId","'智慧消防技术产品','消防信息化技术产品'");
                    }else if(c==3){
                        map.put("categoryId","'喷水灭火产品','泡沫灭火设备产品','干粉灭火设备产品','气体灭火设备产品','灭火剂','灭火器','消防给水设备产品'");
                    }else if(c==4){
                        map.put("categoryId","'消防车辆','消防灭火装备','消防员防护装备','消防抢险救援装备','消防特种装备','消防训练装备','消防员职业健康','应急救援装备','消防通信产品'");
                    }else if(c==5){
                        map.put("categoryId","'火灾探测器','电气火灾监控系统','消防联动控制系统','可燃气体报警产品','消防应急照明产品','消防安全疏散指示产品','消防安全标志','防火涂料','防火堵料','防火门','防火窗','防火卷帘','防火玻璃','建筑防烟排烟设施','逃生自救'");

                    }else if(c==6){
                        map.put("categoryId","'消防科研技术设备','火灾事故调查技术设备'");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        if(productName!=null && !"".equals(productName)){
            map.put("productName",productName);
        }
        if(productId > 0 ){
            map.put("productId",productId);
        }
        map.put("start",(pageIndex-1)*pageSize);
        map.put("end",pageSize);
        return super.findBy("list",map);
    }


    @Override
    public int allcount() {
        return super.count("allcount",null);
    }
}
