/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * copyright: 2018
 */
package com.design.graduation.util;

import java.util.List;

/**
 * @className: com.design.graduation.util.JqGridJsonBean
 * @description: TODO - 
 * @author: 郭伟强   E-mail:gwq20521@163.com
 * @createTime: 2018年3月9日 上午10:41:00 
 * @version: v 1.0
 * @since 
 *
 */
public class JqGridJsonBean {
    private int page;

    private int total;

    private int records;

    private List<?> root;

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRecords() {
        return this.records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public List<?> getRoot() {
        return this.root;
    }

    public void setRoot(List<?> root) {
        this.root = root;
    }
}
