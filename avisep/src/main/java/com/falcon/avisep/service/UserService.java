package com.falcon.avisep.service;

import com.falcon.avisep.model.RoleAvis;
import com.falcon.avisep.model.Student;

public interface UserService {
	void save(Student user);
	Student findByLogin(String login, String passwd, RoleAvis role);
	Student findByLogin(String login, String passwd);
	Student findByLogin(String login);
}
