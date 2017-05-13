package com.falcon.avisep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig  extends WebMvcConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	protected void configure(final HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/login").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login").permitAll()
        .and()
        .logout().permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		//	        .formLogin()
		//	        .loginPage("/login.html")
		//	        .failureUrl("/login-error.html")
		//	      .and()
		//	        .logout()
		//	        .logoutSuccessUrl("/index.html");
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
		auth
        .inMemoryAuthentication()
            .withUser("user").password("password").roles("USER");
	}
}
