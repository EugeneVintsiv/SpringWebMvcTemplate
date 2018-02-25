package com.knightsync.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="testentity")
public class TestEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String testEntityName;
	
	@Column(name="number")
	private int testEntityNumber;
	
	@Column(name="content")
	private String testEntityContent;

	public TestEntity() {
		
	}
	
	public TestEntity(String testEntityName, int testEntityNumber, String testEntityContent) {
		this.testEntityName = testEntityName;
		this.testEntityNumber = testEntityNumber;
		this.testEntityContent = testEntityContent;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestEntityName() {
		return testEntityName;
	}

	public void setTestEntityName(String testEntityName) {
		this.testEntityName = testEntityName;
	}

	public int getTestEntityNumber() {
		return testEntityNumber;
	}

	public void setTestEntityNumber(int testEntityNumber) {
		this.testEntityNumber = testEntityNumber;
	}

	public String getTestEntityContent() {
		return testEntityContent;
	}

	public void setTestEntityContent(String testEntityContent) {
		this.testEntityContent = testEntityContent;
	}

	@Override
	public String toString() {
		return "TestEntity [id=" + id + ", testEntityName=" + testEntityName + ", testEntityNumber=" + testEntityNumber
				+ ", testEntityContent=" + testEntityContent + "]";
	}
	
}
