/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.design.graduation.model.Jobpos;

/**
 * <p>数据层接口</p>
 * <p>Table: jobpos - </p>
 *
 * @since ${.now}
 */
public interface JobposMapper {

    /**
     * jobpos 执行插入 Jobpos 操作
     * @param jobpos
     */
    void insert(Jobpos jobpos);

    /**
     * jobpos 执行删除 数据操作
     * @param jobpos
     */
    void delete(Jobpos jobpos);

    /**
     * jobpos 执行 批量删除 数据操作
     * @param jobpos
     */
    void deleteBatch(@Param("ids") String[] ids);

    /**
     * jobpos 执行修改 数据操作
     * @param jobpos
     */
    void update(Jobpos jobpos);

    /**
     * 根据条件查询Jobpos总数据量
     * @param jobpos
     */
    int selectCount(Jobpos jobpos);

    int selectRelationCount(Jobpos jobpos);

    /**
     * 根据条件查询Jobpos数据
     * @param jobpos
     */
    List<Jobpos> selectData(@Param("jobpos") Jobpos jobpos, @Param("limit") int limit, @Param("offset") int offset,
            @Param("order_by") String order_by);

    List<Map<String, Object>> selectRelationData(@Param("jobpos") Jobpos jobpos, @Param("limit") int limit,
            @Param("offset") int offset, @Param("order_by") String order_by);

    /**
     * 根据条件查询Jobpos数据不分页
     * @param jobpos
     */
    List<Jobpos> selectByParam(@Param("jobpos") Jobpos jobpos, @Param("order_by") String order_by);

    List<Map<Integer, String>> ajaxSelectJobposByDeptId(@Param("deptId") String deptId);

    List<Integer> selectIdListBySubId(@Param("subId") String subId);

    int selectDeptIdById(@Param("jobposId") Integer jobposId);

    String selectCodeById(@Param("jobposId") Integer jobposId);

}