package com.bot.softbot.email.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * Common Factory Class will return jersey client with common network {timeout}, {header}
 * Client related configuration
 * @author abhishekrai
 * @since 29/12/2016
 */
public class ClientFactory {

    private static Client client = Client.create();
    private static WebResource resource;

    public static Client clientBuilder() {
        client.setConnectTimeout(5000); //network connection timeout 5sec {5000 millisecond}
        return client;
    }

    public static  Client clientBuilder(String url) {
        client.resource(url);
        client.setConnectTimeout(5000);
        return client;
    }

    public static Client clientBuilder(String url, int timeOut) {
        client.setConnectTimeout(timeOut);
        client.resource(url);
        return client;
    }
}
