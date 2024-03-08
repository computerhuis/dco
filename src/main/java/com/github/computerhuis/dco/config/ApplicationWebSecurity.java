package com.github.computerhuis.dco.config;

import com.github.computerhuis.dco.filter.LogFilter;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

import static com.github.computerhuis.dco.config.Roles.*;

@Configuration
@EnableWebSecurity
class ApplicationWebSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Add log filter
        http.addFilterBefore(new LogFilter(), WebAsyncManagerIntegrationFilter.class);

        // Enable Content Security Policy
        http.headers(headers -> headers.contentSecurityPolicy(contentSecurityPolicy -> contentSecurityPolicy.policyDirectives("default-src 'self'; img-src 'self' data:")));

        http.authorizeHttpRequests((authorizeHttpRequests) ->
            authorizeHttpRequests.requestMatchers("/assets/**", "/authenticate", "/authenticate/**").permitAll()
                .anyRequest().authenticated()
        );

        // Login
        http.formLogin((formLogin) ->
            formLogin
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/authenticate")
                .failureUrl("/authenticate?failed")
                .loginProcessingUrl("/authenticate/process")
        );

        // Logout
        http.logout((logout) ->
            logout.deleteCookies("remove")
                .invalidateHttpSession(false)
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/authenticate")
        );

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        val admin = User.withUsername(ADMIN_USERNAME)
            .password(passwordEncoder().encode(ADMIN_PASSWORD))
            .roles(ADMIN_ROLE)
            .build();

        val counter = User.withUsername(COUNTER_USERNAME)
            .password(passwordEncoder().encode(COUNTER_PASSWORD))
            .roles(COUNTER_ROLE)
            .build();

        val workshop = User.withUsername(WORKSHOP_USERNAME)
            .password(passwordEncoder().encode(WORKSHOP_PASSWORD))
            .roles(WORKSHOP_ROLE)
            .build();

        val education = User.withUsername(EDUCATION_USERNAME)
            .password(passwordEncoder().encode(EDUCATION_PASSWORD))
            .roles(EDUCATION_ROLE)
            .build();

        return new InMemoryUserDetailsManager(admin, counter, workshop, education);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
