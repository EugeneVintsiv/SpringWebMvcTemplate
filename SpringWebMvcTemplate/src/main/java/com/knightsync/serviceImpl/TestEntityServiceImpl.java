package com.knightsync.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knightsync.dao.TestEntityDao;
import com.knightsync.entity.TestEntity;
import com.knightsync.service.TestEntityService;

@Service
public class TestEntityServiceImpl implements TestEntityService{
	
	@Autowired
	private TestEntityDao testEntityDao;

	@Override
	public List<TestEntity> getAllTestEntities() {
		return testEntityDao.getAllTestEntities();
	}

}
