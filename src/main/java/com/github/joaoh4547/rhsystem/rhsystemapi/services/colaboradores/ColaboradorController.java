package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores;

import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.ColaboradorService;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.dto.CadastroColaboradorDto;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.dto.ColaboradorDto;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.factory.ColaboradorFactory;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

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
    public ResponseEntity<Page<ColaboradorDto>> getColaboradores(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable).map(colaboradorFactory::fromColaborador));
    }

    @PostMapping
    public ResponseEntity<ColaboradorDto> createColaborador(@RequestBody CadastroColaboradorDto colaboradorDto) {
        var colaborador = service.save(colaboradorFactory.fromCadastroDTO(colaboradorDto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(colaborador.getId()).toUri();
        return ResponseEntity.created(uri).body(colaboradorFactory.fromColaborador(colaborador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColaboradorDto> updateColaborador(@PathVariable UUID id, @RequestBody CadastroColaboradorDto colaboradorDto) {
        var colaborador = service.save(colaboradorFactory.fromCadastroDTO(colaboradorDto, id));
        return ResponseEntity.ok(colaboradorFactory.fromColaborador(colaborador));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorDto> getColaboradorById(@PathVariable UUID id) {
        var colaborador = service.findById(id);
        return ResponseEntity.ok(colaboradorFactory.fromColaborador(colaborador));
    }
}
