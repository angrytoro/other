package com.pjxy.wap.user.action;

import java.util.List;

import javax.inject.Inject;

import com.opensymphony.xwork2.ActionContext;
import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.forum.service.ReplyService;
import com.pjxy.common.model.Post;
import com.pjxy.common.model.Reply;
import com.pjxy.common.model.User;
import com.pjxy.wap.action.BaseAction;

@SuppressWarnings("serial")
public class ShowUserAction extends BaseAction{

	private User user;
	private List<Post> posts;
	private List<Reply> replys;
	private String name; //用户名
	private int postAmount; //帖子的数量
	private int replyAmount; //回复的数量
	
	public static final int RECORD_PER_PAGE = 10;//每页最多显示10条数据
	
	@Inject
	private PostService postService;
	@Inject
	private ReplyService replyService;
	
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
	public List<Reply> getReplys() {
		return replys;
	}
	public int getPostAmount() {
		return postAmount;
	}
	public int getReplyAmount() {
		return replyAmount;
	}
	
	@Override
	public String execute()throws Exception{
		User oldUser = (User)ActionContext.getContext().getSession().get("user");//获得当前的用户
		if(oldUser != null && name.equals(oldUser.getName())){ //如果用户已经登录并且如用户想进自己的空间而点击自己的名字
			user = oldUser;
			posts = postService.getPostByUser(user, page * RECORD_PER_PAGE, RECORD_PER_PAGE);
			if(posts.size() == 0){
				posts = null;
				postAmount = 0;
			}else{
				postAmount = postService.countUserPost(user);
			}
			replys = replyService.getReplyByUser(user, page * RECORD_PER_PAGE, RECORD_PER_PAGE);
			if(replys.size() == 0){
				replys = null;
				replyAmount = 0;
			}else{
				replyAmount = replyService.countUserReply(user);
			}
		}else{
			user = userService.getUserByName(name);
			posts = postService.getPostByUser(user, page * RECORD_PER_PAGE, RECORD_PER_PAGE);
			if(posts.size() == 0){
				posts = null;
				postAmount = 0;
			}else{
				postAmount = postService.countUserPost(user);
			}
			replys = null;
			replyAmount = replyService.countUserReply(user);
		}
		return SUCCESS;
	}
	
	@Override
	public void validate(){
		if(name == null || name.isEmpty())
			addFieldError("name", "传值出错！");
	}
}
