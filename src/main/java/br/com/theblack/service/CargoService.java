package br.com.theblack.service;


import br.com.theblack.repository.CargoRepository;
import br.com.theblack.service.dto.SelectDTO;
import br.com.theblack.service.mapper.CargoSelectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CargoService {

private final CargoRepository cargoRepository;
private final CargoSelectMapper cargoSelectMapper;


public List<SelectDTO> mostarCargos(){

    return cargoSelectMapper.toDto(cargoRepository.findAll());
}
}
