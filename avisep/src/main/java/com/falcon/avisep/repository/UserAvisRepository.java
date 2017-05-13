package com.falcon.avisep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falcon.avisep.model.RoleAvis;
import com.falcon.avisep.model.Student;
import com.falcon.avisep.model.UserAvis;

/**
 * Spring Data JPA repository for the UserAvis entity.
 */
@Repository
public interface UserAvisRepository extends JpaRepository<UserAvis,Long> {
	Student findByLogin(String login,String passwd,RoleAvis role);
	Student findByLogin(String login,String passwd);
	Student findByLogin(String login);
}
