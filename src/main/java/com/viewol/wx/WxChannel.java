package com.viewol.wx;



import com.alibaba.fastjson.JSONObject;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 */
public class WxChannel {

    Log logger = LogFactory.getLog(WxChannel.class);

    public WxChannel(String appid,String appSecret){
        this.appId = appid;
        this.appSecret = appSecret;
    }

    private String appId;

    private String appSecret;

    /***初始化变量值***/
    //获取access_token
    private String grant_type = "client_credential";

    /**
     * 获取token的url
     */
    private String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token";

    /**
     * 获取jsapi接口
     */
    private String jsapiUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";


    /**
     * 通过CODE 拉toKen
     */
    private String getUserTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    private String getUserUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";


    private String getUserFollowUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";


    private String imgTicket_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";

    //公众号发送模板消息
    private String send_msg_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";



    private  long lasttime  = 0 ;

    /**
     * 应用唯一id  老APPID 保留备份
     */

    public String getAppId() {
        return appId;
    }

    /**
     * 应用秘钥   老secret 保留备份
     * @param flag 0 正常获取 会根据缓存判断   1 强制刷新
     */

    public String getToken(int flag){

        synchronized (this){
                StringBuffer sb = new StringBuffer(this.tokenUrl);
                sb.append("?")
                        .append("grant_type").append("=").append(grant_type).append("&")
                        .append("appid").append("=").append(appId).append("&")
                        .append("secret").append("=").append(appSecret);
                String response =  HttpsClient.getClient().doGet(sb.toString());
                String access_token_new = null;
                if(response!=null){
                    access_token_new = JSONObject.parseObject(response).getString("access_token");
                    return access_token_new;
                }
        }
        return null;
    }

    /**
     * 推送模板信息
     * @param openid
     * @param template_id
     * @param url
     * @param msg
     * @return
     */
    private JSONObject sendMsg(String openid,String access_token,String template_id,String url,JSONObject msg){
        String wx_url = this.send_msg_url + access_token ;
        JSONObject json = new JSONObject();
        json.put("touser",openid);
        json.put("template_id",template_id);
        json.put("url",url);
        json.put("data",msg);
        String result = HttpsClient.getClient().doPost(wx_url, json.toJSONString());

        JSONObject wx_result;
        try{
            wx_result = JSONObject.parseObject(result);
        }catch (Exception e){
            wx_result = new JSONObject();
            wx_result.put("errcode",-1);
        }

        return wx_result;
    }




    public String getJsapiPath(String access_token){
        StringBuilder sb = new StringBuilder(this.jsapiUrl);
        sb.append("?")
                .append("access_token").append("=").append(access_token).append("&")
                .append("type").append("=").append("jsapi");
        return sb.toString();
    }


    /**
     *
     * @return JSONObject
     * errcode
     * ticket
     */
    public JSONObject getJsapi(String access_token){

        try{
            String response =  HttpsClient.getClient().doGet(getJsapiPath(access_token));
            logger.info(response);
            if(response!=null){
                JSONObject json= JSONObject.parseObject(response);

                return json;
//
//                int errcode = json.getIntValue("errcode");
//                if(0 == errcode){
//                    jsapi_ticket = json.getString("ticket");
//                }else if(40001 == errcode || 42001 == errcode){ // access_token 过期，重新获取
//                    response =  HttpsClient.getClient().doGet(getJsapiPath(access_token));
//                    logger.info(response);
//                    json= JSONObject.parseObject(response);
//                    errcode = json.getIntValue("errcode");
//                    if(0 == errcode){
//                        jsapi_ticket = json.getString("ticket");
//                    }else{
//                        jsapi_ticket = null;
//                    }
//                }else{
//                    jsapi_ticket = null;
//                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成签名
     * @param
     * @return
     */
    public String signature(Map<String, String> params){

        StringBuffer sb = new StringBuffer("");
        Set<Map.Entry<String, String>> es = params.entrySet();
        Iterator<Map.Entry<String, String>> it = es.iterator();
        while(it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            String k = entry.getKey();
            String v = entry.getValue();
            sb.append(k).append("=").append(v).append("&");
        }

        String param = sb.substring(0, sb.lastIndexOf("&"));
        String appsign = Sha1Util.getSha1(param);
        return appsign;
    }

    public String getUser(String token,String openid) {

        String  response = HttpsClient.getClient().doGet(String.format(getUserUrl, token, openid));

        return response;

    }


    public String getUserFollowInfo(String token,String openid) {

        String  response = HttpsClient.getClient().doGet(String.format(getUserFollowUrl, token, openid));

        return response;

    }




    public static void main(String[] args){


    }
}
