/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.service;

import java.util.List;

import com.design.graduation.model.Permission;
import com.design.graduation.model.XtreeData;
import com.design.graduation.util.JqGridJsonBean;
import com.design.graduation.util.ReturnData;

/**
 * <p>服务层接口</p>
 * <p>Table: permission - </p>
 *
 * @since ${.now}
 */
public interface PermissionService {

    /**
      * 执行 Permission 插入操作
      * @param permission
      * @return
      */
    ReturnData insert(Permission permission);

    /**
      * 执行 Permission 删除操作
      * @param permission
      * @return
      */
    ReturnData delete(Permission permission);

    /**
      * 执行 Permission 批量删除操作
      * @param permission
      * @return
      */
    ReturnData deleteBatch(String[] ids);

    /**
      * 执行 Permission 修改操作
      * @param permission
      * @return
      */
    ReturnData update(Permission permission);

    /**
      * 执行 Permission 分页查询操作
      * @param permission
      * @return
      */
    JqGridJsonBean select(String page, String rows, String order_by, Permission permission);

    /**
      * 执行 Permission 分页查询操作 - 关联查询
      * @param permission
      * @return
      */
    JqGridJsonBean selectRelationData(String page, String rows, String order_by, Permission permission);

    /**
      * 执行 Permission 查询不分页操作
      * @param permission
      * @param order_by
      * @return
      */
    ReturnData selectByParam(String order_by, Permission permission);

    ReturnData ajaxSelectPermListByUse();

    ReturnData selectByPermIds(String permIds);

    List<XtreeData> selXtreeData();

    List<XtreeData> selXtreeData(List<Integer> permValue);

}