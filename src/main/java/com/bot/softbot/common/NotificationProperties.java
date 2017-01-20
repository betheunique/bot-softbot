package com.bot.softbot.common;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

@Component
public class NotificationProperties {
	private static Logger logger = Logger.getLogger(NotificationProperties.class);

	private static String NOTIFICATION_PROPERTIES_FILE = "notification.properties";
	private Properties properties = new Properties();
	
	@PostConstruct
	public void initializeProperties(){
		try{
			properties.load(this.getClass().getClassLoader().getResourceAsStream(NOTIFICATION_PROPERTIES_FILE));
		}catch(IOException ioe){
			logger.error("Error while loading partner properties: " + ioe.getMessage());
		}
	}
	
	public String getPropertiesTextValue(String key){
		return (String)properties.get(key);
	}
	
	public void reload(){
		properties.clear();
		initializeProperties();
	}
	
}
