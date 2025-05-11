package com.diocesisdecarupano.sgp.shared.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.diocesisdecarupano.sgp.shared.infrastructure.security.JwtAuthenticationFilter;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private PublicEndpointFilter publicEndpointFilter;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${swagger.auth.username}")
    private String usernameBasicAuth;

    @Value("${swagger.auth.password}")
    private String passwordBasicAuth;

    @Bean
    @Order(1)
    public SecurityFilterChain swaggerSecurityChain(HttpSecurity http) throws Exception {
        http
                // Scope de esta cadena: solo rutas de Swagger
                .securityMatcher(new OrRequestMatcher(
                        new AntPathRequestMatcher("/swagger-ui.html"),
                        new AntPathRequestMatcher("/swagger-ui/**"),
                        new AntPathRequestMatcher("/v3/api-docs/**"),
                        new AntPathRequestMatcher("/webjars/**")))
                .csrf(csrf -> csrf.disable()) // csrf desactivado
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // todas requieren auth
                )
                .httpBasic(Customizer.withDefaults()); // activa HTTP Basic

        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain apiSecurityChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(request -> {
                            Boolean isPublic = (Boolean) request.getAttribute("IS_PUBLIC");
                            return Boolean.TRUE.equals(isPublic);
                        }).permitAll()
                        .anyRequest().authenticated())
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setContentType("application/json");
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            response.getWriter().write("{\"error\": \"Unauthorized - Invalid or missing token.\"}");
                        })
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.setContentType("application/json");
                            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                            response.getWriter().write("{\"error\": \"Forbidden - Access denied.\"}");
                        }))
                .addFilterBefore(publicEndpointFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /** In‐memory user admin/admin para Swagger */
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        String hashed = passwordEncoder.encode(this.passwordBasicAuth);

        return new InMemoryUserDetailsManager(
                User.withUsername(this.usernameBasicAuth)
                        .password(hashed)
                        .roles("SWAGGER")
                        .build());
    }
}