package com.viewol.util;

import com.youguu.core.util.PropertiesUtil;

import java.io.IOException;
import java.util.Properties;

public class ImageUtils {

    public static final String PLACE = "\\{viewol-img}";

    /**
     * 给富文本中img的图片地址增加访问前缀
     * @param content
     * @return
     */
    public static String addUrlContent(String content){
        String result = "";
        if(null != content && !"".equals(content)){
            Properties properties = null;
            try {
                properties = PropertiesUtil.getProperties("properties/config.properties");
            } catch (IOException e) {
                e.printStackTrace();
            }
            String imageUrl = properties.getProperty("imageUrl");
            if(!"".equals(imageUrl)){
                result = content.replaceAll(PLACE, imageUrl);
            } else {
                result = content;
            }
        }

        return result;
    }

    /**
     * 去掉富文本中图片地址的前缀
     * @param content
     * @return
     */
    public static String diffUrlContent(String content){
        String result = "";
        if(null != content && !"".equals(content)){
            Properties properties = null;
            try {
                properties = PropertiesUtil.getProperties("properties/config.properties");
            } catch (IOException e) {
                e.printStackTrace();
            }
            String imageUrl = properties.getProperty("imageUrl");
            if(!"".equals(imageUrl)){
                result = content.replaceAll(imageUrl, PLACE);
            } else {
                result = content;
            }
        }

        return result;
    }

    /**
     * 给图片地址增加前缀
     * @param url
     * @return
     */
    public static String addUrlImage(String url){
        String result = "";
        if(null != url && !"".equals(url)){
            Properties properties = null;
            try {
                properties = PropertiesUtil.getProperties("properties/config.properties");
            } catch (IOException e) {
                e.printStackTrace();
            }
            String imageUrl = properties.getProperty("imageUrl");
            if(!"".equals(imageUrl) && !url.startsWith("http")){
                result = imageUrl + url;
            } else {
                result = url;
            }
        }

        return result;
    }

    /**
     * 去掉图片的URL前缀
     * @param url
     * @return
     */
    public static String diffUrlImage(String url){
        String result = "";
        if(null != url && !"".equals(url)){
            Properties properties = null;
            try {
                properties = PropertiesUtil.getProperties("properties/config.properties");
            } catch (IOException e) {
                e.printStackTrace();
            }
            String imageUrl = properties.getProperty("imageUrl");
            if(!"".equals(imageUrl)){
                result = url.replaceAll(imageUrl, "");
            } else {
                result = url;
            }
        }

        return result;
    }


    /**
     * 给pdf地址增加前缀
     * @param url
     * @return
     */
    public static String addUrlPdf(String url){
        String result = "";
        if(null != url && !"".equals(url)){
            Properties properties = null;
            try {
                properties = PropertiesUtil.getProperties("properties/config.properties");
            } catch (IOException e) {
                e.printStackTrace();
            }
            String pdfUrl = properties.getProperty("pdfUrl");
            if(!"".equals(pdfUrl)){
                result = pdfUrl + url;
            } else {
                result = url;
            }
        }

        return result;
    }

    /**
     * 去掉pdf的URL前缀
     * @param url
     * @return
     */
    public static String diffUrlPdf(String url){
        String result = "";
        if(null != url && !"".equals(url)){
            Properties properties = null;
            try {
                properties = PropertiesUtil.getProperties("properties/config.properties");
            } catch (IOException e) {
                e.printStackTrace();
            }
            String pdfUrl = properties.getProperty("pdfUrl");
            if(!"".equals(pdfUrl)){
                result = url.replaceAll(pdfUrl, "");
            } else {
                result = url;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        String content = "<p>少时诵诗书所所<img src=\"{viewol-img}/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"{viewol-img}/mncg/images/code_080.jpg\" alt=\"undefined\"></p><p>asdasdasd</p>";
//        String result = ImageUtils.addUrlContent(content);
//        System.out.println(result);
//
//
//        String aaa = "<p>少时诵诗书所所<img src=\"http://test.youguu.com/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"http://test.youguu.com/mncg/images/code_080.jpg\" alt=\"undefined\"></p><p>asdasdasd</p>\n";
//        String bbb = ImageUtils.diffUrlContent(content);
//        System.out.println(bbb);


        String url = "http://47.93.25.129/viewol-pdf/images/code_080.pdf";
        String result = ImageUtils.diffUrlPdf(url);
        System.out.println(result);

        result = ImageUtils.addUrlPdf(result);
        System.out.println(result);
    }
}
