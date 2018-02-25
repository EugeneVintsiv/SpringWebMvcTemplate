package com.knightsync.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.knightsync.dao.TestEntityDao;
import com.knightsync.dao.TestEntityHibernateDao;
import com.knightsync.entity.TestEntity;
import com.knightsync.service.TestEntityHibernateService;

@Service
public class TestEntityHibernateServiceImpl implements TestEntityHibernateService{
	
	@Autowired
	TestEntityHibernateDao testEntityHibernateDao;

	@Override
	@Transactional
	public List<TestEntity> getTestEntities() {
		return testEntityHibernateDao.getTestEntities();
	}

	@Override
	@Transactional
	public void saveTestEntity(TestEntity testEntity) {
		testEntityHibernateDao.saveTestEntity(testEntity);
	}

	@Override
	@Transactional
	public TestEntity getTestEntity(int id) {
		return testEntityHibernateDao.getTestEntity(id);
	}

	@Override
	@Transactional
	public void deleteTestEntity(int id) {
		testEntityHibernateDao.deleteTestEntity(id);		
	}

}
