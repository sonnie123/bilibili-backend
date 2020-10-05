package com.rookie.bilibilibean.entity;

import java.io.Serializable;

/**
 * 用户(TConsumers)实体类
 *
 * @author makejava
 * @since 2020-10-04 22:43:03
 */
public class TConsumers implements Serializable {
    private static final long serialVersionUID = 921609150706453040L;
    /**
    * 用户编号
    */
    private Integer conNo;
    /**
    * 角色编号
    */
    private Integer roleNo;
    /**
    * 用户名
    */
    private String name;
    /**
    * 密码
    */
    private String password;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 硬币
    */
    private Integer coins;
    /**
    * 联系电话
    */
    private String teleNum;

    public TConsumers(String name, String password, Integer age, String teleNum) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.teleNum = teleNum;
    }

    @Override
    public String toString() {
        return "TConsumers{" +
                "conNo=" + conNo +
                ", roleNo=" + roleNo +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", coins=" + coins +
                ", teleNum='" + teleNum + '\'' +
                '}';
    }

    public TConsumers() {
    }

    public Integer getConNo() {
        return conNo;
    }

    public void setConNo(Integer conNo) {
        this.conNo = conNo;
    }

    public Integer getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(Integer roleNo) {
        this.roleNo = roleNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public String getTeleNum() {
        return teleNum;
    }

    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum;
    }

}