package com.pjxy.wap.user.action;

import java.util.List;

import javax.inject.Inject;

import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.model.Post;
import com.pjxy.common.model.User;
import com.pjxy.wap.action.BaseAction;

@SuppressWarnings("serial")
public class ShowUserPostAction extends BaseAction{
	
	private User user;
	private List<Post> posts;
	private String name; //用户名
	private int postAmount; //帖子的数量
	
	public static final int RECORD_PER_PAGE = 15;//每页最多显示15条数据
	
	@Inject
	private PostService postService;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public int getPostAmount() {
		return postAmount;
	}
	public void setPostAmount(int postAmount) {
		this.postAmount = postAmount;
	}
	
	@Override
	public String execute() throws Exception {
		user = userService.getUserByName(name);
		if(user == null){
			addActionError("该用户不存在！");
			return INPUT;
		}
		if(postAmount == 0){
			postAmount = postService.countUserPost(user);
		}
		posts = postService.getPostByUser(user, page * RECORD_PER_PAGE, RECORD_PER_PAGE);
		if(posts.size() == 0)
			posts = null;
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		if(name == null || name.isEmpty())
			addFieldError("name", "用户名不能为空！");
	}
	
	
}
