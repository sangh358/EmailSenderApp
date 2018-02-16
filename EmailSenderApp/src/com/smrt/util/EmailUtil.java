package com.smrt.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.iap.Response;

public class EmailUtil {
	 public static void sendEmail(String fromemail,String pass, ArrayList<String> toBcc,String subject, String message) throws AddressException,
	            MessagingException {
	 
	        // sets SMTP server properties
	        Properties properties = new Properties();
	        
	        /*properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.smtp.port", "587");
	        */
	        properties.put("mail.smtp.host", "smtp.smartleaven.com");
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	 
	        // creates a new session with an authenticator
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(fromemail, pass);
	            }
	        };
	 
	        Session session = Session.getInstance(properties, auth);
	        
	        /*StringBuilder bodyText = new StringBuilder(); 
			bodyText.append("<div>")
			     .append("  Dear User<br/><br/>")
			     .append("  ("+message+") <br/>")
			     .append("<span >Writing HTML Mail</span>")
			     .append("  Please click <a href=\""+"\">here</a> or open below link in browser<br/>")
			     .append("  <a href=</a>")
			     .append("  <img width=100 height=50  src='http://smartleaven.com/images/Logo.png'> ")
			     .append("  Thanks,<br/>")
			     .append("  Sanghapal S.Salave")
			     .append("</div>");*/
	 
	        // creates a new e-mail message
	        System.out.println("Arraylist form util"+toBcc);
	        String[] emailArr = new String[toBcc.size()];
	        emailArr = toBcc.toArray(emailArr);
            System.out.println("Convtertd arrylist to string"+emailArr);
	        for(String s : emailArr)
	            System.out.println("Email array"+s);
	        
	        InternetAddress[] address = new InternetAddress[emailArr.length];
	        for(int i =0; i< emailArr.length; i++)
	        {
	            address[i] = new InternetAddress(emailArr[i]);
	        }
           System.out.println("Address from util"+address);
	        
	        Message msg = new MimeMessage(session);
	        
	        msg.setFrom(new InternetAddress(fromemail));
	        InternetAddress[] toAddr = { new InternetAddress("seema@smartleaven.com") };
	        msg.setRecipients(Message.RecipientType.TO, toAddr);
	        msg.setRecipients(Message.RecipientType.BCC, address);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
            msg.setContent(message.toString(),"text/html; charset=utf-8");
	      
	        // sends the e-mail
	        Transport.send(msg);
	        
	        /*Transport transport = session.getTransport("smtps");
	        transport.connect ("smtp.gmail.com", "465", smtp_username, smtp_password);
	        transport.sendMessage(msg, msg.getAllRecipients());
	        transport.close(); */
	 
	    }

}
