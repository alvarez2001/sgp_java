package com.diocesisdecarupano.sgp.shared.infrastructure.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;

import com.diocesisdecarupano.sgp.shared.infrastructure.anotations.Public;

public class PublicEndpointRequestMatcher implements RequestMatcher {

    @Override
    public boolean matches(HttpServletRequest request) {
        Object handler = request.getAttribute(HandlerMapping.BEST_MATCHING_HANDLER_ATTRIBUTE);

        if (handler instanceof HandlerMethod handlerMethod) {
            return AnnotationUtils.findAnnotation(handlerMethod.getMethod(), Public.class) != null ||
                    AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), Public.class) != null;
        }

        return false;
    }
}