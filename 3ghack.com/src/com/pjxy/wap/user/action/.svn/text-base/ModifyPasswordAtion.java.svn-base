package com.pjxy.wap.user.action;

import javax.inject.Inject;

import com.opensymphony.xwork2.ActionContext;
import com.pjxy.common.model.User;
import com.pjxy.common.service.EncryptService;
import com.pjxy.wap.action.BaseAction;

@SuppressWarnings("serial")
public class ModifyPasswordAtion extends BaseAction {

	private String oldPassword;
	private String newPassword;
	private String confirmPassword;

	@Inject
	private EncryptService encryptService;

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String enterModify(){
		return SUCCESS;
	}
	
	public String modiy() throws Exception {

		if (newPassword == null || newPassword.isEmpty()
				|| confirmPassword == null || confirmPassword.isEmpty()) {
			addFieldError("newPassword", "密码输入有误！");
			return INPUT;
		} else if (!newPassword.equals(confirmPassword)) {
			addFieldError("newPassword", "两次输入的新密码不一致，请重新输入！");
			return INPUT;
		}
		
		User user = getSessionUser();
		if(user == null){
			addActionError("还未登录请先登录！");
			return INPUT;
		}
		String nowPassword = user.getPassword();
		String md5OldPassword = encryptService.md5Encrypt(oldPassword);
		if (nowPassword.length() == 16
				&& md5OldPassword.indexOf(nowPassword) > 0
				|| md5OldPassword.equals(nowPassword)) {
			String md5NewPassword = encryptService.md5Encrypt(newPassword);
			User newUser = new User();
			newUser.setId(user.getId());
			newUser.setPassword(md5NewPassword);
			if(userService.updateUser(newUser) > 0){
				user.setPassword(md5NewPassword);
				ActionContext.getContext().getSession().put("user", user);
				return SUCCESS;
			}
			addActionError("密码更改出错！");
			return INPUT;
		}
		addActionError("密码不正确，请重新输入！");
		return INPUT;
	}

}
