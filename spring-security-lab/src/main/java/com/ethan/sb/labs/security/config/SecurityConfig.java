package com.ethan.sb.labs.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhenghui
 * @Description Spring Security的配置类
 * @Date 2022/6/25
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            // 允许访问的请求
            .antMatchers("/", "/home", "/hello").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginProcessingUrl("/test/login")
            .loginPage("/login").permitAll()
            .and().logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 基于内存来存储用户信息
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .withUser("user").password(new BCryptPasswordEncoder().encode("123456")).roles("USER")
            .and().withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("USER", "ADMIN");
    }
}
