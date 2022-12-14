package br.com.theblack.service.mapper;

import br.com.theblack.dominio.Motivo;
import br.com.theblack.service.dto.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {})
public interface MotivoSelectmapper extends EntityMapper<SelectDTO, Motivo> {

    @Mapping(source = "id", target = "value")
    @Mapping(source = "motivo", target = "label")
    SelectDTO toDto(Motivo motivo);

    @InheritInverseConfiguration
    Motivo toEntity(SelectDTO selectDTO);
}
