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

import com.design.graduation.model.Permission;

/**
 * <p>数据层接口</p>
 * <p>Table: permission - </p>
 *
 * @since ${.now}
 */
public interface PermissionMapper {

    /**
     * permission 执行插入 Permission 操作
     * @param permission
     */
    void insert(Permission permission);

    /**
     * permission 执行删除 数据操作
     * @param permission
     */
    void delete(Permission permission);

    /**
     * permission 执行 批量删除 数据操作
     * @param permission
     */
    void deleteBatch(@Param("ids") String[] ids);

    /**
     * permission 执行修改 数据操作
     * @param permission
     */
    void update(Permission permission);

    /**
     * 根据条件查询Permission总数据量
     * @param permission
     */
    int selectCount(Permission permission);

    /**
     * 根据条件查询Permission数据
     * @param permission
     */
    List<Permission> selectData(@Param("permission") Permission permission, @Param("limit") int limit,
            @Param("offset") int offset, @Param("order_by") String order_by);

    /**
     * 根据条件查询Permission总数据量 - 关联查询
     * @param permission
     */
    int selectRelationCount(Permission permission);

    /**
     * 根据条件查询Permission数据 - 关联查询
     * @param permission
     */
    List<Map<String, Object>> selectRelationData(@Param("permission") Permission permission, @Param("limit") int limit,
            @Param("offset") int offset, @Param("order_by") String order_by);

    /**
     * 根据条件查询Permission数据不分页
     * @param permission
     */
    List<Permission> selectByParam(@Param("permission") Permission permission, @Param("order_by") String order_by);

    List<Permission> ajaxSelectPermListByUse();

    List<Permission> selectByPermIds(@Param("permIds") String permIds);

}