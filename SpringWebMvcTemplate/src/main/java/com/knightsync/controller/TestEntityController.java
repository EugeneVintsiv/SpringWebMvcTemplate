package com.knightsync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knightsync.entity.TestEntity;
import com.knightsync.service.TestEntityService;

@Controller
public class TestEntityController {

	@Autowired
	TestEntityService testEntityService;
	
	@RequestMapping("/testentitylist")
	public String showTestEntityList(Model model) {
		List<TestEntity> testEntityList = testEntityService.getAllTestEntities();
		model.addAttribute("testEntityList", testEntityList);
		
		return "test-entity-display";
	}
}
