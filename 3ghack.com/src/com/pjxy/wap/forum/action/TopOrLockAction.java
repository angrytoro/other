package com.pjxy.wap.forum.action;

import javax.inject.Inject;

import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.model.Admin;
import com.pjxy.common.model.Post;
import com.pjxy.common.model.User;
import com.pjxy.common.service.AdminService;
import com.pjxy.wap.action.BaseAction;

/**
 * 置顶或锁帖
 * @author adullboy
 * 
 */
@SuppressWarnings("serial")
public class TopOrLockAction extends BaseAction{
	
	private int postId;
	private int blockId;
	
	@Inject
	private AdminService adminService;
	@Inject
	private PostService postService;
	
	public void setPostId(int postId) {
		this.postId = postId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	
	public String top(){
		Post post = new Post();
		post.setId(postId);
		post.setTopType((short)1);
		if(!postService.updatePost(post)){
			addActionError("数据库更新出现问题，请从新操作！");
			return INPUT;
		}
		return SUCCESS;
	}
	
	public String lock(){
		Post post = new Post();
		post.setId(postId);
		post.setLock(true);
		if(!postService.updatePost(post)){
			addActionError("数据库更新出现问题，请从新操作！");
			return INPUT;
		}
		return SUCCESS;
	}
	
	public void validate(){
		
		User user = getSessionUser();
		if(user == null){
			addFieldError("user", "请先登录！");
			return;
		}
		Admin admin = adminService.getAdminByUserId(user.getId());
		if(admin == null){
			addFieldError("admin", "不是版主，无权使用该功能！");
			return;
		}
		
		Post post = postService.getPostByID(postId);
		
		if(post == null){
			addFieldError("post", "该帖子不存在！");
			return;
		}
		
		if(admin.getBlockId() != null && admin.getBlockId() != post.getBlockId()){
			addFieldError("admin", "不是该版管理员，无此操作全力！");
		}
	}
}
