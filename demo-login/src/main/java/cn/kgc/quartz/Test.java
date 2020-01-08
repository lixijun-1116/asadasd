/*
package cn.kgc.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception{
        JobDetail jobDetail = new JobDetail("a",MyJob.class);
        CronTrigger trigger = new CronTrigger("t1","a","0/3 33 11 * * ?");
        //SimpleTrigger trigger = new SimpleTrigger("t1",SimpleTrigger.REPEAT_INDEFINITELY,3000);
        //2秒后开始
        //trigger.setStartTime(new Date(System.currentTimeMillis()+2000));
        //20秒后结束
        //trigger.setEndTime(new Date(System.currentTimeMillis()+20000));
        SchedulerFactory factory = new StdSchedulerFactory();

        Scheduler s1 = factory.getScheduler();

        s1.scheduleJob(jobDetail,trigger);
        s1.start();
    }
}
*/
