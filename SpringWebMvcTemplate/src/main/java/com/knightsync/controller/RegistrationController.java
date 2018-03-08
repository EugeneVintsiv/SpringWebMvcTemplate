package com.knightsync.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knightsync.user.TemplateUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserDetailsManager userDetailsManager;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model model) {
		model.addAttribute("templateUser", new TemplateUser());
		
		return "registration-page";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
			@Valid @ModelAttribute("templateUser") TemplateUser templateUser,
			BindingResult bindingResult,
			Model model) {
		
		String userName = templateUser.getUserName();
		
		logger.info("Processing registration form for: " + userName);
		
		//form validation
		if (bindingResult.hasErrors()) {
			model.addAttribute("templateUser", new TemplateUser());
			model.addAttribute("registrationError", "User name/ Password cannot be empty");
			
			return "registration-page";
		}
		//check database if user already exists
		boolean userExists = doesUserExist(userName);
		
		if(userExists) {
			model.addAttribute("templateUser", new TemplateUser());
			model.addAttribute("registrationError", "User already exists");
			
			logger.warning("User name already exists.");
			
			return "registration-page";
		}
		
		//encrypt the password
		String encodedPassword = passwordEncoder.encode(templateUser.getPassword());
		
		//prepend the coding algorithm id
		encodedPassword = "{bcrypt}" + encodedPassword;
		
		//give user the default role of employee
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
		
		//create user details object
		User tempUser = new User(userName, encodedPassword, authorities);
		
		//save user to database
		userDetailsManager.createUser(tempUser);
		
		logger.info("Successfully created user: " + userName);
		
		return "registration-confirmation";
	}
	
	private boolean doesUserExist(String userName) {
		//check the database if user exists
		boolean exists = userDetailsManager.userExists(userName);
		
		return exists;
	}
}
