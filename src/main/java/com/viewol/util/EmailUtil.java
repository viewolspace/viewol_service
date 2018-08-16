package com.viewol.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
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


        String SSL_FACTORY="javax.net.ssl.SSLSocketFactory";
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.port", "465"); //google使用465或587端口
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.socketFactory", sf);

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
            message.setContent(content,"text/html;charset=UTF-8");
            //发送信息
            Transport.send(message);
        }catch(MessagingException e){
            e.printStackTrace();

            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(EmailUtil.sendMail("247858193@qq.com","大家伙"));

    }
}
