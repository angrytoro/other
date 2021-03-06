package com.pjxy.common.forum.service;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.pjxy.common.forum.service.impl.ReplyServiceImpl;
import com.pjxy.common.model.Reply;
import com.pjxy.common.model.User;

@ImplementedBy(ReplyServiceImpl.class)
public interface ReplyService {
	// with BLOBs
	List<Reply> getReplyByPostId(int postId, boolean withTop, int start,
			int count);
	
	/**
	 * 根据User获得该用户的所有回复
	 * @param user 用户对象
	 * @param start 从start条记录开始获取
	 * @param count 获得count条数据
	 * @return 返回获得的Reply的List
	 * @author adullboy 2011.07.30
	 */
	List<Reply> getReplyByUser(User user,int start,int count);
	
	/**
	 * 计算某用户回复的帖子数量
	 * @param user
	 * @return
	 */
	int countUserReply(User user);
	
	/**
	 * 添加回复
	 * @param reply 一个新建的reply
	 * @return
	 */
	boolean addReply(Reply reply);
	
	/**
	 * 根据回复的id获得回复
	 * @param replyid
	 * @return
	 */
	Reply getReplyById(int replyId);
	
	/**
	 * 更新Reply
	 * @param reply
	 * @return
	 */
	boolean updateReply(Reply reply);
}
