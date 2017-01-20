package com.bot.softbot.ws.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author abhishekrai
 * @since 18/01/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QOD {
    private QuoteContent contents;

    public QuoteContent getContents() {
        return contents;
    }

    public void setContents(QuoteContent contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "QOD{" +
                "contents=" + contents +
                '}';
    }
}
