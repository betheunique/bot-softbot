package com.bot.softbot.beans;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author abhishekrai
 * @since 17/01/2017
 */
public class SlackPing {
    int id;
    String type;

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

    public String toJSONString() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

    @Override
    public String toString() {
        return "Ping{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
