package com.lviv.taras.config;


import com.lviv.taras.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // register our implementation of UserDetailsService
    // and PasswordEncoder to bring the password in BCrypt format
    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getBCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // enable protection against CSRF attacks
        http.csrf()
                .disable()
                // specify http-query rules
                // by which will be determined access to resources and other data
                .authorizeRequests()
                .antMatchers("/resources/**", "/**").permitAll()

                .anyRequest().permitAll();

        http.formLogin()
                // specify page with login-form
                .loginPage("/login")
                // specify action from login-form
                .loginProcessingUrl("/j_spring_security_check")
                // specify URL when login is unsuccessful
                .failureUrl("/login?error")
                // specify login and password parameters from login-form
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                // give access to login-form to all
                .permitAll();


        http.logout()
                // We allow everyone to do logout
                .permitAll()
                // specify logout URL
                .logoutUrl("/logout")
                // specify URL when logout is success
                .logoutSuccessUrl("/login?logout")
                // making invalid the current session
                .invalidateHttpSession(true);
    }

    // Tell to Spring container, that need to initialize <b></b>BCryptPasswordEncoder
    // We can but it into WebMvcConfig, but for better understand i left it here.
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}