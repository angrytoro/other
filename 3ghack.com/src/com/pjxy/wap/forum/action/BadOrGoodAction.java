package com.pjxy.wap.forum.action;

import javax.inject.Inject;

import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.model.Post;
import com.pjxy.common.model.User;
import com.pjxy.wap.action.BaseAction;

@SuppressWarnings("serial")
public class BadOrGoodAction extends BaseAction{

	private int postId;
	
	private Post post;
	
	@Inject
	private PostService postService;
	
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public String bad(){
		Post newPost = new Post();
		newPost.setId(post.getId());
		newPost.setBadCount(post.getBadCount() + 1);
		if(!postService.updatePost(newPost)){
			addActionError("更新数据出错！");
			return INPUT;
		}
		return SUCCESS;
	}
	
	public String good(){
		
		Post newPost = new Post();
		newPost.setId(post.getId());
		newPost.setGoodCount(post.getGoodCount() + 1);
		if(!postService.updatePost(newPost)){
			addActionError("更新数据出错！");
			return INPUT;
		}
		return SUCCESS;
	}
	
	public void validate(){
		post = postService.getPostByID(postId);
		if(post == null){
			addActionError("不存在此帖子！");
			return;
		}
		
		User user = getSessionUser();
		if(user != null && user.getId() == post.getUserId()){ //不能给自己推荐或推荐
			return;
		}
	}
}
