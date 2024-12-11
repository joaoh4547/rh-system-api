package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.dto;

import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.Colaborador;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

/**
 * DTO for {@link Colaborador}
 */
public record CadastroColaboradorDto(@Size(min = 10, max = 100) @NotBlank String nome,
                                     @Size(min = 11, max = 11) @NotBlank String cpf,
                                     @Size(min = 9, max = 9) @NotBlank String rg,
                                     @NotNull @Past LocalDate dataNascimento,
                                     @Size(min = 5, max = 100) @Email @NotBlank String email,
                                     @Size(min = 10, max = 15) @NotBlank String telefone)
{
}