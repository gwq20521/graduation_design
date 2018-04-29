package com.design.graduation.util;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @className: com.design.graduation.util.ApplicationInit
 * @description: TODO - 
 * @author: 郭伟强   E-mail:gwq20521@163.com
 * @createTime: 2018年3月31日 上午11:49:55 
 * @version: v 1.0
 * @since 
 *
 */
public class ApplicationInit implements ApplicationListener<ContextRefreshedEvent> {
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        try {
            SchedulerUtil.executeAttendanceDailyQuartz();
            System.out.println("考勤日常定时任务初始化成功");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //初始化预定义的请假审批任务

        //

    }
}