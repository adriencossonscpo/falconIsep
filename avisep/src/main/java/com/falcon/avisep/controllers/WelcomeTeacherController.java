package com.falcon.avisep.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller 
public class WelcomeTeacherController {

    private final Logger log = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping("/welcomeT")
	public String consultUsers3(Model model){
    	
		return "welcomeTeacher";
	}
    
}
