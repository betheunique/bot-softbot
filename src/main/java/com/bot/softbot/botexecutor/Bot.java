package com.bot.softbot.botexecutor;

import com.bot.softbot.beans.RTMStartResponse;
import com.bot.softbot.client.SoftBotClient;
import com.bot.softbot.service.CachingService;
import com.bot.softbot.service.PingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author abhishekrai
 * @since 13/01/2017
 * Bot class is front facing communication with slack websocket endPoint, Bot will start communication with slack end point.
 */
@Service
public class Bot {

    private static Logger logger = Logger.getLogger(Bot.class);
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static final ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();

    @Autowired
    private PingService pingServer;

    @Autowired
    private CachingService cachingService;

    @PostConstruct
    public void initialSlackConnect() {
        executorService.execute(new Runnable() {

            public void run() {

                logger.info("Initializing slack connection on single thread");
                try {
//                    String dest = "https://slack.com/api/rtm.start?token=";
                    String dest = "https://slack.com/api/rtm.start?token=";
                    Client client = new Client();
                    WebResource target = client.resource(dest);
                    ClientResponse response = target.get(ClientResponse.class);
                    String result = response.getEntity(String.class);
                    logger.info("response received from slack :" + result);
                    ObjectMapper mapper = new ObjectMapper();
                    RTMStartResponse rtmStartResponse = mapper.readValue(result, RTMStartResponse.class);
                    logger.info("Https call was successful :" + rtmStartResponse.getOk());
                    logger.info("WebSocket url received from Slsck :" + rtmStartResponse.getUrl());
                    SoftBotClient socket = new SoftBotClient();
                    WebSocketContainer container = ContainerProvider.getWebSocketContainer();
                    Session session = container.connectToServer(socket, new URI(rtmStartResponse.getUrl()));
                    cachingService.initialize(rtmStartResponse, session);
                    logger.info("Session id :" + session.getId());
                    pingServer.pingServer(session);

                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        });

//        int a[] = {1, 1, 2, 3, 4, 6, 6, 6, 7, 8, 8, 9};
//        int a1[] = {4, 6, 6, 6, 7, 8, 8, 9, 10, 10, 10, 10, 10, 12, 12, 13};
//        int maxLength = returnLargestLenght(a1);
//        System.out.println("MaxLenght for sequence :" + maxLength );
        //executorService.shutdown();
    }
//    public static int returnLargestLenght(int a[]) {
////        List<Integer> aList = new ArrayList<Integer>();
////        for (int i=0; i < a.length; i++) {
////            aList.add(a[i]);
////        }
////        Set<Integer> count = new HashSet<Integer>(aList);
//        Map<Integer, Integer> listMap = new HashMap<Integer, Integer>();
////        for (Integer i : count) {
////            listMap.put(i, Collections.frequency(aList, i));
////
////        }
//        for (Integer i : a) {
//            if(listMap.get(i) == null) {
//                listMap.put(i, 1);
//            } else {
//                listMap.put(i, listMap.get(i) + 1);
//            }
//        }
//
//        int maxLenght = 0;
//        for (Integer i : listMap.keySet()) {
//            System.out.println("Key value for :" + i);
//            System.out.println("Integer value"  + listMap.get(i));
////            if (null != listMap.get(i+1)) {
//                int arrayMaxlength = listMap.get(i) + (listMap.get(i+1) == null ? 0 : listMap.get(i+1));
//                if (arrayMaxlength > maxLenght) {
//                    maxLenght = arrayMaxlength;
//                    System.out.println("maxlenght :" + maxLenght);
//
//                }
//
////            }
//        }
//        return maxLenght;
//    }

}
