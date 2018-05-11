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

import com.design.graduation.model.DeptPerm;

/**
 * <p>数据层接口</p>
 * <p>Table: dept_perm - </p>
 *
 * @since ${.now}
 */
public interface DeptPermMapper {

    /**
     * dept_perm 执行插入 DeptPerm 操作
     * @param deptPerm
     */
    void insert(DeptPerm deptPerm);

    /**
     * dept_perm 执行删除 数据操作
     * @param deptPerm
     */
    void delete(DeptPerm deptPerm);

    /**
     * dept_perm 执行 批量删除 数据操作
     * @param deptPerm
     */
    void deleteBatch(@Param("ids") String[] ids);

    void deleteBatchByDeptIds(@Param("deptIds") String[] deptIds);

    /**
     * dept_perm 执行修改 数据操作
     * @param deptPerm
     */
    void update(DeptPerm deptPerm);

    /**
     * 根据条件查询DeptPerm总数据量
     * @param deptPerm
     */
    int selectCount(DeptPerm deptPerm);

    /**
     * 根据条件查询DeptPerm数据
     * @param deptPerm
     */
    List<DeptPerm> selectData(@Param("deptPerm") DeptPerm deptPerm, @Param("limit") int limit,
            @Param("offset") int offset, @Param("order_by") String order_by);

    /**
     * 根据条件查询DeptPerm总数据量 - 关联查询
     * @param deptPerm
     */
    int selectRelationCount(DeptPerm deptPerm);

    /**
     * 根据条件查询DeptPerm数据 - 关联查询
     * @param deptPerm
     */
    List<Map<String, Object>> selectRelationData(@Param("deptPerm") DeptPerm deptPerm, @Param("limit") int limit,
            @Param("offset") int offset, @Param("order_by") String order_by);

    /**
     * 根据条件查询DeptPerm数据不分页
     * @param deptPerm
     */
    List<DeptPerm> selectByParam(@Param("deptPerm") DeptPerm deptPerm, @Param("order_by") String order_by);

}