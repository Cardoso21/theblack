package br.com.theblack.service.mapper;

import br.com.theblack.dominio.Evento;
import br.com.theblack.service.dto.EventoListarDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SituacaoSelectMapper.class})
public interface EventoListarMapper extends EntityMapper<EventoListarDTO, Evento> {
}
