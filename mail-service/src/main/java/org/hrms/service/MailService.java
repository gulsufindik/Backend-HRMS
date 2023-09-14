package org.hrms.service;

import lombok.RequiredArgsConstructor;
import org.hrms.rabbitmq.model.ActivationMailModel;
import org.hrms.rabbitmq.model.RegisterEmployeeModel;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;


    public void sendActivationMail(ActivationMailModel model) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setFrom("${java9mail}");
        helper.setTo(model.getEmail());
        helper.setSubject("Linke tiklayarak hesabinizi aktif ediniz");

        String htmlContent = "<div style=\"background-color: #007bff; color: white; text-align: center; padding: 10px; border-radius: 15px\">" +
                "<h2 style=\"margin: 0;\">Hesabınızı Aktive Edin</h2>" +
                "<p style=\"font-size: 18px;\">Hesabınızı aktive etmek için aşağıdaki linke tıklayın:</p>" +
                "<a href=\"http://localhost:9090/api/v1/auth/activation?token=" + model.getActivationCode() + "\"" +
                " style=\"display: inline-block; padding: 10px 20px; background-color: #ff9900; color: white; text-decoration: none; border-radius: 5px;\">Aktivasyon Linki</a>" +
                "</div>";

        helper.setText(htmlContent, true);

        javaMailSender.send(mimeMessage);
    }

    public void sendRegisterEmployeeMail(RegisterEmployeeModel model) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setFrom("${java9mail}");
        helper.setTo(model.getPersonalEmail());
        helper.setSubject(model.getCompanyName());

        String htmlContent = "<div style=\"background-color: #007bff; color: white; text-align: center; padding: 10px; border-radius: 15px\">" +
                "<h2 style=\"margin: 0; background-color: orangered; color: white; border: 2px solid red; border-radius: 15px; \">Aramiza Hosgeldin "+model.getName().toUpperCase()+" ◕‿◕✿, Sirket hesap bilgilerin assagida paylasilmistir</h2>" +
                "<p style=\"font-size: 18px;\"> Emailin : "+model.getCompanyEmail()+"</p>" +
                "<p style=\"font-size: 18px;\"> Sifren : "+model.getPassword()+"</p>" +
                "</div>";

        helper.setText(htmlContent, true);

        javaMailSender.send(mimeMessage);
    }
}
