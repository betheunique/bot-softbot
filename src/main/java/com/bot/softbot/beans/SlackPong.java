package com.bot.softbot.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author abhishekrai
 * @since 17/01/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackPong implements SlackEvent {

    int id;
    String type;
    int reply_to;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getReply_to() {
        return reply_to;
    }

    public void setReply_to(int reply_to) {
        this.reply_to = reply_to;
    }

    @Override
    public String toString() {
        return "SlackPong{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", reply_to=" + reply_to +
                '}';
    }
}
