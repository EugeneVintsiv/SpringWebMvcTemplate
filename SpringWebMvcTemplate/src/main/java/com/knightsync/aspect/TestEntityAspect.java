package com.knightsync.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestEntityAspect {
	
	@Before("execution(public java.util.List<com.knightsync.entity.TestEntity> getTestEntities())")
	public void beforeGetTestEntities(){
		System.out.println("Gathering a list of Test Entities from the Database.");
		
	}
	
	@Before("execution(public void saveTestEntity(com.knightsync.entity.TestEntity))")
	public void beforeSaveTestEntity() {
		System.out.println("Saving test entity");
	}
	
	@Before("execution(public com.knightsync.entity.TestEntity getTestEntity(int))")
	public void beforeGetTestEntity() {
		System.out.println("Retrieving a single Test Entity");
	}
	
	@Before("execution(public void deleteTestEntity(int))")
	public void beforeDeleteTestEntity() {
		System.out.println("Deleting an entity");
	}
}
