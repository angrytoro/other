package com.pjxy.common.forum.service;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.pjxy.common.forum.service.impl.PostServiceImpl;
import com.pjxy.common.model.Block;
import com.pjxy.common.model.Post;
import com.pjxy.common.model.User;

@ImplementedBy(PostServiceImpl.class)
public interface PostService {
	// 获取指定数量的新帖子,若block为null则返回论坛全部新帖子
	List<Post> getNewPost(Block block, boolean withTop, int start, int count);

	// 获取指定数量的热帖子,若block为null则返回论坛全部热帖子
	List<Post> getHotPost(Block block, boolean withTop, int start, int count);

	// 获取指定数量的精帖子,若block为null则返回论坛全部精帖子
	List<Post> getWellPost(Block block, boolean withTop, int start, int count);

	Post getPostByID(int id);
	
	/**
	 * 根据用户获得该用户发表的帖子
	 * @param user 用户
	 * @param start 从哪条数据开始
	 * @param count 需要几条数据
	 * @return 用户的帖子
	 * @author adullboy 2011.07.30
	 */
	List<Post> getPostByUser(User user,int start,int count);
	
	/**
	 * 计算某用户发表的帖子数量
	 * @param user 用户
	 * @return 帖子数量
	 */
	int countUserPost(User user);
	
	/**
	 * 添加帖子
	 * @param post
	 * @return 如果添加成功则返回true，否则返回false
	 */
	boolean addPost(Post post);
	
	/**
	 * 更新某个帖子的信息
	 * @param post
	 * @return 操作成功返回true，否则返回false
	 */
	boolean updatePost(Post post);
}
