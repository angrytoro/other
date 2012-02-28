package com.pjxy.wap.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author weefic 在输出xml的时候需要把网页ContentType设为text/vnd.wap.wml，否则部分手机不能识别
 */

@SuppressWarnings("serial")
public class WapContentTypeInterceptor implements Interceptor {

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ServletActionContext.getResponse().setContentType(
				"text/vnd.wap.wml; charset=utf-8");
		return invocation.invoke();
	}

}
