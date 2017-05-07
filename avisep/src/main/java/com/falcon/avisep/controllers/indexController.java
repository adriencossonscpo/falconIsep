package com.falcon.avisep.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.falcon.avisep.repository.UserAvisRepository;
/**
 * REST controller for managing UserAvis.
 */
@Controller 
@RequestMapping("/")
public class indexController {

    @Autowired  
    private final UserAvisRepository userAvisRepository;

    public indexController() {
		super();
		UserAvisRepository userAvisRepo = null;
		this.userAvisRepository=userAvisRepo;
	}
	public indexController(UserAvisRepository userAvisRepository) {
        this.userAvisRepository = userAvisRepository;
    }
    @RequestMapping("/")
	public String index(){
		return "index";
	}
    
    
//    // Create and display new users
//    @RequestMapping("displayModules")
//	public String consultUsers6(Model model){
//    	Iterable<UserAvis> userAvis = null;
//		if(userAvisRepository.findAll()!=null){
//			userAvis = userAvisRepository.findAll();
//			model.addAttribute("userAvis", userAvis);
//		}else {model.addAttribute("userAvis", null);}
//		
//		return "displayModules";
//	}
    
}
