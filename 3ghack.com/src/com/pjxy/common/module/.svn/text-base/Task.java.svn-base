package com.pjxy.common.module;

import java.util.Enumeration;
import java.util.TimerTask;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.model.Post;
import com.pjxy.wap.util.PostPropertyBuffer;

/**
 * 继承TimerTask的一个线程类， 用于帖子访问人数的更新 被EventHandlerListener调用
 * 
 * @author adullboy
 */
public class Task extends TimerTask {
	@Inject
	private PostService postService; // = new PostServiceImpl();

	// 更新所有被浏览的帖子的数量
	private void update() {

		if (PostPropertyBuffer.viewCount.size() == 0)
			return;
		Post post = null;
		int postId;
		int viewCount;
		int goodCount;
		int badCount;
		Enumeration<Integer> enums = PostPropertyBuffer.viewCount.keys();//
		while (enums.hasMoreElements()) {
			postId = enums.nextElement();
			viewCount = PostPropertyBuffer.viewCount.get(postId);
			post = new Post();
			post.setId(postId);
			post.setViewCount(viewCount);//
			if (PostPropertyBuffer.goodCount.containsKey(postId)) {
				goodCount = PostPropertyBuffer.goodCount.get(postId);
				post.setGoodCount(goodCount);
			}
			if (PostPropertyBuffer.badCount.containsKey(postId)) {
				badCount = PostPropertyBuffer.badCount.get(postId);
				post.setBadCount(badCount);
			}
			postService.updatePost(post); // 更新Post
			PostPropertyBuffer.viewCount.remove(postId); // 删除记录
		}
	}

	@Override
	public void run() {
		// 添加事件
		update();
	}

}
