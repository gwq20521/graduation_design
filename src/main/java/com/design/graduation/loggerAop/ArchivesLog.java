/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * copyright: 2018
 */
package com.design.graduation.loggerAop;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: com.design.graduation.loggerAop.ArchivesLog
 * @description: TODO - 
 * @author: 郭伟强   E-mail:gwq20521@163.com
 * @createTime: 2018年3月9日 下午12:11:04 
 * @version: v 1.0
 * @since 
 *
 */
@Target({ java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ArchivesLog {
    public abstract String operationType();

    public abstract String operationName();
}
