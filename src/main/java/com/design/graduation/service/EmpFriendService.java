/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.service;
 
import com.design.graduation.model.EmpFriend;
import com.design.graduation.util.ReturnData;
import com.design.graduation.util.JqGridJsonBean;
 
/**
 * <p>服务层接口</p>
 * <p>Table: emp_friend - </p>
 *
 * @since ${.now}
 */
public interface EmpFriendService {
 
 	/**
	  * 执行 EmpFriend 插入操作
	  * @param empFriend
	  * @return
	  */
	ReturnData insert(EmpFriend empFriend);
	
	/**
	  * 执行 EmpFriend 删除操作
	  * @param empFriend
	  * @return
	  */
	ReturnData delete(EmpFriend empFriend);
	
	/**
	  * 执行 EmpFriend 批量删除操作
	  * @param empFriend
	  * @return
	  */
    ReturnData deleteBatch(String[] ids);
	
	/**
	  * 执行 EmpFriend 修改操作
	  * @param empFriend
	  * @return
	  */
	ReturnData update(EmpFriend empFriend);
	
	/**
	  * 执行 EmpFriend 分页查询操作
	  * @param empFriend
	  * @return
	  */
	JqGridJsonBean select(String page,String rows,String order_by, EmpFriend empFriend);
	
	/**
	  * 执行 EmpFriend 分页查询操作 - 关联查询
	  * @param empFriend
	  * @return
	  */
    JqGridJsonBean selectRelationData(String page, String rows, String order_by, EmpFriend empFriend);
	
	/**
	  * 执行 EmpFriend 查询不分页操作
	  * @param empFriend
	  * @param order_by
	  * @return
	  */
	ReturnData selectByParam(String order_by, EmpFriend empFriend);
}