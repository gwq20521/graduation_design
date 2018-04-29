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

import com.design.graduation.model.JobsManage;

/**
 * <p>数据层接口</p>
 * <p>Table: jobs_manage - </p>
 *
 * @since ${.now}
 */
public interface JobsManageMapper {

    /**
     * jobs_manage 执行插入 JobsManage 操作
     * @param jobsManage
     */
    void insert(JobsManage jobsManage);

    /**
     * jobs_manage 执行删除 数据操作
     * @param jobsManage
     */
    void delete(JobsManage jobsManage);

    /**
     * jobs_manage 执行 批量删除 数据操作
     * @param jobsManage
     */
    void deleteBatch(@Param("ids") String[] ids);

    /**
     * jobs_manage 执行修改 数据操作
     * @param jobsManage
     */
    void update(JobsManage jobsManage);

    /**
     * 根据条件查询JobsManage总数据量
     * @param jobsManage
     */
    int selectCount(JobsManage jobsManage);

    /**
     * 根据条件查询JobsManage数据
     * @param jobsManage
     */
    List<JobsManage> selectData(@Param("jobsManage") JobsManage jobsManage, @Param("limit") int limit,
            @Param("offset") int offset, @Param("order_by") String order_by);

    /**
     * 根据条件查询JobsManage总数据量 - 关联查询
     * @param jobsManage
     */
    int selectRelationCount(JobsManage jobsManage);

    /**
     * 根据条件查询JobsManage数据 - 关联查询
     * @param jobsManage
     */
    List<Map<String, Object>> selectRelationData(@Param("jobsManage") JobsManage jobsManage, @Param("limit") int limit,
            @Param("offset") int offset, @Param("order_by") String order_by);

    /**
     * 根据条件查询JobsManage数据不分页
     * @param jobsManage
     */
    List<JobsManage> selectByParam(@Param("jobsManage") JobsManage jobsManage, @Param("order_by") String order_by);

    int selectRelationCountByEmpRealname(@Param("jobsManage") JobsManage jobsManage,
            @Param("empRealname") String empRealname);

    List<Map<String, Object>> selectRelationDataByEmpRealname(@Param("jobsManage") JobsManage jobsManage,
            @Param("limit") int limit, @Param("offset") int offset, @Param("order_by") String order_by,
            @Param("empRealname") String empRealname);
}