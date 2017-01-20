package com.bot.softbot.email.service;

import com.bot.softbot.common.NotificationProperties;
import com.bot.softbot.email.beans.EmailPersonalizations;

import com.bot.softbot.email.beans.EmailResponse;
import com.bot.softbot.email.beans.SGEmailObjectV3;
import com.bot.softbot.email.restclients.SendGridRestClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmailService implements EmailService {

	private static Logger logger = Logger.getLogger(DefaultEmailService.class);

	@Autowired
	private NotificationProperties notificationProperties;

	@Autowired
	private SendGridRestClient sendGridRestClient;


//	/**
//	 * Version-3 Its a sendGrid WebService, SendGrid Suggested it is faster than their SMTP SDK version,
//	 * @since 2016-12-20
//	 * @author abhishekrai
//	 * @return
//	 */
//	public EmailResponse sendViaSendGrid_V3 (String customerEmailId, String senderEmailId, String customerName, String subject, String htmlContent, String category, String itineraryId){
//		EmailResponse emailResponse = new EmailResponse();
//
//		EmailPersonalizations[] emailPersonalizations = new EmailPersonalizations[1];
//		EmailPersonalizations emailPersonalizationsObject =  new EmailPersonalizations();
//		SGEmailObjectV3 sgEmailObjectV3 = new SGEmailObjectV3();
//
//		/**
//		 * Personalizing {to} and {bcc}.
//		 */
//		EmailPersonalizations.To[] to = new EmailPersonalizations.To[1];
//		EmailPersonalizations.To toObject = new EmailPersonalizations.To();
//		toObject.setEmail(customerEmailId);
//		toObject.setName(customerName);
//		to[0] = toObject;
//		emailPersonalizationsObject.setTo(to);
//
//		EmailPersonalizations.Bcc[] bcc = new EmailPersonalizations.Bcc[1];
//		EmailPersonalizations.Bcc bccObject = new EmailPersonalizations.Bcc();
//		bccObject.setEmail(notificationProperties.getPropertiesTextValue(FROM));
//		bccObject.setName(notificationProperties.getPropertiesTextValue(FROMNAME));
//		bcc[0] = bccObject;
//		emailPersonalizationsObject.setBcc(bcc);
//
//		emailPersonalizations[0] = emailPersonalizationsObject;
//		sgEmailObjectV3.setPersonalizations(emailPersonalizations);
//
//		SGEmailObjectV3.From from = new SGEmailObjectV3.From();
//		from.setEmail(notificationProperties.getPropertiesTextValue(FROM));
//		from.setName(notificationProperties.getPropertiesTextValue(FROMNAME));
//		sgEmailObjectV3.setFrom(from);
//
//		SGEmailObjectV3.ReplyTo replyTo = new SGEmailObjectV3.ReplyTo();
//		replyTo.setEmail(notificationProperties.getPropertiesTextValue(FROM));
//		replyTo.setName(notificationProperties.getPropertiesTextValue(FROMNAME));
//		sgEmailObjectV3.setReply_to(replyTo);
//
//		String[] categories = new String[1];
//		categories[0] = category;
//		sgEmailObjectV3.setCategories(categories);
//		sgEmailObjectV3.setSubject(subject);
//
//		SGEmailObjectV3.Content contentObject = new SGEmailObjectV3.Content();
//		SGEmailObjectV3.Content[] content = new SGEmailObjectV3.Content[1];
//		contentObject.setType("text/html");
//		contentObject.setValue(htmlContent);
//		content[0] = contentObject;
//
//		sgEmailObjectV3.setContent(content);
//
//		int status = sendGridRestClient.sgSendEmail(sgEmailObjectV3);
//		if(status != 202) {
//			emailResponse.setStatus(status);
//			emailResponse.setMessage("Something went wrong on sendGrid side");
//		} else {
//			emailResponse.setMessage("Email Sent successfully");
//			emailResponse.setStatus(status);
//		}
//		return emailResponse;
//	}
}
