package com.pjxy.common.dao;

import com.pjxy.common.model.User;
import com.pjxy.common.model.UserExample;
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

public interface UserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	@SelectProvider(type = UserSqlProvider.class, method = "countByExample")
	int countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	@DeleteProvider(type = UserSqlProvider.class, method = "deleteByExample")
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	@Delete({ "delete from user", "where ID = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	@Insert({
			"insert into user (`NAME`, `PASSWORD`, ",
			"SESSIONID, MOBILE, ",
			"`ONLINE`, EMAIL, MARK, ",
			"MONEY, LOGIN_TIME, ",
			"REG_TIME)",
			"values (#{name,jdbcType=VARCHAR}, #{password,jdbcType=CHAR}, ",
			"#{sessionid,jdbcType=CHAR}, #{mobile,jdbcType=VARCHAR}, ",
			"#{online,jdbcType=BIT}, #{email,jdbcType=VARCHAR}, #{mark,jdbcType=INTEGER}, ",
			"#{money,jdbcType=INTEGER}, #{loginTime,jdbcType=TIMESTAMP}, ",
			"#{regTime,jdbcType=TIMESTAMP})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	@InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	@SelectProvider(type = UserSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "NAME", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PASSWORD", property = "password", jdbcType = JdbcType.CHAR),
			@Result(column = "SESSIONID", property = "sessionid", jdbcType = JdbcType.CHAR),
			@Result(column = "MOBILE", property = "mobile", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ONLINE", property = "online", jdbcType = JdbcType.BIT),
			@Result(column = "EMAIL", property = "email", jdbcType = JdbcType.VARCHAR),
			@Result(column = "MARK", property = "mark", jdbcType = JdbcType.INTEGER),
			@Result(column = "MONEY", property = "money", jdbcType = JdbcType.INTEGER),
			@Result(column = "LOGIN_TIME", property = "loginTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "REG_TIME", property = "regTime", jdbcType = JdbcType.TIMESTAMP) })
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	@Select({
			"select",
			"ID, `NAME`, `PASSWORD`, SESSIONID, MOBILE, `ONLINE`, EMAIL, MARK, MONEY, LOGIN_TIME, ",
			"REG_TIME", "from user", "where ID = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "NAME", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PASSWORD", property = "password", jdbcType = JdbcType.CHAR),
			@Result(column = "SESSIONID", property = "sessionid", jdbcType = JdbcType.CHAR),
			@Result(column = "MOBILE", property = "mobile", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ONLINE", property = "online", jdbcType = JdbcType.BIT),
			@Result(column = "EMAIL", property = "email", jdbcType = JdbcType.VARCHAR),
			@Result(column = "MARK", property = "mark", jdbcType = JdbcType.INTEGER),
			@Result(column = "MONEY", property = "money", jdbcType = JdbcType.INTEGER),
			@Result(column = "LOGIN_TIME", property = "loginTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "REG_TIME", property = "regTime", jdbcType = JdbcType.TIMESTAMP) })
	User selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	@UpdateProvider(type = UserSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") User record,
			@Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	@UpdateProvider(type = UserSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") User record,
			@Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	@UpdateProvider(type = UserSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	@Update({ "update user", "set `NAME` = #{name,jdbcType=VARCHAR},",
			"`PASSWORD` = #{password,jdbcType=CHAR},",
			"SESSIONID = #{sessionid,jdbcType=CHAR},",
			"MOBILE = #{mobile,jdbcType=VARCHAR},",
			"`ONLINE` = #{online,jdbcType=BIT},",
			"EMAIL = #{email,jdbcType=VARCHAR},",
			"MARK = #{mark,jdbcType=INTEGER},",
			"MONEY = #{money,jdbcType=INTEGER},",
			"LOGIN_TIME = #{loginTime,jdbcType=TIMESTAMP},",
			"REG_TIME = #{regTime,jdbcType=TIMESTAMP}",
			"where ID = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(User record);
}