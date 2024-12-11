package com.github.joaoh4547.rhsystem.rhsystemapi;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableAdminServer
@EnableCaching
@OpenAPIDefinition(
        info = @Info(
                title = "Exemplo de API",
                version = "1.0.0",
                description = "API para demonstração do Springdoc OpenAPI",
                contact = @Contact(
                        name = "Suporte",
                        email = "suporte@exemplo.com",
                        url = "https://exemplo.com/suporte"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                ),
                termsOfService = "https://exemplo.com/termos"
        )
)
public class RhSystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RhSystemApiApplication.class, args);
    }

}
