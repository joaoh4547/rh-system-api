package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.dto;

import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.Colaborador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link Colaborador}
 */
public record ColaboradorDto(UUID id, String nome,
                             String cpf,
                             String rg, LocalDate dataNascimento,
                             String email,
                             String telefone, Boolean ativo,
                             LocalDateTime dataCriacao, LocalDateTime dataAtualizacao)

{

    public static ColaboradorDto from(Colaborador colaborador) {
        return new ColaboradorDto(colaborador.getId(),
                                  colaborador.getNome(),
                                  colaborador.getCpf(),
                                  colaborador.getRg(),
                                  colaborador.getDataNascimento(),
                                  colaborador.getEmail(),
                                  colaborador.getTelefone(),
                                  colaborador.getAtivo(),
                                  colaborador.getDataCriacao(),
                                  colaborador.getDataAtualizacao());
    }

}