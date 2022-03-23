package com.work.amqpboot.amqp.rabbit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomMessage {

	private String text;
	
	private int priority;
	
	private boolean secret;
		
}
