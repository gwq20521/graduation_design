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

import com.design.graduation.model.Contract;

/**
 * <p>数据层接口</p>
 * <p>Table: contract - </p>
 *
 * @since ${.now}
 */
public interface ContractMapper {

    /**
     * contract 执行插入 Contract 操作
     * @param contract
     */
    void insert(Contract contract);

    /**
     * contract 执行删除 数据操作
     * @param contract
     */
    void delete(Contract contract);

    /**
     * contract 执行 批量删除 数据操作
     * @param contract
     */
    void deleteBatch(@Param("ids") String[] ids);

    /**
     * contract 执行修改 数据操作
     * @param contract
     */
    void update(Contract contract);

    /**
     * 根据条件查询Contract总数据量
     * @param contract
     */
    int selectCount(Contract contract);

    /**
     * 根据条件查询Contract数据
     * @param contract
     */
    List<Contract> selectData(@Param("contract") Contract contract, @Param("limit") int limit,
            @Param("offset") int offset, @Param("order_by") String order_by);

    /**
     * 根据条件查询Contract总数据量 - 关联查询
     * @param contract
     */
    int selectRelationCount(Contract contract);

    /**
     * 根据条件查询Contract数据 - 关联查询
     * @param contract
     */
    List<Map<String, Object>> selectRelationData(@Param("contract") Contract contract, @Param("limit") int limit,
            @Param("offset") int offset, @Param("order_by") String order_by);

    int selectRelationCountByEmpRealname(@Param("contract") Contract contract,
            @Param("empRealname") String empRealname);

    List<Map<String, Object>> selectRelationDataByEmpRealname(@Param("contract") Contract contract,
            @Param("limit") int limit, @Param("offset") int offset, @Param("order_by") String order_by,
            @Param("empRealname") String empRealname);

    /**
     * 根据条件查询Contract数据不分页
     * @param contract
     */
    List<Contract> selectByParam(@Param("contract") Contract contract, @Param("order_by") String order_by);

}