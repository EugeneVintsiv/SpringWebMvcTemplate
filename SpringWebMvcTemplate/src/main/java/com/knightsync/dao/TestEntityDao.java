package com.knightsync.dao;

import java.util.List;

import javax.sql.DataSource;

import com.knightsync.entity.TestEntity;

public interface TestEntityDao {

	// Set the data-source that will be required to create a connection to the database
	public void setDataSource(DataSource ds);
	
	// Create a record of the TestEntity table
	public boolean create(TestEntity testEntity);
	
	// Retrieve a single TestEntity
	public TestEntity getTestEntity(Integer id);
	
	// Retrieve all TestEntity
	public List<TestEntity> getAllTestEntities();
	
	// Delete a specific TestEntity from the table
	public boolean delete(TestEntity testEntity);
	
	// Update an existing TestEntity
	public boolean update(TestEntity testEntity);
	
	public void cleanup();
}
