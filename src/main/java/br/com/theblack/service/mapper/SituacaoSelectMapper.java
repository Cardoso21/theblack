package br.com.theblack.service.mapper;

import br.com.theblack.dominio.Situacao;
import br.com.theblack.service.dto.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface SituacaoSelectMapper extends EntityMapper<SelectDTO, Situacao> {


    @Mapping(source = "id", target = "value")
    @Mapping(source = "situacao", target = "label")
    SelectDTO toDto(Situacao situacao);


    @InheritInverseConfiguration
    Situacao toEntity(SelectDTO selectDTO);


}
