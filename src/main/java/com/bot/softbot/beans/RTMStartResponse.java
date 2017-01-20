package com.bot.softbot.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * @author abhishekrai
 * @since 15/01/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RTMStartResponse {
    private boolean ok;
    private String url;
    private SlackUser[] users;
    private SlackChannel[] channels;
    private SlackIM[] ims;
    private SlackBot[] bots;
    private SlackGroup[] groups;


    public boolean getOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SlackUser[] getUsers() {
        return users;
    }

    public void setUsers(SlackUser[] users) {
        this.users = users;
    }

    public SlackChannel[] getChannels() {
        return channels;
    }

    public void setChannels(SlackChannel[] channels) {
        this.channels = channels;
    }

    public SlackIM[] getIms() {
        return ims;
    }

    public void setBots(SlackBot[] bots) {
        this.bots = bots;
    }

    public SlackBot[] getBots() {
        return bots;
    }

    public void setIms(SlackIM[] ims) {
        this.ims = ims;
    }

    public SlackGroup[] getGroups() {
        return groups;
    }

    public void setGroups(SlackGroup[] groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "RTMStartResponse{" +
                "ok=" + ok +
                ", url='" + url + '\'' +
                ", users=" + Arrays.toString(users) +
                ", channels=" + Arrays.toString(channels) +
                ", ims=" + Arrays.toString(ims) +
                ", bots=" + Arrays.toString(bots) +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}
