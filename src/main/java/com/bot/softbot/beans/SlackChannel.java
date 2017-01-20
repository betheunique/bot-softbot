package com.bot.softbot.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author abhishekrai
 * @since 17/01/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackChannel {
    private String id;
    private String name;
    private long created;
    private String creator;
    private boolean is_archived;
    private boolean is_general;
    private boolean has_pins;
    private boolean is_member;

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

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean is_archived() {
        return is_archived;
    }

    public void setIs_archived(boolean is_archived) {
        this.is_archived = is_archived;
    }

    public boolean is_general() {
        return is_general;
    }

    public void setIs_general(boolean is_general) {
        this.is_general = is_general;
    }

    public boolean is_member() {
        return is_member;
    }

    public void setIs_member(boolean is_member) {
        this.is_member = is_member;
    }

    public boolean isHas_pins() {
        return has_pins;
    }

    public void setHas_pins(boolean has_pins) {
        this.has_pins = has_pins;
    }

    @Override
    public String toString() {
        return "SlackChannel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", creator='" + creator + '\'' +
                ", is_archived=" + is_archived +
                ", is_general=" + is_general +
                ", has_pins=" + has_pins +
                ", is_member=" + is_member +
                '}';
    }
}
