/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

/**
 * <p>实体类</p>
 * <p>Table: employee - </p>
 *
 * @since ${.now}
 */
@Alias("Employee")
public class Employee implements Serializable {

    /**
     * @description: TODO - 
     * @author: 郭伟强   E-mail:gwq20521@163.com
     * @createTime: 2018年4月29日 下午8:04:43
     */
    private static final long serialVersionUID = -4700578691030494236L;

    /** 主键 */
    private Integer id;

    /** 员工编码 */
    private String empCode;

    /** 用户名 */
    private String loginname;

    /** 用户密码 */
    private String password;

    /** 真实姓名 */
    private String realname;

    /** 入职时间 */
    private Date entryTime;

    /** 所属职位 */
    private Integer jobposId;

    /** 注册时间 */
    private Timestamp registerTime;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpCode() {
        return this.empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getLoginname() {
        return this.loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return this.realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Date getEntryTime() {
        return this.entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Integer getJobposId() {
        return this.jobposId;
    }

    public void setJobposId(Integer jobposId) {
        this.jobposId = jobposId;
    }

    public Timestamp getRegisterTime() {
        return this.registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        String toString = "Employee [" + "id = " + id + "," + "emp_code = " + empCode + "," + "loginname = " + loginname
                + "," + "password = " + password + "," + "realname = " + realname + "," + "entry_time = " + entryTime
                + "," + "jobpos_id = " + jobposId + "," + "register_time = " + registerTime + "," + "]";
        return toString;
    }

}