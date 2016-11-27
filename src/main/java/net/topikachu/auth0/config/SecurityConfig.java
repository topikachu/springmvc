package net.topikachu.auth0.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by 禕 on 2016/11/27.
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
//        http
//                .authorizeRequests()
//                .antMatchers("/signup","/about","/api/**").permitAll() // #4
//                .antMatchers("/admin/**").hasRole("ADMIN") // #6
//                .anyRequest().authenticated() // 7
//                .and()
//                .formLogin()  // #8
//                .loginPage("/login") // #9
//                .permitAll(); // #5
    }
}