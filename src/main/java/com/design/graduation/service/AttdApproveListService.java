/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.service;
 
import com.design.graduation.model.AttdApproveList;
import com.design.graduation.util.ReturnData;
import com.design.graduation.util.JqGridJsonBean;
 
/**
 * <p>服务层接口</p>
 * <p>Table: attd_approve_list - </p>
 *
 * @since ${.now}
 */
public interface AttdApproveListService {
 
 	/**
	  * 执行 AttdApproveList 插入操作
	  * @param attdApproveList
	  * @return
	  */
	ReturnData insert(AttdApproveList attdApproveList);
	
	/**
	  * 执行 AttdApproveList 删除操作
	  * @param attdApproveList
	  * @return
	  */
	ReturnData delete(AttdApproveList attdApproveList);
	
	/**
	  * 执行 AttdApproveList 批量删除操作
	  * @param attdApproveList
	  * @return
	  */
    ReturnData deleteBatch(String[] ids);
	
	/**
	  * 执行 AttdApproveList 修改操作
	  * @param attdApproveList
	  * @return
	  */
	ReturnData update(AttdApproveList attdApproveList);
	
	/**
	  * 执行 AttdApproveList 分页查询操作
	  * @param attdApproveList
	  * @return
	  */
	JqGridJsonBean select(String page,String rows,String order_by, AttdApproveList attdApproveList);
	
	/**
	  * 执行 AttdApproveList 分页查询操作 - 关联查询
	  * @param attdApproveList
	  * @return
	  */
    JqGridJsonBean selectRelationData(String page, String rows, String order_by, AttdApproveList attdApproveList);
	
	/**
	  * 执行 AttdApproveList 查询不分页操作
	  * @param attdApproveList
	  * @param order_by
	  * @return
	  */
	ReturnData selectByParam(String order_by, AttdApproveList attdApproveList);
}