package com.rookie.bilibilibean.entity.entity;

import java.io.Serializable;

/**
 * 角色(TRoles)实体类
 *
 * @author makejava
 * @since 2020-10-05 14:26:13
 */
public class TRoles implements Serializable {
    private static final long serialVersionUID = 775399059322972783L;
    /**
    * 角色编号
    */
    private Integer roleNo;
    /**
    * 角色名称
    */
    private String roleName;


    public Integer getRoleNo() {
        return roleNo;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "TRoles{" +
                "roleNo=" + roleNo +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}