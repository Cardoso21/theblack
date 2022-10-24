package br.com.theblack.service.mapper;

import br.com.theblack.dominio.Evento;
import br.com.theblack.service.dto.EventoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MotivoSelectmapper.class,SituacaoSelectMapper.class, UsuarioSelectMapper.class})
public interface EventoMapper extends EntityMapper<EventoDTO, Evento> {

}
