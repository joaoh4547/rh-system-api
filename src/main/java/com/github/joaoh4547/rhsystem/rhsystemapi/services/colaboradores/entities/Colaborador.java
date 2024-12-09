package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_colaboradores", indexes = {
        @Index(name = "idx_colaborador_cpf_unq", columnList = "cpf", unique = true),
        @Index(name = "idx_colaborador_rg_unq", columnList = "rg", unique = true),
        @Index(name = "idx_colaborador_email_unq", columnList = "email", unique = true)
})
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_colaborador", nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false)
    @Size(min = 10, max = 100)
    private String nome;

    @Column(name = "cpf", nullable = false)
    @Size(min = 11, max = 11)
    private String cpf;

    @Column(name = "rg", nullable = false)
    @Size(min = 9, max = 9)
    private String rg;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "email", nullable = false)
    @Email
    @Size(min = 5, max = 100)
    private String email;

    @Column(name = "telefone")
    @Size(min = 10, max = 15)
    private String telefone;

    @Column(name = "ativo", nullable = false)
    @ColumnDefault("true")
    private Boolean ativo;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    public Colaborador() {
    }

    public Colaborador(String nome, String cpf, String rg, LocalDate dataNascimento, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Colaborador{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", dataNascimento=" + dataNascimento + ", email=" + email + '}';
    }

}
