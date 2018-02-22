package com.knightsync.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.knightsync.entity.TestEntity;

public class TestEntityRowMapper implements RowMapper<TestEntity>{

	@Override
	public TestEntity mapRow(ResultSet rs, int rownum) throws SQLException {
		TestEntity testEntity = new TestEntity();
		testEntity.setId(rs.getInt("id"));
		testEntity.setTestEntityName(rs.getString("name"));
		testEntity.setTestEntityContent(rs.getString("content"));
		testEntity.setTestEntityNumber(rs.getInt("number"));
		
		return testEntity;
	}

	
}
