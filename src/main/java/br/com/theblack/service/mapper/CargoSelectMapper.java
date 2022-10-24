package br.com.theblack.service.mapper;

import br.com.theblack.dominio.Cargo;
import br.com.theblack.service.dto.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {})
public interface CargoSelectMapper extends EntityMapper<SelectDTO, Cargo>{


    @Mapping(source = "id", target = "value")
    @Mapping(source = "cargo", target = "label")
    SelectDTO toDto(Cargo cargo);

    @InheritInverseConfiguration
    Cargo toEntity(SelectDTO selectDTO);
}
