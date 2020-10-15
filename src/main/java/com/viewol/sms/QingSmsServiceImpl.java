package com.viewol.sms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.pojo.Response;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/8/14.
 * 900492 报名论坛
 */
public class QingSmsServiceImpl implements ISmsService {

    private static Log log = LogFactory.getLog(QingSmsServiceImpl.class);

    public static Response<String> sendGet(String url, Map<String, String> head,Map<String,String> params, String charset) {
        Response res = new Response();
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;

        try {

            StringBuilder sb = new StringBuilder(url);

            sb.append("?");

            for(Map.Entry<String,String> entry:params.entrySet()){
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }


            String path = sb.toString();
            path = path.substring(0,path.length()-1);

            URL e2 = new URL(path);
            HttpURLConnection connection = (HttpURLConnection)e2.openConnection();
            connection.setRequestMethod("GET");
            for(Map.Entry<String,String> entry:head.entrySet()){
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }

            connection.setConnectTimeout(10000);
            connection.setReadTimeout(15000);
            connection.setDoOutput(true);
            connection.connect();

            int code1 = connection.getResponseCode();
            System.out.println(code1);
            if(code1 == 200 || code1 == 400) {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));

                String line2;
                while((line2 = in.readLine()) != null) {
                    result.append(line2);
                }

                res.setCode("0000");
                res.setMsg("ok");
                res.setT(result.toString());
            } else {
                res.setCode("1001");
                res.setMsg("返回码异常:" + code1);
            }
        } catch (SocketTimeoutException var22) {
            res.setCode("1001");
            res.setMsg("连接超时");
            var22.printStackTrace();
        } catch (Exception var23) {
            res.setCode("1001");
            res.setMsg("连接异常");
            var23.printStackTrace();
        } finally {
            try {
                if(in != null) {
                    in.close();
                }
            } catch (Exception var21) {
                res.setCode("1002");
                res.setMsg("关闭连接异常");
                var21.printStackTrace();
            }

        }

        return res;
    }

    @Override
    public int sendRand(String phone,String rand) {

        String host = "https://feginesms.market.alicloudapi.com/codeNotice";
        String path = "/codeNotice";
        String method = "GET";
        String appcode = "b1569a310a8c42afb4a62fc71f8341e9";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("param", rand);
        querys.put("phone", phone);
        querys.put("sign", "51806");
        querys.put("skin", "100001");
        //JDK 1.8示例代码请在这里下载：  http://code.fegine.com/Tools.zip

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 或者直接下载：
             * http://code.fegine.com/HttpUtils.zip
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             * 相关jar包（非pom）直接下载：
             * http://code.fegine.com/aliyun-jar.zip
             *Response [code=0000, msg=ok, t={"Message":"手机号码错误！","Code":"101","RequestId":"","BizId":""}]
             * Response [code=0000, msg=ok, t={"Message":"OK","RequestId":"20764A63-8012-4DEB-8F1C-0F9BAB58D502","BizId":"576505734212865015^0","Code":"OK"}]
             */

            Response<String> response = sendGet(host, headers, querys, "UTF-8");
            System.out.println(response.toString());

            if("0000".equals(response.getCode())){
                JSONObject json = JSON.parseObject(response.getT()) ;
                String code = json.getString("Code");
                if("OK".equals(code)){
                    return 1;
                }else{
                    log.error("sms_err:" + code);
                }
            }
            //获取response的body
//            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }




    public int sendsms(String phone,int bbsId) {
        try {
            String param = "建筑火灾防控研讨会|10月16日13:00-17:20新馆W201";
            if(bbsId==2){
                param = "智慧消防论坛|10月18日9:15-12:2 新馆W201";
            }else if(bbsId==3){
                param = "消防装备创新论坛|10月18日13:30-16:35 新馆W201";
            }else if(bbsId==4){
                param = "灭火救援技术论坛|10月17日9:30-16:40 新馆W201";
            }


            String host = "https://feginesms.market.alicloudapi.com/codeNotice";
            String path = "/codeNotice";
            String method = "GET";
            String appcode = "b1569a310a8c42afb4a62fc71f8341e9";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("param", URLEncoder.encode(param,"UTF-8"));
            querys.put("phone", phone);
            querys.put("sign", "51806");
            querys.put("skin", "900492");
        //JDK 1.8示例代码请在这里下载：  http://code.fegine.com/Tools.zip


            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 或者直接下载：
             * http://code.fegine.com/HttpUtils.zip
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             * 相关jar包（非pom）直接下载：
             * http://code.fegine.com/aliyun-jar.zip
             *Response [code=0000, msg=ok, t={"Message":"手机号码错误！","Code":"101","RequestId":"","BizId":""}]
             * Response [code=0000, msg=ok, t={"Message":"OK","RequestId":"20764A63-8012-4DEB-8F1C-0F9BAB58D502","BizId":"576505734212865015^0","Code":"OK"}]
             */

            Response<String> response = sendGet(host, headers, querys, "UTF-8");
            System.out.println(response.toString());

            if("0000".equals(response.getCode())){
                JSONObject json = JSON.parseObject(response.getT()) ;
                String code = json.getString("Code");
                if("OK".equals(code)){
                    return 1;
                }else{
                    log.error("sms_err:" + code);
                }
            }
            //获取response的body
//            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static void lt1(){
        String phoneSend = "";
        String phoneReady = "18500569567,15910605866,13922126168,13911309594,13826105071,18917317846,13681950846,18903121007,13520122519,13828772336,15889675961,13918365851,18616901018,13911270738,13261781562,17610126623,15600038310,18911653315,18813096202,15120098291,18651849335,13466333903,13810436365,13917017539,13866726091,18974979021,13527439735,15808883250,13811763138,18916058012,15961132698,15901601919,13901003559,17600103218,13720071048,13501391566,18616588846,13333168063,18501640641,15025787057,18810654098,13665699737,18901392356,18513835159,13911400505,13911400506,13601210311,13910412819,15811273898,13901337282,18682163190,17380049119,15850586308,15671375333";
        String[] phones = phoneReady.split(",");
        QingSmsServiceImpl q = new QingSmsServiceImpl();
        for(String phone:phones){
            if(phoneSend.indexOf(phone)<0){
                q.sendsms(phone,1);
            }
        }
    }


    public static void lt2(){
        String phoneSend = "";
        String phoneReady = "15306386879,15898969510,13928870950,13772328184,13381579936,13925158105,13901393450,17686421388,13708729895,13811518664,15110010031,18515566680,13811263387,13621062015,18615516119,15910278187,13951743146,18761660015,13810044099,15901337208,13581739175,13815866019,18601711946,13801302895,15895893122,18601005442,18611129178,13977782696,13810180022,13501892973,13671108866,15830858807,13801107685,18601781612,15221866762,15711263304,18519779144,13591000462,18831416860,18401770477,13910412819,15301588893,15568885117,13522558119,18200258575,15522506119,15776650349,13817168119,15810250849,13503820119,13901330207,18092582777,15210305361,13928454478,13898198566,18515119119,15024895000,13810554313,18945092560,18600426286,13981889991,13917393009,18809573777,13384785550,13811535690,13805185852,13281350765,18079226119,13390911999,13787150921,13911986969,13199568087,13601138155,13904320036,13656657038,13922127686,18681907721,13146257355,13819183101,18957135682,15910990457,18678983001,13210970128,18610272610,13581954178,13408663540,17781404970,19141913273,18328365348,13308028119,13541127506,14780091119,18310096099,13325103413,18056070379,13581693203,18519328930,13141170710,18253266677,18653205977,18920503070,17726073070,13905712928,18857128080,18966377771,18966377770,13983782200,18868402118,15157341002,18367163858,15824305613,18368322013,13910766857,13811829206,15120091592,18611111111,15029528631,18909510163,18695109897,13980681199,18050015966,18806335117,13996339518,15369467493,13910037475,18866191818,15911017252,13811661805,18911673777,18901392356,18686891232,15811271166,13810436365,13911111111,18658216932,16602812707,13426303984,15057102808,18031962231,15865572018,15723225463,15568885117,17781404970,18328365348,13541127506,14780091119,15739529119,19141913273,13241976587,18662057595,18512367894,15529378770,15133985603,17380049119,15523864881,18601781612,13513371771,13801027680,13901337282,18774660907,13868117030,13883755460,17318213156,13772328184,15221866762,13552468259,18276659250,18618126620,13301315906,13905768350,15258612138,15850586308,18814820218,13958606066,15258610510,18357168323,13819618989,15305886622,15640518131,13753180566,15980838679,15860705804,13916629841,13485329788";
        String[] phones = phoneReady.split(",");
        QingSmsServiceImpl q = new QingSmsServiceImpl();
        for(String phone:phones){
            if(phoneSend.indexOf(phone)<0){
                q.sendsms(phone,2);
            }
        }
    }

    public static void lt3(){
        String phoneSend = "";
        String phoneReady = "15306386879,15898969510,13925158105,13314633888,18045330528,15765523555,13901048427,15057119711,18600756794,18519779144,18911067010,18515566680,13801080174,15711263304,15895793122,18814709119,18601005442,13032677028,18919013777,13825851415,13671108866,15830858807,13801107685,13488691530,13591000462,15568885117,13522558119,13981834119,13817168033,13901330207,13201420494,13655264546,15810520188,15201192281,18515119119,13521606566,13810554313,13922169266,15921466682,13981889991,13801871985,13752230393,13001188230,18227822777,18682163190,13805185852,13752150555,13311801513,13601138155,13199568087,13922127686,13390911999,13904320036,13338746035,13840896119,18516818119,18611095093,18778820911,15853516777,13772328184,15910990457,18616786823,\u202D18017128205\u202C,\u202D13343588883\u202C,18600828777,18310096099,13325103413,18056070379,13581693203,18519328930,13141170710,18253266677,18653205977,18920503070,17726073070,17708020015,13378116541,18981933022,13666209175,15105217377,13628056934,17308001305,18280194898,13408568563,13568979897,18002826199,18780265607,17323224709,15806600990,13693597477,13301022334,15313086892,18401623960,18701038355,13833108929,15029528631,18909510163,18695109897,13819863088,18918517040,18910931788,18732182815,19909061193,13915945366,13915086119,18686891232,13911111111,13426303984,15057102808,18031962231,15865572018,13784967009,13241976587,13811217950,18512367894,15529378770,17710220514,18601781612,13801027680,13901337282,18774660907,13868117030,13883755460,17318213156,15184449716,13772328184,13308087739,13850157119,18276659250,18696768175,18618126620,13905768350,15258612138,15850586308,18814820218,13958606066,15258610510,15765523555,18357168323,15640518131,15860705804,15896006096,18621046697,18502876715,13485329788";
        String[] phones = phoneReady.split(",");
        QingSmsServiceImpl q = new QingSmsServiceImpl();
        for(String phone:phones){
            if(phoneSend.indexOf(phone)<0){
                q.sendsms(phone,3);
            }
        }
    }

    public static void lt4(){
        String phoneSend = "";
        String phoneReady = "15306386879,15898969510,15057119711,13925158105,13846967119,18108138134,45187908013,13801107685,13805872086,15110010031,18519779144,13838856406,13402869353,13817585458,13905740583,18515566680,15755773119,15973119488,18911067010,15711263304,18761660015,13815866019,13951743146,18601711946,18618358513,15895893122,18601005442,15882223327,13825851415,18931973939,18118445891,13671108866,15830858807,18401770477,13591000462,18831416860,13801324685,15568885117,13911270738,13805185852,13099570950,13817168119,13901330207,13328055800,13366076375,15811094446,15201192281,18515119119,13521606566,13810554313,13961005002,18502701023,13981889991,13917393009,15911111513,18227822777,13390911999,13199568087,13601138155,13904320036,13547849632,13810988622,13120235519,13915086119,15131997907,13976019979,13161764111,15651666999,13901071587,15168900119,13840896119,15850822873,13809503547,18611095093,18778820911,15853516777,13373048469,18918517040,13772328184,15910990457,13601008179,13408663540,17781404970,19141913273,18328365348,13308028119,13541127506,14780091119,13901628863,13816748119,13795294119,13816717119,13918139119,13818334119,15021934119,13795358787,13918731853,13795284119,13817696119,13918125119,13818839119,13918704119,13564122561,13816740119,18519922244,13944545078,18310096099,13325103413,18056070379,13581693203,18519328930,13141170710,18253266677,18653205977,18920503070,17726073070,13601003270,15029528631,18695109897,18909510163,18910931788,13236633603,18255721688,13701007620,13266961019,15713881304,15369467493,18682163190,13691409816,18686891232,18618494592,13426303984,15057102808,13546413467,15865572018,15723225463,17781404970,18328365348,13541127506,14780091119,15739529119,19141913273,13241976587,18750336077,13811217950,18867710937,15026552992,18512367894,18616221379,15523864881,18601781612,18681437596,13338888667,13622159209,13801027680,13901337282,18774660907,13868117030,13883755460,17318213156,15076190189,13772328184,13552468259,18276659250,18696768175,13864215030,18618126620,13905768350,15850586308,13958606066,15291706896,13819618989,15640518131,15576668920,13916629841,13704282010,13485329788";
        String[] phones = phoneReady.split(",");
        QingSmsServiceImpl q = new QingSmsServiceImpl();
        for(String phone:phones){
            if(phoneSend.indexOf(phone)<0){
                q.sendsms(phone,4);
            }
        }
    }

    public static void main(String[] args) {
//        QingSmsServiceImpl q = new QingSmsServiceImpl();
//        q.sendRand("13810436365","1234");
//        q.sendsms("13810436365",1);
        lt1();
        lt2();
        lt3();
        lt4();
    }
}
