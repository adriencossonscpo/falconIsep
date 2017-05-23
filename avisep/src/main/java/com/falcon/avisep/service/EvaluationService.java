package com.falcon.avisep.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falcon.avisep.model.Cours;
import com.falcon.avisep.model.Evaluation;
import com.falcon.avisep.model.Question;
import com.falcon.avisep.model.UserAvis;
import com.falcon.avisep.repository.EvaluationRepository;
import com.falcon.avisep.util.utilMethod;

@Service
public class EvaluationService {
	@Autowired
	EvaluationRepository evaluationRepository;
	public void saveEvaluation(Cours cours) {
		List <Question> questions=utilMethod.toList(cours.getForm().getQuestion());
    	List <Evaluation> evaluations=new ArrayList<Evaluation>();
    	for(int i=0;i<questions.size();i++){
    		Evaluation evaluation=new Evaluation();
    		evaluation.setCours(cours);
    		String data=null;
			evaluation.setEData(data);
			UserAvis myUser = null;
			evaluation.setUser(myUser);
			questions.get(i).addEvaluation(evaluation);
    	}
    	evaluationRepository.save(evaluations);
	}
}
