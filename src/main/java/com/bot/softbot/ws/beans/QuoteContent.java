package com.bot.softbot.ws.beans;

import java.util.Arrays;

/**
 * @author abhishekrai
 * @since 18/01/2017
 */
public class QuoteContent {
    private Quote[] quotes;

    public Quote[] getQuotes() {
        return quotes;
    }

    public void setQuotes(Quote[] quotes) {
        this.quotes = quotes;
    }

    @Override
    public String toString() {
        return "QuoteContent{" +
                "quotes=" + Arrays.toString(quotes) +
                '}';
    }
}
