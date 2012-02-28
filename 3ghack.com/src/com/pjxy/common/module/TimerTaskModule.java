package com.pjxy.common.module;

import java.util.TimerTask;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class TimerTaskModule extends AbstractModule {
	@Override
	protected void configure() {
		requestStaticInjection(EventHandlerListener.class);
		Multibinder<TimerTask> multibinder = Multibinder.newSetBinder(binder(),
				TimerTask.class);
		multibinder.addBinding().to(Task.class);
	}
}
