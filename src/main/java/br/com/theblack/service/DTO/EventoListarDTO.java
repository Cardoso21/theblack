package br.com.theblack.service.DTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventoListarDTO {
    private Long id;
    private String nome;
    private LocalDate dataEvento;
}
