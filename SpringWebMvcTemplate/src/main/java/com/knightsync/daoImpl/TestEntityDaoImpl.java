package com.knightsync.daoImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.knightsync.dao.TestEntityDao;
import com.knightsync.entity.TestEntity;

@Repository
public class TestEntityDaoImpl implements TestEntityDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public boolean create(TestEntity testEntity) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(testEntity);
		String sqlQuery = "INSERT INTO testentity (name, content, number)" + 
		"VALUES(:testEntityName, :testEntityContent, :testEntityNumber)";
		
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	@Override
	public TestEntity getTestEntity(Integer id) {
		SqlParameterSource params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT id, name, content, number FROM testentity WHERE id :ID";
		TestEntity testEntity = namedParameterJdbcTemplate.queryForObject(sqlQuery, params, new TestEntityRowMapper());
		
		return testEntity;
	}

	@Override
	public List<TestEntity> getAllTestEntities() {
		String sqlQuery = "SELECT * FROM testentity";
		List<TestEntity> testEntityList = namedParameterJdbcTemplate.query(sqlQuery, new TestEntityRowMapper());
		
		return testEntityList;
	}

	@Override
	public boolean delete(TestEntity testEntity) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(testEntity);
		String sqlQuery = "DELETE FROM testentity WHERE id = :id";
		
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	@Override
	public boolean update(TestEntity testEntity) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(testEntity);
		String sqlQuery = "UPDATE testentity SET content=:testEntityContent WHERE id=:id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	@Override
	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE testentity";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}

}
