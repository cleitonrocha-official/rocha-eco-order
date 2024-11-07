package br.com.rockha.adapter.inbound.mq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RabbitMQConfig {

	public static final String QUEUE_NAME = "pedido-event";

	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME, true);
	}
}
