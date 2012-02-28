package com.pjxy.wap.forum.action;

import java.util.List;

import javax.inject.Inject;

import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.model.Post;
import com.pjxy.wap.action.BaseAction;

@SuppressWarnings("serial")
public class QuickPostAction extends BaseAction {
	public static final int CATALOG_NEW = 0;
	public static final int CATALOG_HOT = 1;
	public static final int CATALOG_WELL = 2;// 热帖
	public static final int CATALOG_RECOMMEND = 3;
	public static final int CATALOG_MARK = 4;

	public static final int POST_COUNT = 150;
	public static final int POSTS_PER_PAGE = 15;

	@Inject
	private PostService postService;

	private int catalog;
	private List<Post> posts;

	public int getCatalog() {
		return catalog;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public String viewHotPost() throws Exception {
		this.catalog = CATALOG_HOT;
		super.resolvePage(POST_COUNT / POSTS_PER_PAGE);
		posts = postService.getHotPost(null, false,
				(page - 1) * POSTS_PER_PAGE, POSTS_PER_PAGE);
		return SUCCESS;
	}

	public String viewNewPost() throws Exception {
		this.catalog = CATALOG_NEW;
		super.resolvePage(POST_COUNT / POSTS_PER_PAGE);
		posts = postService.getNewPost(null, false,
				(page - 1) * POSTS_PER_PAGE, POSTS_PER_PAGE);
		return SUCCESS;
	}

	public String viewWellPost() throws Exception {
		this.catalog = CATALOG_WELL;
		super.resolvePage(POST_COUNT / POSTS_PER_PAGE);
		posts = postService.getWellPost(null, false, (page - 1)
				* POSTS_PER_PAGE, POSTS_PER_PAGE);
		return SUCCESS;
	}

}
