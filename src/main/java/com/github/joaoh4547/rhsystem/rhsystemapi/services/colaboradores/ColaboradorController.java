package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores;

import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.ColaboradorService;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.dto.ColaboradorDto;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.factory.ColaboradorFactory;
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

    private final ColaboradorFactory colaboradorFactory;

    @Autowired
    public ColaboradorController(ColaboradorService service, ColaboradorFactory colaboradorFactory) {
        this.service = service;
        this.colaboradorFactory = colaboradorFactory;
    }

    @GetMapping
    public Page<ColaboradorDto> getColaboradores(Pageable pageable) {
        return service.findAll(pageable).map(colaboradorFactory::fromColaborador);
    }
}
