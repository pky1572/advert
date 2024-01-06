package com.example.xuerun.advert.util.timing;

import com.example.xuerun.advert.controller.AutomaticController;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class FirstJob implements Job {

    @Autowired
    AutomaticController automaticController;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        AutomaticController automaticController = (AutomaticController) ApplicationContextUtil.getBean("controller");
        System.out.println("截图动作");
        if(automaticController.screenshotol()){
            System.out.println("截图完成");
        }
    }
}
