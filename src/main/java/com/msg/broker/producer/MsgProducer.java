package com.msg.broker.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MsgProducer {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	
	public boolean msgsending(String str) {
		
		try{
		
			/*
			 * jmsTemplate.send("my-app", ses->{ return ses.createObjectMessage(emp); });
			 */
			jmsTemplate.send(ses->ses.createTextMessage(str));
	
		 /* if we write key in application.properties default-destination
		 * jmsTemplate.send(ses->ses.createTextMessage(str));*/
		//jmsTemplate.send((session)->session.createObjectMessage(emp));
		return true;
		}catch (Exception e) {
			e.printStackTrace();	
			return false;
		}
	}
	
}
