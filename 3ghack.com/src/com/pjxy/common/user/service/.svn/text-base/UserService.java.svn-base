package com.pjxy.common.user.service;

import com.google.inject.ImplementedBy;
import com.pjxy.common.model.User;
import com.pjxy.common.model.constant.LoginType;
import com.pjxy.common.user.service.impl.UserServiceImpl;

@ImplementedBy(UserServiceImpl.class)
public interface UserService {
	User loginUser(String name, String password, LoginType loginType);

	User getUserByName(String name);

	User getUserByID(int id);

	User getUserByMobile(String mobile);

	User getUserBySessionID(String sid);
	
	/**
	 * 更新用户信息
	 * @param user 需要更新的用户。
	 * 该user必须是新new的user，带有需要更改的属性，不需要更改的属性为null。
	 * @return 若成功则返回更新的记录数，否则返回0
	 */
	int updateUser(User newUser);
	
	/**
	 * 当用户登录的时候得更新用户的最近登录时间与登录状态
	 * @param oldUser 需要更改的用户
	 * @return 返回更新后的oldUser
	 */
	User updateLoginTimeAndOnline(User oldUser);
	
	/**
	 * 计算在线人数
	 * @return 返回在线人数的数量
	 */
	int countOnlineUser();
	
	/**
	 * 添加用户
	 * @param user 需要添加的用户对象
	 * @return 如果成功返回true，否则返回false
	 */
	boolean addUser(User user);
}