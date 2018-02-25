package com.knightsync.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.knightsync.dao.TestEntityHibernateDao;
import com.knightsync.entity.TestEntity;

@Repository
public class TestEntityHibernateDaoImpl implements TestEntityHibernateDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TestEntity> getTestEntities() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<TestEntity> theQuery = currentSession.createQuery("from TestEntity", TestEntity.class);
		List<TestEntity> testEntity = theQuery.getResultList();
		
		return testEntity;
	}

	@Override
	public void saveTestEntity(TestEntity testEntity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(testEntity);
	}

	@Override
	public TestEntity getTestEntity(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		TestEntity testEntity = currentSession.get(TestEntity.class, id);
		
		return testEntity;
	}

	@Override
	public void deleteTestEntity(int id) {
		System.out.println("!! " + id);
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from TestEntity WHERE id=:testEntityId");
		theQuery.setParameter("testEntityId", id);
		
		theQuery.executeUpdate();
	}

}
