package com.dev.authentication.config;

import org.springframework.context.annotation.Configuration;

@Configuration

public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/users").permitAll()
//                .anyRequest().authenticated()
//                .and().httpBasic()
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and().csrf().disable();
//
//        http.headers().frameOptions().sameOrigin();
//
//        return http.build();
//    }
}
