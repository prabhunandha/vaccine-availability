package com.kadiam.cowin.vaccine.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailUtil {
    public static final Logger log = LoggerFactory.getLogger(EmailUtil.class);

    @Value("${to.mail.id}")
    public String toMail;

    @Value("${age.limit}")
    public long ageLimt;

    @Value("${from.mail.id}")
    public String fromEmail;

    @Value("${secret.password}")
    public String password;

    private Session getMailSession(String fromEmail, String password) {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        return session;
    }

    /**
     * Utility method to send simple HTML email
     * @param body
     */
    public void sendEmail(String body, String date){
        try
        {
            String subject ="Vaccine Availability Details By Pincode On "+date;

            Session session = getMailSession(fromEmail, password);

            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/html; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("no_reply@example.com", "Prabhunandha KADIAM"));

            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail, false));

            Transport.send(msg);

            System.out.println("Email Sent Successfully!!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
