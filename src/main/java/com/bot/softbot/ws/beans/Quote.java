package com.bot.softbot.ws.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author abhishekrai
 * @since 18/01/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private String quote;
    private int length;
    private String author;
    private String category;
    private String date;
    private String title;
    private String background;
    private String id;

    public int getLength() {
        return length;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quote='" + quote + '\'' +
                ", length=" + length +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", background='" + background + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
