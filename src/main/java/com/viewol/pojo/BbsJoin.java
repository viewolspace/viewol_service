package com.viewol.pojo;

/**
 * Created by lenovo on 2019/10/9.
 */
public class BbsJoin {
    private int id;
    private String name;
    private String sex;
    private String company;
    private String address;
    private String position;
    private String phone;
    private String email;
    private String idea;
    private int bbsId;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public int getBbsId() {
        return bbsId;
    }

    public void setBbsId(int bbsId) {
        this.bbsId = bbsId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BbsJoin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", idea='" + idea + '\'' +
                ", bbsId=" + bbsId +
                ", status=" + status +
                '}';
    }
}
