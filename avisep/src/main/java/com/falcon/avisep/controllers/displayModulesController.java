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
public class displayModulesController  {

    private final Logger log = LoggerFactory.getLogger(indexController.class);
    @Autowired  
    private final UserAvisRepository userAvisRepository;

    public displayModulesController() {
		super();
		UserAvisRepository userAvisRepo = null;
		this.userAvisRepository=userAvisRepo;
	}
	public displayModulesController(UserAvisRepository userAvisRepository) {
        this.userAvisRepository = userAvisRepository;
    }
    // Create and display forms
    @RequestMapping("/displayM")
	public String displayM(Model model){
		
		return "displayModules";
	}
    
}