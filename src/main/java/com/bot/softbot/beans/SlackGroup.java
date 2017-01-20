package com.bot.softbot.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * @author abhishekrai
 * @since 17/01/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackGroup {
    private String id;
    private String name;
    private boolean is_group;
    private long created;
    private String creator;
    private boolean is_archived;
    private boolean is_mpim;
    private boolean has_pins;
    private boolean is_open;
    private String last_read;
    private SlackMessage latest;
    private int unread_count;
    private int unread_count_display;
    private String[] members;

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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public void setCreated(long created) {
        this.created = created;
    }

    public long getCreated() {
        return created;
    }

    public SlackMessage getLatest() {
        return latest;
    }

    public void setLatest(SlackMessage latest) {
        this.latest = latest;
    }

    public String getLast_read() {
        return last_read;
    }

    public void setLast_read(String last_read) {
        this.last_read = last_read;
    }

    public String[] getMembers() {
        return members;
    }

    public void setMembers(String[] members) {
        this.members = members;
    }

    public boolean isHas_pins() {
        return has_pins;
    }

    public void setHas_pins(boolean has_pins) {
        this.has_pins = has_pins;
    }

    public boolean is_archived() {
        return is_archived;
    }

    public void setIs_archived(boolean is_archived) {
        this.is_archived = is_archived;
    }

    public boolean is_group() {
        return is_group;
    }

    public void setIs_group(boolean is_group) {
        this.is_group = is_group;
    }

    public boolean is_mpim() {
        return is_mpim;
    }

    public void setIs_mpim(boolean is_mpim) {
        this.is_mpim = is_mpim;
    }

    public boolean is_open() {
        return is_open;
    }

    public void setIs_open(boolean is_open) {
        this.is_open = is_open;
    }

    @Override
    public String toString() {
        return "SlackGroup{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", is_group=" + is_group +
                ", created=" + created +
                ", creator='" + creator + '\'' +
                ", is_archived=" + is_archived +
                ", is_mpim=" + is_mpim +
                ", has_pins=" + has_pins +
                ", is_open=" + is_open +
                ", last_read='" + last_read + '\'' +
                ", latest=" + latest +
                ", unread_count=" + unread_count +
                ", unread_count_display=" + unread_count_display +
                ", members=" + Arrays.toString(members) +
                '}';
    }
}
