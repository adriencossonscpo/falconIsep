package com.falcon.avisep.controllers;


import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.falcon.avisep.model.Role;
import com.falcon.avisep.model.UserAvis;
/**
 * REST controller for managing UserAvis.
 */
@Controller 
public class IndexController {
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request){
		UserAvis user=((UserAvis )request.getSession().getAttribute("userLogged"));
		Role role= user.getRole();
		switch (role)
		{
		case ROLE_STUDENT:
			return "redirect:welcomeS";
		case ROLE_VTEACHER:
			return "redirect:welcomeT";
		case ROLE_ADMIN:
			return "redirect:welcomeA";
		case ROLE_VTEACHER_and_ETEACHER:
			return "redirect:welcomeT";
		default:
			return "index";
		}
	}
}
