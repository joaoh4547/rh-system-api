package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores;

import com.github.joaoh4547.rhsystem.rhsystemapi.commons.GenericService;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.Colaborador;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.ColaboradorRepository;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ColaboradorServiceImpl extends GenericService<Colaborador, UUID> implements ColaboradorService {

    private final ColaboradorRepository repository;

    @Autowired
    public ColaboradorServiceImpl(ColaboradorRepository repository) {
        this.repository = repository;
    }


    @Override
    public JpaRepository<Colaborador, UUID> getRepository() {
        return repository;
    }

    @Override
    protected UUID extractId(Colaborador obj) {
        return obj.getId();
    }
}
