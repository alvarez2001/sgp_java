package com.diocesisdecarupano.sgp.shared.infrastructure.config;

import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        title = "API SISTEMA GESTION DE PROYECTOS (SGP)",
        description = "SISTEMA PARA GESTIONAR PROYECTOS DE FORMA MAS EFECTIVA",
        version = "1.0.0",
        contact = @Contact(
            name = "Jose Alvarez",
            url = "https://github.com/alvarez2001"
        )
    ),
    servers = {
        @Server(
            description = "LOCAL SERVER",
            url = "http://192.168.80.160:8080/api/v1"
        )
    },
    security = @SecurityRequirement(
        name = "Security Token"
    )
)
@SecurityScheme(
    name = "Security Token",
    description = "Access token for my API",
    type = SecuritySchemeType.HTTP,
    paramName = HttpHeaders.AUTHORIZATION,
    in = SecuritySchemeIn.HEADER,
    scheme = "bearer",
    bearerFormat = "JWT"
)
public class SwaggerConfig {
    
}
