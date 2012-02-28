package com.pjxy.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated
	 */
	protected int limitStart = -1;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated
	 */
	protected int limitEnd = -1;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public UserExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public int getLimitStart() {
		return limitStart;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public void setLimitEnd(int limitEnd) {
		this.limitEnd = limitEnd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated
	 */
	public int getLimitEnd() {
		return limitEnd;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user
	 * @mbggenerated
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("`NAME` is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("`NAME` is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("`NAME` =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("`NAME` <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("`NAME` >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("`NAME` >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("`NAME` <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("`NAME` <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("`NAME` like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("`NAME` not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("`NAME` in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("`NAME` not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("`NAME` between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("`NAME` not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("`PASSWORD` is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("`PASSWORD` is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("`PASSWORD` =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("`PASSWORD` <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("`PASSWORD` >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("`PASSWORD` >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("`PASSWORD` <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("`PASSWORD` <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("`PASSWORD` like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("`PASSWORD` not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("`PASSWORD` in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("`PASSWORD` not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("`PASSWORD` between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("`PASSWORD` not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andSessionidIsNull() {
			addCriterion("SESSIONID is null");
			return (Criteria) this;
		}

		public Criteria andSessionidIsNotNull() {
			addCriterion("SESSIONID is not null");
			return (Criteria) this;
		}

		public Criteria andSessionidEqualTo(String value) {
			addCriterion("SESSIONID =", value, "sessionid");
			return (Criteria) this;
		}

		public Criteria andSessionidNotEqualTo(String value) {
			addCriterion("SESSIONID <>", value, "sessionid");
			return (Criteria) this;
		}

		public Criteria andSessionidGreaterThan(String value) {
			addCriterion("SESSIONID >", value, "sessionid");
			return (Criteria) this;
		}

		public Criteria andSessionidGreaterThanOrEqualTo(String value) {
			addCriterion("SESSIONID >=", value, "sessionid");
			return (Criteria) this;
		}

		public Criteria andSessionidLessThan(String value) {
			addCriterion("SESSIONID <", value, "sessionid");
			return (Criteria) this;
		}

		public Criteria andSessionidLessThanOrEqualTo(String value) {
			addCriterion("SESSIONID <=", value, "sessionid");
			return (Criteria) this;
		}

		public Criteria andSessionidLike(String value) {
			addCriterion("SESSIONID like", value, "sessionid");
			return (Criteria) this;
		}

		public Criteria andSessionidNotLike(String value) {
			addCriterion("SESSIONID not like", value, "sessionid");
			return (Criteria) this;
		}

		public Criteria andSessionidIn(List<String> values) {
			addCriterion("SESSIONID in", values, "sessionid");
			return (Criteria) this;
		}

		public Criteria andSessionidNotIn(List<String> values) {
			addCriterion("SESSIONID not in", values, "sessionid");
			return (Criteria) this;
		}

		public Criteria andSessionidBetween(String value1, String value2) {
			addCriterion("SESSIONID between", value1, value2, "sessionid");
			return (Criteria) this;
		}

		public Criteria andSessionidNotBetween(String value1, String value2) {
			addCriterion("SESSIONID not between", value1, value2, "sessionid");
			return (Criteria) this;
		}

		public Criteria andMobileIsNull() {
			addCriterion("MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andMobileIsNotNull() {
			addCriterion("MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andMobileEqualTo(String value) {
			addCriterion("MOBILE =", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotEqualTo(String value) {
			addCriterion("MOBILE <>", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThan(String value) {
			addCriterion("MOBILE >", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThanOrEqualTo(String value) {
			addCriterion("MOBILE >=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThan(String value) {
			addCriterion("MOBILE <", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThanOrEqualTo(String value) {
			addCriterion("MOBILE <=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLike(String value) {
			addCriterion("MOBILE like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotLike(String value) {
			addCriterion("MOBILE not like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileIn(List<String> values) {
			addCriterion("MOBILE in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotIn(List<String> values) {
			addCriterion("MOBILE not in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileBetween(String value1, String value2) {
			addCriterion("MOBILE between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotBetween(String value1, String value2) {
			addCriterion("MOBILE not between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andOnlineIsNull() {
			addCriterion("`ONLINE` is null");
			return (Criteria) this;
		}

		public Criteria andOnlineIsNotNull() {
			addCriterion("`ONLINE` is not null");
			return (Criteria) this;
		}

		public Criteria andOnlineEqualTo(Boolean value) {
			addCriterion("`ONLINE` =", value, "online");
			return (Criteria) this;
		}

		public Criteria andOnlineNotEqualTo(Boolean value) {
			addCriterion("`ONLINE` <>", value, "online");
			return (Criteria) this;
		}

		public Criteria andOnlineGreaterThan(Boolean value) {
			addCriterion("`ONLINE` >", value, "online");
			return (Criteria) this;
		}

		public Criteria andOnlineGreaterThanOrEqualTo(Boolean value) {
			addCriterion("`ONLINE` >=", value, "online");
			return (Criteria) this;
		}

		public Criteria andOnlineLessThan(Boolean value) {
			addCriterion("`ONLINE` <", value, "online");
			return (Criteria) this;
		}

		public Criteria andOnlineLessThanOrEqualTo(Boolean value) {
			addCriterion("`ONLINE` <=", value, "online");
			return (Criteria) this;
		}

		public Criteria andOnlineIn(List<Boolean> values) {
			addCriterion("`ONLINE` in", values, "online");
			return (Criteria) this;
		}

		public Criteria andOnlineNotIn(List<Boolean> values) {
			addCriterion("`ONLINE` not in", values, "online");
			return (Criteria) this;
		}

		public Criteria andOnlineBetween(Boolean value1, Boolean value2) {
			addCriterion("`ONLINE` between", value1, value2, "online");
			return (Criteria) this;
		}

		public Criteria andOnlineNotBetween(Boolean value1, Boolean value2) {
			addCriterion("`ONLINE` not between", value1, value2, "online");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("EMAIL is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("EMAIL is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("EMAIL =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("EMAIL <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("EMAIL >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("EMAIL >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("EMAIL <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("EMAIL <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("EMAIL like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("EMAIL not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("EMAIL in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("EMAIL not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("EMAIL between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("EMAIL not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andMarkIsNull() {
			addCriterion("MARK is null");
			return (Criteria) this;
		}

		public Criteria andMarkIsNotNull() {
			addCriterion("MARK is not null");
			return (Criteria) this;
		}

		public Criteria andMarkEqualTo(Integer value) {
			addCriterion("MARK =", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotEqualTo(Integer value) {
			addCriterion("MARK <>", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkGreaterThan(Integer value) {
			addCriterion("MARK >", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkGreaterThanOrEqualTo(Integer value) {
			addCriterion("MARK >=", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkLessThan(Integer value) {
			addCriterion("MARK <", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkLessThanOrEqualTo(Integer value) {
			addCriterion("MARK <=", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkIn(List<Integer> values) {
			addCriterion("MARK in", values, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotIn(List<Integer> values) {
			addCriterion("MARK not in", values, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkBetween(Integer value1, Integer value2) {
			addCriterion("MARK between", value1, value2, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotBetween(Integer value1, Integer value2) {
			addCriterion("MARK not between", value1, value2, "mark");
			return (Criteria) this;
		}

		public Criteria andMoneyIsNull() {
			addCriterion("MONEY is null");
			return (Criteria) this;
		}

		public Criteria andMoneyIsNotNull() {
			addCriterion("MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andMoneyEqualTo(Integer value) {
			addCriterion("MONEY =", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotEqualTo(Integer value) {
			addCriterion("MONEY <>", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThan(Integer value) {
			addCriterion("MONEY >", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThanOrEqualTo(Integer value) {
			addCriterion("MONEY >=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThan(Integer value) {
			addCriterion("MONEY <", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThanOrEqualTo(Integer value) {
			addCriterion("MONEY <=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyIn(List<Integer> values) {
			addCriterion("MONEY in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotIn(List<Integer> values) {
			addCriterion("MONEY not in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyBetween(Integer value1, Integer value2) {
			addCriterion("MONEY between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotBetween(Integer value1, Integer value2) {
			addCriterion("MONEY not between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andLoginTimeIsNull() {
			addCriterion("LOGIN_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLoginTimeIsNotNull() {
			addCriterion("LOGIN_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLoginTimeEqualTo(Date value) {
			addCriterion("LOGIN_TIME =", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeNotEqualTo(Date value) {
			addCriterion("LOGIN_TIME <>", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeGreaterThan(Date value) {
			addCriterion("LOGIN_TIME >", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LOGIN_TIME >=", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeLessThan(Date value) {
			addCriterion("LOGIN_TIME <", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
			addCriterion("LOGIN_TIME <=", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeIn(List<Date> values) {
			addCriterion("LOGIN_TIME in", values, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeNotIn(List<Date> values) {
			addCriterion("LOGIN_TIME not in", values, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeBetween(Date value1, Date value2) {
			addCriterion("LOGIN_TIME between", value1, value2, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
			addCriterion("LOGIN_TIME not between", value1, value2, "loginTime");
			return (Criteria) this;
		}

		public Criteria andRegTimeIsNull() {
			addCriterion("REG_TIME is null");
			return (Criteria) this;
		}

		public Criteria andRegTimeIsNotNull() {
			addCriterion("REG_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andRegTimeEqualTo(Date value) {
			addCriterion("REG_TIME =", value, "regTime");
			return (Criteria) this;
		}

		public Criteria andRegTimeNotEqualTo(Date value) {
			addCriterion("REG_TIME <>", value, "regTime");
			return (Criteria) this;
		}

		public Criteria andRegTimeGreaterThan(Date value) {
			addCriterion("REG_TIME >", value, "regTime");
			return (Criteria) this;
		}

		public Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("REG_TIME >=", value, "regTime");
			return (Criteria) this;
		}

		public Criteria andRegTimeLessThan(Date value) {
			addCriterion("REG_TIME <", value, "regTime");
			return (Criteria) this;
		}

		public Criteria andRegTimeLessThanOrEqualTo(Date value) {
			addCriterion("REG_TIME <=", value, "regTime");
			return (Criteria) this;
		}

		public Criteria andRegTimeIn(List<Date> values) {
			addCriterion("REG_TIME in", values, "regTime");
			return (Criteria) this;
		}

		public Criteria andRegTimeNotIn(List<Date> values) {
			addCriterion("REG_TIME not in", values, "regTime");
			return (Criteria) this;
		}

		public Criteria andRegTimeBetween(Date value1, Date value2) {
			addCriterion("REG_TIME between", value1, value2, "regTime");
			return (Criteria) this;
		}

		public Criteria andRegTimeNotBetween(Date value1, Date value2) {
			addCriterion("REG_TIME not between", value1, value2, "regTime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user
	 * @mbggenerated
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}