package com.yunbo3.book.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 기본 사용자를 정의합니다.
        auth.inMemoryAuthentication()
                .withUser("test")
                .password("{noop}test") // Spring Security 5부터 비밀번호에 {noop} 접두사를 붙여야 합니다.
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/favicon.ico","http://localhost:8080/*","/api/v1/posts","/api/v1/posts/{id}","/posts/save","/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable() // Disable CSRF for simplicity in the test
                .headers().frameOptions().disable(); // Disable X-Frame-Options for H2 Console

        // Add debug logs
        http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
            System.out.println("Authentication exception: " + authException.getMessage());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
        });
    }
}
