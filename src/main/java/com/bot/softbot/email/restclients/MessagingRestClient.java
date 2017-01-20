package com.bot.softbot.email.restclients;

import javax.ws.rs.core.MediaType;

import com.bot.softbot.email.beans.InfoBipSMSBean;
import com.bot.softbot.email.service.ClientFactory;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessagingRestClient {
    private static Logger logger = Logger.getLogger(MessagingRestClient.class);
  
	@Value("${messaging.infobip.authkey}")
	private String authKey;

	@Value("${messaging.infobip.url}")
	private String url;

    /**
     * It can be useful for sending multi as well as single recipient message.
     * either create array of {infoBipSMSBean} object or single array object,
     * depending on usage or requirements.
     * @param infoBipSMSBean
     * @author abhishekrai
     */
    public void sendMultiSMS(InfoBipSMSBean[] infoBipSMSBean) {
        logger.info("SMS send method");
        long startTime = System.currentTimeMillis();
        Map map = new HashMap();
        map.put("messages", infoBipSMSBean);

        try {

            //Getting jersey client from factory method.
            WebResource webResource = ClientFactory.clientBuilder().resource(url+"/sms/1/text/multi");
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String clientJson = mapper.writeValueAsString(map);
            logger.info("Json so formed as :" + clientJson);

            ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON)
                    .type(MediaType.APPLICATION_JSON).header("Authorization", "App "+authKey).post(ClientResponse.class, clientJson);

            // Response Status from InfoBip
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            } else {
                logger.info("SMS send successfully");
            }
        } catch (Exception e) {
            logger.error("Exception occurred while sending SMS :" + e);
            e.printStackTrace();
        }
        logger.info("Execution time for Multi SMS method :" + (System.currentTimeMillis() - startTime));
    }

}