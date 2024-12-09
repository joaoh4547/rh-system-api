package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaboradores")
@Tag(name = "Geral", description = "Serviços Gerais")
public class ColaboradorController {

    @GetMapping
    public String getColaboradores() {
        return "Colaboradores";
    }
}
