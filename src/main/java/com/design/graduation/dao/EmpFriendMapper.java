/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.dao;

import com.design.graduation.model.EmpFriend;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * <p>数据层接口</p>
 * <p>Table: emp_friend - </p>
 *
 * @since ${.now}
 */
public interface EmpFriendMapper{
	
	/**
	 * emp_friend 执行插入 EmpFriend 操作
	 * @param empFriend
	 */
	void insert(EmpFriend empFriend);
	
	/**
	 * emp_friend 执行删除 数据操作
	 * @param empFriend
	 */
	void delete(EmpFriend empFriend);
	
	/**
	 * emp_friend 执行 批量删除 数据操作
	 * @param empFriend
	 */
    void deleteBatch(@Param("ids") String[] ids);

	/**
	 * emp_friend 执行修改 数据操作
	 * @param empFriend
	 */
	void update(EmpFriend empFriend);
	
	/**
	 * 根据条件查询EmpFriend总数据量
	 * @param empFriend
	 */
	int selectCount(EmpFriend empFriend);
	
	/**
	 * 根据条件查询EmpFriend数据
	 * @param empFriend
	 */
	List<EmpFriend> selectData(@Param("empFriend")EmpFriend empFriend,@Param("limit")int limit,@Param("offset")int offset,@Param("order_by")String order_by);
	
	/**
	 * 根据条件查询EmpFriend总数据量 - 关联查询
	 * @param empFriend
	 */
	int selectRelationCount(EmpFriend empFriend);
	
	/**
	 * 根据条件查询EmpFriend数据 - 关联查询
	 * @param empFriend
	 */
	List<Map<String, Object>> selectRelationData(@Param("empFriend")EmpFriend empFriend,@Param("limit")int limit,@Param("offset")int offset,@Param("order_by")String order_by);
	
	/**
	 * 根据条件查询EmpFriend数据不分页
	 * @param empFriend
	 */
	List<EmpFriend> selectByParam(@Param("empFriend")EmpFriend empFriend,@Param("order_by")String order_by);
}