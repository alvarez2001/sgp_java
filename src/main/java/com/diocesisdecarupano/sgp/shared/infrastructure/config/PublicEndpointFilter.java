package com.diocesisdecarupano.sgp.shared.infrastructure.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.diocesisdecarupano.sgp.shared.infrastructure.anotations.Public;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class PublicEndpointFilter extends OncePerRequestFilter {

    private final RequestMappingHandlerMapping handlerMapping;

    public PublicEndpointFilter(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        try {
            HandlerExecutionChain handlerChain = handlerMapping.getHandler(request);
            if (handlerChain != null && handlerChain.getHandler() instanceof HandlerMethod method) {
                boolean isPublic = AnnotationUtils.findAnnotation(method.getMethod(), Public.class) != null
                        || AnnotationUtils.findAnnotation(method.getBeanType(), Public.class) != null;
                if (isPublic) {
                    request.setAttribute("IS_PUBLIC", true);
                }
            }
        } catch (Exception ignored) {
        }

        filterChain.doFilter(request, response);
    }
}