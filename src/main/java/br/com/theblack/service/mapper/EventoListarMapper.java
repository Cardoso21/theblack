package br.com.theblack.service.mapper;

import org.mapstruct.Mapper;

import br.com.theblack.dominio.Evento;
import br.com.theblack.service.DTO.EventoListarDTO;

@Mapper(componentModel = "spring", uses = {SituacaoSelectMapper.class})
public interface EventoListarMapper extends EntityMapper<EventoListarDTO, Evento> {
}

