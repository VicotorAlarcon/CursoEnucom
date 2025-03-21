package com.mx.SalaCine.Confing;

import javax.security.sasl.AuthorizeCallback;

import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
//@EnableWebSecurity
public class CorsConfing {
	
	/*
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
			
			manager.createUser(
					User.withDefaultPasswordEncoder()
					.username("user")
					.password("1234")
					.roles("USER")
					.build()
					
					);
			
			return manager;
		
		
	}
	*/
	
	/*
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(	//URLs Permitidos
					authorize -> authorize
					.requestMatchers(HttpMethod.GET,"/sala/**").authenticated()
					
					.anyRequest().denyAll())
			
			.formLogin().and()
			.httpBasic();
		
		return http.build();
	}
*/
}
