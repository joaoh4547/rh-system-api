package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.factory;

import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.Colaborador;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.builder.ColaboradorBuilder;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.builder.ColaboradorDtoBuilder;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.dto.CadastroColaboradorDto;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.dto.ColaboradorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Factory class responsible for creating instances of {@link Colaborador}.
 * Utilizes {@link ColaboradorBuilder} to build and configure {@link Colaborador} entities
 * based on the data provided in {@link CadastroColaboradorDto}.</p>
 * <p>
 * This class is a Spring-managed component and is intended to streamline the creation of
 * {@link Colaborador} objects, particularly when dealing with data transfer objects.
 */
@Component
public class ColaboradorFactory {


    /**
     * Converts a {@link CadastroColaboradorDto} object into a {@link Colaborador} entity instance.
     *
     * @param dto the CadastroColaboradorDto containing data to populate the Colaborador entity
     * @return a new Colaborador instance with attributes set based on the provided dto
     */
    public Colaborador fromCadastroDTO(CadastroColaboradorDto dto) {
        return ColaboradorBuilder.builder()
                .nome(dto.nome())
                .cpf(dto.cpf())
                .rg(dto.rg())
                .dataNascimento(dto.dataNascimento())
                .email(dto.email())
                .telefone(dto.telefone())
                .build();
    }

    /**
     * Converts a {@link Colaborador} entity into a {@link ColaboradorDto}.
     *
     * @param colaborador the Colaborador entity to be converted
     * @return a ColaboradorDto populated with data from the provided Colaborador entity
     */
    public ColaboradorDto fromColaborador(Colaborador colaborador) {
        return ColaboradorDtoBuilder.builder()
                .id(colaborador.getId())
                .cpf(colaborador.getCpf())
                .nome(colaborador.getNome())
                .rg(colaborador.getRg())
                .dataNascimento(colaborador.getDataNascimento())
                .telefone(colaborador.getTelefone())
                .dataCriacao(colaborador.getDataCriacao())
                .dataAtualizacao(colaborador.getDataAtualizacao()).build();
    }


}
