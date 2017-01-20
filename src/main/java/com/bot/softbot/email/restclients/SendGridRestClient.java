package com.bot.softbot.email.restclients;

import com.bot.softbot.email.service.ClientFactory;
import com.bot.softbot.email.utils.EmailConstants;

import com.bot.softbot.email.beans.SGEmailObjectV3;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;

/**
 * @author abhishekrai
 * @since 13/12/2016
 * This class is single point of contact with SendGrid WebService.
 * Http Timeout will be added to avoid any network latency.
 */
@Component
public class SendGridRestClient {

    private static Logger logger = Logger.getLogger(SendGridRestClient.class);

    /**
     * SendGrid WebService for transaction emails,
     * faster than SendGrid SDK.
     * @param sgEmailObjectV3
     * @return
     */
    public int sgSendEmail(SGEmailObjectV3 sgEmailObjectV3) {
        try {
            WebResource target = ClientFactory.clientBuilder().resource(EmailConstants.SENDGRID_V3_SEND_EMAIL_URL);

            ObjectMapper mapper = new ObjectMapper();
            String requestJson = mapper.writeValueAsString(sgEmailObjectV3);
            //logger.info("JSON so formed as :" + requestJson);
            ClientResponse response = target.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header(EmailConstants.SENDGRID_AUTHORIZATION_HEADER_KEY, EmailConstants.SENDGRID_AUTHORIZATION_HEADER_VALUE).post(ClientResponse.class, requestJson);
            if(response.getStatus() !=202) {
                logger.info("email didn't successful");
                logger.info("Response status came in as : " + response.getStatus());
                return response.getStatus();
            } else {
                logger.info("Email was successful");
                logger.info("Response status came in as : " + response.getStatus());
                return response.getStatus();
            }
        } catch (Exception io) {
            logger.error("IO exception occurred while converting object to json :" + io);
            return HttpStatus.SC_INTERNAL_SERVER_ERROR;
        }
    }
}
