package br.com.theblack.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application.email")
public class ApplicationProperties {
    public String enderecoRemetente;
    public String nomeRemetente;
}