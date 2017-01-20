package com.bot.softbot.ws;

import com.bot.softbot.ws.beans.QOD;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author abhishekrai
 * @since 18/01/2017
 * Class Responsible to get Quote every Day at {10:30} from thirdPartyService.
 */
@Component
public class TheySaidDoSoClient {
    private static Logger logger = Logger.getLogger(TheySaidDoSoClient.class);

    private static Client client = new Client();

    public QOD getTodaysQuote() {
        WebResource target = client.resource("http://quotes.rest/qod.json");
        ClientResponse response = target.get(ClientResponse.class);
        try {
            ObjectMapper mapper = new ObjectMapper();
            String result = response.getEntity(String.class);
            logger.info("Result from third party Quote of the day :" + result);
            QOD qod = mapper.readValue(result, QOD.class);
            logger.info("Mapped Result to QAD :" + qod);
            return qod;
        } catch(Exception e) {
            logger.error("Exception occurred here getTodayQuote :" + e);
            return null;
        }
    }
}
