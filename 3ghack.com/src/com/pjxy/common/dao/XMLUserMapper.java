package com.pjxy.common.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

public interface XMLUserMapper {

	boolean updatePostGood(@Param(value = "userid")int userid,@Param(value = "good")int good);
	
	boolean updateBufferPostGood(HashMap<Integer,Integer> buffer);
}
