package com.pjxy.common.dao;

import com.pjxy.common.model.Reply;
import com.pjxy.common.model.ReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ReplyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@SelectProvider(type = ReplySqlProvider.class, method = "countByExample")
	int countByExample(ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@DeleteProvider(type = ReplySqlProvider.class, method = "deleteByExample")
	int deleteByExample(ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@Delete({ "delete from reply", "where ID = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@Insert({
			"insert into reply (USER_ID, POST_ID, ",
			"CREATE_TIME, `TOP`, MARK, ",
			"USER_NAME, CONTENT)",
			"values (#{userId,jdbcType=INTEGER}, #{postId,jdbcType=INTEGER}, ",
			"#{createTime,jdbcType=TIMESTAMP}, #{top,jdbcType=BIT}, #{mark,jdbcType=INTEGER}, ",
			"#{userName,jdbcType=VARCHAR}, #{content,jdbcType=LONGVARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(Reply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@InsertProvider(type = ReplySqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(Reply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@SelectProvider(type = ReplySqlProvider.class, method = "selectByExampleWithBLOBs")
	@Results({
			@Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "USER_ID", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "POST_ID", property = "postId", jdbcType = JdbcType.INTEGER),
			@Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "TOP", property = "top", jdbcType = JdbcType.BIT),
			@Result(column = "MARK", property = "mark", jdbcType = JdbcType.INTEGER),
			@Result(column = "USER_NAME", property = "userName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "CONTENT", property = "content", jdbcType = JdbcType.LONGVARCHAR) })
	List<Reply> selectByExampleWithBLOBs(ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@SelectProvider(type = ReplySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "USER_ID", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "POST_ID", property = "postId", jdbcType = JdbcType.INTEGER),
			@Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "TOP", property = "top", jdbcType = JdbcType.BIT),
			@Result(column = "MARK", property = "mark", jdbcType = JdbcType.INTEGER),
			@Result(column = "USER_NAME", property = "userName", jdbcType = JdbcType.VARCHAR) })
	List<Reply> selectByExample(ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@Select({
			"select",
			"ID, USER_ID, POST_ID, CREATE_TIME, `TOP`, MARK, USER_NAME, CONTENT",
			"from reply", "where ID = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "USER_ID", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "POST_ID", property = "postId", jdbcType = JdbcType.INTEGER),
			@Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "TOP", property = "top", jdbcType = JdbcType.BIT),
			@Result(column = "MARK", property = "mark", jdbcType = JdbcType.INTEGER),
			@Result(column = "USER_NAME", property = "userName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "CONTENT", property = "content", jdbcType = JdbcType.LONGVARCHAR) })
	Reply selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@UpdateProvider(type = ReplySqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Reply record,
			@Param("example") ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@UpdateProvider(type = ReplySqlProvider.class, method = "updateByExampleWithBLOBs")
	int updateByExampleWithBLOBs(@Param("record") Reply record,
			@Param("example") ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@UpdateProvider(type = ReplySqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Reply record,
			@Param("example") ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@UpdateProvider(type = ReplySqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Reply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@Update({ "update reply", "set USER_ID = #{userId,jdbcType=INTEGER},",
			"POST_ID = #{postId,jdbcType=INTEGER},",
			"CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
			"`TOP` = #{top,jdbcType=BIT},", "MARK = #{mark,jdbcType=INTEGER},",
			"USER_NAME = #{userName,jdbcType=VARCHAR},",
			"CONTENT = #{content,jdbcType=LONGVARCHAR}",
			"where ID = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKeyWithBLOBs(Reply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbggenerated
	 */
	@Update({ "update reply", "set USER_ID = #{userId,jdbcType=INTEGER},",
			"POST_ID = #{postId,jdbcType=INTEGER},",
			"CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
			"`TOP` = #{top,jdbcType=BIT},", "MARK = #{mark,jdbcType=INTEGER},",
			"USER_NAME = #{userName,jdbcType=VARCHAR}",
			"where ID = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Reply record);
}