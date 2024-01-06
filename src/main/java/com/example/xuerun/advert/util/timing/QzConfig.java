package com.example.xuerun.advert.util.timing;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QzConfig {

    @Bean
    public Scheduler scheduler() throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail first = JobBuilder.newJob(FirstJob.class)
                .withIdentity("job1","group1").build();

        JobDetail second = JobBuilder.newJob(SecondJob.class)
                .withIdentity("job2","group2").build();

        JobDetail third = JobBuilder.newJob(ThirdJob.class)
                .withIdentity("job3","group3").build();

        TriggerBuilder<Trigger> newTrigger =  trigger();

        newTrigger.withIdentity("trigger1","gtoup1");
        newTrigger.withSchedule(CronScheduleBuilder
                .cronSchedule("01 00 10 * * ? *"));//每天的早上10点截图
        Trigger one =  newTrigger.build();
        /*newTrigger.withSchedule(CronScheduleBuilder
                .cronSchedule("01 00 13 * * ? *"));//每天的下午13点截图
        Trigger one1 =  newTrigger.build();
        newTrigger.withSchedule(CronScheduleBuilder
                .cronSchedule("01 00 18 * * ? *"));//每天的晚上18点截图
        Trigger one2 =  newTrigger.build();*/

        newTrigger.withIdentity("trigger2","group2");
        newTrigger.withSchedule(CronScheduleBuilder
                .cronSchedule("01 00 09 * * ? *"));//每周日的早上9点总结excle
        Trigger two =  newTrigger.build();

        newTrigger.withIdentity("trigger3","group3");
        newTrigger.withSchedule(CronScheduleBuilder
                .cronSchedule("01 00 12 * * ? *"));//每天的18点整理信息
        Trigger three =  newTrigger.build();


        scheduler.scheduleJob(first,one);
        /*scheduler.scheduleJob(first,one1);
        scheduler.scheduleJob(first,one2);*/
        scheduler.scheduleJob(second,two);
        scheduler.scheduleJob(third,three);
        scheduler.start();
        return  scheduler;
    }

    @Bean
    public TriggerBuilder<Trigger> trigger() {
        return TriggerBuilder.newTrigger();
    }

}
