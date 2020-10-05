package com.rookie.bilibilidao.dao;

import com.rookie.bilibilibean.entity.TConsumers;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户(TConsumers)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-04 22:46:58
 */
public interface TConsumersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param conNo 主键
     * @return 实例对象
     */
    @Select("select * from t_consumers where conNo = #{conNo}")
    TConsumers queryById(Integer conNo);

    /**
     * 通过name查询单条数据
     *
     * @param name
     * @return 实例对象
     */
    @Select("select * from t_consumers where name = #{name}")
    TConsumers queryByName(String name);

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
    int insert(TConsumers tConsumers);

    /**
     * 修改数据
     *
     * @param tConsumers 实例对象
     * @return 影响行数
     */
    int update(TConsumers tConsumers);

    /**
     * 通过主键删除数据
     *
     * @param conNo 主键
     * @return 影响行数
     */
    int deleteById(Integer conNo);

}