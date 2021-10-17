package com.example.pizzanetwork.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    Logger logger = Logger.getLogger(AppSecurityConfig.class);

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("populate inmemory auth user");
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("123"))
                .roles("USER").and()
                .withUser("admin")
                .password(passwordEncoder().encode("12345"))
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("config http security");
        http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers("/v2/api-docs/**",
                        "/swagger-ui/**").permitAll()
                .antMatchers("/api/**").authenticated()
                .and().httpBasic();
    }

    @Override
    public void configure(WebSecurity web) {
        logger.info("config web Security");
        web
                .ignoring()
                .antMatchers("/images/**");
    }
}
