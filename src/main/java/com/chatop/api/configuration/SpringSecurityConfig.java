package com.chatop.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Remove for the prod
				.authorizeHttpRequests(
						(auth) -> auth.requestMatchers("/secur/**").authenticated().requestMatchers("/**").permitAll());

		return http.build();
	}
}
