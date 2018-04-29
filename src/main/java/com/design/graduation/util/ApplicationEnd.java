/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * copyright: 2018
 */
package com.design.graduation.util;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @className: com.design.graduation.util.ApplicationEnd
 * @description: TODO - 
 * @author: 郭伟强   E-mail:gwq20521@163.com
 * @createTime: 2018年4月17日 下午2:49:04 
 * @version: v 1.0
 * @since 
 *
 */
public class ApplicationEnd implements ApplicationListener<ContextClosedEvent> {
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        Scheduler scheduler = SchedulerUtil.getScheduler();

        try {
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        }
        catch (SchedulerException e) {
            e.printStackTrace();
        }

        System.out.println("QUARTZ定时器关闭成功");
    }
}
