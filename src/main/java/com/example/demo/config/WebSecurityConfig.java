package com.example.demo.config;

import com.example.demo.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

    @Bean
    public UserDetailsService mongoUserDetails() {
        return new CustomUserDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetailsService userDetailsService = mongoUserDetails();
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/uno").permitAll()
                .antMatchers("/minilabTest").permitAll()
                .antMatchers("/leaderboard").permitAll()
                .antMatchers("/search").permitAll()
                .antMatchers("/test").permitAll()
                .antMatchers("/GCD").permitAll()
                .antMatchers("/unoGame").permitAll()
                .antMatchers("/kevinSort").permitAll()
                .antMatchers("/andrewSort").permitAll()
                .antMatchers("/alexSort").permitAll()
                .antMatchers("/seanData").permitAll()
                .antMatchers("/Factorial").permitAll()
                .antMatchers("/**").permitAll()
                .antMatchers("/kevinSorts2").permitAll()
                .antMatchers("/kevinLL").permitAll()
                .antMatchers("/andrewRealSort").permitAll()
                .antMatchers("/andrewLL").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/fibonacci").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/data").permitAll()
                .antMatchers("/alexSorts2").permitAll()
                .antMatchers("/alexLL").permitAll()
                .antMatchers("/seanSort").permitAll()
                .antMatchers("/seanLL").permitAll()
                .antMatchers("/atharvaSort").permitAll()
                .antMatchers("/unoInit").permitAll()
                .antMatchers("/atharvaLL").permitAll()
                .antMatchers("/binSearchAP").permitAll()
                .antMatchers("/binSearch").permitAll()
                .antMatchers("/binResult").permitAll()
                .antMatchers("/Palindrome").permitAll()
                .antMatchers("/Palindromeresult").permitAll()
                .antMatchers("/2048").permitAll()
                .antMatchers("/dashboard/**").hasAuthority("ADMIN").anyRequest()
                .authenticated().and().csrf().disable().formLogin().successHandler(customizeAuthenticationSuccessHandler)
                .loginPage("/login").failureUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
