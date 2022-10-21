package br.com.theblack.service.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.theblack.dominio.Pagamento;
import br.com.theblack.service.DTO.SelectDTO;



@Mapper(componentModel = "spring", uses = {})
public interface PagamentoSelectMapper extends EntityMapper<SelectDTO,Pagamento>{

	@Mapping(source = "id", target = "value")
	@Mapping(source = "pagamento", target = "label")
	SelectDTO toDto(Pagamento pagamento);
	
	@InheritInverseConfiguration
	Pagamento toEntity(SelectDTO selectDTO);
}
