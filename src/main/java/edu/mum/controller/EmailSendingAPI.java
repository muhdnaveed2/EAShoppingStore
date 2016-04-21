package edu.mum.controller;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@Configuration
public class EmailSendingAPI {


		public JavaMailSender javaMailService() {
			JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

			javaMailSender.setHost("smtp.gmail.com");
			javaMailSender.setPort(587);
			javaMailSender.setUsername("ushoppingstore123@gmail.com");
			javaMailSender.setPassword("HewlettPackard");

			javaMailSender.setJavaMailProperties(getMailProperties());

			return javaMailSender;
		}

		private Properties getMailProperties() {
			Properties properties = new Properties();
			properties.setProperty("mail.transport.protocol", "smtp");
			properties.setProperty("mail.smtp.auth","true");
			properties.setProperty("mail.smtp.starttls.enable", "true");
			properties.setProperty("mail.debug", "false");
			return properties;
		}

		public void send(String toAddress, String fromAddress, String subject, String msgBody) {
			JavaMailSender jms = javaMailService();
			MimeMessage mimeMessage = jms.createMimeMessage();
			try {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

				helper.setFrom(fromAddress);
				helper.setTo(toAddress);
				helper.setSubject(subject);
				helper.setText(msgBody);

				/*
				 * uncomment the following lines for attachment
				 * FileSystemResource file = new
				 * FileSystemResource("attachment.jpg");
				 * helper.addAttachment(file.getFilename(), file);
				 */

				jms.send(mimeMessage);
				System.out.println("Mail sent successfully.");
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

