package com.bot.softbot.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author abhishekrai
 * @since 17/01/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackBot {
    private String id;
    private boolean deleted;
    private String name;
    private String app_id;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "SlackBot{" +
                "id='" + id + '\'' +
                ", deleted=" + deleted +
                ", name='" + name + '\'' +
                ", app_id='" + app_id + '\'' +
                '}';
    }
}
