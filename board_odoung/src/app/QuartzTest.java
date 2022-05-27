package app;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import task.TimeTask;

public class QuartzTest {
	public static void main(String[] args) {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler;
		try {
			scheduler = schedulerFactory.getScheduler();
			JobDetail job = JobBuilder.newJob(TimeTask.class)
					.withIdentity("time", Scheduler.DEFAULT_GROUP)
					.build();
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("timetrigger", Scheduler.DEFAULT_GROUP)
					.withSchedule(CronScheduleBuilder.cronSchedule("20 29 * * * ?"))
					.build();
			scheduler.scheduleJob(job, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
