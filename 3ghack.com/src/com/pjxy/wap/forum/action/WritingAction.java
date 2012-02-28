package com.pjxy.wap.forum.action;

import java.util.Date;

import javax.inject.Inject;

import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.model.Post;
import com.pjxy.common.model.User;
import com.pjxy.common.user.service.UserService;
import com.pjxy.wap.action.BaseAction;
import com.pjxy.wap.util.TimeUtil;

@SuppressWarnings("serial")
public class WritingAction extends BaseAction{

	private String title; //标题
	private String content; //内容
	private String blockId; //板块id
	private String mark; //赏分
	
	private User user;
	@Inject
	private PostService postService;
	private UserService userService;

	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	private int getMark(){
		try {
			return Integer.parseInt(mark);
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	private int getBlockId(){
		try {
			return Integer.parseInt(blockId);
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	private Post getPost(){
		int mark = getMark();
		Date now = TimeUtil.getCurrentTime();
		if(mark == -1){
			mark = 0;
		}else{ //直接从用户身上扣除积分
			User newUser = new User();
			newUser.setId(user.getId());
			newUser.setMark(user.getMark() - mark);
			userService.updateUser(newUser);
		}
		Post post = new Post();
		post.setAuthorName(user.getName());
		post.setBadCount(0);
		post.setBest(false);
		if(getBlockId() == -1){
			post.setBlockId(0);//如果传进的板块id有问题，是否需要有个默认的板块
		}else{
			post.setBlockId(getBlockId());
		}
		post.setContent(content);
		post.setCreateTime(now);
		post.setDeleted(false);
		post.setEnd(false);
		post.setFavCount(0);
		post.setGoodCount(0);
		post.setHasAttachment(false);
		post.setHasVote(false);
		post.setLock(false);
		post.setMark(mark);
		post.setReplyCount(0);
		post.setReplyHasTop(0);
		post.setReplyTime(now);
		post.setTitle(title);
		post.setTopType((short)0);
		post.setUserId(user.getId());
		post.setViewCount(0);
		post.setWell(false);
		return post;
	}
	
	@Override
	public String execute(){
		Post post = getPost();
		if(!postService.addPost(post)){
			addActionError("编写出错，请重新编写！");//如果用户辛辛苦苦写了那么多，添加不进去怎么办。
			return INPUT;
		}
		return SUCCESS;
	}
	
	@Override
	public void validate(){
		if(title == null || title.length() < 3){
			addFieldError("title", "标题不能为空且不少于3个字符！");
			return;
		}
		if(content == null || content.length() < 9){
			addFieldError("content", "内容不能为空且不少于9个字符！");
			return;
		}
		user = getSessionUser();
		if(user == null){
			addFieldError("user", "该用户已下线，请重新登录！");
			return;
		}
		if(user.getMark() < getMark()){
			addFieldError("mark", "悬赏的积分不能大于用户本身的积分！");
		}
		
	}
}
