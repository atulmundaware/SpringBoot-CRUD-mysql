package com.hrtm.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value="/abc")
	public String home(){
		return "hello";
	}
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	
}
