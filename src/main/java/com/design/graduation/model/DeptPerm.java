/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.model;


import org.apache.ibatis.type.Alias;

/**
 * <p>实体类</p>
 * <p>Table: dept_perm - </p>
 *
 * @since ${.now}
 */
@Alias("DeptPerm")
public class DeptPerm {

    /** 主键 */
    private Integer id;
    /** 部门ID */
    private Integer deptId;
    /** 权限ID */
    private Integer permId;


    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public Integer getDeptId(){
        return this.deptId;
    }
    public void setDeptId(Integer deptId){
        this.deptId = deptId;
    }

    public Integer getPermId(){
        return this.permId;
    }
    public void setPermId(Integer permId){
        this.permId = permId;
    }
 	@Override
    public String toString() {
    String toString = "DeptPerm ["+
    					"id = "+id+","+
						"dept_id = "+deptId+","+
						"perm_id = "+permId+","+
						"]";
        return toString;
	}

}