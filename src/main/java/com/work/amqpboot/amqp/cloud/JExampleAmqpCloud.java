package com.work.amqpboot.amqp.cloud;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class JExampleAmqpCloud {
	

	public static void execute() throws IOException, TimeoutException {

//		 set up the connection
//		amqps://atyftcdh:nOhw26J5K87e9zbcgwFeF2rObEQU8IPn@dingo.rmq.cloudamqp.com/atyftcdh
		CachingConnectionFactory connectionFactory=new CachingConnectionFactory("dingo.rmq.cloudamqp.com");
		connectionFactory.setUsername("atyftcdh");
		connectionFactory.setPassword("nOhw26J5K87e9zbcgwFeF2rObEQU8IPn");
		connectionFactory.setVirtualHost("atyftcdh");
		
		// Recommended settings
		connectionFactory.setRequestedHeartBeat(30);
		connectionFactory.setConnectionTimeout(30000);

		// Set up queue, exchanges and bindings
		RabbitAdmin admin = new RabbitAdmin(connectionFactory);
		Queue queue = new Queue("myQueue");
		admin.declareQueue(queue);
		TopicExchange exchange = new TopicExchange("myExchange");
		admin.declareExchange(exchange);
		admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with("foo.*"));

		// Set up the listener
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
		Object listener = new Object() {
			public void handleMessage(String foo) {
				System.out.println(foo);
			}
		};

		// Send a message
		MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
		container.setMessageListener(adapter);
		container.setQueueNames("myQueue");
		container.start();

		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.convertAndSend("myExchange", "foo.bar", "Hello CloudAMQP!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		container.stop();
	}
	
}
