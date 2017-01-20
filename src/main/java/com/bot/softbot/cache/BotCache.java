package com.bot.softbot.cache;

import com.bot.softbot.beans.SlackChannel;
import com.bot.softbot.beans.SlackGroup;
import com.bot.softbot.beans.SlackIM;
import com.bot.softbot.beans.SlackUser;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.HashMap;
import java.util.Map;

/**
 * @author abhishekrai
 * @since 17/01/2017
 * Its Bot Memory, All the initial information stored here. About {@link SlackChannel}, {@link SlackUser}, {@link SlackGroup},
 * {@link SlackIM} and {@link Session}.
 */
@Component
public class BotCache {
    private static Logger logger = Logger.getLogger(BotCache.class);
    private Session session = null;

    /**
     * Map for Active users against their userID.
     */
    private Map<String, SlackUser> userIDVsSlackUser = new HashMap<String, SlackUser>();

    /**
     * Map for active channel against their channelID.
     */
    private Map<String, SlackChannel> channelIDVsSlackChannel = new HashMap<String, SlackChannel>();

    /**
     * Map for active group against their GroupID.
     */
    private Map<String, SlackGroup> groupIDVsSlackGroup = new HashMap<String, SlackGroup>();

    /**
     * Map for active direct message of Bot against IMId.
     */
    private Map<String, SlackIM> imIDVsSlackIM = new HashMap<String, SlackIM>();

    /**
     * Map for active direct message of userId againts imID.
     */
    private Map<String, String> userIDVsImID = new HashMap<String, String>();

    public void addUserAgainstUserID(String id, SlackUser slackUser) {
        userIDVsSlackUser.put(id, slackUser);
    }

    public void addChannelAgainstChannelID(String id, SlackChannel slackChannel) {
        channelIDVsSlackChannel.put(id, slackChannel);
    }

    public void addGroupAgainstGroupID(String groupId, SlackGroup slackGroup) {
        groupIDVsSlackGroup.put(groupId, slackGroup);
    }

    public void addDirectMessageAgainstImID(String imID, SlackIM slackIM) {
        imIDVsSlackIM.put(imID, slackIM);
    }

    public void addIMIdagainstUserID(String userId, String imID) {
        userIDVsImID.put(userId, imID);
    }

    /**
     * Get SlackUser against its ID.
     * @param userID
     * @return
     */
    public SlackUser getSlackUser(String userID) {
        return userIDVsSlackUser.get(userID);
    }

    public String getIMID(String userID) {
        return userIDVsImID.get(userID);
    }

    public SlackIM getSlackIM(String imID) {
        return imIDVsSlackIM.get(imID);
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }
}
