/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * copyright: 2018
 */
package com.design.graduation.util;

import java.util.Map;

/**
 * @className: com.design.graduation.util.ReturnData
 * @description: TODO - 
 * @author: 郭伟强   E-mail:gwq20521@163.com
 * @createTime: 2018年3月31日 上午11:50:12 
 * @version: v 1.0
 * @since 
 *
 */
public class ReturnData {
    private String code;

    private String msg;

    private Map<String, Object> data;

    public ReturnData() {
    }

    public ReturnData(String code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}