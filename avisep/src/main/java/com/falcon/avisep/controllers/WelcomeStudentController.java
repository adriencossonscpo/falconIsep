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
import com.falcon.avisep.model.Evaluation;
import com.falcon.avisep.model.Form;
import com.falcon.avisep.model.ModelViewAnsForm;
import com.falcon.avisep.model.Module;
import com.falcon.avisep.model.Question;
import com.falcon.avisep.model.UserAvis;
import com.falcon.avisep.service.CoursService;
import com.falcon.avisep.service.EvaluationService;
import com.falcon.avisep.service.StudentService;
import com.falcon.avisep.util.utilMethod;
@Controller 
public class WelcomeStudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	EvaluationService evaluationService;
	@Autowired
	CoursService coursService;
    private final Logger log = LoggerFactory.getLogger(WelcomeStudentController.class);
    @RequestMapping("/welcomeS")
	public String consultStudent(HttpServletRequest request,Model model){
    	
    	Long id=((UserAvis )request.getSession().getAttribute("userLogged")).getId();
    	List<Module> myListModulesByIdUser=studentService.findAllModulesByIdUser(id);
    	List<Evaluation> evaluations=studentService.findAllEvaluationByUser(id);
    	
    	List<Module> myListModules=studentService.findAllModulesWithForm();
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
    		model.addAttribute("myListModulesByIdUser", myListModulesByIdUser);
    		model.addAttribute("finalListCours", finalListCours);
    		model.addAttribute("evaluations", evaluations);
		return "welcomeStudent";
	}
    @RequestMapping("/welcomeS/answerF/{id}/{decription}")
	public String ansForm(Model model,@PathVariable("id") Long id,@PathVariable("decription") String description){
    	Cours cours=coursService.findACours(id);
    	Form forms=cours.getForm();
    	List<Question> question=utilMethod.toList(forms.getQuestion());
    	ModelViewAnsForm modelViewAnsForm=new ModelViewAnsForm(cours,forms, question,forms.getFormTitle());
    	for(int i=0;i<modelViewAnsForm.getOptions().size();i++){
    		System.out.println(modelViewAnsForm.getOptions().get(i));
    	}
    	
    	
    	model.addAttribute("modelViewAnsForm", modelViewAnsForm);
    	model.addAttribute("id", id);
    	model.addAttribute("description", description);
    	return "answerForm";
	}
    @RequestMapping("/welcomeS/sendEvaluation/{id}")
	public String saveEvaluation(Model model,@PathVariable("id") Long id){
    	System.out.println("/welcomeS/sendEvaluation/"+id);
    	Evaluation evaluation=new Evaluation();
    	Cours cours=coursService.findACours(id);
    	evaluationService.saveEvaluation(cours);
		
    	model.addAttribute("id", id);
    	return "answerForm";
	}
	
}