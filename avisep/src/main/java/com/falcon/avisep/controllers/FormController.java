package com.falcon.avisep.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.falcon.avisep.service.UserService;
@Controller 
public class FormController {

    private final Logger log = LoggerFactory.getLogger(IndexController.class);
    
    // Create and display forms
    @RequestMapping("/createF")
	public String cForm(Model model){
		return "createForm";
	}
    //Create and display forms
    @RequestMapping("/answerF")
	public String ansForm(Model model){
		return "answerForm";
	}
    
}
