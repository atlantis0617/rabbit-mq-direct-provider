package com.yhy.rabbitmq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${mq.config.exchange}")
	private String exchange;
	
	public void send() {
		String msg = "hello yhy-----------"+new Date();
		this.rabbitTemplate.convertAndSend(this.exchange,"log.error.routing.key",msg);
	}

}
