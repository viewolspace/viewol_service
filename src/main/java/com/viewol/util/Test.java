package com.viewol.util;

/**
 * Created by lenovo on 2018/7/11.
 */
public class Test {

    static String s  = "<img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\"><img src=\"/mncg/images/code_080.jpg\" alt=\"undefined\">";

    public static String contentHandler(String content){

        String pattern = "(<img[^\"]*\")/([^\"]*\")";
//        String pattern = "<img[^>]*>";

        return content.replaceAll(pattern,"$1http://www.baidu.com/$2");
    }

    public static void main(String[] args) {
        System.out.println(contentHandler(s));
    }
}
