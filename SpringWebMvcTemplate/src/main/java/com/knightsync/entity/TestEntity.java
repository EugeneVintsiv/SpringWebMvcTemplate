package com.knightsync.entity;

public class TestEntity {
	
	private int id;
	private String testEntityName;
	private int testEntityNumber;
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
