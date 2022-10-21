package br.com.theblack.service.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {
    private String assunto;
    private String destinatario;
    private String corpo;
    private List<String> copias;
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	public List<String> getCopias() {
		return copias;
	}
	public void setCopias(List<String> copias) {
		this.copias = copias;
	}
    
	
    
}

