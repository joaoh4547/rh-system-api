package com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.builder;

import com.github.joaoh4547.rhsystem.rhsystemapi.services.colaboradores.entities.dto.ColaboradorDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class ColaboradorDtoBuilder extends AbstractColaboradorBuilder<ColaboradorDto> {

    public static ColaboradorDtoBuilder builder(){
        return new ColaboradorDtoBuilder();
    }


    @Override
    public ColaboradorDto build() {
        ColaboradorDto dto = new ColaboradorDto(id, nome, cpf, rg, dataNascimento, email, telefone, ativo, dataCriacao, dataAtualizacao);
        clear();
        return dto;
    }

}
