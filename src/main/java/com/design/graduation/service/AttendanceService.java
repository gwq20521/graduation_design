/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.service;

import com.design.graduation.model.Attendance;
import com.design.graduation.util.JqGridJsonBean;
import com.design.graduation.util.ReturnData;

/**
 * <p>服务层接口</p>
 * <p>Table: attendance - </p>
 *
 * @since ${.now}
 */
public interface AttendanceService {

    /**
      * 执行 Attendance 插入操作
      * @param attendance
      * @return
      */
    ReturnData insert(Attendance attendance);

    /**
      * 执行 Attendance 删除操作
      * @param attendance
      * @return
      */
    ReturnData delete(Attendance attendance);

    /**
      * 执行 Attendance 批量删除操作
      * @param attendance
      * @return
      */
    ReturnData deleteBatch(String[] ids);

    /**
      * 执行 Attendance 修改操作
      * @param attendance
      * @return
      */
    ReturnData update(Attendance attendance);

    /**
      * 执行 Attendance 分页查询操作
      * @param attendance
      * @return
      */
    JqGridJsonBean select(String page, String rows, String order_by, Attendance attendance);

    /**
      * 执行 Attendance 分页查询操作 - 关联查询
      * @param attendance
      * @return
      */
    JqGridJsonBean selectRelationData(String page, String rows, String order_by, Attendance attendance);

    /**
      * 执行 Attendance 查询不分页操作
      * @param attendance
      * @param order_by
      * @return
      */
    ReturnData selectByParam(String order_by, Attendance attendance);

    JqGridJsonBean selectRelationDataByEmpRealname(String page, String rows, String order_by, Attendance attendance,
            String empRealname, String createTimeStr);

    ReturnData selectByNowDateStr(Attendance attendance, String nowDateStr);

    ReturnData insertByTime(Attendance attendance);

    ReturnData selectEmpIdsByCreateTime(String createTime);
}