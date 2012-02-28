package com.pjxy.common.service;

import com.pjxy.common.model.Admin;

public interface AdminService {

	//根据用户id得到版主
	Admin getAdminByUserId(int userId);
}
