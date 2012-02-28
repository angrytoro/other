package com.pjxy.wap.user.action;

import javax.inject.Inject;

import com.opensymphony.xwork2.ActionSupport;
import com.pjxy.common.model.User;
import com.pjxy.common.service.EncryptService;
import com.pjxy.common.user.service.UserService;
import com.pjxy.wap.util.TimeUtil;
import com.pjxy.wap.util.UUIDUtil;

@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport{

	private String mobile;
	
	@Inject
	private UserService userService;
	@Inject
	private EncryptService encryptService;
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Override
	public void validate(){
		if(mobile == null || mobile.isEmpty())
			addFieldError("mobile", "电话号码为空。");
	}
	
	@Override
	public String execute(){
		User user = new User();
		setUserProperty(user);
		if(!userService.addUser(user)){
			addActionError("添加用户失败！");
			return INPUT;
		}
		return SUCCESS;
	}
	
	private void setUserProperty(User user){
		user.setLoginTime(TimeUtil.getCurrentTime());
		user.setMark(0);
		user.setMobile(mobile);
		user.setMoney(0);
		user.setName("");
		user.setOnline(false);
		user.setPassword(encryptService.md5Encrypt(mobile.substring(mobile.length() - 6)));
		user.setRegTime(TimeUtil.getCurrentTime());
		user.setSessionid(UUIDUtil.generateUUID());
	}
	
//	public static void main(String[] args){
//		String x = "13797056739";
//		System.out.print(x.substring(x.length() - 6));
//	}
}
