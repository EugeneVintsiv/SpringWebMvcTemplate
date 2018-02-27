package com.knightsync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.knightsync.entity.TestEntity;
import com.knightsync.service.TestEntityHibernateService;
import com.knightsync.service.TestEntityService;

@Controller
@RequestMapping("/testentityhibernate")
public class TestEntityHibernateController {
	
	@Autowired
	private TestEntityHibernateService testEntityHibernateService;
	
	@GetMapping("/list")
	public String listTestEntities(Model model) {
		List<TestEntity> testEntities = testEntityHibernateService.getTestEntities();
		model.addAttribute("testEntities", testEntities);
		
		return "list-test-entities";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		TestEntity testEntity = new TestEntity();
		model.addAttribute("testEntity", testEntity);
		
		return "test-entity-form";
	}
	
	@PostMapping("/saveTestEntity")
	public String saveCustomer(@ModelAttribute("testEntity") TestEntity testEntity) {
		testEntityHibernateService.saveTestEntity(testEntity);
		
		return "redirect:/testentityhibernate/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("testEntityId") int id, Model model) {
		TestEntity testEntity = testEntityHibernateService.getTestEntity(id);
		model.addAttribute("testEntity", testEntity);
		
		return "test-entity-form";
	}
	
	@GetMapping("/delete")
	public String deleteTestEntity(@RequestParam("deleteTestEntity") int id) {
		testEntityHibernateService.deleteTestEntity(id);
		return "redirect:/testentityhibernate/list";
	}
}
