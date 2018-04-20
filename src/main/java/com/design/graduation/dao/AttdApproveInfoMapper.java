/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.dao;

import com.design.graduation.model.AttdApproveInfo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * <p>数据层接口</p>
 * <p>Table: attd_approve_info - </p>
 *
 * @since ${.now}
 */
public interface AttdApproveInfoMapper{
	
	/**
	 * attd_approve_info 执行插入 AttdApproveInfo 操作
	 * @param attdApproveInfo
	 */
	void insert(AttdApproveInfo attdApproveInfo);
	
	/**
	 * attd_approve_info 执行删除 数据操作
	 * @param attdApproveInfo
	 */
	void delete(AttdApproveInfo attdApproveInfo);
	
	/**
	 * attd_approve_info 执行 批量删除 数据操作
	 * @param attdApproveInfo
	 */
    void deleteBatch(@Param("ids") String[] ids);

	/**
	 * attd_approve_info 执行修改 数据操作
	 * @param attdApproveInfo
	 */
	void update(AttdApproveInfo attdApproveInfo);
	
	/**
	 * 根据条件查询AttdApproveInfo总数据量
	 * @param attdApproveInfo
	 */
	int selectCount(AttdApproveInfo attdApproveInfo);
	
	/**
	 * 根据条件查询AttdApproveInfo数据
	 * @param attdApproveInfo
	 */
	List<AttdApproveInfo> selectData(@Param("attdApproveInfo")AttdApproveInfo attdApproveInfo,@Param("limit")int limit,@Param("offset")int offset,@Param("order_by")String order_by);
	
	/**
	 * 根据条件查询AttdApproveInfo总数据量 - 关联查询
	 * @param attdApproveInfo
	 */
	int selectRelationCount(AttdApproveInfo attdApproveInfo);
	
	/**
	 * 根据条件查询AttdApproveInfo数据 - 关联查询
	 * @param attdApproveInfo
	 */
	List<Map<String, Object>> selectRelationData(@Param("attdApproveInfo")AttdApproveInfo attdApproveInfo,@Param("limit")int limit,@Param("offset")int offset,@Param("order_by")String order_by);
	
	/**
	 * 根据条件查询AttdApproveInfo数据不分页
	 * @param attdApproveInfo
	 */
	List<AttdApproveInfo> selectByParam(@Param("attdApproveInfo")AttdApproveInfo attdApproveInfo,@Param("order_by")String order_by);
}