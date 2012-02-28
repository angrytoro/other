package com.pjxy.wap.forum.action;

import java.util.List;

import javax.inject.Inject;

import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.forum.service.ReplyService;
import com.pjxy.common.model.Post;
import com.pjxy.common.model.Reply;
import com.pjxy.wap.action.BaseAction;
import com.pjxy.wap.util.PostPropertyBuffer;

@SuppressWarnings("serial")
public class PostAction extends BaseAction {
	@Inject
	private PostService postService;
	@Inject
	private ReplyService replyService;

	// 帖子信息
	private int postId;
	private Post post;
	private String content;
	private boolean viewRemain;

	// 回复信息
	private List<Reply> replies;

	// Post的ID
	public int getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		try {
			this.postId = Integer.parseInt(postId);
		} catch (Exception e) {
		}
	}

	public Post getPost() {
		return post;
	}

	// 页面呈现的内容(受分页影响)
	public String getContent() {
		return content;
	}

	// 是否查看全文
	public boolean getViewRemain() {
		return viewRemain;
	}

	public void setViewRemain(String viewRemain) {
		try {
			this.viewRemain = Integer.parseInt(viewRemain) == 1;
		} catch (Exception e) {
		}
	}

	public List<Reply> getReplies() {
		return replies;
	}

	@Override
	public String execute() throws Exception {
		if (postId < 1) {
			return SUCCESS;// Fast
		}
		post = postService.getPostByID(postId);
		if (post != null) {
			replies = replyService.getReplyByPostId(post.getId(), true, 0, 3);
		}
		resolveContent();
		return SUCCESS;
	}

	// 增加浏览用户数量
	private void increaseViewCount() {
		
		PostPropertyBuffer.viewCount.replace(postId,
				PostPropertyBuffer.viewCount.get(postId) + 1);
	}

	private void resolveContent() {
		if (post == null) {
			content = "";
		} else {
			String value = post.getContent();
			// 如果存在(all/)关键字,则默认显示全文
			if (value.indexOf("(all/)") > -1) {
				resolvePage(1);
				content = value.replaceAll("\\(all/\\)", "");
			} else {
				int next = value.indexOf("(next/)");
				if (next > -1) {
					String results[] = value.split("\\(next/\\)");
					resolvePage(results.length);
					if (viewRemain && page < maxPage) {
						content = "";
						for (int i = page - 1; i < results.length; i++) {
							content += results[i];
						}
					} else {
						content = results[page - 1];
					}
				} else {
					int wordsPerPage = 500;
					resolvePage((value.length() - 1) / wordsPerPage + 1);
					if (viewRemain && page < maxPage) {
						content = value.substring((page - 1) * wordsPerPage);
					} else {
						if (page == maxPage) {
							content = value
									.substring((page - 1) * wordsPerPage);
						} else {
							content = value.substring(
									(page - 1) * wordsPerPage, page
											* wordsPerPage);
						}
					}
				}
			}
		}
	}

}
