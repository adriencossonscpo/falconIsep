package com.falcon.avisep.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.falcon.avisep.model.Form;
import com.falcon.avisep.model.Question;
import com.falcon.avisep.service.FormService;
import com.falcon.avisep.service.QuestionService;
import com.falcon.avisep.util.utilMethod;
@Controller 
public class FormController {
	@Autowired
	FormService formService;
	
	private final Logger log = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	QuestionService questionService;
	// Create and display forms
	@RequestMapping("/createF")
	public String cForm(){


		return "createForm";
	}

	@RequestMapping(value= "createF", method = RequestMethod.POST)
	public  String cForm(HttpServletRequest request,@RequestBody Map<String, Object> jsonObjectBuilderForm, Model model){
		Form form=new Form();
		
		
		
		
		List<String> listS = utilMethod.takeListFromMap(jsonObjectBuilderForm);
		List<Question> questions = new ArrayList<Question>();
		for(int i=0;i<listS.size();i++){
			String[] qType=new String[2];
			List<String> listChamps=utilMethod.takeChamps(listS,i);
			Question e=new Question();
			for(int j=0;j<listChamps.size();j++){
				//System.out.println(listChamps.get(j));
				
				switch (j)
				{
				  case 0:
					  e.setQType(listChamps.get(j));
				    //System.out.println("Type :"+listChamps.get(j));
				    break;
				  case 1:
					  qType[0]=listChamps.get(j); 
				    //System.out.println("Title :"+listChamps.get(j));
				    break;
				  default:
					  qType[1]=listChamps.get(j);
				    //System.out.println("Options :"+listChamps.get(j));
				}
				
			}
			e.setqTitle(qType[0]);
			qType[1]=qType[1]!=null?qType[1]:"";
			e.setOptions(qType[1]);
			System.out.println(e.getqTitle()+" "+e.getOptions());
			questions.add(e);
		}
		Set<Question> q=new HashSet<Question>(questionService.saveQuestion(questions));
		form.addAllQuestion(q);
		String myFormTitle=null;
		form.setFormTitle(myFormTitle);
		Date myDateCreation =  new Date();
		form.setDateCreation(myDateCreation);
		formService.createForm(request, form);
		//model.addAttribute("form", form);
		//System.out.println(jsonObjectBuilderForm);
		//model.addAttribute("form", form);
		return "redirect:createForm";
	}
	//Create and display forms
	@RequestMapping("/answerF")
	public String ansForm(Model model){
		return "answerForm";
	}
}
//entry key 0: title
//Object value 0: Formulaire BDD
//entry key 1: questions
//Object value 1: [{type=text, title=O que é o amor ?}, {type=checkbox, title=Gostas dela ?, options=[Nao, Sim, Confuso]}, {type=yn, title=Diga apenas sim ou nao?}, {type=radio, title=Sabes dancar?, options=[Em minha casa, fora de casa]}]
//type=text, title=O que é o amor ?
//type=checkbox, title=Gostas dela ?, options=[Nao, Sim, Confuso]
//type=yn, title=Diga apenas sim ou nao?
//type=radio, title=Sabes dancar?, options=[Em minha casa, fora de casa]