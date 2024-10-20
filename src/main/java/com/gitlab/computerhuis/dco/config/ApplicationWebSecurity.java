package com.gitlab.computerhuis.dco.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
class ApplicationWebSecurity {

    private static final String QUERY_USERNAME = "select username AS id, password, case when (unregistered is null or unregistered <= CURRENT_TIMESTAMP) then 'true' else 'false' end as enabled from individual_login where username=?";
    private static final String QUERY_AUTHORITIES = "select username as id, authority from individual_authorities where username=?";

    private final DataSource dataSource;

    // --[ CONFIGURATION ]-----------------------------------------------------------------------------------------------------------------
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(QUERY_USERNAME)
            .authoritiesByUsernameQuery(QUERY_AUTHORITIES);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Enable Content Security Policy
        http.headers(headers -> headers.contentSecurityPolicy(contentSecurityPolicy -> contentSecurityPolicy.policyDirectives("default-src 'self'; img-src 'self' data:")));

        http.authorizeHttpRequests((authorizeHttpRequests) ->
            authorizeHttpRequests.requestMatchers("/assets/**", "/authenticeren", "/authenticeren/**").permitAll()
                .anyRequest().authenticated()
        );

        // Login
        http.formLogin((formLogin) ->
            formLogin
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/authenticeren")
        );

        // Logout
        http.logout((logout) ->
            logout.deleteCookies("remove")
                .invalidateHttpSession(false)
                .deleteCookies("JSESSIONID")
                .logoutUrl("/uitloggen")
                .logoutSuccessUrl("/authenticeren")
        );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
