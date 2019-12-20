package com.eventmanagment.event.config;


import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
              .passwordEncoder(NoOpPasswordEncoder.getInstance())
              .usersByUsernameQuery("select username, password, active from usr where username=?")
              .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable();
//        //System log into here and gives the object over
//        http.cors().and().csrf().disable()
//                //then below helps us to turns the autharization on
//                .authorizeRequests()
//                .antMatchers("/", "/registration").permitAll()
//                .antMatchers("/home", "/user/signup").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .antMatchers("/user/**").hasAnyRole("USER")
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .loginPage("/login").usernameParameter("userid")
//                .passwordParameter("passcode").permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/signout")
//                .permitAll();
    }



    }
