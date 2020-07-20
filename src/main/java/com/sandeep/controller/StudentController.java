package com.sandeep.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandeep.model.School;

@RestController
public class StudentController {
	
	
	
	@RequestMapping("/schools")
	public String getSchools() {

		String returnValue = null;
		try {
			System.out.println("Getting Schools");
			
			School school = new School();
			school.setId(1);
			school.setName("ISH");
			
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			returnValue = objectMapper.writeValueAsString(school);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnValue;
	}
	
	
	
	@PostMapping("/login")
	public void login(@RequestParam(value="user") String user, @RequestParam(value="pwd")String pwd, HttpServletResponse response) {
		
		System.out.println("Login called: User ="+user);
		System.out.println("Login called: Password ="+pwd);
		
		if ("admin".equals(user) && "admin".equals(pwd)) {
			
			System.out.println("successfully logged in");
			Cookie cookie = new Cookie("CookieId","1234567890");
			response.addCookie(cookie);
		}
	}
	
	
	@PostMapping("/tasks/complete")
	public void completeTask(@RequestParam(value="user") String user, @RequestParam(value="pwd")String pwd, HttpServletResponse response) {
		
	
	}

	

}
