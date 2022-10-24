package br.com.theblack.service.mapper;

import br.com.theblack.dominio.Usuario;
import br.com.theblack.service.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CargoSelectMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {

}
