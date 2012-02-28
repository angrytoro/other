package com.pjxy.common.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.pjxy.common.dao.AdminMapper;
import com.pjxy.common.model.Admin;
import com.pjxy.common.model.AdminExample;
import com.pjxy.common.service.AdminService;

public class AdminServiceImpl implements AdminService{

	@Inject
	private AdminMapper mapper;
	
	@Override
	public Admin getAdminByUserId(int userId) {
		
		AdminExample example = new AdminExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<Admin> users = mapper.selectByExample(example);
		if(users.size() != 0)
			return users.get(0);
		
		return null;
	}

}
