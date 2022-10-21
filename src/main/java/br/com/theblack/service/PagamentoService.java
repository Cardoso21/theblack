package br.com.theblack.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.theblack.repository.PagamentoRepository;
import br.com.theblack.service.DTO.SelectDTO;
import br.com.theblack.service.mapper.PagamentoSelectMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PagamentoService {
	
	private  PagamentoRepository pagamentoRepository ;
	private PagamentoSelectMapper pagamentoSelectMapper;
	
	public List<SelectDTO> mostrarPagamentos(){
		return pagamentoSelectMapper.toDto(pagamentoRepository.findAll());
	}

}
