package br.com.theblack.repository;

import br.com.theblack.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

    List<Usuario> findByStatusTrue();
    List<Usuario> findByStatusFalse();

    boolean existsByEmail(String email);

}
