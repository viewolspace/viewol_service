package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/19.
 */
public class WxToken {
    private String appId;
    /**
     * 基础token
     */
    private String token;
    private Date tokenTime;

    private String jsapiTicket;
    private Date ticketTime;
    private Date cTime;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(Date tokenTime) {
        this.tokenTime = tokenTime;
    }

    public String getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket;
    }

    public Date getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(Date ticketTime) {
        this.ticketTime = ticketTime;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    @Override
    public String toString() {
        return "WxToken{" + "appId='" + appId + '\'' + ", token='" + token + '\'' + ", tokenTime=" + tokenTime + ", jsapiTicket='" + jsapiTicket + '\'' + ", ticketTime=" + ticketTime + ", cTime=" + cTime + '}';
    }
}
