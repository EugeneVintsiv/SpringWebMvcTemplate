package com.knightsync.dao;

import java.util.List;

import com.knightsync.entity.TestEntity;

public interface TestEntityHibernateDao {

	public List<TestEntity> getTestEntities();
	
	public void saveTestEntity(TestEntity testEntity);
	
	public TestEntity getTestEntity(int id);
	
	public void deleteTestEntity(int id);
}
