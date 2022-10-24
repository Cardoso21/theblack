package br.com.theblack.service;

import br.com.theblack.dominio.Usuario;
import br.com.theblack.repository.UsuarioRepository;
import br.com.theblack.service.dto.SelectDTO;
import br.com.theblack.service.dto.UsuarioDTO;
import br.com.theblack.service.dto.UsuarioListagemDTO;
import br.com.theblack.service.exception.RegraNegocioException;
import br.com.theblack.service.filter.UsuarioFilter;
import br.com.theblack.service.mapper.UsuarioListagemMapper;
import br.com.theblack.service.mapper.UsuarioMapper;
import br.com.theblack.service.mapper.UsuarioSelectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final EventoService eventoService;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioListagemMapper usuarioListagemMapper;
    private final UsuarioSelectMapper usuarioSelectMapper;
    
    public List<UsuarioListagemDTO> mostrarTodosUsuariosFiltrado(UsuarioFilter filtro) {
        return usuarioListagemMapper.toDto(usuarioRepository.findAll(filtro.filtrar()));

    }

    public UsuarioDTO mostrarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Usuario não existe"));
        return usuarioMapper.toDto(usuario);
    }

    public List<SelectDTO> listarUsuariosEmSelect(){
        return usuarioSelectMapper.toDto(usuarioRepository.findAll());
    }

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RegraNegocioException("E-mail ja existe");
        }
        return usuarioMapper.toDto(persistir(usuario));
    }

    public UsuarioDTO editarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario usuarioBanco = usuarioRepository.findById(usuario.getId()).orElseThrow(() -> new RegraNegocioException("Usuario não existe"));

        return usuarioMapper.toDto(persistir(persistir(usuario)));
    }


    public void inativarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Usuário Não existe"));
        eventoService.InativacaoDeUsuario(usuario);
        usuario.setStatus(false);
        usuarioRepository.save(usuario);
    }

    public UsuarioDTO ativarusuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Usuário Não Existe"));
        usuario.setStatus(true);
        Usuario usuariosalvar = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuariosalvar);

    }

    private Usuario persistir(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
