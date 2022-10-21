package br.com.theblack.service.DTO;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


public class EventoDTO {

    private Long id;

    @NotBlank
    private String nome;

    @NotNull(message = "Data não pode ser nula\"")
    @Future(message = "Nao e possivel criar um evento em uma data passada")
    private LocalDate dataEvento;

    private String justificativa;

    @NotNull(message = "Valor não pode ser nulo")
    private Double valor;

    @NotNull(message = "Motivo não pode ser nulo")
    private SelectDTO motivo;
    @NotNull(message = "Situação não pode ser nula")
    private SelectDTO situacao;
    @NotNull(message = "Usuario não pode ser nulo")
    private List<SelectDTO> usuario;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public SelectDTO getMotivo() {
		return motivo;
	}
	public void setMotivo(SelectDTO motivo) {
		this.motivo = motivo;
	}
	public SelectDTO getSituacao() {
		return situacao;
	}
	public void setSituacao(SelectDTO situacao) {
		this.situacao = situacao;
	}
	public List<SelectDTO> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<SelectDTO> usuario) {
		this.usuario = usuario;
	}
    
    
}