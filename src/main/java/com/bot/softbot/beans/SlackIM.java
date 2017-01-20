package com.bot.softbot.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author abhishekrai
 * @since 17/01/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackIM {
    private String id;
    private long created;
    private boolean is_im;
    private boolean is_org_shared;
    private String user;
    private boolean has_pins;
    private String last_read;
    private SlackMessage latest;
    private int unread_count;
    private int unread_count_display;
    private boolean is_open;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public boolean is_im() {
        return is_im;
    }

    public void setIs_im(boolean is_im) {
        this.is_im = is_im;
    }

    public boolean is_org_shared() {
        return is_org_shared;
    }

    public void setIs_org_shared(boolean is_org_shared) {
        this.is_org_shared = is_org_shared;
    }

    public boolean isHas_pins() {
        return has_pins;
    }

    public void setHas_pins(boolean has_pins) {
        this.has_pins = has_pins;
    }

    public String getLast_read() {
        return last_read;
    }

    public void setLast_read(String last_read) {
        this.last_read = last_read;
    }

    public SlackMessage getLatest() {
        return latest;
    }

    public void setLatest(SlackMessage latest) {
        this.latest = latest;
    }

    public int getUnread_count() {
        return unread_count;
    }

    public void setUnread_count(int unread_count) {
        this.unread_count = unread_count;
    }

    public int getUnread_count_display() {
        return unread_count_display;
    }

    public void setUnread_count_display(int unread_count_display) {
        this.unread_count_display = unread_count_display;
    }

    public void setIs_open(boolean is_open) {
        this.is_open = is_open;
    }

    public boolean is_open() {
        return is_open;
    }

    @Override
    public String toString() {
        return "SlackIM{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", is_im=" + is_im +
                ", is_org_shared=" + is_org_shared +
                ", user='" + user + '\'' +
                ", has_pins=" + has_pins +
                ", last_read='" + last_read + '\'' +
                ", latest=" + latest +
                ", unread_count=" + unread_count +
                ", unread_count_display=" + unread_count_display +
                ", is_open=" + is_open +
                '}';
    }
}
