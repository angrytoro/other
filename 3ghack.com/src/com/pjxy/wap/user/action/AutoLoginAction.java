package com.pjxy.wap.user.action;

import com.pjxy.common.model.User;
import com.pjxy.wap.action.BaseAction;

@SuppressWarnings("serial")
public class AutoLoginAction extends BaseAction {
	@Override
	public String execute() throws Exception {
		User user = getSessionUser();
		if (user == null)
			return LOGIN;
		return SUCCESS;
	}
}