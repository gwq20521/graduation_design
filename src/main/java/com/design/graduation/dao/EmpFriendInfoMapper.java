/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.dao;

import com.design.graduation.model.EmpFriendInfo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * <p>数据层接口</p>
 * <p>Table: emp_friend_info - </p>
 *
 * @since ${.now}
 */
public interface EmpFriendInfoMapper{
	
	/**
	 * emp_friend_info 执行插入 EmpFriendInfo 操作
	 * @param empFriendInfo
	 */
	void insert(EmpFriendInfo empFriendInfo);
	
	/**
	 * emp_friend_info 执行删除 数据操作
	 * @param empFriendInfo
	 */
	void delete(EmpFriendInfo empFriendInfo);
	
	/**
	 * emp_friend_info 执行 批量删除 数据操作
	 * @param empFriendInfo
	 */
    void deleteBatch(@Param("ids") String[] ids);

	/**
	 * emp_friend_info 执行修改 数据操作
	 * @param empFriendInfo
	 */
	void update(EmpFriendInfo empFriendInfo);
	
	/**
	 * 根据条件查询EmpFriendInfo总数据量
	 * @param empFriendInfo
	 */
	int selectCount(EmpFriendInfo empFriendInfo);
	
	/**
	 * 根据条件查询EmpFriendInfo数据
	 * @param empFriendInfo
	 */
	List<EmpFriendInfo> selectData(@Param("empFriendInfo")EmpFriendInfo empFriendInfo,@Param("limit")int limit,@Param("offset")int offset,@Param("order_by")String order_by);
	
	/**
	 * 根据条件查询EmpFriendInfo总数据量 - 关联查询
	 * @param empFriendInfo
	 */
	int selectRelationCount(EmpFriendInfo empFriendInfo);
	
	/**
	 * 根据条件查询EmpFriendInfo数据 - 关联查询
	 * @param empFriendInfo
	 */
	List<Map<String, Object>> selectRelationData(@Param("empFriendInfo")EmpFriendInfo empFriendInfo,@Param("limit")int limit,@Param("offset")int offset,@Param("order_by")String order_by);
	
	/**
	 * 根据条件查询EmpFriendInfo数据不分页
	 * @param empFriendInfo
	 */
	List<EmpFriendInfo> selectByParam(@Param("empFriendInfo")EmpFriendInfo empFriendInfo,@Param("order_by")String order_by);
}