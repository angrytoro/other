package com.pjxy.common.dao;

import com.pjxy.common.model.Bulletin;
import com.pjxy.common.model.BulletinExample;
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

public interface BulletinMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bulletin
	 * @mbggenerated
	 */
	@SelectProvider(type = BulletinSqlProvider.class, method = "countByExample")
	int countByExample(BulletinExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bulletin
	 * @mbggenerated
	 */
	@DeleteProvider(type = BulletinSqlProvider.class, method = "deleteByExample")
	int deleteByExample(BulletinExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bulletin
	 * @mbggenerated
	 */
	@Delete({ "delete from bulletin", "where ID = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bulletin
	 * @mbggenerated
	 */
	@Insert({
			"insert into bulletin (POST_ID, BLOCK_ID, ",
			"SHOW_NAME)",
			"values (#{postId,jdbcType=INTEGER}, #{blockId,jdbcType=INTEGER}, ",
			"#{showName,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(Bulletin record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bulletin
	 * @mbggenerated
	 */
	@InsertProvider(type = BulletinSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(Bulletin record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bulletin
	 * @mbggenerated
	 */
	@SelectProvider(type = BulletinSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "POST_ID", property = "postId", jdbcType = JdbcType.INTEGER),
			@Result(column = "BLOCK_ID", property = "blockId", jdbcType = JdbcType.INTEGER),
			@Result(column = "SHOW_NAME", property = "showName", jdbcType = JdbcType.VARCHAR) })
	List<Bulletin> selectByExample(BulletinExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bulletin
	 * @mbggenerated
	 */
	@Select({ "select", "ID, POST_ID, BLOCK_ID, SHOW_NAME", "from bulletin",
			"where ID = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "POST_ID", property = "postId", jdbcType = JdbcType.INTEGER),
			@Result(column = "BLOCK_ID", property = "blockId", jdbcType = JdbcType.INTEGER),
			@Result(column = "SHOW_NAME", property = "showName", jdbcType = JdbcType.VARCHAR) })
	Bulletin selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bulletin
	 * @mbggenerated
	 */
	@UpdateProvider(type = BulletinSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Bulletin record,
			@Param("example") BulletinExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bulletin
	 * @mbggenerated
	 */
	@UpdateProvider(type = BulletinSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Bulletin record,
			@Param("example") BulletinExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bulletin
	 * @mbggenerated
	 */
	@UpdateProvider(type = BulletinSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Bulletin record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bulletin
	 * @mbggenerated
	 */
	@Update({ "update bulletin", "set POST_ID = #{postId,jdbcType=INTEGER},",
			"BLOCK_ID = #{blockId,jdbcType=INTEGER},",
			"SHOW_NAME = #{showName,jdbcType=VARCHAR}",
			"where ID = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Bulletin record);
}