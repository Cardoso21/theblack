package br.com.theblack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.theblack.dominio.Motivo;

public interface MotivoRepository extends JpaRepository<Motivo,Long>{

}
