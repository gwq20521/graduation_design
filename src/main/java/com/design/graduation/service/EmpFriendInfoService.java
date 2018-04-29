/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.service;
 
import com.design.graduation.model.EmpFriendInfo;
import com.design.graduation.util.ReturnData;
import com.design.graduation.util.JqGridJsonBean;
 
/**
 * <p>服务层接口</p>
 * <p>Table: emp_friend_info - </p>
 *
 * @since ${.now}
 */
public interface EmpFriendInfoService {
 
 	/**
	  * 执行 EmpFriendInfo 插入操作
	  * @param empFriendInfo
	  * @return
	  */
	ReturnData insert(EmpFriendInfo empFriendInfo);
	
	/**
	  * 执行 EmpFriendInfo 删除操作
	  * @param empFriendInfo
	  * @return
	  */
	ReturnData delete(EmpFriendInfo empFriendInfo);
	
	/**
	  * 执行 EmpFriendInfo 批量删除操作
	  * @param empFriendInfo
	  * @return
	  */
    ReturnData deleteBatch(String[] ids);
	
	/**
	  * 执行 EmpFriendInfo 修改操作
	  * @param empFriendInfo
	  * @return
	  */
	ReturnData update(EmpFriendInfo empFriendInfo);
	
	/**
	  * 执行 EmpFriendInfo 分页查询操作
	  * @param empFriendInfo
	  * @return
	  */
	JqGridJsonBean select(String page,String rows,String order_by, EmpFriendInfo empFriendInfo);
	
	/**
	  * 执行 EmpFriendInfo 分页查询操作 - 关联查询
	  * @param empFriendInfo
	  * @return
	  */
    JqGridJsonBean selectRelationData(String page, String rows, String order_by, EmpFriendInfo empFriendInfo);
	
	/**
	  * 执行 EmpFriendInfo 查询不分页操作
	  * @param empFriendInfo
	  * @param order_by
	  * @return
	  */
	ReturnData selectByParam(String order_by, EmpFriendInfo empFriendInfo);
}