package com.paymentMicroservice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.paymentMicroservice.domain.Application;
import com.paymentMicroservice.rm.ApplicationRowMapper;

@Repository
public class ApplicationDAOImpl extends BaseDAO implements ApplicationDAO {

	@Override
	public void save(Application a) {
		String sql = "INSERT INTO appliocation(name, userId)"
                + " VALUES(:name, :userId)";
		Map m = new HashMap();
		m.put("name", a.getName());
		m.put("userId", a.getUserId());		
		
		
		 KeyHolder kh = new GeneratedKeyHolder();
	        SqlParameterSource ps = new MapSqlParameterSource(m);
	        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
	        Integer app_id = kh.getKey().intValue();
	        a.setApp_id(app_id);
	}

	@Override
	public void update(Application a) {
		String sql = "UPDATE application SET name=:name, WHERE app_id=:app_id";
        Map m = new HashMap();
        m.put("name", a.getName());
        m.put("app_id", a.getApp_id());
        getNamedParameterJdbcTemplate().update(sql, m);		
	}

	@Override
	public void delete(Application a) {
		this.delete(a.getApp_id());
		
	}
	
	@Override
	public void delete(Integer app_id) {
		String sql="DELETE FROM application WHERE app_id=?";
        getJdbcTemplate().update(sql, app_id);		
	}

	@Override
	public Application findById(Integer app_id) {
		String sql = "SELECT app_id, userId, name FROM application WHERE app_id=?";
		Application a = getJdbcTemplate().queryForObject(sql, new ApplicationRowMapper(), app_id);
		return a;
	}

	@Override
	public List<Application> findByProperty(String propName, Object propValue) {
		String sql = "SELECT app_id, userId, name FROM application WHERE "+propName+"=?";
		return getJdbcTemplate().query(sql, new ApplicationRowMapper(), propValue);// TODO Auto-generated method stub
	}

	@Override
	public List<Application> findAll() {
		String sql = "SELECT app_id, userId, name FROM application";
		return getJdbcTemplate().query(sql, new ApplicationRowMapper());
		
	}

}
