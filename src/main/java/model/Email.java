/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *Model class for sending an email
 * @author hoovb
 */
public class Email {

    private Session session;
    private String from = "send.address@gmail.com";

    /**
     * Sends an email to the user after decrypting 
     * the text.
     * @param email
     * @param digitizedText
     * @param c
     * @param v 
     */
    public void sendEmail(String email, String digitizedText, String c, String v) {
        String to = email;
        
        setupEmail();
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Your recently decrypted message");
            message.setText("Digitized text: " + digitizedText
                    +"\nCaesar Cipher result: " + c
                    +"\nVigenere Cipher result: " +v);
            Transport.send(message);
            System.out.println("Message sent to " + email);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    /**
     * Sends am email to the user after translating
     * the text. 
     * @param email
     * @param digitizedText
     * @param result 
     */
    public void sendEmail(String email, String digitizedText, String result) {
        String to = email;
        
        setupEmail();
     
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Your recently translated message" );
            message.setText("Digitized Text: " + digitizedText
                    +"\nTranslated to English: " +result);
            Transport.send(message);
            System.out.println("Message sent to " + email);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    /**
     * Sets up basic properties for sending an
     * email from a gmail account. 
     */
    private void setupEmail() {
        final String username = "nlb5264";
        final String password = "Decrypt123";
        String host = "smtp.gmail.com";
        Properties pro = new Properties();
        pro.put("mail.smtp.host", host);
        pro.put("mail.smtp.socketFactory.port", "465");
        pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.port", "465");
        session = Session.getInstance(pro,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        }
        );
    }
}
