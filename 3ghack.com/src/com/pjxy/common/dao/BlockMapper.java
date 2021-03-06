package com.pjxy.common.dao;

import com.pjxy.common.model.Block;
import com.pjxy.common.model.BlockExample;
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

public interface BlockMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table block
	 * @mbggenerated
	 */
	@SelectProvider(type = BlockSqlProvider.class, method = "countByExample")
	int countByExample(BlockExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table block
	 * @mbggenerated
	 */
	@DeleteProvider(type = BlockSqlProvider.class, method = "deleteByExample")
	int deleteByExample(BlockExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table block
	 * @mbggenerated
	 */
	@Delete({ "delete from block", "where ID = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table block
	 * @mbggenerated
	 */
	@Insert({ "insert into block (PARENT, `NAME`, ", "BANNER, POST_COUNT)",
			"values (#{parent,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
			"#{banner,jdbcType=VARCHAR}, #{postCount,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(Block record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table block
	 * @mbggenerated
	 */
	@InsertProvider(type = BlockSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(Block record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table block
	 * @mbggenerated
	 */
	@SelectProvider(type = BlockSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "PARENT", property = "parent", jdbcType = JdbcType.INTEGER),
			@Result(column = "NAME", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "BANNER", property = "banner", jdbcType = JdbcType.VARCHAR),
			@Result(column = "POST_COUNT", property = "postCount", jdbcType = JdbcType.INTEGER) })
	List<Block> selectByExample(BlockExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table block
	 * @mbggenerated
	 */
	@Select({ "select", "ID, PARENT, `NAME`, BANNER, POST_COUNT", "from block",
			"where ID = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "PARENT", property = "parent", jdbcType = JdbcType.INTEGER),
			@Result(column = "NAME", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "BANNER", property = "banner", jdbcType = JdbcType.VARCHAR),
			@Result(column = "POST_COUNT", property = "postCount", jdbcType = JdbcType.INTEGER) })
	Block selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table block
	 * @mbggenerated
	 */
	@UpdateProvider(type = BlockSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Block record,
			@Param("example") BlockExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table block
	 * @mbggenerated
	 */
	@UpdateProvider(type = BlockSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Block record,
			@Param("example") BlockExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table block
	 * @mbggenerated
	 */
	@UpdateProvider(type = BlockSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Block record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table block
	 * @mbggenerated
	 */
	@Update({ "update block", "set PARENT = #{parent,jdbcType=INTEGER},",
			"`NAME` = #{name,jdbcType=VARCHAR},",
			"BANNER = #{banner,jdbcType=VARCHAR},",
			"POST_COUNT = #{postCount,jdbcType=INTEGER}",
			"where ID = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Block record);
}