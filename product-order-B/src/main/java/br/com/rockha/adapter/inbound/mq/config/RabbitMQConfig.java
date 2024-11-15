package br.com.rockha.adapter.inbound.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RabbitMQConfig {

	    public static final String PROCESSED_QUEUE_NAME = "pedido-event-processed";


	    @Bean
	    Queue pedidoEventProcessedQueue() {
	        return new Queue(PROCESSED_QUEUE_NAME, true);
	    }
}
