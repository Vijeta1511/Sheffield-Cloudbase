package com.singlesignin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import javax.sql.DataSource;

abstract public class BaseDAO extends NamedParameterJdbcDaoSupport{
	
	/*
	 * Set the JDBC DataSource to be used by this DAO. 
	 * The DataSource which is to be used is configured in mvc-dispatcher-servlet.xml configuration file.
	 */
	
	@Autowired
	public void setDatasource2(DataSource ds) {
	
		super.setDataSource(ds);
		
	}
	
}