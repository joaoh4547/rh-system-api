package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores;

import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.ColaboradorService;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.dto.ColaboradorDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaboradores")
@Tag(name = "Geral", description = "Serviços Gerais")
public class ColaboradorController {

    private final ColaboradorService service;

    @Autowired
    public ColaboradorController(ColaboradorService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ColaboradorDto> getColaboradores(Pageable pageable) {
        return service.findAll(pageable).map(ColaboradorDto::from);
    }
}
