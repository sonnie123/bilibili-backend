package com.rookie.bilibilidao.dao;

import com.rookie.bilibilibean.entity.entity.TConsumers;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户(TConsumers)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-04 22:46:58
 */
@Repository
@Mapper
public interface TConsumersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param conNo 主键
     * @return 实例对象
     */
    @Select("select * from t_consumers where conNo = #{conNo}")
    TConsumers queryById(@Param("conNo") Integer conNo);

    /**
     * 通过name查询单条数据
     *
     * @param name 名字
     * @return 实例对象
     */
    @Select("select * from t_consumers where name = #{name}")
    TConsumers queryByName(@Param("name") String name);

    /**
     * 通过name、password查询单条数据
     *
     * @param name password
     * @return 实例对象
     */
    @Select("select * from t_consumers where name = #{name} and password = #{password}")
    TConsumers queryByNameAndPwd(@Param("name") String name,@Param("password") String password);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tConsumers 实例对象
     * @return 对象列表
     */
    List<TConsumers> queryAll(TConsumers tConsumers);

    /**
     * 新增数据
     *
     * @param tConsumers 实例对象
     * @return 影响行数
     */
    @Insert("insert into t_consumers (name,password) values(#{name},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "con_no")
    int insert(TConsumers tConsumers);

    /**
     * 修改数据
     *
     * @param tConsumers 实例对象
     * @return 影响行数
     */
    int update(TConsumers tConsumers);


    /**
     * 获取用户的角色role
     *
     */
    @Select("select role_name from t_roles where role_no in (select role_no from t_consumers where name = #{name})")
    String getRole(@Param("name") String name);

}