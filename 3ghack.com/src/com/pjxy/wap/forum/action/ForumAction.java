package com.pjxy.wap.forum.action;

import java.util.List;

import javax.inject.Inject;

import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.model.Post;
import com.pjxy.wap.action.BaseAction;

@SuppressWarnings("serial")
public class ForumAction extends BaseAction {
	@Inject
	private PostService postService;
	private List<Post> hotPostList;

	public List<Post> getHotPostList() {
		return hotPostList;
	}

	@Override
	public String execute() throws Exception {
		long start = System.currentTimeMillis();
		hotPostList = postService.getHotPost(null, false, 0, 5);
		long end = System.currentTimeMillis();
		System.out.println("Query Time:" + (end - start));
		return SUCCESS;
	}

}
