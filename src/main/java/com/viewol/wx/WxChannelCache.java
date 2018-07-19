package com.viewol.wx;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lenovo on 2016/12/25.
 */
public class WxChannelCache {


    public final static  int TYPE_1 = 1; //第一个公众号

    public final static String APPID = "wx33ced9524f7aa796";

    //wxbe5a13b7459582d0 , 54faccfe1fa3aa67b4855d235003f360

    private static Map<Integer,WxChannel> map = new ConcurrentHashMap<>();

    /**
     * 先不支持多个appid 默认写死
     * @return
     */
    public static WxChannel getWxChannel(int type){
        WxChannel channel = map.get(TYPE_1);
        if(channel!=null){
            return channel;
        }
        synchronized (WxChannelCache.class){
            channel = map.get(TYPE_1);
            if(channel==null){
                if("1".equals(TYPE_1)){
                    channel = new WxChannel();
                    map.put(TYPE_1,channel);
                }else{
                    return null;
                }


            }
        }
        return channel;
    }


}
