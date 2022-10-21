package br.com.theblack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.theblack.dominio.Pagamento;

public interface PagamentoRepository extends JpaRepository <Pagamento,Long>, JpaSpecificationExecutor<Pagamento>{

}
