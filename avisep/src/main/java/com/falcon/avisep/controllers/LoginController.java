package com.falcon.avisep.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.falcon.avisep.model.Admin;
import com.falcon.avisep.model.ETeacher;
import com.falcon.avisep.model.Role;
import com.falcon.avisep.model.Student;
import com.falcon.avisep.model.VTeacher;
import com.falcon.avisep.service.UserAvisServiceImpl;
import com.falcon.avisep.util.utilMethod;
@Controller 
public class LoginController  {

	private final Logger log = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private UserAvisServiceImpl userService;
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }
	@RequestMapping(value= "login", method = RequestMethod.POST)
	public String login(HttpSession session,@RequestParam("login") String login, @RequestParam("passwd") String passwd){

		if(userService.userExist(login)>0){
			
			List<Role> roles=utilMethod.toList(userService.findByLogin(login).getRole());
			System.out.println(roles.get(0)+" "+login+" "+passwd);
			if(roles.get(0).name().equalsIgnoreCase(Role.ROLE_STUDENT.name())){
				Student userLog=(Student) userService.findByLogin(login);
				if((userLog.getLogin().equalsIgnoreCase(login) && 
						userLog.getPasswd().equalsIgnoreCase(passwd)))
					//&& 
					//checkUser(login,passwd))
				{
					session.setAttribute("userLogged", userLog);
					return "redirect:/index";
				}
				else{
					return "redirect:/login-error";
				}
			}else if(roles.get(0).name().equalsIgnoreCase(Role.ROLE_VTEACHER.name())){
				VTeacher userLog=(VTeacher) userService.findByLogin(login);
				if((userLog.getLogin().equalsIgnoreCase(login) && 
						userLog.getPasswd().equalsIgnoreCase(passwd)))
					//&& 
					//checkUser(login,passwd))
				{
					session.setAttribute("userLogged", userLog);
					return "redirect:/index";
				}
				else{
					return "redirect:/login-error";
				}
			}else if(roles.get(0).name().equalsIgnoreCase(Role.ROLE_ETEACHER.name())){
				ETeacher userLog=(ETeacher) userService.findByLogin(login);
				if((userLog.getLogin().equalsIgnoreCase(login) && 
						userLog.getPasswd().equalsIgnoreCase(passwd)))
					//&& 
					//checkUser(login,passwd))
				{
					session.setAttribute("userLogged", userLog);
					return "redirect:/index";
				}
				else{
					return "redirect:/login-error";
				}
			}else if(roles.get(0).name().equalsIgnoreCase(Role.ROLE_ADMIN.name())){
				Admin userLog=(Admin) userService.findByLogin(login);
				if((userLog.getLogin().equalsIgnoreCase(login) && 
						userLog.getPasswd().equalsIgnoreCase(passwd)))
					//&& 
					//checkUser(login,passwd))
				{
					session.setAttribute("userLogged", userLog);
					return "redirect:/index";
				}
				else{
					return "redirect:/login-error";
				}
			}
		}
		return null;
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
			LDAPObject test = access.LDAPget("spedro", "Simaopedro0903@gmail.com1992");
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