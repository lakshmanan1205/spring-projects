package com.lionel.library_management_v1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class UserSecurityConfig {
    // PASSWORD ENCODER FOR ENCODING
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    //ADD SUPPORT FOR JDBC
    public UserDetailsManager userDetailsManager(DataSource  dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // DEFINE QUERY TO RETRIVE USERS BY USER NAME
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT email,password,enabled FROM users where email=?"
        );


        // DEFINE QUERY TO RETRIVES AUTHORITIES/ROLES BY USER NAME
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT users.email, CONCAT('ROLE_', roles.role) FROM user_roles\n" +
                        "JOIN roles \n" +
                        "ON roles.id = user_roles.role_id \n" +
                        "JOIN users\n" +
                        "ON users.id = user_roles.user_id\n" +
                        "WHERE user_roles.enabled = 1 AND users.email =?"
        );

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http.authorizeHttpRequests(configure->
                configure
                        // ADMIN
                        .requestMatchers(HttpMethod.GET,"/api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/users").hasRole("ADMIN")
        );
        // USE HTTP BASIC AUTHENTICATION
        http.httpBasic(Customizer.withDefaults());

        // DISABLE CSRF
        //IN GENERAL NOT REQUIRED FOR STATELESS REST API S THAT USE POST,PUT,DELETE,PATCH
        http.csrf(csrf->csrf.disable());

        return  http.build();
    }
}
