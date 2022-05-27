package task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

@WebServlet(value = "/SchedulerInit", loadOnStartup = 1, name = "ScheduleInit")
//initParams = 
//	{
//			@WebInitParam(name = "load-on-startup", value = "true"),
//			@WebInitParam(name = "start-scheduler-on-load", value = "true"),
//			@WebInitParam(name = "shutdown-on-unload", value = "true")
//	})
public class ScheduleInit extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler;
		try {
			scheduler = schedulerFactory.getScheduler();
			JobDetail job = JobBuilder.newJob(TimeTask.class)
					.withIdentity("time", Scheduler.DEFAULT_GROUP)
					.build();
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("timetrigger", Scheduler.DEFAULT_GROUP)
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
					.build();
			scheduler.scheduleJob(job, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
