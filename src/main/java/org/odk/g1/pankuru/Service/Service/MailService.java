package org.odk.g1.pankuru.Service.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.odk.g1.pankuru.dto.MailStructure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final JavaMailSender javaMailSender;
    private final MimeMessage mimeMessage;

    public MailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
        this.mimeMessage = javaMailSender.createMimeMessage();
    }

    @Value("${spring.mail.username}")
    public String sendFrom;

    /*public void sendMail(String mail, MailStructure mailStructure){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sendFrom);
        simpleMailMessage.setSubject(mailStructure.getSubject());
        simpleMailMessage.setText(mailStructure.getMessage());
        simpleMailMessage.setTo(mail);

        javaMailSender.send(simpleMailMessage);
    }*/
    public void sendMail(String to, MailStructure mailStructure, Long idTicket) {


        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(sendFrom);
            helper.setTo(to);
            helper.setSubject(mailStructure.getSubject());

            String htmlMsg = "<html><body>" +
                    "<h3>" + mailStructure.getMessage() + "</h3>" +
                    "<a href=\"http://localhost:8080/formateur/ticket/statut/" + idTicket + "/1\" style=\"display:inline-block;padding:10px 20px;font-size:16px;color:#ffffff;background-color:#007bff;text-decoration:none;border-radius:5px;\">Commencer le traitement</a>" +
                    "</body></html>";

            helper.setText(htmlMsg, true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void sendMailToApprenant(String to, MailStructure mailStructure, Long idTicket) {

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(sendFrom);
            helper.setTo(to);
            helper.setSubject(mailStructure.getSubject());

            String htmlMsg = "<html><body>" +
                    "<h3>" + mailStructure.getMessage() + "</h3>" +
                    "</body></html>";

            helper.setText(htmlMsg, true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}