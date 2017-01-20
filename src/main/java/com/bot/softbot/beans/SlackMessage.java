package com.bot.softbot.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author abhishekrai
 * @since 17/01/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackMessage {
    private String type;
    private String user;
    private String text;
    private String ts;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SlackMessage{" +
                "type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", text='" + text + '\'' +
                ", ts='" + ts + '\'' +
                '}';
    }
}
