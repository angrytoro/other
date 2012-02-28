package com.pjxy.common.reply.action;

import javax.inject.Inject;

import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.forum.service.ReplyService;
import com.pjxy.common.model.Admin;
import com.pjxy.common.model.Post;
import com.pjxy.common.model.Reply;
import com.pjxy.common.model.User;
import com.pjxy.common.service.AdminService;
import com.pjxy.wap.action.BaseAction;

//置顶回复
@SuppressWarnings("serial")
public class TopReplyAction extends BaseAction {

	private int replyId;
	private int postId;

	@Inject
	private AdminService adminService;
	@Inject
	private ReplyService replyService;
	@Inject
	private PostService postService;

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public void validate() {

		Reply reply = replyService.getReplyById(replyId);
		if (reply == null) {
			addActionError("数据处理出错，请重新操作！");
		}

		User user = getSessionUser();
		if (user == null) {
			addFieldError("user", "请先登录！");
			return;
		}

		Admin admin = adminService.getAdminByUserId(user.getId());

		if (admin == null) {
			addFieldError("admin", "非版主，没有此权限！");
			return;
		}

		Post post = postService.getPostByID(postId);
		if (post == null) {
			addFieldError("post", "该帖子不存在！");
			return;
		}

		if (admin.getBlockId() != null
				|| admin.getBlockId() != post.getBlockId()) {
			addFieldError("admin", "不是该版管理员，无此操作全力！");
		}
	}

	//更新先关的帖子
	private void updateRelatePost() {

		Post post = new Post();
		post.setId(postId);
		post.setReplyHasTop(1);// ???为什么是int

		postService.updatePost(post);
	}

	//更新回复
	private boolean updateReply() {

		Reply reply = new Reply();
		reply.setId(replyId);
		reply.setTop(true);

		if (replyService.updateReply(reply))
			return true;
		return false;
	}

	public String execute() {
		if (!updateReply()) {
			addActionError("置顶操作失败，请重新操作！");
			return INPUT;
		}
		updateRelatePost();
		return SUCCESS;
	}
}
