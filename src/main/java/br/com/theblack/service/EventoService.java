package br.com.theblack.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.theblack.config.ApplicationProperties;
import br.com.theblack.dominio.Evento;
import br.com.theblack.dominio.Motivo;
import br.com.theblack.dominio.Situacao;
import br.com.theblack.dominio.Usuario;
import br.com.theblack.repository.EventoRepository;
import br.com.theblack.service.DTO.EmailDTO;
import br.com.theblack.service.DTO.EventoDTO;
import br.com.theblack.service.DTO.EventoListarDTO;
import br.com.theblack.service.exception.RegraNegocioException;
import br.com.theblack.service.filter.EventoFilter;
import br.com.theblack.service.mapper.EventoListarMapper;
import br.com.theblack.service.mapper.EventoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class EventoService {
    private  EventoRepository eventoRepository;
    private  EventoMapper eventoMapper;
    private  EventoListarMapper eventoListarMapper;
    private  EmailService emailService;
    private  ApplicationProperties applicationProperties;

    public List<EventoListarDTO> filtrarEventos(EventoFilter filter){
        return eventoListarMapper.toDto(eventoRepository.findAll(filter.filtrar()));
    }
    public EventoDTO mostrarEventoPorId(Long id){
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Evento não existe"));
        return eventoMapper.toDto(evento);
    }

    public EventoDTO salvarEvento(EventoDTO dto){
        Evento evento = eventoMapper.toEntity(dto);
        if (evento.getUsuario().toArray().length <= 0){
            throw new RegraNegocioException("Nenhum usuario foi cadastrado no evento");
        }
        if (eventoRepository.existsByDataEvento(evento.getDataEvento())){
            throw new RegraNegocioException("Já existe um evento marcado nessa data");
        }
        Evento eventoSalvo = eventoRepository.save(evento);
        return eventoMapper.toDto(eventoSalvo);
    }
    public EventoDTO editarEvento (EventoDTO eventoDTO){
        Evento evento = eventoMapper.toEntity(eventoDTO);
        Evento eventoComp = eventoRepository.findById(evento.getId()).orElseThrow(()-> new RegraNegocioException("evento não existe"));
        if (evento.getDataEvento().equals(eventoComp.getDataEvento())){
            Evento eventoSalvo = eventoRepository.save(evento);

        }
        else if (eventoRepository.existsByDataEvento(evento.getDataEvento())){
            throw new RegraNegocioException("Já existe um evento marcado nessa data");
        }
    return eventoMapper.toDto(eventoRepository.getById(evento.getId()));
    }

    public void trocarEventosDeData(Long idPrimario,Long idSecundario){
        Evento eventoPrimario = eventoRepository.findById(idPrimario).orElseThrow(()-> new RegraNegocioException("Evento primario não existe"));
        Evento eventoSecundario = eventoRepository.findById(idSecundario).orElseThrow(()-> new RegraNegocioException("Evento secundario não existe"));
        LocalDate dateEventoPrimario = eventoPrimario.getDataEvento();
        LocalDate dateEventoSecundario = eventoSecundario.getDataEvento();
        eventoPrimario.setDataEvento(dateEventoSecundario);
        eventoSecundario.setDataEvento(dateEventoPrimario);
        eventoRepository.save(eventoPrimario);
        eventoRepository.save(eventoSecundario);
    }

    public void adiarEvento(Long id){
        Evento eventoAdiado = eventoRepository.findById(id).orElseThrow(()-> new RegraNegocioException("Evento não existe"));
        LocalDate dataInicial = eventoAdiado.getDataEvento();
        List<Evento> eventos = eventoRepository.findAllAfter(dataInicial);
        List<Evento> eventosSave = new ArrayList<>();
        for (Evento e: eventos){
            e.setDataEvento(e.getDataEvento().plusDays(7));
            eventosSave.add(e);
        }
        eventoRepository.saveAll(eventosSave);
    }


    public void cancelarEvento(Long id){
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Evento não existe"));
        Situacao situacao = new Situacao();
        situacao.setId(3L);
        evento.setSituacao(situacao);
        eventoRepository.save(evento);
    }
    public void InativacaoDeUsuario(Usuario usuario){

        List<Evento> eventos = eventoRepository.getAllByUsuario(usuario);
        for (Evento e: eventos){
            if (e.getUsuario().toArray().length == 1){
                eventoRepository.delete(e);
            }else{
                List<Usuario> usuarios = e.getUsuario();
                usuarios.remove(usuario);
                e.setUsuario(usuarios);
                eventoRepository.save(e);
            }
        }
        }
    public Optional<List<Evento>> buscarMotivosEmEventos(Motivo motivo){
        return eventoRepository.findByMotivo(motivo);
    }

    @Scheduled(cron = "0 0 10 * * ?")
    public void enviaRotinaEmail() throws MessagingException{
        Optional<Evento> optionalEvento = eventoRepository.findTodayEvento(LocalDate.now());

        if(optionalEvento.isPresent()) {
            List<String> copias = new ArrayList<>();
            EmailDTO emailDTO = new EmailDTO();
            Evento eventoHoje = optionalEvento.get();

            emailDTO.setAssunto("Hoje tem! um evento organizado pela nossa Familía");
            emailDTO.setCorpo("Um evento está para acontecer hoje: " +
                    eventoHoje.getNome() +
                    ". Esse evento foi organizado por " +
                    eventoHoje.getUsuario().toArray()[0] +
                    " E mais " + (eventoHoje.getUsuario().toArray().length - 1) + " pessoas."
            );
            emailDTO.setDestinatario(applicationProperties.enderecoRemetente);

            for (Usuario u : eventoHoje.getUsuario()) {
                copias.add(u.getEmail());
            }

            emailDTO.setCopias(copias);

            emailService.enviaEmail(emailDTO);
            System.out.println("Enviou o email!\n");
        }
    }
}
