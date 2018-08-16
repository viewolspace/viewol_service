package com.viewol.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by lenovo on 2018/8/16.
 */
public class EmailUtil {

    private static String from = "xiaoguanshixun2018@163.com";

    private static String username = "xiaoguanshixun2018@163.com";

    private static String password = "Qr040712";

    private static String host = "smtp.163.com";

    public static boolean sendMail(String toMail,String content){
        Properties props = new Properties();
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try{
            //创建Message对象，并设置相关参数
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toMail));
            //设置发送信息主题.信息正文
            message.setSubject("产品说明书");
            message.setContent(content,"text/html");
            //发送信息
            Transport.send(message);
        }catch(MessagingException e){
            e.printStackTrace();

            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(EmailUtil.sendMail("247858193@qq.com","1111"));

    }
}
