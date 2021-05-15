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
/*    public static void main(String[] args) {
        String body;
        body = "<html><head>This is Testing mail</head><body>{\"centers\":[{\"center_id\":633912,\"name\":\"PERUNGUDI-UCHC COVAXIN\",\"address\":\"NO-1 SCHOOL ROAD KARAYANCHAVADI PERUNGUDI\",\"state_name\":\"Tamil Nadu\",\"district_name\":\"Chennai\",\"block_name\":\"Perungudi\",\"pincode\":600096,\"lat\":12,\"long\":80,\"from\":\"09:00:00\",\"to\":\"16:00:00\",\"fee_type\":\"Free\",\"sessions\":[{\"session_id\":\"26784c46-338d-4522-8986-c6228ea89c80\",\"date\":\"09-05-2021\",\"available_capacity\":0,\"min_age_limit\":45,\"vaccine\":\"COVAXIN\",\"slots\":[\"09:00AM-11:00AM\",\"11:00AM-01:00PM\",\"01:00PM-03:00PM\",\"03:00PM-04:00PM\"]}]},{\"center_id\":603362,\"name\":\"Apollo Spec HospOMR COVISHIELD\",\"address\":\"5-639 Old Mahabalipuram Rd Tirumalai Nagar Perungudi Chennai\",\"state_name\":\"Tamil Nadu\",\"district_name\":\"Chennai\",\"block_name\":\"Perungudi\",\"pincode\":600096,\"lat\":12,\"long\":80,\"from\":\"09:00:00\",\"to\":\"15:30:00\",\"fee_type\":\"Paid\",\"sessions\":[{\"session_id\":\"1d896811-5753-46a3-9876-39802bdf82a8\",\"date\":\"09-05-2021\",\"available_capacity\":0,\"min_age_limit\":18,\"vaccine\":\"COVISHIELD\",\"slots\":[\"09:00AM-10:00AM\",\"10:00AM-11:00AM\",\"11:00AM-12:00PM\",\"12:00PM-03:30PM\"]},{\"session_id\":\"c6bda42d-e98a-442c-bff2-6526e2d5df7e\",\"date\":\"10-05-2021\",\"available_capacity\":0,\"min_age_limit\":18,\"vaccine\":\"COVISHIELD\",\"slots\":[\"09:00AM-11:00AM\",\"11:00AM-01:00PM\",\"01:00PM-03:00PM\",\"03:00PM-04:00PM\"]}],\"vaccine_fees\":[{\"vaccine\":\"COVISHIELD\",\"fee\":\"850\"}]},{\"center_id\":604167,\"name\":\"PERUNGUDI-UCHC COVISHIELD\",\"address\":\"NO-1 SCHOOL ROAD KARAYANCHAVADI PERUNGUDI\",\"state_name\":\"Tamil Nadu\",\"district_name\":\"Chennai\",\"block_name\":\"Perungudi\",\"pincode\":600096,\"lat\":12,\"long\":80,\"from\":\"09:00:00\",\"to\":\"16:00:00\",\"fee_type\":\"Free\",\"sessions\":[{\"session_id\":\"5556d9ce-ff4d-41b3-93b4-b2766c75810e\",\"date\":\"09-05-2021\",\"available_capacity\":0,\"min_age_limit\":45,\"vaccine\":\"COVISHIELD\",\"slots\":[\"09:00AM-11:00AM\",\"11:00AM-01:00PM\",\"01:00PM-03:00PM\",\"03:00PM-04:00PM\"]}]},{\"center_id\":581756,\"name\":\"Apollo Proton COVISHIELD\",\"address\":\"Perungudi\",\"state_name\":\"Tamil Nadu\",\"district_name\":\"Chennai\",\"block_name\":\"Perungudi\",\"pincode\":600096,\"lat\":12,\"long\":80,\"from\":\"09:00:00\",\"to\":\"14:00:00\",\"fee_type\":\"Paid\",\"sessions\":[{\"session_id\":\"766cf5ab-eed8-45f9-9ebf-c0f84f0dc2fd\",\"date\":\"10-05-2021\",\"available_capacity\":0,\"min_age_limit\":18,\"vaccine\":\"COVISHIELD\",\"slots\":[\"09:00AM-10:00AM\",\"10:00AM-11:00AM\",\"11:00AM-12:00PM\",\"12:00PM-02:00PM\"]}],\"vaccine_fees\":[{\"vaccine\":\"COVISHIELD\",\"fee\":\"850\"}]}]}</body></html>";
        sendEmail(body);
    }*/

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
    public void sendEmail(String body){
        try
        {
//            System.out.println("Sending Mail...");
//            System.out.println("To Mail===>>"+toMail);
//            System.out.println("Age -->>"+ageLimt);

            final String fromEmail = "kprabhu99@gmail.com"; //requires valid gmail id
            final String password = "XXXXXXXXXXXXXX"; // correct password for gmail id
//            final String toEmail = "kadiam.prabhu@gmail.com,Seshagiri.Palteru@gmail.com"; // can be any email id
            String subject ="Vaccine Availability Details - Age :: "+ageLimt+" and above";

            Session session = getMailSession(fromEmail, password);

            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/html; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("no_reply@example.com", "Prabhunandha"));

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
