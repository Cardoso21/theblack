package br.com.theblack.service.mapper;

import org.mapstruct.Mapper;

import br.com.theblack.dominio.Motivo;
import br.com.theblack.service.DTO.MotivoDTO;

@Mapper(componentModel = "spring", uses = {})
public interface MotivoMapper extends EntityMapper<MotivoDTO, Motivo> {
}

