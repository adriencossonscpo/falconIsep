package com.falcon.avisep.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.falcon.avisep.model.RoleAvis;
import com.falcon.avisep.model.Student;
import com.falcon.avisep.repository.UserAvisRepository;

/**
 * REST controller for managing UserAvis.
 */
@Service
public class UserAvisServiceImpl implements UserService{
	@Autowired
	private UserAvisRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public void save(Student user) {
		user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
		//user.addRoleAvis(RoleAvis.ROLE_STUDENT);
		userRepository.save(user);
	}
	@Override
	public Student findByLogin(String login, String passwd,RoleAvis role) {
		return  userRepository.findByLogin(login,passwd,role);
	}
	@Override
	public Student findByLogin(String login, String passwd) {
		return  userRepository.findByLogin(login,passwd);
	}
	@Override
	public Student findByLogin(String login) {
		return userRepository.findByLogin(login);
	}
}
