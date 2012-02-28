package com.pjxy.common.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.struts2.Struts2GuicePluginModule;

public class GuiceListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new DatabaseModule(),
				new Struts2GuicePluginModule(), new GuiceServletModule(),
				new TimerTaskModule());
	}
}
