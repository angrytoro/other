package com.pjxy.common.module;

import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.inject.Injector;

/**
 * 处理定时事件， 当服务器启动的时候，就创建一个处理定时事件的线程，
 * 
 * @author adullboy
 * 
 */

public class EventHandlerListener implements ServletContextListener{

	@Inject
	private static Injector injector;
	@com.google.inject.Inject(optional = false)
	private Set<TimerTask> tasks;
	
	private Timer timer;

	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();
		event.getServletContext().log("定时器销毁！");
	}

	public void contextInitialized(ServletContextEvent event) {
		injector.injectMembers(this);
		timer = new Timer(true); // 指定其相关的线程作为守护程序运行
		event.getServletContext().log("定时器已启动！");
		// 第二个参数表示任务无延迟，第二个参数表示每隔多少秒执行一次，目前设置2min
		if (tasks != null)
			for (TimerTask task : tasks)
				timer.schedule(task, 0, 2 * 60 * 1000); // 将某个线程的定时器设置为timer
		event.getServletContext().log("已经添加任务！");
	}
}
