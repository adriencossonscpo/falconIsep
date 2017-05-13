package com.falcon.avisep.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.falcon.avisep.ldap.LDAPAccess;
import com.falcon.avisep.ldap.LDAPObject;
import com.falcon.avisep.model.RoleAvis;
import com.falcon.avisep.model.Student;
import com.falcon.avisep.model.UserAvis;
import com.falcon.avisep.service.UserAvisServiceImpl;
import com.falcon.avisep.service.UserService;
@Controller 
public class LoginController  {

	private final Logger log = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private UserAvisServiceImpl userService;
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value= "login", method = RequestMethod.POST)
	public String login(Student user,@RequestParam("login") String login, @RequestParam("passwd") String passwd){
		user=userService.findByLogin(login);
		if(
				//(user.getLogin().equalsIgnoreCase(login) && user.getPasswd().equalsIgnoreCase(passwd))
				//&& 
				checkUser(login,passwd)
				){
			return "redirect:/index";
		}else{
			return "redirect:/login-error";
		}
	}
	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}
	public boolean checkUser(String login, String passwd)
	{
		LDAPAccess access = new LDAPAccess();
		try {
			//Enter login and password Here
			LDAPObject test = access.LDAPget(login, passwd);
			if (test == null)
			{
				System.out.println("login invalide");
				System.exit(1);
				return true;
			}

			System.out.println(test.toString()+ ""+test.mail);
			System.exit(0);
		} catch(Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
			return false;
		}
		return false;
	}

}