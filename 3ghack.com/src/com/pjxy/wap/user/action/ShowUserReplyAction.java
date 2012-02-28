package com.pjxy.wap.user.action;

import java.util.List;

import javax.inject.Inject;

import com.pjxy.common.forum.service.ReplyService;
import com.pjxy.common.model.Reply;
import com.pjxy.common.model.User;
import com.pjxy.wap.action.BaseAction;

@SuppressWarnings("serial")
public class ShowUserReplyAction extends BaseAction{

	private User user;
	private List<Reply> replys;
	private String name; //用户名
	private int replyAmount; //回复的数量
	
	public static final int RECORD_PER_PAGE = 10;//每页最多显示10条数据
	
	@Inject
	private ReplyService replyService;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReplyAmount() {
		return replyAmount;
	}

	public void setReplyAmount(int replyAmount) {
		this.replyAmount = replyAmount;
	}

	public User getUser() {
		return user;
	}

	public List<Reply> getReplys() {
		return replys;
	}
	
	@Override
	public String execute()throws Exception{
		user = getSessionUser();
		if(replyAmount == 0){
			replyAmount = replyService.countUserReply(user);
		}
		replys = replyService.getReplyByUser(user, page * RECORD_PER_PAGE, RECORD_PER_PAGE);
		if(replys.size() == 0)
			replys = null;
		return SUCCESS;
	}
	
	@Override
	public void validate(){
		if(name == null || name.isEmpty())
			addFieldError("name", "用户名不能为空！");
	}
}
