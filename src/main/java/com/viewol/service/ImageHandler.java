package com.viewol.service;

import com.youguu.core.util.SpringUtil;
import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

public class ImageHandler {

    private static String imageSavePath = "";
    private static String imagePath = "";
    private static String inviteUrl="";

    static {
        Properties pro = new Properties();
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/config.properties");
            if(is!=null){
                pro.load(is);
                imageSavePath = pro.getProperty("imageSavePath");
                imagePath = pro.getProperty("imagePath");
                inviteUrl = pro.getProperty("inviteUrl");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int getWordWidth(Font font, String content) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int width = 0;
        for (int i = 0; i < content.length(); i++) {
            width += metrics.charWidth(content.charAt(i));
        }
        return width;

    }
    //377 561
    public static void drawString(Graphics2D gs,String name,int x,int y){

        Font f = new Font("思源黑",Font.BOLD,70);
        Color mycolor = new Color(254, 226, 192);//new Color(0, 0, 255);
        gs.setColor(Color.WHITE);
        gs.setFont(f);
        gs.drawString(name,x,y);
        gs.dispose();
    }


    /**
     * 头像圆形处理，背景透明
     * @param filePath
     * @param width
     * @param height
     * @return
     */
    public static BufferedImage headImage(String filePath,int width,int height) throws Exception{
        BufferedImage pic  = getBufferedImage(filePath); //原图

        int boder = 1; //留一个像素的白圈

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); //透明的背景图

        Graphics2D g2 = image.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Ellipse2D.Double shape = new Ellipse2D.Double(boder, boder, width-2*boder, height-2*boder);


        // 需要保留
        g2.setComposite(AlphaComposite.Clear);
        g2.fill(new Rectangle(image.getWidth(), image.getHeight()));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2.setClip(shape);
        g2.drawImage(pic, boder, boder, width-2*boder, height-2*boder,null);
        g2.dispose();

        //新创建一个graphics，这样画的圆不会有锯齿
        g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int border1 = 3;
        //画笔是4.5个像素，BasicStroke的使用可以查看下面的参考文档
        //使画笔时基本会像外延伸一定像素，具体可以自己使用的时候测试
        Stroke s = new BasicStroke(4.5F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2.setStroke(s);
        g2.setColor(Color.WHITE);
        g2.drawOval(border1, border1, width - border1 * 2, height - border1 * 2);
        g2.dispose();

        return image;
    }

    public static BufferedImage getBufferedImage(String filePath) throws Exception{
        if(filePath!=null && (filePath.startsWith("http")|| filePath.startsWith("https"))){
            return getRemoteBufferedImage(filePath);
        }else{
            return ImageIO.read(new File(filePath));
        }
    }


    public static BufferedImage getRemoteBufferedImage(String imageURL) {
        URL url = null;
        InputStream is = null;
        BufferedImage bufferedImage = null;
        try {
            url = new URL(imageURL);
            is = url.openStream();
            bufferedImage = ImageIO.read(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(is!=null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return bufferedImage;
    }


	//生成海报
    public static String genPlaybill(int uid,String nickName,String openId,String thirdId,String headPic) throws Exception{

        File file = new File(imageSavePath + uid + ".png");

        if(file.exists()){
            return imagePath + uid + ".png";
        }

        Random ra =new Random();
        int num = ra.nextInt(5) + 1;

        //如果多个改成随机数
        BufferedImage hb  = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("playbill/"+num+".png")); //原图

        Graphics2D g2 = hb.createGraphics();

        g2.drawImage(headImage(headPic, 108, 108), 318, 422, null);//322, 422

        String url = inviteUrl + "?inviteOpenId=" + openId + "&inviteUserId=" + thirdId;

        System.out.println(url);

//        g2.drawImage(createQRCode(url, 115, 115), 302, 808, 144, 143, null);//291, 797, 166, 165,

        //logo
        BufferedImage logo  = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("playbill/logo.png"));
        g2.drawImage(logo, 355, 862, null);


        drawString(g2,nickName,375,575);//375*575

        try {
            // 输出图地址
            file = new File(imageSavePath);
            if(!file.exists()){
                file.mkdirs();
            }
            ImageIO.write(hb, "PNG", new File(imageSavePath + uid + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePath + uid + ".png";
    }


    public static String getInviteUrl() {
        return inviteUrl;
    }

    public static void drawNewString(Graphics2D gs,String name,int x,int y){

        Font f = new Font("思源黑",Font.BOLD,36);
        Color mycolor = new Color(254, 226, 192);//new Color(0, 0, 255);
        gs.setColor(mycolor);
        gs.setFont(f);
        gs.drawString(name,x,y);
        gs.dispose();
    }

    public static void main(String[] args) throws Exception{


        BufferedImage hb  = ImageIO.read(new FileInputStream("D:\\bj.png")); //原图

        Graphics2D g2 = hb.createGraphics();

        ImageHandler.drawString(g2,"王大锤  邀请您一起参加",419,168);


        IWxService service = (IWxService)SpringUtil.getBean("wxService");

        File file = service.createProgramWxaCode(2,740,"page/index");

        g2.drawImage(ImageIO.read(file),386,1369,null);

        ImageIO.write(hb, "PNG", new File( "d:\\tt.png"));


    }

}
