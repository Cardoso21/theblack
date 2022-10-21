package br.com.theblack.web.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.theblack.service.PagamentoService;
import br.com.theblack.service.DTO.SelectDTO;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/pagameto")
public class PagamentoResouce {
	
	private PagamentoService pagamentoService;
	
	@GetMapping
	public ResponseEntity<List<SelectDTO>>mostrarPagamento(){
		return ResponseEntity.ok(pagamentoService.mostrarPagamentos());
	}

}
