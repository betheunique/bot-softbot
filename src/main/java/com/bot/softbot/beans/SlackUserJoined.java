package com.bot.softbot.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author abhishekrai
 * @since 18/01/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackUserJoined {
    private String type;
    private SlackUser user;

    public SlackUser getUser() {
        return user;
    }

    public void setUser(SlackUser user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "SlackUserJoined{" +
                "type='" + type + '\'' +
                ", user=" + user +
                '}';
    }
}
