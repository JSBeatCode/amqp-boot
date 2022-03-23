package com.work.amqpboot;

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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.work.amqpboot.amqp.cloud.JExampleAmqpCloud;
import com.work.amqpboot.amqp.tuto.basic.Recv;
import com.work.amqpboot.amqp.tuto.basic.Send;
import com.work.amqpboot.amqp.tuto.direct.RecvReceiveLogsDirect;
import com.work.amqpboot.amqp.tuto.direct.SendEmitLogDirect;
import com.work.amqpboot.amqp.tuto.exchange.RecvRecieveLogs;
import com.work.amqpboot.amqp.tuto.exchange.SendEmitLog;
import com.work.amqpboot.amqp.tuto.topic.RecvReceiveLogsTopic;
import com.work.amqpboot.amqp.tuto.topic.SendEmitLogTopic;
import com.work.amqpboot.amqp.tuto.work.RecvWorker;
import com.work.amqpboot.amqp.tuto.work.SendNewTask;

@SpringBootApplication
public class AmqpBootApplication {

	public static void main(String[] args) throws IOException, TimeoutException {
		SpringApplication.run(AmqpBootApplication.class, args);
		
//		basic
//		Recv.execute();
//		Send.execute();
		
//		work
//		RecvWorker.exeucte();
//		String[] recvArgv = {"info","test.task1"};
//		SendNewTask.execute(argv);

//		publish / subscribe
//		String[] argv = {"info","test.task2"};
//		RecvRecieveLogs.execute();
//		SendEmitLog.execute(argv);
		
//		exchange - direct
//		String[] recvArgv = {"info","warning"};
//		RecvReceiveLogs.execute(recvArgv);
//		String[] sendArgv1 = {"info","test.task2"};
//		SendEmitLogDirect.execute(sendArgv1);
//		String[] sendArgv2 = {"warning","test.task1"};
//		SendEmitLogDirect.execute(sendArgv2);
		
//		topic
//		String[] recvArgv = {"info","warning"};
//		RecvReceiveLogsTopic.execute(recvArgv);
//		String[] sendArgv1 = {"info","test.task2"};
//		SendEmitLogTopic.execute(sendArgv1);
//		String[] sendArgv2 = {"warning","test.task1"};
//		SendEmitLogTopic.execute(sendArgv2);
		
	}

}
