/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.dao;

import com.design.graduation.model.AttdApproveList;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * <p>数据层接口</p>
 * <p>Table: attd_approve_list - </p>
 *
 * @since ${.now}
 */
public interface AttdApproveListMapper{
	
	/**
	 * attd_approve_list 执行插入 AttdApproveList 操作
	 * @param attdApproveList
	 */
	void insert(AttdApproveList attdApproveList);
	
	/**
	 * attd_approve_list 执行删除 数据操作
	 * @param attdApproveList
	 */
	void delete(AttdApproveList attdApproveList);
	
	/**
	 * attd_approve_list 执行 批量删除 数据操作
	 * @param attdApproveList
	 */
    void deleteBatch(@Param("ids") String[] ids);

	/**
	 * attd_approve_list 执行修改 数据操作
	 * @param attdApproveList
	 */
	void update(AttdApproveList attdApproveList);
	
	/**
	 * 根据条件查询AttdApproveList总数据量
	 * @param attdApproveList
	 */
	int selectCount(AttdApproveList attdApproveList);
	
	/**
	 * 根据条件查询AttdApproveList数据
	 * @param attdApproveList
	 */
	List<AttdApproveList> selectData(@Param("attdApproveList")AttdApproveList attdApproveList,@Param("limit")int limit,@Param("offset")int offset,@Param("order_by")String order_by);
	
	/**
	 * 根据条件查询AttdApproveList总数据量 - 关联查询
	 * @param attdApproveList
	 */
	int selectRelationCount(AttdApproveList attdApproveList);
	
	/**
	 * 根据条件查询AttdApproveList数据 - 关联查询
	 * @param attdApproveList
	 */
	List<Map<String, Object>> selectRelationData(@Param("attdApproveList")AttdApproveList attdApproveList,@Param("limit")int limit,@Param("offset")int offset,@Param("order_by")String order_by);
	
	/**
	 * 根据条件查询AttdApproveList数据不分页
	 * @param attdApproveList
	 */
	List<AttdApproveList> selectByParam(@Param("attdApproveList")AttdApproveList attdApproveList,@Param("order_by")String order_by);
}