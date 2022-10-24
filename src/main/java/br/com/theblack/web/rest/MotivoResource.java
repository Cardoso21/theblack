package br.com.theblack.web.rest;


import br.com.theblack.service.MotivoService;
import br.com.theblack.service.dto.MotivoDTO;
import br.com.theblack.service.dto.SelectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/motivo")
@RequiredArgsConstructor
public class MotivoResource {

    private final MotivoService motivoService;


    @GetMapping
    public ResponseEntity<List<MotivoDTO>> exibirTodosMotivos(){
        return ResponseEntity.ok(motivoService.exibirTodosMotivos());
    }
    @GetMapping("{id}")
    public ResponseEntity<MotivoDTO> exibirMotivoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(motivoService.exibirMotivoPorId(id));
    }
    @GetMapping("/select")
    public ResponseEntity<List<SelectDTO>> exibirMotivosEmSelect(){
        return ResponseEntity.ok(motivoService.exibirMotivosEmSelect());
    }
    @PostMapping
    public ResponseEntity<MotivoDTO> salvarMotivo(@Valid @RequestBody MotivoDTO motivoDTO){
        MotivoDTO motivoSalvo = motivoService.salvarMotivo(motivoDTO);
        return ResponseEntity.created(URI.create("api/motivo"+motivoSalvo.getId())).body(motivoSalvo);
    }
    @PutMapping
    public ResponseEntity<MotivoDTO> atualizarMotivo(@Valid @RequestBody MotivoDTO motivoDTO){
        return ResponseEntity.ok(motivoService.salvarMotivo(motivoDTO));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarMotivo(@PathVariable("id") Long id){
        motivoService.deletarMotivo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
