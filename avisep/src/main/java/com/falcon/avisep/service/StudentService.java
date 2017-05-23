package com.falcon.avisep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falcon.avisep.model.Cours;
import com.falcon.avisep.model.Evaluation;
import com.falcon.avisep.model.Module;
import com.falcon.avisep.model.UserAvis;
import com.falcon.avisep.repository.EvaluationRepository;
import com.falcon.avisep.repository.ModuleRepository;
import com.falcon.avisep.repository.UserAvisRepository;
import com.falcon.avisep.util.utilMethod;

@Service
public class StudentService {
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	UserAvisRepository userRepository;
	@Autowired
	EvaluationRepository evaluationRepository;
	public List<Cours> findAllCoursByIdModule(Long id){
		List<Cours> cours=utilMethod.toList(moduleRepository.getOne(id).getCours());
		for(int i=0;i<cours.size();i++){
			if(cours.get(i).getForm()==null){
				cours.remove(i);
			}
		}
		return cours;
	}
	public List<Module> findAllModulesByIdUser(Long id){
		UserAvis user=userRepository.getOne(id);
		List<Module> modules=utilMethod.toList(user.getModule());
		return modules;
	}
	public List<Module> findAllModulesWithForm(){
		List<Module> modules=utilMethod.toList(moduleRepository.findAll());
		for(int i=0;i<modules.size();i++){
			if(modules.get(i).getForm()==null){
				modules.remove(i);
			}
		}
		return modules;
	}
	public List<Evaluation> findAllEvaluationByUser(Long id){
		List<Evaluation> evaluations=utilMethod.toList(evaluationRepository.findAll());
		for(int i=0;i<evaluations.size();i++){
			if(evaluations.get(i).getUser().getId()!=id){
				evaluations.remove(i);
			}
		}
		return evaluations;
	}
}
