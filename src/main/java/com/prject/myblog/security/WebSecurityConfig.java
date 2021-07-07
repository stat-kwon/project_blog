package com.prject.myblog.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();

        //로그인 기능 상세 설정을 해주는 것
        http.authorizeRequests()

                .antMatchers("/assets/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/user/signup").permitAll()
                .anyRequest().authenticated()

                .and()

                .formLogin()
                .loginPage("/user/login")
                .failureUrl("/user/login/error")
                .defaultSuccessUrl("/")
                .permitAll()

                .and()

                .logout()
                .permitAll();
    }
}