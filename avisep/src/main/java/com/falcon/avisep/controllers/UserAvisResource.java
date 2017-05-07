package com.falcon.avisep.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.falcon.avisep.model.UserAvis;
import com.falcon.avisep.repository.UserAvisRepository;
/**
 * REST controller for managing UserAvis.
 */
@Controller
public class UserAvisResource {

    private final Logger log = LoggerFactory.getLogger(UserAvisResource.class);
    @Autowired  
    private final UserAvisRepository userAvisRepository;

    public UserAvisResource() {
		super();
		UserAvisRepository userAvisRepo = null;
		this.userAvisRepository=userAvisRepo;
	}
	public UserAvisResource(UserAvisRepository userAvisRepository) {
        this.userAvisRepository = userAvisRepository;
    }
    @RequestMapping("/")
	public String index(){
		return "index";
	}
    
    // Some Mapping to navigate in the pages of the app
    // Student main page after being connected
    @RequestMapping("welcomeStudent")
	public String consultUsers(Model model){
    	Iterable<UserAvis> userAvis = null;
		if(userAvisRepository.findAll()!=null){
			userAvis = userAvisRepository.findAll();
			model.addAttribute("userAvis", userAvis);
		}else {model.addAttribute("userAvis", null);}
		
		return "welcomeStudent";
	}
    // Teacher main page after being connected
    @RequestMapping("welcomeTeacher")
	public String consultUsers1(Model model){
    	Iterable<UserAvis> userAvis = null;
		if(userAvisRepository.findAll()!=null){
			userAvis = userAvisRepository.findAll();
			model.addAttribute("userAvis", userAvis);
		}else {model.addAttribute("userAvis", null);}
		
		return "welcomeTeacher";
	}
    // Admin main page after being connected
    @RequestMapping("welcomeAdmin")
	public String consultUsers2(Model model){
    	Iterable<UserAvis> userAvis = null;
		if(userAvisRepository.findAll()!=null){
			userAvis = userAvisRepository.findAll();
			model.addAttribute("userAvis", userAvis);
		}else {model.addAttribute("userAvis", null);}
		
		return "welcomeAdmin";
	}
    // Create and display forms
    @RequestMapping("createForm")
	public String consultUsers3(Model model){
    	Iterable<UserAvis> userAvis = null;
		if(userAvisRepository.findAll()!=null){
			userAvis = userAvisRepository.findAll();
			model.addAttribute("userAvis", userAvis);
		}else {model.addAttribute("userAvis", null);}
		
		return "createForm";
	}
    // Display the form to answer
    @RequestMapping("answerForm")
	public String consultUsers4(Model model){
    	Iterable<UserAvis> userAvis = null;
		if(userAvisRepository.findAll()!=null){
			userAvis = userAvisRepository.findAll();
			model.addAttribute("userAvis", userAvis);
		}else {model.addAttribute("userAvis", null);}
		
		return "answerForm";
	}	
    // Create and display new users
    @RequestMapping("displayUser")
	public String consultUsers5(Model model){
    	Iterable<UserAvis> userAvis = null;
		if(userAvisRepository.findAll()!=null){
			userAvis = userAvisRepository.findAll();
			model.addAttribute("userAvis", userAvis);
		}else {model.addAttribute("userAvis", null);}
		
		return "displayUser";
	}
    
	// Creating some users
	@RequestMapping(value = "saveUserAvis", method = RequestMethod.POST )
	public String saveUser(@RequestParam("firstN") String firstN, @RequestParam("lastN")String lastN, 
			@RequestParam("login") String login,@RequestParam("email") String email,@RequestParam("password") String password, Model model){
		
		com.falcon.avisep.model.RoleAvis roleAvis=com.falcon.avisep.model.RoleAvis.AdminAvis;
		UserAvis userAvis =new UserAvis();
		//login,firstN,email, password,roleAvis,
		userAvis.setLogin(login);
		userAvis.setFirstName(firstN);
		userAvis.setEmail(email);
		userAvis.setPasswd(password);
		userAvis.addRoleAvis(roleAvis);
		userAvisRepository.saveAndFlush(userAvis);
		//new EmailService().enviar(nome, email);
		
		Iterable<UserAvis> userAvis1 = userAvisRepository.findAll();
		
		model.addAttribute("userAvis", userAvis1);
		
		return "displayUser";
	}
}
