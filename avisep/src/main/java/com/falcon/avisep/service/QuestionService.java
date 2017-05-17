package com.falcon.avisep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falcon.avisep.model.Question;
import com.falcon.avisep.repository.QuestionRepository;
@Service
public class QuestionService {
	@Autowired
	private QuestionRepository question;
	public List<Question> saveQuestion(List<Question> questions){
		return question.save(questions);
	}
}
