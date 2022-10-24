package br.com.theblack.service.mapper;

import br.com.theblack.dominio.Usuario;
import br.com.theblack.service.dto.UsuarioListagemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CargoSelectMapper.class})
public interface UsuarioListagemMapper extends EntityMapper<UsuarioListagemDTO, Usuario> {


}
