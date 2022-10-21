package br.com.theblack.service.filter;

import org.springframework.data.jpa.domain.Specification;

public interface EntityFilter<E> {
    Specification<E> filtrar();
}
