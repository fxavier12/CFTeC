package br.data.Validacao;


import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class JavaMailApp {

   
    public void sendMail(String Destino, String cod) {
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("emailvalidacaocadastro@gmail.com",
                        "emailvalidacaocadastro123");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("emailvalidacaocadastro@gmail.com")); //Remetente
             
            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(Destino);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Email de Validação de Cadastro Collaborator");//Assunto
            
            String texto = "http://localhost:8084/CFTeC/faces/operacoes/crudColaborador/Validation.xhtml?p1="+cod;
            message.setText(" Link para validação do cadastro " + texto);
            /**
             * Método para enviar a mensagem criada
            */
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
