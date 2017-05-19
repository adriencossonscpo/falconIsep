package com.falcon.avisep.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.falcon.avisep.model.Cours;
import com.falcon.avisep.model.ETeacher;
import com.falcon.avisep.model.Module;
import com.falcon.avisep.model.Role;
import com.falcon.avisep.model.UserAvis;
import com.falcon.avisep.model.VTeacher;
import com.falcon.avisep.service.ModuleService;
import com.falcon.avisep.util.utilMethod;
@Controller 
public class WelcomeTeacherController {
	@Autowired
	private ModuleService moduleService;
    private final Logger log = LoggerFactory.getLogger(WelcomeTeacherController.class);
    @RequestMapping("/welcomeT")
	public String consultUsers3(Model model){
    	
		return "welcomeTeacher";
	}
    @RequestMapping("/welcomeT/{id}")
	public String displayModule(HttpServletRequest request,@PathVariable("id") Long id,Model model){
    	List<Module> myListModules=moduleService.findAllModulesByIdUser(id);
    	List<List<Cours>> myListCours=new ArrayList<>();
    	List<Cours> finalListCours=new ArrayList<>();
    	for(int i=0;i<myListModules.size();i++){
    		myListCours.add(utilMethod.toList(myListModules.get(i).getCours()));
    	}
    	for(int i=0;i<myListCours.size();i++){
    		for(int j=0;j<myListCours.get(i).size();j++){
    			finalListCours.add(myListCours.get(i).get(j));
    		}
    	}
    	if(((UserAvis) request.getSession().getAttribute("userLogged")).getRole().iterator().next().name().equalsIgnoreCase(Role.ROLE_VTEACHER.name())){
    		VTeacher user=(VTeacher) request.getSession().getAttribute("userLogged");
    		
    		model.addAttribute("finalListCours", finalListCours);
    		model.addAttribute("listModules", myListModules);
    		return "welcomeTeacher";
    	}else{
    		ETeacher user=(ETeacher) request.getSession().getAttribute("userLogged");
    		
    		model.addAttribute("finalListCours", myListCours);
    		model.addAttribute("listModules", myListModules);
    		return "welcomeTeacher";
    	}
    	
    	
    			
	}
}
