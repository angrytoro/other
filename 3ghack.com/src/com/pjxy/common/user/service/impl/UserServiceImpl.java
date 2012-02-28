package com.pjxy.common.user.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.pjxy.common.dao.UserMapper;
import com.pjxy.common.model.User;
import com.pjxy.common.model.UserExample;
import com.pjxy.common.model.constant.LoginType;
import com.pjxy.common.service.EncryptService;
import com.pjxy.common.user.service.UserService;
import com.pjxy.wap.util.TimeUtil;

public class UserServiceImpl implements UserService {
	@Inject
	private UserMapper userMapper;
	@Inject
	private EncryptService encryptService;

	@Override
	public User loginUser(String name, String password, LoginType loginType) {
		User user = null;
		if (loginType == LoginType.ID) {
			try {
				user = getUserByID(Integer.parseInt(name));
			} catch (NumberFormatException e) {
			}
		} else if (loginType == LoginType.MOBILE) {
			user = getUserByMobile(name.trim());
		} else if (loginType == LoginType.NAME) {
			user = getUserByName(name);
		}
		if ((user != null) && (password != null)) {
			String correctPass = this.encryptService.md5Encrypt(password);
			if (user.getPassword().length() == 16) {
				if (correctPass.indexOf(user.getPassword()) > 0)
					return user;
			} else if (correctPass.equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getUserByName(String name) {
		if ((name == null) || (name.isEmpty()))
			return null;
		UserExample example = new UserExample();
		example.createCriteria().andNameEqualTo(name);
		List<User> users = this.userMapper.selectByExample(example);
		if (users.size() == 0)
			return null;
		return ((User) users.get(0));
	}

	@Override
	public User getUserByID(int id) {
		return this.userMapper.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public User getUserByMobile(String mobile) {
		if ((mobile == null) || (mobile.isEmpty()))
			return null;
		UserExample example = new UserExample();
		example.createCriteria().andMobileEqualTo(mobile);
		List<User> users = this.userMapper.selectByExample(example);
		if (users.size() == 0)
			return null;
		return ((User) users.get(0));
	}

	@Override
	public User getUserBySessionID(String sid) {
		if ((sid == null) || (sid.isEmpty()))
			return null;
		UserExample example = new UserExample();
		example.createCriteria().andSessionidEqualTo(sid);
		List<User> users = this.userMapper.selectByExample(example);
		if (users.size() == 0)
			return null;
		return ((User) users.get(0));
	}

	@Override
	public int updateUser(User newUser) {
		if(newUser != null){			
			return userMapper.updateByPrimaryKeySelective(newUser);
		}
		return 0;
	}

	@Override
	public User updateLoginTimeAndOnline(User oldUser) {
		
		if(oldUser != null){
			Date date = TimeUtil.getCurrentTime();
			User newUser = new User();
			newUser.setId(oldUser.getId());
			newUser.setOnline(true);
			newUser.setLoginTime(date);
			if(updateUser(newUser) > 0){ //如果更新成功，则旧的user也更新在线状态与登录时间
				oldUser.setOnline(true);
				oldUser.setLoginTime(date);
				return oldUser;
			}
			return null;
		}
		
		return null;
	}

	@Override
	public int countOnlineUser() {
		UserExample example = new UserExample();
		example.createCriteria().andOnlineEqualTo(true);
		return userMapper.countByExample(example);
	}

	@Override
	public boolean addUser(User user) {
		if(user == null){
			return false;
		}
		if(userMapper.insert(user) < 0)
			return false;
		user = getUserByMobile(user.getMobile());
		User newUser = new User();
		newUser.setId(user.getId());
		newUser.setName("新用户" + user.getId());
		if(updateUser(newUser) > 0)
			return true;
		return false;
	}

}