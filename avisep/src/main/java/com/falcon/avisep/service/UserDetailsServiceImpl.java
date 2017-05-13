package com.falcon.avisep.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.falcon.avisep.model.RoleAvis;
import com.falcon.avisep.model.UserAvis;
import com.falcon.avisep.repository.UserAvisRepository;
@Service
@Component
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserAvisRepository userRepository;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		UserAvis user=userRepository.findByLogin(login);
		for (RoleAvis role : user.getRoleAvis()){
			grantedAuthorities.add(new SimpleGrantedAuthority(role.name()));
		}

		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPasswd(), grantedAuthorities);
	}
}
