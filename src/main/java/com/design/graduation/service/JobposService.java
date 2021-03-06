/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.service;

import com.design.graduation.model.Jobpos;
import com.design.graduation.util.JqGridJsonBean;
import com.design.graduation.util.ReturnData;

/**
 * <p>服务层接口</p>
 * <p>Table: jobpos - </p>
 *
 * @since ${.now}
 */
public interface JobposService {

    /**
      * 执行 Jobpos 插入操作
      * @param jobpos
      * @return
      */
    ReturnData insert(Jobpos jobpos);

    /**
      * 执行 Jobpos 删除操作
      * @param jobpos
      * @return
      */
    ReturnData delete(Jobpos jobpos);

    /**
      * 执行 Jobpos 批量删除操作
      * @param jobpos
      * @return
      */
    ReturnData deleteBatch(String[] ids);

    /**
      * 执行 Jobpos 修改操作
      * @param jobpos
      * @return
      */
    ReturnData update(Jobpos jobpos);

    /**
      * 执行 Jobpos 分页查询操作
      * @param jobpos
      * @return
      */
    JqGridJsonBean select(String page, String rows, String order_by, Jobpos jobpos);

    /**
      * 执行 Jobpos 查询不分页操作
      * @param jobpos
      * @param order_by
      * @return
      */
    ReturnData selectByParam(String order_by, Jobpos jobpos);

    ReturnData ajaxSelectJobposByDeptId(String deptId);

    JqGridJsonBean selectRelationData(String page, String rows, String order_by, Jobpos jobpos);

    ReturnData selectIdListBySubId(String subId);

    int selectDeptIdById(Integer jobposId);

    String selectCodeById(int jobposId);

}