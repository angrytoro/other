package com.pjxy.wap.ui;

import javax.servlet.ServletContext;

import org.apache.struts2.views.freemarker.FreemarkerManager;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

public class FreemarkerManagerExt extends FreemarkerManager {

	@Override
	protected Configuration createConfiguration(ServletContext servletContext)
			throws TemplateException {
		Configuration config = super.createConfiguration(servletContext);
		config.setSharedVariable("wml", new FtlWmlEscape());
		config.setSharedVariable("ubb", new FtlUbbEscape());
		config.setSharedVariable("width", new FtlSubstringWidth());
		return config;
	}

}
