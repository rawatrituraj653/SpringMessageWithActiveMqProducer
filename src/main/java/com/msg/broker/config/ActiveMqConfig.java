package com.msg.broker.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMqConfig {
	
	public ActiveMQConnectionFactory activeMQConnectionFactory () {
		
		ActiveMQConnectionFactory activeMQConnectionFactory=
				new ActiveMQConnectionFactory("tcp://localhost:61616");
		activeMQConnectionFactory.setUserName("admin");
		activeMQConnectionFactory.setPassword("admin");
		return activeMQConnectionFactory;}
	@Bean
	public  ConnectionFactory connectionFactory() {
		ConnectionFactory connectionFactory=new CachingConnectionFactory(activeMQConnectionFactory());
	return connectionFactory;}
	@Bean
	public ActiveMQQueue activeMQQueue() {
		ActiveMQQueue   mqQueue=new ActiveMQQueue("my-app"); 
	return mqQueue;
	}
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate=new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setDefaultDestination(activeMQQueue());
		return jmsTemplate;
	}
	
}
