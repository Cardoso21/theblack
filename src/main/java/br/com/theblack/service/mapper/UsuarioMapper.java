package br.com.theblack.service.mapper;

import org.mapstruct.Mapper;

import br.com.theblack.dominio.Usuario;
import br.com.theblack.service.DTO.UsuarioDTO;

@Mapper(componentModel = "spring", uses = {PagamentoSelectMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {

}
