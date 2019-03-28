package com.lnson.temp.lib.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lnson.temp.lib.dao.BaseDao;
import com.lnson.temp.lib.service.BaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseServiceImpl<TEntity> implements BaseService<TEntity> {

	protected static Logger logger = LogManager.getLogger();

	@Autowired
	private BaseDao<TEntity> baseDao;

	@Override
	public String getSqlStatement(String sqlId, TEntity object) {
		return baseDao.getSqlStatement(sqlId, object);
	}

	/**
	 * 被SUPPORTS标记的业务方法，如果在有事务处理的方法中被调用，也会作为事务的一部分被执行；
	 * 如果在未使用事务的方法中被调用，那么被SUPPORTS标记的业务方法也会在没有事务的环境中执行。
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public void insertObject(TEntity object) {
		logger.debug("insert parameter：" + JSON.toJSONString(object, SerializerFeature.WRITE_MAP_NULL_FEATURES,
				SerializerFeature.QuoteFieldNames));
		baseDao.insertObject(this.insertSqlId, object);
	}

	@Override
	public TEntity queryForObject(Object primaryKey) {
		logger.debug("query parameter：" + primaryKey);
		return baseDao.queryForObject(this.querySqlId, primaryKey);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public void updateObject(TEntity object) {
		logger.debug("update parameter：" + JSON.toJSONString(object, SerializerFeature.WRITE_MAP_NULL_FEATURES,
				SerializerFeature.QuoteFieldNames));
		baseDao.updateObject(this.updateSqlId, object);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public void deleteObject(Object primaryKey) {
		logger.debug("delete parameter：" + primaryKey);
		baseDao.deleteObject(this.deleteSqlId, primaryKey);
	}

	/**
	 * 插入语句的sql标识
	 */
	private String insertSqlId;
	/**
	 * 查询语句的sql标识
	 */
	private String querySqlId;
	/**
	 * 更新语句的sql标识
	 */
	private String updateSqlId;
	/**
	 * 删除语句的sql标识
	 */
	private String deleteSqlId;

	protected void setInsertSqlId(String insertSqlId) {
		this.insertSqlId = insertSqlId;
	}

	protected void setQuerySqlId(String querySqlId) {
		this.querySqlId = querySqlId;
	}

	protected void setUpdateSqlId(String updateSqlId) {
		this.updateSqlId = updateSqlId;
	}

	protected void setDeleteSqlId(String deleteSqlId) {
		this.deleteSqlId = deleteSqlId;
	}

}
