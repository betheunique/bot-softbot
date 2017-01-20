package com.bot.softbot.botexecutor;

import com.bot.softbot.handler.EventHandler;
import com.bot.softbot.ws.TheySaidDoSoClient;
import com.bot.softbot.ws.beans.QOD;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author abhishekrai
 * @since 18/01/2017
 */
@Service
public class DailyChannelMessageExecutor {
    private static Logger logger = Logger.getLogger(DailyChannelMessageExecutor.class);

    @Autowired
    private TheySaidDoSoClient theySaidDoSoClient;

    @Autowired
    private EventHandler eventHandler;

    private static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    @PostConstruct
    public void sendDailyQuote() {
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

            public void run() {
                QOD qod = theySaidDoSoClient.getTodaysQuote();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(qod.getContents().getQuotes()[0].getTitle() +".\n");
                stringBuilder.append("\n*" + qod.getContents().getQuotes()[0].getQuote() +".*\n");
                stringBuilder.append("\nBy Author :" + qod.getContents().getQuotes()[0].getAuthor() +".");
//                stringBuilder.append("Testing here");
                eventHandler.sendMessageToChannel(stringBuilder.toString());
            }
        }, 2*60*1000, 24*60*60*1000, TimeUnit.MILLISECONDS);
    }

    private long timeToTenThirtyOClock() {
        Calendar configureTime = new GregorianCalendar();
        configureTime.set(Calendar.HOUR_OF_DAY, 10);
        configureTime.set(Calendar.MINUTE, 30);
        configureTime.set(Calendar.SECOND, 0);
        configureTime.set(Calendar.MILLISECOND, 0);
        configureTime.add(Calendar.DAY_OF_MONTH, 1);
        long difference = configureTime.getTimeInMillis()
                - System.currentTimeMillis();
        logger.debug(difference/1000 + " seconds to 10:30 am.");
        return difference;
    }
 }
