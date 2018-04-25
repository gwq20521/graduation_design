/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.service;

import com.design.graduation.model.AttdApproveInfo;
import com.design.graduation.util.JqGridJsonBean;
import com.design.graduation.util.ReturnData;

/**
 * <p>服务层接口</p>
 * <p>Table: attd_approve_info - </p>
 *
 * @since ${.now}
 */
public interface AttdApproveInfoService {

    /**
      * 执行 AttdApproveInfo 插入操作
      * @param attdApproveInfo
      * @return
      */
    ReturnData insert(AttdApproveInfo attdApproveInfo);

    /**
      * 执行 AttdApproveInfo 删除操作
      * @param attdApproveInfo
      * @return
      */
    ReturnData delete(AttdApproveInfo attdApproveInfo);

    /**
      * 执行 AttdApproveInfo 批量删除操作
      * @param attdApproveInfo
      * @return
      */
    ReturnData deleteBatch(String[] ids);

    /**
      * 执行 AttdApproveInfo 修改操作
      * @param attdApproveInfo
      * @return
      */
    ReturnData update(AttdApproveInfo attdApproveInfo);

    /**
      * 执行 AttdApproveInfo 分页查询操作
      * @param attdApproveInfo
      * @return
      */
    JqGridJsonBean select(String page, String rows, String order_by, AttdApproveInfo attdApproveInfo);

    /**
      * 执行 AttdApproveInfo 分页查询操作 - 关联查询
      * @param attdApproveInfo
      * @return
      */
    JqGridJsonBean selectRelationData(String page, String rows, String order_by, AttdApproveInfo attdApproveInfo);

    /**
      * 执行 AttdApproveInfo 查询不分页操作
      * @param attdApproveInfo
      * @param order_by
      * @return
      */
    ReturnData selectByParam(String order_by, AttdApproveInfo attdApproveInfo);

    JqGridJsonBean selectRelationDataByEmpRealname(String page, String rows, String order_by,
            AttdApproveInfo attdApproveInfo, String empRealname);
}