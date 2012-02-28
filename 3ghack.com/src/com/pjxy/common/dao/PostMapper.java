package com.pjxy.common.dao;

import com.pjxy.common.model.Post;
import com.pjxy.common.model.PostExample;
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

public interface PostMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@SelectProvider(type = PostSqlProvider.class, method = "countByExample")
	int countByExample(PostExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@DeleteProvider(type = PostSqlProvider.class, method = "deleteByExample")
	int deleteByExample(PostExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@Delete({ "delete from post", "where ID = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@Insert({
			"insert into post (USER_ID, BLOCK_ID, ",
			"TITLE, VIEW_COUNT, ",
			"GOOD_COUNT, BAD_COUNT, ",
			"WELL, BEST, `END`, ",
			"`LOCK`, MARK, DELETED, ",
			"TOP_TYPE, CREATE_TIME, ",
			"REPLY_TIME, REPLY_COUNT, ",
			"REPLY_HAS_TOP, FAV_COUNT, ",
			"AUTHOR_NAME, HAS_ATTACHMENT, ",
			"HAS_VOTE, CONTENT)",
			"values (#{userId,jdbcType=INTEGER}, #{blockId,jdbcType=INTEGER}, ",
			"#{title,jdbcType=VARCHAR}, #{viewCount,jdbcType=INTEGER}, ",
			"#{goodCount,jdbcType=INTEGER}, #{badCount,jdbcType=INTEGER}, ",
			"#{well,jdbcType=BIT}, #{best,jdbcType=BIT}, #{end,jdbcType=BIT}, ",
			"#{lock,jdbcType=BIT}, #{mark,jdbcType=INTEGER}, #{deleted,jdbcType=BIT}, ",
			"#{topType,jdbcType=SMALLINT}, #{createTime,jdbcType=TIMESTAMP}, ",
			"#{replyTime,jdbcType=TIMESTAMP}, #{replyCount,jdbcType=INTEGER}, ",
			"#{replyHasTop,jdbcType=INTEGER}, #{favCount,jdbcType=INTEGER}, ",
			"#{authorName,jdbcType=VARCHAR}, #{hasAttachment,jdbcType=BIT}, ",
			"#{hasVote,jdbcType=BIT}, #{content,jdbcType=LONGVARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(Post record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@InsertProvider(type = PostSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(Post record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@SelectProvider(type = PostSqlProvider.class, method = "selectByExampleWithBLOBs")
	@Results({
			@Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "USER_ID", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "BLOCK_ID", property = "blockId", jdbcType = JdbcType.INTEGER),
			@Result(column = "TITLE", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "VIEW_COUNT", property = "viewCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "GOOD_COUNT", property = "goodCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "BAD_COUNT", property = "badCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "WELL", property = "well", jdbcType = JdbcType.BIT),
			@Result(column = "BEST", property = "best", jdbcType = JdbcType.BIT),
			@Result(column = "END", property = "end", jdbcType = JdbcType.BIT),
			@Result(column = "LOCK", property = "lock", jdbcType = JdbcType.BIT),
			@Result(column = "MARK", property = "mark", jdbcType = JdbcType.INTEGER),
			@Result(column = "DELETED", property = "deleted", jdbcType = JdbcType.BIT),
			@Result(column = "TOP_TYPE", property = "topType", jdbcType = JdbcType.SMALLINT),
			@Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "REPLY_TIME", property = "replyTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "REPLY_COUNT", property = "replyCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "REPLY_HAS_TOP", property = "replyHasTop", jdbcType = JdbcType.INTEGER),
			@Result(column = "FAV_COUNT", property = "favCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "AUTHOR_NAME", property = "authorName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "HAS_ATTACHMENT", property = "hasAttachment", jdbcType = JdbcType.BIT),
			@Result(column = "HAS_VOTE", property = "hasVote", jdbcType = JdbcType.BIT),
			@Result(column = "CONTENT", property = "content", jdbcType = JdbcType.LONGVARCHAR) })
	List<Post> selectByExampleWithBLOBs(PostExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@SelectProvider(type = PostSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "USER_ID", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "BLOCK_ID", property = "blockId", jdbcType = JdbcType.INTEGER),
			@Result(column = "TITLE", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "VIEW_COUNT", property = "viewCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "GOOD_COUNT", property = "goodCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "BAD_COUNT", property = "badCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "WELL", property = "well", jdbcType = JdbcType.BIT),
			@Result(column = "BEST", property = "best", jdbcType = JdbcType.BIT),
			@Result(column = "END", property = "end", jdbcType = JdbcType.BIT),
			@Result(column = "LOCK", property = "lock", jdbcType = JdbcType.BIT),
			@Result(column = "MARK", property = "mark", jdbcType = JdbcType.INTEGER),
			@Result(column = "DELETED", property = "deleted", jdbcType = JdbcType.BIT),
			@Result(column = "TOP_TYPE", property = "topType", jdbcType = JdbcType.SMALLINT),
			@Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "REPLY_TIME", property = "replyTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "REPLY_COUNT", property = "replyCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "REPLY_HAS_TOP", property = "replyHasTop", jdbcType = JdbcType.INTEGER),
			@Result(column = "FAV_COUNT", property = "favCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "AUTHOR_NAME", property = "authorName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "HAS_ATTACHMENT", property = "hasAttachment", jdbcType = JdbcType.BIT),
			@Result(column = "HAS_VOTE", property = "hasVote", jdbcType = JdbcType.BIT) })
	List<Post> selectByExample(PostExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@Select({
			"select",
			"ID, USER_ID, BLOCK_ID, TITLE, VIEW_COUNT, GOOD_COUNT, BAD_COUNT, WELL, BEST, ",
			"`END`, `LOCK`, MARK, DELETED, TOP_TYPE, CREATE_TIME, REPLY_TIME, REPLY_COUNT, ",
			"REPLY_HAS_TOP, FAV_COUNT, AUTHOR_NAME, HAS_ATTACHMENT, HAS_VOTE, CONTENT",
			"from post", "where ID = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "USER_ID", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "BLOCK_ID", property = "blockId", jdbcType = JdbcType.INTEGER),
			@Result(column = "TITLE", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "VIEW_COUNT", property = "viewCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "GOOD_COUNT", property = "goodCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "BAD_COUNT", property = "badCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "WELL", property = "well", jdbcType = JdbcType.BIT),
			@Result(column = "BEST", property = "best", jdbcType = JdbcType.BIT),
			@Result(column = "END", property = "end", jdbcType = JdbcType.BIT),
			@Result(column = "LOCK", property = "lock", jdbcType = JdbcType.BIT),
			@Result(column = "MARK", property = "mark", jdbcType = JdbcType.INTEGER),
			@Result(column = "DELETED", property = "deleted", jdbcType = JdbcType.BIT),
			@Result(column = "TOP_TYPE", property = "topType", jdbcType = JdbcType.SMALLINT),
			@Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "REPLY_TIME", property = "replyTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "REPLY_COUNT", property = "replyCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "REPLY_HAS_TOP", property = "replyHasTop", jdbcType = JdbcType.INTEGER),
			@Result(column = "FAV_COUNT", property = "favCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "AUTHOR_NAME", property = "authorName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "HAS_ATTACHMENT", property = "hasAttachment", jdbcType = JdbcType.BIT),
			@Result(column = "HAS_VOTE", property = "hasVote", jdbcType = JdbcType.BIT),
			@Result(column = "CONTENT", property = "content", jdbcType = JdbcType.LONGVARCHAR) })
	Post selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@UpdateProvider(type = PostSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Post record,
			@Param("example") PostExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@UpdateProvider(type = PostSqlProvider.class, method = "updateByExampleWithBLOBs")
	int updateByExampleWithBLOBs(@Param("record") Post record,
			@Param("example") PostExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@UpdateProvider(type = PostSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Post record,
			@Param("example") PostExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@UpdateProvider(type = PostSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Post record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@Update({ "update post", "set USER_ID = #{userId,jdbcType=INTEGER},",
			"BLOCK_ID = #{blockId,jdbcType=INTEGER},",
			"TITLE = #{title,jdbcType=VARCHAR},",
			"VIEW_COUNT = #{viewCount,jdbcType=INTEGER},",
			"GOOD_COUNT = #{goodCount,jdbcType=INTEGER},",
			"BAD_COUNT = #{badCount,jdbcType=INTEGER},",
			"WELL = #{well,jdbcType=BIT},", "BEST = #{best,jdbcType=BIT},",
			"`END` = #{end,jdbcType=BIT},", "`LOCK` = #{lock,jdbcType=BIT},",
			"MARK = #{mark,jdbcType=INTEGER},",
			"DELETED = #{deleted,jdbcType=BIT},",
			"TOP_TYPE = #{topType,jdbcType=SMALLINT},",
			"CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
			"REPLY_TIME = #{replyTime,jdbcType=TIMESTAMP},",
			"REPLY_COUNT = #{replyCount,jdbcType=INTEGER},",
			"REPLY_HAS_TOP = #{replyHasTop,jdbcType=INTEGER},",
			"FAV_COUNT = #{favCount,jdbcType=INTEGER},",
			"AUTHOR_NAME = #{authorName,jdbcType=VARCHAR},",
			"HAS_ATTACHMENT = #{hasAttachment,jdbcType=BIT},",
			"HAS_VOTE = #{hasVote,jdbcType=BIT},",
			"CONTENT = #{content,jdbcType=LONGVARCHAR}",
			"where ID = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKeyWithBLOBs(Post record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post
	 * @mbggenerated
	 */
	@Update({ "update post", "set USER_ID = #{userId,jdbcType=INTEGER},",
			"BLOCK_ID = #{blockId,jdbcType=INTEGER},",
			"TITLE = #{title,jdbcType=VARCHAR},",
			"VIEW_COUNT = #{viewCount,jdbcType=INTEGER},",
			"GOOD_COUNT = #{goodCount,jdbcType=INTEGER},",
			"BAD_COUNT = #{badCount,jdbcType=INTEGER},",
			"WELL = #{well,jdbcType=BIT},", "BEST = #{best,jdbcType=BIT},",
			"`END` = #{end,jdbcType=BIT},", "`LOCK` = #{lock,jdbcType=BIT},",
			"MARK = #{mark,jdbcType=INTEGER},",
			"DELETED = #{deleted,jdbcType=BIT},",
			"TOP_TYPE = #{topType,jdbcType=SMALLINT},",
			"CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
			"REPLY_TIME = #{replyTime,jdbcType=TIMESTAMP},",
			"REPLY_COUNT = #{replyCount,jdbcType=INTEGER},",
			"REPLY_HAS_TOP = #{replyHasTop,jdbcType=INTEGER},",
			"FAV_COUNT = #{favCount,jdbcType=INTEGER},",
			"AUTHOR_NAME = #{authorName,jdbcType=VARCHAR},",
			"HAS_ATTACHMENT = #{hasAttachment,jdbcType=BIT},",
			"HAS_VOTE = #{hasVote,jdbcType=BIT}",
			"where ID = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Post record);
}