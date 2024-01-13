package rest.java.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class WebSecurityConfig {
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(
					(authorizeRequests) -> authorizeRequests
								.requestMatchers(new AntPathRequestMatcher("/courses/**", "GET"))
								.hasAnyRole("USER", "ADMIN")
								.requestMatchers(new AntPathRequestMatcher("/courses", "POST"))
								.hasRole("ADMIN")
								.requestMatchers(new AntPathRequestMatcher("/courses", "DELETE"))
								.hasRole("ADMIN")
								.requestMatchers(new AntPathRequestMatcher("/courses", "PUT"))
								.hasRole("ADMIN")
								.requestMatchers(new AntPathRequestMatcher("/students/**", "GET"))
								.hasAnyRole("USER", "ADMIN")
								.requestMatchers(new AntPathRequestMatcher("/students", "POST"))
								.hasRole("ADMIN")
								.requestMatchers(new AntPathRequestMatcher("/students", "DELETE"))
								.hasRole("ADMIN")
								.requestMatchers(new AntPathRequestMatcher("/students", "PUT"))
								.hasRole("ADMIN"))
				.httpBasic(withDefaults())
				.csrf((csrf) -> csrf.ignoringRequestMatchers("/students/**", "/courses/**"));
		return http.build();
	}
	
}
