package com.falcon.avisep.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falcon.avisep.model.Form;
import com.falcon.avisep.model.UserAvis;
import com.falcon.avisep.repository.FormRepository;
import com.falcon.avisep.repository.QuestionRepository;
import com.falcon.avisep.repository.UserAvisRepository;
@Service
public class FormService {
	@Autowired
	private FormRepository formRepository;
	@Autowired
	UserAvisServiceImpl userAvisServiceImpl;
	@Autowired
	private UserAvisRepository userRepository;
	@Autowired
	private QuestionRepository question;
	public Long createForm(HttpServletRequest request,Form form){
		if(request.getSession().getAttribute("userLogged")!=null){
			UserAvis user=(UserAvis) request.getSession().getAttribute("userLogged");
			System.out.println("Debug "+user.getFirstName());
			form.basicSetUserAvis(user);
			//form.setUserAvis(user);
			Form f=formRepository.save(form);
			//String formId=Long.toString(f.getId());
			Long formIdLong=f.getId();
			user.addForm(formRepository.findOne(formIdLong));
			userRepository.flush();
			return formIdLong;
		}
		return null;
	}
}
