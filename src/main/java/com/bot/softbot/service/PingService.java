package com.bot.softbot.service;

import com.bot.softbot.beans.SlackPing;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author abhishekrai
 * @since 17/01/2017
 */
@Service
public class PingService {
    private static Logger logger = Logger.getLogger(PingService.class);
    private static final ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();

    /**
     * method will be used to schedule ping to remote server every 5sec. It will keep the connection alive.
     * This method runs on single thread. Independent from main thread.
     * @param session
     */
    public void pingServer(final Session session) {
        scheduled.scheduleWithFixedDelay(new Runnable() {

            public void run() {
                SlackPing ping = new SlackPing();
                ping.setId(1234);
                ping.setType("ping");
                try {
                    String pingString = ping.toJSONString();
                    session.getBasicRemote().sendText(pingString);
                } catch (Exception e) {
                    System.out.println("Exception occurred :" + e );
                    logger.error("Exception occurred while sending ping to remote server :" + e);
                    logger.error("Closing scheduler due to exception");
                    scheduled.shutdown();
                }
            }
        }, 60*1000, 5*1000, TimeUnit.MILLISECONDS);
    }

}
