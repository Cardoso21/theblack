package br.com.theblack.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.theblack.config.ApplicationProperties;
import br.com.theblack.service.DTO.EmailDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
@Service
@RequiredArgsConstructor
@Transactional
public class EmailService {

    private  JavaMailSender javaMailSender;
    private  ApplicationProperties applicationProperties;

    @SneakyThrows
    public void enviaEmail(EmailDTO dto) throws MessagingException{
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mime = new MimeMessageHelper(message, false, "UTF-8");
        mime.setTo(dto.getDestinatario());
        mime.setFrom(applicationProperties.enderecoRemetente);
        mime.setSubject(dto.getAssunto());
        for(String s: dto.getCopias()){
            mime.addCc(s);
        }
        mime.setText(dto.getCorpo());
        javaMailSender.send(message);
    }
}
