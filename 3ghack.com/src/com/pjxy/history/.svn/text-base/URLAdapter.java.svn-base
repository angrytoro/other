package com.pjxy.history;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URLAdapter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		System.out.println(request.getRequestURI());
		String uri = request.getRequestURI();
		if (uri.endsWith("asp")) {
			response.encodeRedirectURL("/bbs/");
		} else {
			chain.doFilter(request, res);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
