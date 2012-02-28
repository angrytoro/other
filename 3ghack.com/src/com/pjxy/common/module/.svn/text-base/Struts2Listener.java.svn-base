package com.pjxy.common.module;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.pjxy.common.model.User;
import com.pjxy.wap.util.OnlineUserCounter;

public class Struts2Listener implements HttpSessionListener{

	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		User user = (User) arg0.getSession().getAttribute("user");
		if(user != null)
			OnlineUserCounter.addonlineUser(user);
		//System.out.println("create a user" + OnlineUserCounter.getOnlineCount());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		OnlineUserCounter.decrease();
		User user = (User) arg0.getSession().getAttribute("user");
		if(user != null)
			OnlineUserCounter.deleteOnlineUser(user);
		//System.out.println("delete a user" + OnlineUserCounter.getOnlineCount());
	}

}
