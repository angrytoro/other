package com.pjxy.wap.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.pjxy.common.model.User;
import com.pjxy.common.model.constant.LoginType;
import com.pjxy.wap.action.BaseAction;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction {
	private String loginType;
	private String name;
	private String password;
	private LoginType[] loginTypes = LoginType.values();

	public String getLoginType() {
		return this.loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		if ((this.name == null) || (this.password == null)
				|| (this.loginType == null))
			return LOGIN;
		try {
			int type = Integer.parseInt(this.loginType);
			if ((type < 0) || (type > this.loginTypes.length - 1)){
				addFieldError("loginType", "登录方式检查错误!");
				return INPUT;
			}
			User user = this.userService.loginUser(this.name, this.password,
					this.loginTypes[type]);
			if (user == null) {
				addActionError("用户名或用户密码错误!");
				return INPUT;
			}
			user = userService.updateLoginTimeAndOnline(user);//于7月28号添加，登录需要更新登录时间字段与在线状态
			if(user == null){
				addFieldError("update", "用户状态设置出现错误！");
				return INPUT;
			}
			setSid(user.getSessionid());
			ActionContext.getContext().getSession().put("user", user); //于7月28号添加
		} catch (NumberFormatException e) {
			addFieldError("loginType", "登录方式检查错误!");
			return "input";
		}
		return SUCCESS;
	}

	@Override
	public void validate() {
		if ((this.name == null) || (this.password == null)
				|| (this.loginType == null))
			return;
		if (this.name.trim().length() == 0)
			addFieldError("name", "登录名不能为空!");
		if (this.password.trim().length() == 0)
			addFieldError("password", "登录密码不能为空!");
	}
}