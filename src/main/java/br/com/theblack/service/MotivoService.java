package br.com.theblack.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.theblack.dominio.Motivo;
import br.com.theblack.repository.MotivoRepository;
import br.com.theblack.service.DTO.MotivoDTO;
import br.com.theblack.service.DTO.SelectDTO;
import br.com.theblack.service.exception.RegraNegocioException;
import br.com.theblack.service.mapper.MotivoMapper;
import br.com.theblack.service.mapper.MotivoSelectmapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class MotivoService {

   private  MotivoRepository motivoRepository;
   private  EventoService eventoService;
   private  MotivoMapper motivoMapper;
   private  MotivoSelectmapper motivoSelectmapper;

    public List<MotivoDTO> exibirTodosMotivos(){
        return motivoMapper.toDto(motivoRepository.findAll());
    }
   public MotivoDTO exibirMotivoPorId(Long id){
       Motivo motivo = motivoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Motivo não existe"));
       return motivoMapper.toDto(motivo);
   }

    public List<SelectDTO> exibirMotivosEmSelect(){
       return motivoSelectmapper.toDto(motivoRepository.findAll());
    }
   public MotivoDTO salvarMotivo(MotivoDTO motivoDTO){
       Motivo motivo = motivoMapper.toEntity(motivoDTO);
       Motivo motivoSalvar = motivoRepository.save(motivo);
       return motivoMapper.toDto(motivoSalvar);
   }

   public void deletarMotivo(Long id){
       Motivo motivo  = motivoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Motivo não existe"));
    if(eventoService.buscarMotivosEmEventos(motivo).isPresent()){
       throw new RegraNegocioException("Motivo não pode ser excluido por estar vinculado a um evento");
       }
       motivoRepository.deleteById(id);

   }
}

