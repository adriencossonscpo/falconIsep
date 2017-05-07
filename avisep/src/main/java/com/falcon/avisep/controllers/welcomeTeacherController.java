package com.falcon.avisep.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falcon.avisep.repository.UserAvisRepository;
@Controller 
public class welcomeTeacherController {

    private final Logger log = LoggerFactory.getLogger(indexController.class);
    @Autowired  
    private final UserAvisRepository userAvisRepository;

    public welcomeTeacherController() {
		super();
		UserAvisRepository userAvisRepo = null;
		this.userAvisRepository=userAvisRepo;
	}
	public welcomeTeacherController(UserAvisRepository userAvisRepository) {
        this.userAvisRepository = userAvisRepository;
    }
    // Create and display forms
    @RequestMapping("/welcomeT")
	public String consultUsers3(Model model){
    	
		return "welcomeTeacher";
	}
    
}
