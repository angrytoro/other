package com.pjxy.wap.forum.action;

import javax.inject.Inject;

import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.model.Post;
import com.pjxy.wap.action.BaseAction;

//结贴与删除帖子
@SuppressWarnings("serial")
public class EndOrDeletePostAction extends BaseAction{

	private int postId;
	
	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Inject
	private PostService postService;
	
	//结贴
	public String endPost(){
		Post post = new Post();
		post.setId(postId);
		post.setEnd(true);
		if(!postService.updatePost(post)){
			addActionError("更新数据出错！");
			return INPUT;
		}
		return SUCCESS;
	}
	
	public String deletePost(){
		Post post = new Post();
		post.setId(postId);
		post.setDeleted(true);
		if(!postService.updatePost(post)){
			addActionError("更新数据出错！");
			return INPUT;
		}
		return SUCCESS;
	}
	
	public void validate(){
	}
}
