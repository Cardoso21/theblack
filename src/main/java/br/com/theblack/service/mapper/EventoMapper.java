package br.com.theblack.service.mapper;

import org.mapstruct.Mapper;

import br.com.theblack.dominio.Evento;
import br.com.theblack.service.DTO.EventoDTO;

@Mapper(componentModel = "spring", uses = {MotivoSelectmapper.class,SituacaoSelectMapper.class, UsuarioSelectMapper.class})
public interface EventoMapper extends EntityMapper<EventoDTO, Evento> {

}