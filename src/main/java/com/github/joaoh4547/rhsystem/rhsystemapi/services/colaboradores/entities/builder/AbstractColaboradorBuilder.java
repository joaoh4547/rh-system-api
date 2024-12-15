package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.builder;

import com.github.joaoh4547.rhsystem.rhsystemapi.commons.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents an abstract builder for constructing Colaborador entities with fluent
 * method chaining. This builder provides methods to set various properties commonly
 * associated with a Colaborador, such as identification details, contact information,
 * and status attributes. Specific implementations of this abstract class should
 * define how the object is ultimately built.
 *
 * @param <T> the type of object that will be built using this builder
 */
public abstract class AbstractColaboradorBuilder<T> implements Builder<T> {

    /**
     * Represents the unique identifier for a Colaborador entity.
     * This field is automatically generated and serves as the primary key
     * for distinguishing individual entities within the system.
     */
    protected UUID id;

    /**
     * The name of the collaborator.
     * It must be a non-blank string with a length between 10 and 100 characters.
     */
    protected String nome;

    /**
     * Represents the CPF (Cadastro de Pessoas Físicas) of a Colaborador.
     * This is a unique and mandatory field designed to identify individuals
     * in the Brazilian registry system. The CPF must consist of exactly 11 digits.
     */
    protected String cpf;

    /**
     * Represents the unique RG (Registro Geral) identifier of a collaborator.
     * This is typically a 9-digit identifier that is unique to each individual
     * and forms part of the collaborator's identification details.
     */
    protected String rg;

    /**
     * Represents the date of birth of a collaborator.
     * This field is mandatory and must reference a date in the past.
     */
    protected LocalDate dataNascimento;

    /**
     * Represents the telephone number of a collaborator.
     * This variable is designed to store a valid telephone number format,
     * with a minimum length of 10 and a maximum length of 15 characters.
     */
    protected String telefone;

    /**
     * Represents an email address associated with a Colaborador entity.
     * This field is expected to adhere to a valid email format.
     * It must not be blank and has a size constraint of 5 to 100 characters.
     * The email value is unique within the database and cannot be null.
     */
    protected String email;

    /**
     * Represents the active status of the entity.
     * When true, the entity is considered active; otherwise, it is considered inactive.
     * Default value is true.
     */
    protected Boolean ativo;

    /**
     * Represents the creation date and time of the entity.
     * This field is automatically populated when the entity is created and cannot be updated.
     */
    protected LocalDateTime dataCriacao;

    /**
     * Represents the date and time when the entity was last updated.
     * This field is automatically updated whenever changes are made
     * to the corresponding entity in the database.
     */
    protected LocalDateTime dataAtualizacao;

    /**
     * Assigns a unique identifier (UUID) to the Colaborador entity being built.
     *
     * @param id the UUID to be assigned as the identifier of the Colaborador
     * @return the current instance of AbstractColaboradorBuilder to allow method chaining
     */
    public AbstractColaboradorBuilder<T> id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Sets the name of the Colaborador being built.
     *
     * @param nome the name to be assigned to the Colaborador
     * @return the current instance of AbstractColaboradorBuilder to allow method chaining
     */
    public AbstractColaboradorBuilder<T> nome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * Sets the CPF (Cadastro de Pessoas Físicas) of the Colaborador being built.
     *
     * @param cpf the CPF to be assigned to the Colaborador
     * @return the current instance of AbstractColaboradorBuilder to allow method chaining
     */
    public AbstractColaboradorBuilder<T> cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    /**
     * Sets the RG (Registro Geral) of the Colaborador being built.
     *
     * @param rg the RG to be assigned to the Colaborador
     * @return the current instance of AbstractColaboradorBuilder to allow method chaining
     */
    public AbstractColaboradorBuilder<T> rg(String rg) {
        this.rg = rg;
        return this;
    }

    /**
     * Sets the date of birth of the Colaborador being built.
     *
     * @param dataNascimento the date of birth to be assigned to the Colaborador
     * @return the current instance of AbstractColaboradorBuilder to allow method chaining
     */
    public AbstractColaboradorBuilder<T> dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    /**
     * Sets the telefone (phone number) of the Colaborador being built.
     *
     * @param telefone the phone number to be assigned to the Colaborador
     * @return the current instance of AbstractColaboradorBuilder to allow method chaining
     */
    public AbstractColaboradorBuilder<T> telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    /**
     * Sets the email of the Colaborador being built.
     *
     * @param email the email to be assigned to the Colaborador
     * @return the current instance of AbstractColaboradorBuilder to allow method chaining
     */
    public AbstractColaboradorBuilder<T> email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the active status of the Colaborador being built.
     *
     * @param ativo the active status to be assigned to the Colaborador.
     *              A Boolean value where {@code true} represents an active Colaborador
     *              and {@code false} represents an inactive Colaborador.
     * @return the current instance of AbstractColaboradorBuilder to allow method chaining.
     */
    public AbstractColaboradorBuilder<T> ativo(Boolean ativo) {
        this.ativo = ativo;
        return this;
    }

    /**
     * Sets the creation date of the Colaborador being built.
     *
     * @param dataCriacao the creation date to be assigned to the Colaborador
     * @return the current instance of AbstractColaboradorBuilder to allow method chaining
     */
    public AbstractColaboradorBuilder<T> dataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
        return this;
    }

    /**
     * Sets the update timestamp for the Colaborador being built.
     *
     * @param dataAtualizacao the date and time to be assigned as the update timestamp
     * @return the current instance of AbstractColaboradorBuilder to allow method chaining
     */
    public AbstractColaboradorBuilder<T> dataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
        return this;
    }

    protected void clear() {
        id = null;
        nome = null;
        cpf = null;
        rg = null;
        dataNascimento = null;
        email = null;
        telefone = null;
        ativo = null;
        dataCriacao = null;
    }
}
