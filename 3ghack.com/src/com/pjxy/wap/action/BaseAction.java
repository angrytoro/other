package com.pjxy.wap.action;

import javax.inject.Inject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pjxy.common.model.User;
import com.pjxy.common.user.service.UserService;

@SuppressWarnings("serial")
public abstract class BaseAction extends ActionSupport {
	private String sid;
	private ThreadLocal<User> localUser = new ThreadLocal<User>();
	private User sessionUser;
	// page
	protected int page;
	protected int maxPage;

	@Inject
	protected UserService userService;

	public String getSid() {
		if (sessionUser != null) {
			return sessionUser.getSessionid();
		}
		return ((this.sid == null) ? "" : this.sid);
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	/**
	 * 从Session中获取User,返回的User数据可能不同步
	 * 
	 * @return 当前用户,若用户未登录则返回null
	 */
	public User getSessionUser() {
		User user = localUser.get();
		if (user != null) {
			return user;
		} else if (sessionUser != null) {
			return sessionUser;
		}
		sessionUser = ((User) ActionContext.getContext().getSession()
				.get("user"));
		if (sessionUser == null) {
			sessionUser = this.userService.getUserBySessionID(getSid());
			sessionUser = userService.updateLoginTimeAndOnline(sessionUser);//于7月28号添加
			localUser.set(sessionUser);
			ActionContext.getContext().getSession().put("user", sessionUser);
		}
		return sessionUser;
	}

	/**
	 * 从数据库中获取User
	 * 
	 * @return 当前用户,若用户未登录则返回null
	 */
	public User getDBUser() {
		User user = getSessionUser();
		if (localUser.get() != null) {
			return localUser.get();
		} else {
			if (user == null) {
				return null;
			} else {
				user = sessionUser = userService.getUserByID(user.getId());
				ActionContext.getContext().getSession()
						.put("user", sessionUser);
				localUser.set(user);
				return user;
			}
		}
	}

	// Page
	public int getPage() {
		return page;
	}

	public void setPage(String page) {
		try {
			this.page = Integer.parseInt(page);
		} catch (Exception e) {
		}
	}

	public int getMaxPage() {
		return maxPage;
	}

	protected void resolvePage(int length) {
		maxPage = length;
		if (page > maxPage) {
			page = maxPage;
		} else if (page < 1) {
			page = 1;
		}
	}
}