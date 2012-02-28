package com.pjxy.common.forum.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.guice.transactional.Transactional;

import com.pjxy.common.dao.PostMapper;
import com.pjxy.common.forum.service.PostService;
import com.pjxy.common.model.Block;
import com.pjxy.common.model.Post;
import com.pjxy.common.model.PostExample;
import com.pjxy.common.model.PostExample.Criteria;
import com.pjxy.common.model.User;
import com.pjxy.common.model.constant.PostTopType;

public class PostServiceImpl implements PostService {
	@Inject
	private PostMapper mapper;

	@Override
	@Transactional
	public List<Post> getHotPost(Block block, boolean withTop, int start,
			int count) {
		return this.getPost(block, withTop, false, start, count,
				"REPLY_TIME desc");
	}

	@Override
	@Transactional
	public List<Post> getNewPost(Block block, boolean withTop, int start,
			int count) {
		return this.getPost(block, withTop, false, start, count, "ID desc");
	}

	@Override
	@Transactional
	public List<Post> getWellPost(Block block, boolean withTop, int start,
			int count) {
		return this.getPost(block, withTop, true, start, count, "ID desc");
	}

	private List<Post> getPost(Block block, boolean withTop, boolean isWell,
			int start, int count, /* Not null */String orderByClause) {
		PostExample example = new PostExample();
		if (withTop) {
			example.createCriteria()
					.andTopTypeEqualTo(
							new Integer(PostTopType.ALL.ordinal()).shortValue())
					.andDeletedEqualTo(false);
			orderByClause = "TOP_TYPE desc, " + orderByClause;
		}
		Criteria criteria = example.or().andDeletedEqualTo(false);
		if (block != null) {
			criteria.andBlockIdEqualTo(block.getId());
		}
		if (isWell) {
			criteria.andWellEqualTo(true);
		}

		example.setOrderByClause(orderByClause);
		example.setLimitStart(start);
		example.setLimitEnd(count);
		return mapper.selectByExample(example);
	}

	@Override
	public Post getPostByID(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Post> getPostByUser(User user, int start, int count) {
		PostExample example = new PostExample();
		example.createCriteria().andUserIdEqualTo(user.getId());
		example.setOrderByClause("CREATE_TIME desc");
		example.setLimitStart(start);
		example.setLimitEnd(count);
		return mapper.selectByExample(example);
	}

	@Override
	public int countUserPost(User user) {
		PostExample example = new PostExample();
		example.createCriteria().andUserIdEqualTo(user.getId());
		return mapper.countByExample(example);
	}

	@Override
	public boolean addPost(Post post) {
		if(mapper.insert(post) < 0)
			return false;
		return true;
	}

	@Override
	public boolean updatePost(Post post) {
		if(mapper.updateByPrimaryKeySelective(post) > 0)
			return true;
		return false;
	}

}
