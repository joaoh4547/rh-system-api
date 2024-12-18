package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.builder;

import com.github.joaoh4547.rhsystem.rhsystemapi.commons.Builder;
import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.Colaborador;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Builder class for constructing instances of {@link Colaborador}.
 * This builder allows for step-by-step configuration of a {@link Colaborador} object.
 * Each method configures a specific attribute of the {@link Colaborador} and returns
 * the builder itself for method chaining. The {@code build} method finalizes the creation
 * of the {@link Colaborador} instance.
 * <p>
 * This class is annotated with {@code @Component} to indicate that it is a Spring-managed
 * component, and {@code @Scope("request")} to define its lifecycle scoped to the request.
 * </p>
 * Methods:
 * - Configures various fields such as 'id', 'nome', 'cpf', and more, as needed for creating a {@link Colaborador}.
 * - The {@code build} method instantiates and initializes a {@link Colaborador} with the configured values.
 * <p>
 * Example fields supported by the builder:
 * - UUID id
 * - String nome
 * - String cpf
 * - String rg
 * - LocalDate dataNascimento
 * - String telefone
 * - String email
 * - Boolean ativo
 * - LocalDateTime dataCriacao
 * - LocalDateTime dataAtualizacao
 * </p>
 * Usage of the builder pattern ensures immutability and promotes readability when creating
 * complex objects such as {@link Colaborador}.
 */
public class ColaboradorBuilder extends AbstractColaboradorBuilder<Colaborador> {

    public static ColaboradorBuilder builder() {
        return new ColaboradorBuilder();
    }

    @Override
    public Colaborador build() {
        Colaborador colaborador = new Colaborador();
        colaborador.setId(id);
        colaborador.setNome(nome);
        colaborador.setCpf(cpf);
        colaborador.setRg(rg);
        colaborador.setDataNascimento(dataNascimento);
        colaborador.setEmail(email);
        colaborador.setTelefone(telefone);
        colaborador.setAtivo(ativo);
        colaborador.setDataCriacao(dataCriacao);
        colaborador.setDataAtualizacao(dataAtualizacao);
        clear();
        return colaborador;
    }


}
