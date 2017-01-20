package com.bot.softbot.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;

/**
 * @author abhishekrai
 * @since 18/01/2017
 */
@Path("/bot")
@Component
public class BotStopController {

    private static Logger logger = Logger.getLogger(BotStopController.class);

    @Path("/v1/stop")
    public int stopBot() {
        return 1;
    }
}
