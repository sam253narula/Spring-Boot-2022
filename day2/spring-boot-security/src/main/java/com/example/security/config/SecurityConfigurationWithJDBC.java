package com.example.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigurationWithJDBC extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Without encryption
//		auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
//		.withUser(User.withUsername("samarth").password("samarth")
//				.roles("STORE_OWNER"))
//		.withUser(
//				User.withUsername("rohan").password("rohan").roles("STORE_CLERK"));

		// JDBC authentication, method chaining with encryption
		auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
				.withUser(User.withUsername("samarth").password(getPasswordEncoder().encode("samarth"))
						.roles("STORE_OWNER"))
				.withUser(
						User.withUsername("rohan").password(getPasswordEncoder().encode("rohan")).roles("STORE_CLERK"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/organicVeggies/viewFinancials", "/organicVeggies/makeAnnouncement")
				.hasRole("STORE_OWNER")
				.antMatchers("/organicVeggies/checkInventory", "/organicVeggies/viewInventory",
						"/organicVeggies/doCheckout/")
				.hasAnyRole("STORE_OWNER", "STORE_CLERK").antMatchers("/").permitAll().and().formLogin();
	}

//	If you don't want to encode the created password, you can write the below bean method, FYI: not recommended for Prod env
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}
}
