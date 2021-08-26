package com.perscholas.camppower.security;

import com.perscholas.camppower.services.UserDetailsServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/register_success/**").permitAll()
                .antMatchers("///**").permitAll()
                .antMatchers("/booking/**").authenticated()
                .antMatchers("/showBooking/**").authenticated()
                .antMatchers("/rental/**").authenticated()
                .antMatchers("/process_rental/**").authenticated()
                .antMatchers("/processBooking/**").authenticated()
                .antMatchers("/rentals/**").authenticated()
                .antMatchers("/rentalsAll/**").authenticated()





                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll()

                .and()
                .logout().permitAll();
    }
}