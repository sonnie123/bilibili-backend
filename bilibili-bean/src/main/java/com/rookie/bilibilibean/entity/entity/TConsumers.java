package com.rookie.bilibilibean.entity.entity;

import java.io.Serializable;

/**
 * 用户(TConsumers)实体类
 *
 * @author makejava
 * @since 2020-10-04 22:43:03
 */
public class TConsumers implements Serializable {
    private static final long serialVersionUID = 921609150706453040L;
//    /**
//    * 用户编号
//    */
//    private Integer conNo;
//    /**
//    * 角色编号
//    */
//    private Integer roleNo;
    /**
    * 用户名
    */
    private String name;
    /**
    * 密码
    */
    private String password;
//    /**
//    * 硬币
//    */
//    private Integer coins;
//    /**
//    * 联系电话
//    */
//    private String teleNum;

    public TConsumers(String name, String password) {
        this.name = name;
        this.password = password;
//        this.teleNum = teleNum;
    }

    @Override
    public String toString() {
        return "TConsumers{" +
                ", name='" + name + '\'' +
                ", password='" + password + '\''+
                '}';
    }

    public TConsumers() {
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

}