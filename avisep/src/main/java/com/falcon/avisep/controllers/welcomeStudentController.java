package com.falcon.avisep.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.falcon.avisep.repository.UserAvisRepository;
@Controller 
public class welcomeStudentController {

    private final Logger log = LoggerFactory.getLogger(indexController.class);
    @Autowired  
    private final UserAvisRepository userAvisRepository;

    public welcomeStudentController() {
		super();
		UserAvisRepository userAvisRepo = null;
		this.userAvisRepository=userAvisRepo;
	}
	public welcomeStudentController(UserAvisRepository userAvisRepository) {
        this.userAvisRepository = userAvisRepository;
    }
    @RequestMapping("/welcomeS")
	public String consultStudent(){
		
		return "welcomeStudent";
	}
}