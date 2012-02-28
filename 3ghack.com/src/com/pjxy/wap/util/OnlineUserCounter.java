package com.pjxy.wap.util;

import java.util.ArrayList;

import com.pjxy.common.model.User;

public class OnlineUserCounter {
	
	private static int onlineCount = 0; //在线人数统计
	private static ArrayList<String> onlineUsers = new ArrayList<String>(); //存储在线会员的sessionid
	
	//得到在线人数
	public static int getOnlineCount() {
		return onlineCount;
	}

	//得到在线会员sessionid的ArrayList数组
	public static ArrayList<String> getOnlineUsers() {
		return onlineUsers;
	}

	//每创建一个session，onlineCount就加1
	public static void increase(){
		onlineCount++;
	}
	
	//每创删除一个session，onlineCount就减1
	public static void decrease(){
		onlineCount--;
	}
	
	
	public static void addonlineUser(User user){
		if(!isUserOnline(user)) //如果该会员没有在另外一个地方登陆的话
			onlineUsers.add(user.getSessionid());
	}
	
	//在线用户减1
	public static void deleteOnlineUser(User user){
		onlineUsers.remove(user.getSessionid());
	}
	
	//判断该用户是否已经在线
	private static boolean isUserOnline(User user){
		
		return onlineUsers.contains(user.getSessionid());
		
	}
}
