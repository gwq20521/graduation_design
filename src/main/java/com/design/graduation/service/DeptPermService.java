/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.service;
 
import com.design.graduation.model.DeptPerm;
import com.design.graduation.util.ReturnData;
import com.design.graduation.util.JqGridJsonBean;
 
/**
 * <p>服务层接口</p>
 * <p>Table: dept_perm - </p>
 *
 * @since ${.now}
 */
public interface DeptPermService {
 
 	/**
	  * 执行 DeptPerm 插入操作
	  * @param deptPerm
	  * @return
	  */
	ReturnData insert(DeptPerm deptPerm);
	
	/**
	  * 执行 DeptPerm 删除操作
	  * @param deptPerm
	  * @return
	  */
	ReturnData delete(DeptPerm deptPerm);
	
	/**
	  * 执行 DeptPerm 批量删除操作
	  * @param deptPerm
	  * @return
	  */
    ReturnData deleteBatch(String[] ids);
	
	/**
	  * 执行 DeptPerm 修改操作
	  * @param deptPerm
	  * @return
	  */
	ReturnData update(DeptPerm deptPerm);
	
	/**
	  * 执行 DeptPerm 分页查询操作
	  * @param deptPerm
	  * @return
	  */
	JqGridJsonBean select(String page,String rows,String order_by, DeptPerm deptPerm);
	
	/**
	  * 执行 DeptPerm 分页查询操作 - 关联查询
	  * @param deptPerm
	  * @return
	  */
    JqGridJsonBean selectRelationData(String page, String rows, String order_by, DeptPerm deptPerm);
	
	/**
	  * 执行 DeptPerm 查询不分页操作
	  * @param deptPerm
	  * @param order_by
	  * @return
	  */
	ReturnData selectByParam(String order_by, DeptPerm deptPerm);
}