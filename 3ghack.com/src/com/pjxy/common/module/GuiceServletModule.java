package com.pjxy.common.module;

import javax.inject.Singleton;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import com.google.inject.servlet.ServletModule;
import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.forum.service.impl.PostServiceImpl;

public class GuiceServletModule extends ServletModule {
	@Override
	protected void configureServlets() {
		bind(StrutsPrepareAndExecuteFilter.class).in(Singleton.class);
		filter("/*").through(StrutsPrepareAndExecuteFilter.class);
	}
}
