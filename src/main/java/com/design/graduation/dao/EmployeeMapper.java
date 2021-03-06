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

import com.design.graduation.model.Employee;

/**
 * <p>数据层接口</p>
 * <p>Table: employee - </p>
 *
 * @since ${.now}
 */
public interface EmployeeMapper {

    /**
     * employee 执行插入 Employee 操作
     * @param employee
     */
    void insert(Employee employee);

    /**
     * employee 执行删除 数据操作
     * @param employee
     */
    void delete(Employee employee);

    /**
     * employee 执行 批量删除 数据操作
     * @param employee
     */
    void deleteBatch(@Param("ids") String[] ids);

    /**
     * employee 执行修改 数据操作
     * @param employee
     */
    void update(Employee employee);

    /**
     * 根据条件查询Employee总数据量
     * @param employee
     */
    int selectCount(Employee employee);

    /**
     * @description: TODO - 主要区分拥有的模糊查询
     * @author: 郭伟强   E-mail:gwq20521@163.com
     * @createTime: 2018年3月24日 下午9:33:08
     * @param employee
     * @return
     */
    int selectRelationCount(Employee employee);

    /**
     * 根据条件查询Employee数据
     * @param employee
     */
    List<Employee> selectData(@Param("employee") Employee employee, @Param("limit") int limit,
            @Param("offset") int offset, @Param("order_by") String order_by);

    List<Map<String, Object>> selectRelationData(@Param("employee") Employee employee, @Param("limit") int limit,
            @Param("offset") int offset, @Param("order_by") String order_by);

    /**
     * 根据条件查询Employee数据不分页
     * @param employee
     */
    List<Employee> selectByParam(@Param("employee") Employee employee, @Param("order_by") String order_by);

    String ajaxSelectMaxEmpCode();

    List<Map<Integer, String>> ajaxSelectEmpByJobposId(@Param("jobposId") String jobposId);

    String selectRealnameById(@Param("id") Integer id);

    List<Integer> selectEmpIds();

    List<Employee> selectSubEmpListByJobId(@Param("jobposId") String jobposId);

}