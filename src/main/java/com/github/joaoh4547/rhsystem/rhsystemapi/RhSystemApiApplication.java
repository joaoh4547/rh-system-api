package com.github.joaoh4547.rhsystem.rhsystemapi;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableAdminServer
@EnableCaching
public class RhSystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RhSystemApiApplication.class, args);
    }

}
