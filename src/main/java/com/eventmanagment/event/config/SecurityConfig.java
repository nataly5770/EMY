package com.eventmanagment.event.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    //private UserDetailsService userDetailsService;
    //admin role - he can laways log in as admin
    // user role / he/she can always log in as a regular user
    //


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable();*/
//        //System log into here and gives the object over
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/signup", "/home").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/user/signin").usernameParameter("userid")
                .passwordParameter("passcode").permitAll()
                .and()
                .logout()
                .logoutUrl("/signout")
                .permitAll();
    }
}
