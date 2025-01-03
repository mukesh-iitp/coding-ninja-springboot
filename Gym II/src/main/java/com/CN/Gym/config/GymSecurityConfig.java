package com.CN.Gym.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GymSecurityConfig {

    /*
        1. Add relevant annotations to make this class a configuration class and enable method leve security.
        2. Create authenticationManager, passwordEncoder bean.
        3. Create securityFilterChain bean with httpBasic security and use antMatcher to make "/user/register"
           an open API.
     */
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
			.authorizeHttpRequests()
			.antMatchers("/user/register").permitAll()
            //.anyRequest()
            //.authenticated()
            //.and()
            //.httpBasic();
			.and()
			.rememberMe()
			.userDetailsService(userDetailsService)
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout()
			.deleteCookies("remember_me");
		
		return http.build();
	}
	
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}
