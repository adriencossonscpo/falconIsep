package com.falcon.avisep.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller 
public class WelcomeStudentController {

    private final Logger log = LoggerFactory.getLogger(WelcomeStudentController.class);
    @RequestMapping("/welcomeS")
	public String consultStudent(){
		
		return "welcomeStudent";
	}
}