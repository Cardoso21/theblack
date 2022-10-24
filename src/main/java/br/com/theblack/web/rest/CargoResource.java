package br.com.theblack.web.rest;


import br.com.theblack.service.CargoService;
import br.com.theblack.service.dto.SelectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/cargo")
public class CargoResource {
    private final CargoService cargoService;
    @GetMapping
    public ResponseEntity<List<SelectDTO>> mostrarCargos(){
        return ResponseEntity.ok(cargoService.mostarCargos());
    }
}
