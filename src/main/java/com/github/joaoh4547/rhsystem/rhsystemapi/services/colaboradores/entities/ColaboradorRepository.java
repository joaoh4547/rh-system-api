package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, UUID> {


    long countByAtivoIn(@Nullable Collection<Boolean> ativos);
}
