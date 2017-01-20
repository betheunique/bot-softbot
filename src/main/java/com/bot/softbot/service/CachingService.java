package com.bot.softbot.service;

import com.bot.softbot.beans.RTMStartResponse;
import com.bot.softbot.beans.SlackChannel;
import com.bot.softbot.beans.SlackGroup;
import com.bot.softbot.beans.SlackIM;
import com.bot.softbot.beans.SlackUser;
import com.bot.softbot.cache.BotCache;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.websocket.Session;

/**
 * @author abhishekrai
 * @since 17/01/2017
 * Class is responsible for initializing {@link BotCache}. Basically it fill the bot memory.
 * {@link BotCache} consists of {@link SlackUser}, {@link SlackChannel}, {@link SlackGroup}, {@link SlackIM} and {Session}.
 */
@Service
public class CachingService {

    private static Logger logger = Logger.getLogger(CachingService.class);

    @Autowired
    private BotCache botCache;

    @Async
    public void initialize(RTMStartResponse rtmStartResponse, Session session) {
        SlackChannel[] slackChannels = rtmStartResponse.getChannels();
        SlackUser[] slackUsers = rtmStartResponse.getUsers();
        SlackGroup[] slackGroups = rtmStartResponse.getGroups();
        SlackIM[] slackIMs = rtmStartResponse.getIms();

        for(SlackChannel channel : slackChannels) {
            botCache.addChannelAgainstChannelID(channel.getId(), channel);
        }

        for(SlackUser user : slackUsers) {
            if(!user.isDeleted()) { //Only initializing active slack users in the team.
                botCache.addUserAgainstUserID(user.getId(), user);
            }
        }

        for(SlackGroup group : slackGroups) {
            if(group.is_open()) {
                botCache.addGroupAgainstGroupID(group.getId(), group);
            }
        }

        for(SlackIM im : slackIMs) {
            if(im.is_open()){
                botCache.addDirectMessageAgainstImID(im.getId(), im);
            }
        }

        for(SlackIM im : slackIMs) {
            if (im.is_open()) {
                botCache.addIMIdagainstUserID(im.getUser(), im.getId());
            }
        }

        botCache.setSession(session);
    }
}
