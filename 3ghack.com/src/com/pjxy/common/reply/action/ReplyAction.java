package com.pjxy.common.reply.action;

import java.util.Date;

import javax.inject.Inject;

import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.forum.service.ReplyService;
import com.pjxy.common.model.Post;
import com.pjxy.common.model.Reply;
import com.pjxy.common.model.User;
import com.pjxy.wap.action.BaseAction;
import com.pjxy.wap.util.TimeUtil;

@SuppressWarnings("serial")
public class ReplyAction extends BaseAction {

	private String content;

	private int postId;

	@Inject
	private ReplyService replyService;

	@Inject
	private PostService postService;

	public void setContent(String content) {
		this.content = content;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	// 添加回复
	private boolean addReply(int userId, Date now) {
		Reply reply = new Reply();

		reply.setContent(content);
		reply.setCreateTime(now);
		reply.setMark(0);
		reply.setPostId(postId);
		reply.setTop(false);
		reply.setUserId(userId);

		if (replyService.addReply(reply))
			return true;
		return false;
	}

	// 更新相关的帖子
	private void updateRelatedPost(Date now) {

		Post oldPost = postService.getPostByID(postId);
		Post newPost = new Post();

		newPost.setId(postId);
		newPost.setReplyCount(oldPost.getReplyCount() + 1);
		newPost.setReplyTime(now);

		postService.updatePost(newPost);
	}

	public String execute() {
		User user = getSessionUser();
		if (user == null) {
			addActionMessage("请先登录！");
			return LOGIN;
		}

		Date now = TimeUtil.getCurrentTime();
		if (!addReply(user.getId(), now)) {
			addActionError("回复失败，请重新提交！");
			return INPUT;
		}

		updateRelatedPost(now);

		return SUCCESS;
	}

	public void validate() {
		if (content == null || content.trim().length() < 9) {
			addFieldError("content", "回复内容不能小于9个字符！");
		}
	}
}
