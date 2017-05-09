package com.falcon.avisep.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falcon.avisep.model.UserAvis;
import com.falcon.avisep.model.Module;
import com.falcon.avisep.repository.ModuleRepository;
@Controller 
public class displayModulesController  {

    private final Logger log = LoggerFactory.getLogger(indexController.class);
    @Autowired  
    private final ModuleRepository ModuleRepository;

    public displayModulesController() {
		super();
		ModuleRepository moduleRepo = null;
		this.ModuleRepository=moduleRepo;
	}
	public displayModulesController(ModuleRepository ModuleRepository) {
        this.ModuleRepository = ModuleRepository;
    }
    // Create and display forms
    @RequestMapping("/displayM")
	public String displayM(Model model){
    	
    	Iterable<Module> module1 = ModuleRepository.findAll();
 		
 		model.addAttribute("module", module1);
    	
		return "displayModules";
	}
    
}