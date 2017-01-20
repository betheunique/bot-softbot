package com.bot.softbot.client;

import com.bot.softbot.beans.SlackMessage;
import com.bot.softbot.beans.SlackPong;
import com.bot.softbot.beans.SlackUserJoined;
import com.bot.softbot.constants.SlackMessageTypes;
import com.bot.softbot.handler.EventHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.util.HashSet;
import java.util.Set;

/**
 * @author abhishekrai
 * @since 13/01/2017
 * Its a webSocket end point all communication goes through here.
 */
@ClientEndpoint
public class SoftBotClient {

    private Logger logger = Logger.getLogger(SoftBotClient.class);
    private Set<Session> sessionSet = new HashSet<Session>();

    @OnOpen
    public void onOpenConnection (Session session) {
        sessionSet.add(session);
        logger.info("Session set size :" + sessionSet.size());
        logger.info("On open connection print this :" + session.getId());
    }

    @OnMessage
    public void onMessageReceive (String message, Session session) {
        EventHandler eventHandler = new EventHandler();
        logger.info("Session id :" + session.getId());
        logger.info(" Message received form slack :" + message);
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(message);
            if(node.path("type").asText().equalsIgnoreCase(SlackMessageTypes.MESSAGE.name().toLowerCase())) {
                SlackMessage slackMessage = mapper.readValue(message, SlackMessage.class);
            } else if(node.path("type").asText().equalsIgnoreCase(SlackMessageTypes.GOODBYE.name().toLowerCase())) {
//                eventHandler.goodByeHandler();
            } else if (node.path("type").asText().equalsIgnoreCase(SlackMessageTypes.TEAM_JOIN.name().toLowerCase())) {
                SlackUserJoined slackUserJoined = mapper.readValue(message, SlackUserJoined.class);
                eventHandler.userJoined(slackUserJoined, session);
            } else if (node.path("type").asText().equalsIgnoreCase(SlackMessageTypes.PONG.name().toLowerCase())) {
                SlackPong slackPong = mapper.readValue(message, SlackPong.class);
                eventHandler.pongHandler(slackPong, session);
            } else {
                logger.info("Not Doing anything other than printing message : "+ message);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while mapping event :" + e);
        }
    }

    @OnClose
    public void onClose (Session session, CloseReason reason) {
        logger.info("Removing the session:" + session.getId());
        sessionSet.remove(session);
        logger.info("Reason for close :" + reason.getReasonPhrase());
    }

//    @OnError
//    public void onError(Exception e) {
//        System.out.println("Error occurred in this session :" + e);
//    }
//    public CountDownLatch getLatch() {
//        return latch;
//    }
//


//    public static void main(String[] args) {
//        latch = new CountDownLatch(1);
//
//        Client client = Client.create();
//        try {
//            String dest = "ws://slack.com/api/rtm.start?token=";
//
////            client.connectToServer(SoftBotClient.class, new URI());
//            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
//            container.connectToServer(SoftBotClient.class, new URI(dest));
//            latch.await();
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

}
