/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.service;

import com.design.graduation.model.JobsManage;
import com.design.graduation.util.JqGridJsonBean;
import com.design.graduation.util.ReturnData;

/**
 * <p>服务层接口</p>
 * <p>Table: jobs_manage - </p>
 *
 * @since ${.now}
 */
public interface JobsManageService {

    /**
      * 执行 JobsManage 插入操作
      * @param jobsManage
      * @return
      */
    ReturnData insert(JobsManage jobsManage);

    /**
      * 执行 JobsManage 删除操作
      * @param jobsManage
      * @return
      */
    ReturnData delete(JobsManage jobsManage);

    /**
      * 执行 JobsManage 批量删除操作
      * @param jobsManage
      * @return
      */
    ReturnData deleteBatch(String[] ids);

    /**
      * 执行 JobsManage 修改操作
      * @param jobsManage
      * @return
      */
    ReturnData update(JobsManage jobsManage);

    /**
      * 执行 JobsManage 分页查询操作
      * @param jobsManage
      * @return
      */
    JqGridJsonBean select(String page, String rows, String order_by, JobsManage jobsManage);

    /**
      * 执行 JobsManage 分页查询操作 - 关联查询
      * @param jobsManage
      * @return
      */
    JqGridJsonBean selectRelationData(String page, String rows, String order_by, JobsManage jobsManage);

    /**
      * 执行 JobsManage 查询不分页操作
      * @param jobsManage
      * @param order_by
      * @return
      */
    ReturnData selectByParam(String order_by, JobsManage jobsManage);

    JqGridJsonBean selectRelationDataByEmpRealname(String page, String rows, String order_by, JobsManage jobsManage,
            String empRealname);

}