package com.pjxy.wap.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.pjxy.common.model.User;
import com.pjxy.wap.action.BaseAction;
import com.pjxy.wap.util.StringUtil;

@SuppressWarnings("serial")
public class ModifyProfileAction extends BaseAction {

	private User user;
	private String name;
	private String mobile;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public String showProfile()throws Exception{
		user =  getSessionUser();
		return SUCCESS;
	}
	public String modify() throws Exception {
		user = getSessionUser();
		if (name.equals(user.getName())
				&& mobile.equals(user.getMobile())
				&& email.equals(user.getEmail())) { //当没有修改任何东西的时候
			return SUCCESS;
		}
		if(!name.equals(user.getName())){
			if(userService.getUserByName(name) != null) //用户名是唯一的，所以不能有重复
				addFieldError("name", "该用户名已存在，请用其他名称！");
				return INPUT;
		}
		User newUser = new User();
		newUser.setId(user.getId());
		newUser.setName(name);
		newUser.setMobile(mobile);
		newUser.setEmail(email);
		
		if(userService.updateUser(newUser) < 1){
			addActionError("更新失败！");
			return INPUT;
		}
		user = userService.getUserByID(user.getId());
		ActionContext.getContext().getSession().put("user", user);
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (name == null || name.length() == 0)
			addFieldError("name", "用户名不能为空！");
		if (mobile == null || mobile.length() == 0)
			addFieldError("mobile", "电话号码不能为空！");
		if (!StringUtil.isMobile(mobile))
			addFieldError("mobile", "电话号码不符合规范！");
	}
}
