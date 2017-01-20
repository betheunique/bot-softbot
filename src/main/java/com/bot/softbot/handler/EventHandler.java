package com.bot.softbot.handler;

import com.bot.softbot.beans.SlackPong;
import com.bot.softbot.beans.SlackUserJoined;
import com.bot.softbot.cache.BotCache;
import com.bot.softbot.constants.SlackMessageTypes;
import com.bot.softbot.beans.BotMessage;
import com.bot.softbot.email.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.Session;

/**
 * @author abhishekrai
 * @since 17/01/2017
 * Class consists of various message handler {manages message sends from slack and reply appropriate to these messages.}
 */
@Service
public class EventHandler {

    private static Logger logger = Logger.getLogger(EventHandler.class);

    @Autowired
    private BotCache botCache;

    @Autowired
    private EmailService defaultEmailService;

    public void userJoined(SlackUserJoined slackUserJoined, Session session) {
        botCache.addUserAgainstUserID(slackUserJoined.getUser().getId(), slackUserJoined.getUser());
        BotMessage botMessage = new BotMessage();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hi *" + slackUserJoined.getUser().getReal_name() + "*");
        stringBuilder.append("Welcome to Slack Family.!!");
        stringBuilder.append("\n");
        stringBuilder.append("I am SoftBot, I wish you All The Best in this Endeavour");
        botMessage.setId(123456);
        botMessage.setType(SlackMessageTypes.MESSAGE.name().toLowerCase());
        botMessage.setChannel(slackUserJoined.getUser().getId());
        botMessage.setText(stringBuilder.toString());
        try {
            ObjectMapper mapper = new ObjectMapper();
            String send = mapper.writeValueAsString(botMessage);
            session.getBasicRemote().sendText(send);
            stringBuilder.append("Hi <strong>" + slackUserJoined.getUser().getReal_name() + "</strong>");
            stringBuilder.append("Welcome to Slack Family.!!");
            stringBuilder.append("I wish you All The Best In This Endeavour");
            stringBuilder.append("<br/>");
            stringBuilder.append("<br/>");
            stringBuilder.append("<br/>");
            stringBuilder.append("<br/>");
            stringBuilder.append("<br/>");
            stringBuilder.append("<br/>");
            stringBuilder.append("<br/>");
            stringBuilder.append("Warm Regards,");
            stringBuilder.append("SoftBot");
            //defaultEmailService.sendViaSendGrid_V3(slackUserJoined.getUser().getProfile().getEmail(), null, slackUserJoined.getUser().getReal_name(), "Welcome To CatchThatBus Family!!", stringBuilder.toString(), "New Join", null);
        } catch (Exception e) {
            logger.error("Exception occurred while sending welcome mail:" + e);
        }
    }

    public void pongHandler(SlackPong slackPong, Session session) {
        logger.info("Pong response from slack: " + slackPong);
    }

    //TODO need to add handler.
    public void sendDirectMesage() {

    }

    public void sendMessageToChannel(String message) {
        String generalChannelID =  "";
        BotMessage botMessage = new BotMessage();
        botMessage.setText(message);
        botMessage.setChannel(generalChannelID);
        botMessage.setType(SlackMessageTypes.MESSAGE.name().toLowerCase());
        botMessage.setId(123456789);
        try {
            ObjectMapper mapper = new ObjectMapper();
            String send = mapper.writeValueAsString(botMessage);
            botCache.getSession().getBasicRemote().sendText(send);
        } catch (Exception e) {
            logger.error("Exception occurred in sendMessageToChannel :" + e);
        }

    }


    public void presenceChanged() {

    }

//    public void goodByeHandler() {
//        System.out.println("Initializing again connection");
//        bot.initialSlackConnect();
//    }
}
