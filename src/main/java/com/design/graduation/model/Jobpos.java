/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.model;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

/**
 * <p>实体类</p>
 * <p>Table: jobpos - </p>
 *
 * @since ${.now}
 */
@Alias("Jobpos")
public class Jobpos {

    /** 主键 */
    private Integer id;
    /** 职位名称 */
    private String jobposName;
    /** 职位编码 */
    private String jobposCode;
    /** 职位层级 */
    private String jobposLevel;
    /** 所属部门 */
    private Integer deptId;
    /** 创建时间 */
    private Date createTime;


    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getJobposName(){
        return this.jobposName;
    }
    public void setJobposName(String jobposName){
        this.jobposName = jobposName;
    }

    public String getJobposCode(){
        return this.jobposCode;
    }
    public void setJobposCode(String jobposCode){
        this.jobposCode = jobposCode;
    }

    public String getJobposLevel(){
        return this.jobposLevel;
    }
    public void setJobposLevel(String jobposLevel){
        this.jobposLevel = jobposLevel;
    }

    public Integer getDeptId(){
        return this.deptId;
    }
    public void setDeptId(Integer deptId){
        this.deptId = deptId;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }
 	@Override
    public String toString() {
    String toString = "Jobpos ["+
    					"id = "+id+","+
						"jobpos_name = "+jobposName+","+
						"jobpos_code = "+jobposCode+","+
						"jobpos_level = "+jobposLevel+","+
						"dept_id = "+deptId+","+
						"create_time = "+createTime+","+
						"]";
        return toString;
	}

}