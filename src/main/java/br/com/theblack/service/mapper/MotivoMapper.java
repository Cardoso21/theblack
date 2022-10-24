package br.com.theblack.service.mapper;

import br.com.theblack.dominio.Motivo;
import br.com.theblack.service.dto.MotivoDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface MotivoMapper extends EntityMapper<MotivoDTO, Motivo> {
}
